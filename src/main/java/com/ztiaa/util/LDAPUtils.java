package com.ztiaa.util;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;
import javax.naming.directory.BasicAttribute;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import javax.naming.directory.ModificationItem;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;

import com.ztiaa.password.server.LDAPServer;
import com.ztiaa.user.User;

/**
 * LDAPUtils.class
 *
 * @author Aravind Suresh
 * @copyright 2024 Aravind Suresh
 */
public class LDAPUtils {

	public static DirContext getConnection(LDAPServer server) {
		DirContext ctx = null;
		Hashtable<String, Object> env = new Hashtable<>();
		env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
		env.put(Context.PROVIDER_URL, "ldap://" + server.getHost() + ":" + server.getPort());
		env.put(Context.SECURITY_AUTHENTICATION, "simple");
		env.put(Context.SECURITY_PRINCIPAL, server.getBindDN());
		env.put(Context.SECURITY_CREDENTIALS, server.getBindPassword());

		try {
			ctx = new InitialDirContext(env);
		} catch (NamingException e) {
			e.printStackTrace();
		}
		return ctx;
	}

	public static DirContext getConnection(LDAPServer server, String userDN, String password) {
		DirContext ctx = null;
		Hashtable<String, Object> env = new Hashtable<>();
		env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
		env.put(Context.PROVIDER_URL, "ldap://" + server.getHost() + ":" + server.getPort());
		env.put(Context.SECURITY_AUTHENTICATION, "simple");
		env.put(Context.SECURITY_PRINCIPAL, userDN);
		env.put(Context.SECURITY_CREDENTIALS, password);

		try {
			ctx = new InitialDirContext(env);
		} catch (NamingException e) {
			e.printStackTrace();
		}
		return ctx;
	}

	public static List<User> getUsersFiltered(LDAPServer server, String filter) {
		DirContext ctx = getConnection(server);
		List<User> users = new ArrayList<User>();

		NamingEnumeration<SearchResult> results;
		String[] attributeFilter = {};
		SearchControls sc = new SearchControls();
		sc.setReturningAttributes(attributeFilter);
		sc.setSearchScope(SearchControls.SUBTREE_SCOPE);

		String fullFilter = "(&(objectClass=" + server.getUserObject() + ")" + filter + ")";
		System.out.println(fullFilter);
		try {
			results = ctx.search(server.getSearchBase(), fullFilter, sc);

			while (results.hasMore()) {
				SearchResult result = results.next();
				Attributes attributes = ctx.getAttributes(result.getNameInNamespace(), new String[] { "*", "+" });

				// String cn = attributes.get("cn") != null ? (String)
				// attributes.get("cn").get() : null;
				String dn = attributes.get("entrydn") != null ? (String) attributes.get("entrydn").get() : null;
				String displayName = attributes.get("displayName") != null
						? (String) attributes.get("displayName").get()
						: null;
				String email = attributes.get("displayName") != null ? (String) attributes.get("displayName").get()
						: null;
				String manager = attributes.get("manager") != null ? (String) attributes.get("manager").get() : null;

				String idAttributeValue = attributes.get(server.getUniqueIDAttribute()) != null
						? (String) attributes.get(server.getUniqueIDAttribute()).get()
						: null;

				User user = new User(idAttributeValue, idAttributeValue, dn, displayName, email, manager,
						null);
				System.out.println(user);
				users.add(user);
			}
		} catch (NamingException e) {
			e.printStackTrace();
		}
		return users;
	}

	public static List<User> getUsersForManager(LDAPServer server, String managerDN) {
		String filter = "(manager=" + managerDN + ")";
		List<User> users = getUsersFiltered(server, filter);
		return users;
	}

	public static List<User> getNewUsers(LDAPServer server) {
		List<User> users = getUsersFiltered(server, "");
		return users;
	}

	public static List<User> getAllUsers(LDAPServer server) {
		List<User> users = getUsersFiltered(server, "");
		return users;
	}

	public static User getUserDetails(LDAPServer server, String userID) {
		DirContext ctx = getConnection(server);
		User user = null;

		NamingEnumeration<SearchResult> results;
		String[] attributeFilter = {};
		SearchControls sc = new SearchControls();
		sc.setReturningAttributes(attributeFilter);
		sc.setSearchScope(SearchControls.SUBTREE_SCOPE);
		try {
			results = ctx.search("", "(" + server.getUniqueIDAttribute() + "=" + userID + ")", sc);
			if (results.hasMore()) {
				SearchResult result = results.next();
				Attributes attributes = ctx.getAttributes(result.getNameInNamespace(), new String[] { "*", "+" });

				// String cn = attributes.get("cn") != null ? (String)
				// attributes.get("cn").get() : null;
				String dn = attributes.get("entrydn") != null ? (String) attributes.get("entrydn").get() : null;
				String displayName = attributes.get("displayName") != null
						? (String) attributes.get("displayName").get()
						: null;
				String email = attributes.get("displayName") != null ? (String) attributes.get("displayName").get()
						: null;
				String manager = attributes.get("manager") != null ? (String) attributes.get("manager").get() : null;

				String idAttributeValue = attributes.get(server.getUniqueIDAttribute()) != null
						? (String) attributes.get(server.getUniqueIDAttribute()).get()
						: null;

				user = new User(idAttributeValue, idAttributeValue, dn, displayName, email, manager, null);
			}
		} catch (NamingException e) {
			e.printStackTrace();
		}
		System.out.println(user);
		return user;
	}

	public static Boolean isUserAdmin(LDAPServer server, String userDN) {
		DirContext ctx = getConnection(server);

		NamingEnumeration<SearchResult> results;
		String[] attributeFilter = { };
		SearchControls sc = new SearchControls();
		sc.setReturningAttributes(attributeFilter);
		sc.setSearchScope(SearchControls.SUBTREE_SCOPE);
		try {
			results = ctx.search(server.getSearchBase(), "(&(cn=ZTIAA_Admins)(member=" + userDN + "))", sc);
			if (results.hasMore()) {
				return true;
			}
		} catch (NamingException e) {
			e.printStackTrace();
		}
		return false;
	}

	public static void updateUserPassword(LDAPServer server, String userID, String newPassword) {
		DirContext ctx = getConnection(server);
		String userDN = getUserDetails(server, userID).getUserDN();
		try {
			Attribute attribute = new BasicAttribute(server.getPasswordAttribute(), newPassword);
			ModificationItem[] item = new ModificationItem[1];
			item[0] = new ModificationItem(DirContext.REPLACE_ATTRIBUTE, attribute);
			ctx.modifyAttributes(userDN, item);
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

}
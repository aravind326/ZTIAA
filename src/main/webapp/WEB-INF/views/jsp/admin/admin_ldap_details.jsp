<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<jsp:include page='../layout/head.jsp' />
<body>

	<jsp:include page='../layout/navbar.jsp' />
	<jsp:include page='../layout/subheader.jsp'>
		<jsp:param name="headerVal" value="LDAP Server Configuration" />
	</jsp:include>

	<jsp:include page='../layout/breadcrumb.jsp'>
		<jsp:param name="l1" value="Administrator Home" />
		<jsp:param name="l1_link" value="/ZTIAA/admin/" />
		<jsp:param name="l2" value="LDAP  Server Config" />
		<jsp:param name="l2_link" value="/ZTIAA/admin/ldap" />
		<jsp:param name="active_level"
			value="LDAP Server Details: ${server.serverName}" />
	</jsp:include>

	<c:if test="${not empty testSuccess and testSuccess}">
		<jsp:include page='../layout/toast.jsp'>
			<jsp:param name="message" value="Server connection validated successfully!" />
			<jsp:param name="type" value="success" />
		</jsp:include>
	</c:if>
	<c:if test="${not empty testSuccess and not testSuccess}">
		<jsp:include page='../layout/toast.jsp'>
			<jsp:param name="message" value="Server connection validation failed!" />
			<jsp:param name="type" value="danger" />
		</jsp:include>
	</c:if>

	<c:if test="${not empty success and success}">
		<jsp:include page='../layout/toast.jsp'>
			<jsp:param name="message" value="Server updated successfully!" />
			<jsp:param name="type" value="success" />
		</jsp:include>
	</c:if>
	<c:if test="${not empty success and not success}">
		<jsp:include page='../layout/toast.jsp'>
			<jsp:param name="message" value="Server update failed!" />
			<jsp:param name="type" value="danger" />
		</jsp:include>
	</c:if>

	<div class="container p-auto">
		<form:form action="/ZTIAA/admin/ldap" method="POST">
			<c:if test="${not empty server.serverID}">
				<div class="mb-3 row">
					<label for="serverID" class="col-2 col-form-label">Server
						ID</label>
					<div class="col-5">
						<input type="text" class="form-control-plaintext" id="serverID"
							value="${server.serverID}" name="serverID" readonly>
					</div>
				</div>
			</c:if>
			<div class="mb-3 row">
				<label for="serverName" class="col-2 col-form-label">Server
					Name</label>
				<div class="col-5">
					<input type="text" class="form-control" id="serverName"
						name="serverName" value="${server.serverName}" required />
				</div>
			</div>
			<div class="mb-3 row">
				<label for="serverHostName" class="col-2 col-form-label">Server
					Host</label>
				<div class="col-5">
					<input type="text" class="form-control" id="serverHostName"
						value="${server.host}" name="host" required>
				</div>
			</div>
			<div class="mb-3 row">
				<label for="serverPort" class="col-2 col-form-label">Server
					Port</label>
				<div class="col-5">
					<input type="number" min="1" max="65535" class="form-control"
						id="serverPort" value="${server.port}" name="port" required>
				</div>
			</div>
			<div class="mb-3 row">
				<label for="serverBindDN" class="col-2 col-form-label">Bind
					DN</label>
				<div class="col-5">
					<input type="text" class="form-control" id="serverBindDN"
						value="${server.bindDN}" name="bindDN" required>
				</div>
			</div>
			<div class="mb-3 row">
				<label for="serverBindPassword" class="col-2 col-form-label">Bind
					Password</label>
				<div class="col-5">
					<input type="password" class="form-control" id="serverBindPassword"
						value="${server.bindPassword}" name="bindPassword" required>
				</div>
			</div>
			<div class="mb-3 row">
				<label for="severUniqueIDAttribute" class="col-2 col-form-label">Unique
					ID Attribute</label>
				<div class="col-5">
					<input type="text" class="form-control" id="severUniqueIDAttribute"
						value="${server.uniqueIDAttribute}" name="uniqueIDAttribute"
						required>
				</div>
			</div>
			<div class="mb-3 row">
				<label for="severUserObject" class="col-2 col-form-label">User
					Object Class</label>
				<div class="col-5">
					<input type="text" class="form-control" id="severUserObject"
						value="${server.uniqueIDAttribute}" name="userObject" required>
				</div>
			</div>
			<div class="mb-3 row">
				<label for="severSearchBase" class="col-2 col-form-label">Search
					Base DN</label>
				<div class="col-5">
					<input type="text" class="form-control" id="severSearchBase"
						value="${server.searchBase}" name="searchBase" required>
				</div>
			</div>
			<div class="mb-3 row">
				<label for="serverPasswordAttribute" class="col-2 col-form-label">Password
					Attribute</label>
				<div class="col-5">
					<input type="text" class="form-control"
						id="serverPasswordAttribute" value="${server.passwordAttribute}"
						name="passwordAttribute" required>
				</div>
			</div>
			<c:if test="${not empty server.serverID}">
				<div class="mb-3 row">
					<label for="serverCreatedDate" class="col-2 col-form-label">Created
						Date</label>
					<div class="col-5">
						<input type="text" class="form-control-plaintext"
							id="serverCreatedDate" value="${server.createdDate}"
							name="createdDate" readonly>
					</div>
				</div>
			</c:if>
			<c:if test="${not empty server.serverID}">
				<div class="mb-3 row">
					<label for="serverUpdatedDate" class="col-2 col-form-label">Created
						Date</label>
					<div class="col-5">
						<input type="text" class="form-control-plaintext"
							id="serverUpdatedDate" value="${server.updatedDate}"
							name="updatedDate" readonly>
					</div>
				</div>
			</c:if>

			<div class="mb-3 row">
				<label for="serverEnabled" class="col-2 col-form-check-label">Activate?</label>
				<div class="col-5">
					<input class="form-control form-check-input" type="checkbox"
						role="switch" id="serverEnabled"
						<c:if test="${server.enabled}">checked</c:if> name="enabled">
				</div>
			</div>
			<button type="submit" class="btn btn-primary"  name="action" value="save">Save</button>
			<button type="submit" class="btn btn-primary"  name="action" value="test">Test Connection</button>
		</form:form>
	</div>

</body>
</html>
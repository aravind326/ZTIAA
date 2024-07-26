<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>


<jsp:include page='../layout/head.jsp' />
<body>

	<jsp:include page='../layout/navbar.jsp' />
	<jsp:include page='../layout/subheader.jsp'>
		<jsp:param name="headerVal"
			value="${fn:toUpperCase(serverType)} Server List" />
	</jsp:include>

	<jsp:include page='../layout/breadcrumb.jsp'>
		<jsp:param name="l1" value="Administrator Home" />
		<jsp:param name="l1_link" value="/ZTIAA/admin/" />
		<jsp:param name="active_level"
			value="${fn:toUpperCase(serverType)} Server Config" />
	</jsp:include>

	<div class="container p-auto">
		<div class="d-flex flex-row-reverse mb-3">
			<a class="btn btn-primary p-2" href="/ZTIAA/admin/${serverType}/add">+ Add New
				Server</a>
		</div>
		<table class="table table-hover">
			<thead>
				<tr>
					<th scope="col">ID</th>
					<th scope="col">Server Name</th>
					<th scope="col" class="text-center">Created Date</th>
					<th scope="col" class="text-center">Updated Date</th>
					<th scope="col" class="text-center">Active?</th>
					<th scope="col"></th>
				</tr>
			</thead>
			<tbody class="table-group-divider">
				<c:forEach items="${serverList}" var="server">
					<tr>
						<th scope="row">${server.serverID}</th>
						<td>${server.serverName}</td>
						<td class="text-center">${server.createdDate}</td>
						<td class="text-center">${server.updatedDate}</td>
						<td class="text-center"><input class="form-check-input"
							type="checkbox" value=""
							<c:if test = "${server.enabled}">checked</c:if> disabled></td>

						<td><a href="/ZTIAA/admin/${serverType}/${server.serverID}">Update</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

</body>
</html>
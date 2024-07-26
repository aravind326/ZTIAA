<%@ taglib prefix="c" uri="jakarta.tags.core"%>


<jsp:include page='../layout/head.jsp' />
<body>

	<jsp:include page='../layout/navbar.jsp' />
	<jsp:include page='../layout/subheader.jsp'>
		<jsp:param name="headerVal" value="Manage User Activation" />
	</jsp:include>

	<jsp:include page='../layout/breadcrumb.jsp'>
		<jsp:param name="active_level" value="Manager Home" />
	</jsp:include>

	<div class="container p-auto">
		<table class="table table-hover">
			<thead>
				<tr>
					<th scope="col">ID</th>
					<th scope="col">User Name</th>
					<th scope="col">Email</th>
					<th scope="col" class="text-center">Activation Status</th>
					<th scope="col"></th>
				</tr>
			</thead>
			<tbody class="table-group-divider">
				<c:forEach items="${userList}" var="user">
					<tr>
						<th scope="row">${user.userEnterpriseID}</th>
						<td>${user.displayName}</td>
						<td>${user.email}</td>
						<td class="text-center">${user.activationStatus}</td>
						<td><c:if test="${user.activationStatus == 'Pending'}">
								<a href="/ZTIAA/manager/users/${user.userID}">Activate</a>
							</c:if></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>
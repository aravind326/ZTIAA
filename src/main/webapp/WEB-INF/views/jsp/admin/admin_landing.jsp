<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<jsp:include page='../layout/head.jsp' />
<body>

	<jsp:include page='../layout/navbar.jsp' />

	<jsp:include page='../layout/subheader.jsp'>
		<jsp:param name="headerVal" value="Administrator Console" />
	</jsp:include>

	<jsp:include page='../layout/breadcrumb.jsp'>
		<jsp:param name="active_level" value="Administrator Home" />
	</jsp:include>

	<div class="container p-auto">
		<div class="row text-center">
			<div class="col-4">
				<a href="/ZTIAA/admin/password" class="text-decoration-none">
					<div class="card text-bg-light h-100">
						<img src="https://picsum.photos/id/0/500" class="card-img-top"
							alt="...">
						<div class="card-body">
							<h5 class="card-title">Configure Password Complexity</h5>
							<p class="card-text">Set the password complexity criteria for
								your organization.</p>
						</div>
					</div>
				</a>
			</div>
			<div class="col-4">
				<a href="/ZTIAA/admin/ldap" class="text-decoration-none">
					<div class="card text-bg-light h-100">
						<img src="https://picsum.photos/id/60/500" class="card-img-top"
							alt="...">
						<div class="card-body">
							<h5 class="card-title">Configure LDAP Servers</h5>
							<p class="card-text">Configure the downstream LDAP servers to
								which the new passwords set by users should be synchronized.</p>
						</div>
					</div>
				</a>
			</div>
			<div class="col-4">
				<a href="/ZTIAA/admin/scim" class="text-decoration-none">
					<div class="card text-bg-light h-100">
						<img src="https://picsum.photos/id/180/500" class="card-img-top"
							alt="...">
						<div class="card-body">
							<h5 class="card-title">Configure SCIM Servers</h5>
							<p class="card-text">Configure the downstream SCIM enabled
								servers to which the new passwords set by users should be
								synchronized.</p>
						</div>
					</div>
				</a>
			</div>
		</div>
	</div>

</body>
</html>
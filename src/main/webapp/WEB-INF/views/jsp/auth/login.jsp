<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<jsp:include page='../layout/head.jsp' />
<body>

	<jsp:include page='../layout/navbar.jsp' />

	<c:if test="${authStatus == 'fail'}">
		<jsp:include page='../layout/toast.jsp'>
			<jsp:param name="message"
				value="Authentication Failed!" />
			<jsp:param name="type" value="danger" />
		</jsp:include>
	</c:if>

	<div class="container d-flex align-items-center py-4 ">
		<div
			class="container align-items-center w-50 mt-5 bg-secondary-subtle rounded-4">
			<div class="form-signin w-100 m-auto p-5">
				<form:form action="/ZTIAA/loginURL" method="POST" >
					<h1 class="h3 mb-3 fw-normal">Please sign in</h1>

					<div class="form-floating mb-3">
						<input type="text" class="form-control" id="userLogin" name="userLogin"
							placeholder="User Login"> <label for="userLogin">User
							Login</label>
						<div data-lastpass-icon-root=""
							style="position: relative !important; height: 0px !important; width: 0px !important; float: left !important;"></div>
					</div>
					<div class="form-floating mb-3">
						<input type="password" class="form-control" id="userPassword" name="userPassword"
							placeholder="Password"> <label for="userPassword">Password</label>
						<div data-lastpass-icon-root=""
							style="position: relative !important; height: 0px !important; width: 0px !important; float: left !important;"></div>
					</div>

					<button class="btn btn-primary w-100 py-2" type="submit">Sign
						in</button>
				</form:form>
			</div>
		</div>
	</div>

</body>
</html>
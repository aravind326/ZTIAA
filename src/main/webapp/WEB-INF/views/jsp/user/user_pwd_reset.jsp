<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<jsp:include page='../layout/head.jsp' />
<body>

	<jsp:include page='../layout/navbar.jsp' />
		
	<c:if test="${not empty verificationPass and verificationPass}">
		<jsp:include page='../layout/toast.jsp'>
			<jsp:param name="message" value="OTP verification successful!" />
			<jsp:param name="type" value="success" />
		</jsp:include>
	</c:if>
	
			
	<c:if test="${not empty passwordValid and not passwordValid}">
		<jsp:include page='../layout/toast.jsp'>
			<jsp:param name="message" value="Password does not meet required criteria! Please try again." />
			<jsp:param name="type" value="danger" />
		</jsp:include>
	</c:if>
			
	<c:if test="${not empty passwordMatch and not passwordMatch}">
		<jsp:include page='../layout/toast.jsp'>
			<jsp:param name="message" value="Entered passwords do not match! Please try again." />
			<jsp:param name="type" value="danger" />
		</jsp:include>
	</c:if>

	<div class="container p-auto">
		<div class="row gx-5 justify-content-center mt-5 h-40">
			<div class="col-4">
				<div class="text-bg-light border rounded-3 p-4 h-100">
					<div class="mb-3">
						<p class="h4">User Information</p>
					</div>
					<div class="mb-5">
						<p class="h6">User: ${user.displayName}</p>
					</div>

					<form:form action="/ZTIAA/resetpassword" method="POST">

						<input type="text" readonly class="visually-hidden" id="userid"
							name="userid" value="${user.userEnterpriseID}">
						<div class="mb-3">
							<label for="password" class="form-label">Password</label> <input
								type="password" class="form-control" id="password"
								name="password">
						</div>
						<div class="mb-3">
							<label for="confirmPassword" class="form-label">Confirm
								Password</label> <input type="password" class="form-control"
								id="confirmPassword" name="confirmPassword">
						</div>
						<button type="submit" class="btn btn-primary">Submit</button>
					</form:form>
				</div>
			</div>
			<div class="col-6">
				<div class="text-bg-light border rounded-3 p-4 h-100">
					<p class="fw-bold">Password Complexity Criteria:</p>
					<ul>
						<li>Minimum password length: ${passwordConfig.minLength}</li>
						<li>Minimum English uppercase characters (A - Z): ${passwordConfig.minUpperCaseChars}</li>
						<li>Minimum English lowercase characters (a - z): ${passwordConfig.minLowerCaseChars}</li>
						<li>Minimum Base 10 digits (0 - 9): ${passwordConfig.minDigits}</li>
						<li>Minimum Non-alphanumeric (For example: !, $, #, or %): ${passwordConfig.minSpecialChars}</li>
						<li>The password does not contain ${passwordConfig.maxConsecutiveUserNameChars} or more consecutive
							characters from the user's account name</li>
					</ul>
				</div>
			</div>
		</div>
	</div>

</body>
</html>
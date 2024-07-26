<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<jsp:include page='../layout/head.jsp' />
<body>

	<jsp:include page='../layout/navbar.jsp' />


	<c:if test="${not empty verificationPass and not verificationPass}">
		<c:if test="${not empty tokenLocked and tokenLocked}">
			<jsp:include page='../layout/toast.jsp'>
				<jsp:param name="message"
					value="Invalid OTP was entered 3 times. Token is locked till ${tokenLockedTill }!" />
				<jsp:param name="type" value="danger" />
			</jsp:include>
		</c:if>
		<c:if test="${empty tokenLocked}">
			<jsp:include page='../layout/toast.jsp'>
				<jsp:param name="message" value="OTP verification failed!" />
				<jsp:param name="type" value="danger" />
			</jsp:include>
		</c:if>
	</c:if>
	<c:choose>
		<c:when test="${not empty invalidToken and invalidToken}">
			<div class="container p-auto">
				<div class="row gx-5 justify-content-center mt-5">
					<div class="col-6">
						<div
							class="bg-danger-subtle border rounded-3 p-4 text-align-center">
							<div class="mb-3 mt-3">
								<p class="h4">Invalid URL!</p>
							</div>

							<div class="mb-3">
								<p class="h6">The URL you have entered is invalid or you
									have already used this link to activate your account.</p>
								<p class="h6">If you feel like the issue is genuine, please
									contact an administrator.</p>
							</div>
						</div>
					</div>
				</div>
			</div>
		</c:when>
		<c:otherwise>
			<div class="container p-auto">
				<div class="row gx-5 justify-content-center mt-5 h-50">
					<div class="col-6">
						<div class="text-bg-light border rounded-3 p-4 h-100">
							<div class="mb-3">
								<p class="h4">User Information</p>
							</div>
							<div class="mb-5">
								<p class="h6">User: ${user.displayName}</p>
							</div>



							<form:form action="/ZTIAA/activate" method="POST">

								<input type="text" readonly class="visually-hidden" id="userid"
									name="userid" value="${user.userEnterpriseID}">
								<div class="mb-1 row">
									<label for="activationOTP" class="form-label">Enter OTP
										received from your manager</label>
								</div>
								<div class="mb-3 row">
									<div>
										<input type="text" class="form-control" id="activationOTP"
											name="activationOTP">
									</div>
								</div>
								<button type="submit" class="btn btn-primary">Submit</button>
							</form:form>
						</div>
					</div>
					<div class="col-4">
						<div class="text-bg-light border rounded-3 p-4 h-100">
							<p>Please contact your manager and provide them the one-time
								token you received in the onboarding email.</p>
							<p>Your manager will be able to validate your token and
								provide with an OTP which you can enter in this page and verify
								your account.</p>
							<p>Upon successful verification, you will be prompted to set
								a new permanent password for your account.</p>
						</div>
					</div>
				</div>
			</div>
		</c:otherwise>
	</c:choose>



</body>
</html>
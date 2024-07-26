<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<jsp:include page='../layout/head.jsp' />
<body>

	<jsp:include page='../layout/navbar.jsp' />
	<jsp:include page='../layout/subheader.jsp'>
		<jsp:param name="headerVal" value="Activate User" />
	</jsp:include>

	<jsp:include page='../layout/breadcrumb.jsp'>
		<jsp:param name="l1" value="Manager Home" />
		<jsp:param name="l1_link" value="/ZTIAA/manager/" />
		<jsp:param name="active_level"
			value="Activate User: ${user.displayName} (${user.userEnterpriseID})" />
	</jsp:include>

	<c:if test="${not empty verificationPass and verificationPass}">
		<jsp:include page='../layout/toast.jsp'>
			<jsp:param name="message"
				value="Token verified successfully!" />
			<jsp:param name="type" value="success" />
		</jsp:include>
	</c:if>
	<c:if test="${not empty verificationPass and not verificationPass}">
		<c:if test="${not empty tokenLocked and tokenLocked}">
			<jsp:include page='../layout/toast.jsp'>
				<jsp:param name="message" value="Invalid token was entered 3 times. Token is locked till ${tokenLockedTill }!" />
				<jsp:param name="type" value="danger" />
			</jsp:include>
		</c:if>
		<c:if test="${empty tokenLocked}">
			<jsp:include page='../layout/toast.jsp'>
				<jsp:param name="message" value="Token verification failed!" />
				<jsp:param name="type" value="danger" />
			</jsp:include>
		</c:if>
	</c:if>


	<div class="container p-auto">
		<c:choose>
			<c:when test="${verificationPass}">
				<div class="mb-3 row  fw-bolder">
					<label class="col-2 col-form-label">Activation OTP</label>
					<div class="col-5">
						<input type="text" class="form-control-plaintext"
							id="activationOTP" name="activationOTP" value="${activationOTP }"
							readonly>
					</div>
				</div>
			</c:when>
			<c:otherwise>
				<form:form action="/ZTIAA/manager/users/${user.userEnterpriseID}/activate"
					method="POST">

					<input type="text" readonly class="visually-hidden" id="userID"
						name="userID" value="${user.userEnterpriseID}">
					<div class="mb-3 row">
						<label for="serverID" class="col-2 col-form-label">Enter
							User Token</label>
						<div class="col-5">
							<input type="text" class="form-control" id="userToken"
								name="userToken">
						</div>
					</div>
					<button type="submit" class="btn btn-primary">Submit</button>
				</form:form>
			</c:otherwise>
		</c:choose>

	</div>
</body>
</html>
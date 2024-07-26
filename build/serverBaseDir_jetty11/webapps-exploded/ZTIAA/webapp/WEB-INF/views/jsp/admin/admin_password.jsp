<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<jsp:include page='../layout/head.jsp' />
<body>

	<jsp:include page='../layout/navbar.jsp' />
	<jsp:include page='../layout/subheader.jsp'>
		<jsp:param name="headerVal" value="Password Complexity Configuration" />
	</jsp:include>

	<jsp:include page='../layout/breadcrumb.jsp'>
		<jsp:param name="l1" value="Administrator Home" />
		<jsp:param name="l1_link" value="/ZTIAA/admin/" />
		<jsp:param name="active_level" value="Password Config" />
	</jsp:include>

	<c:if test="${not empty success and success}">
		<jsp:include page='../layout/toast.jsp'>
			<jsp:param name="message"
				value="Password config updated successfully!" />
			<jsp:param name="type" value="success" />
		</jsp:include>
	</c:if>
	<c:if test="${not empty success and not success}">
		<jsp:include page='../layout/toast.jsp'>
			<jsp:param name="message" value="${message}" />
			<jsp:param name="type" value="danger" />
		</jsp:include>
	</c:if>

	<div class="container p-auto">
		<form:form action="/ZTIAA/admin/password" method="POST"
			modelAttribute="passwordConfig">

			<div class="mb-3 row">
				<label for="minLength" class="col-5 col-form-label">Minimum
					Password Length</label>
				<div class="col-1">
					<input type="number" class="form-control" id="minLength"
						value="${passwordConfig.minLength}" name="minLength">
				</div>
			</div>

			<div class="mb-3 row">
				<label for="minUpperCaseChars" class="col-5 col-form-label">Minimum
					number of upper case characters (A - Z)</label>
				<div class="col-1">
					<input type="number" class="form-control" id="minUpperCaseChars"
						value="${passwordConfig.minUpperCaseChars}"
						name="minUpperCaseChars">
				</div>
			</div>

			<div class="mb-3 row">
				<label for="minLowerCaseChars" class="col-5 col-form-label">Minimum
					number of lower case characters (a - z)</label>
				<div class="col-1">
					<input type="number" class="form-control" id="minLowerCaseChars"
						value="${passwordConfig.minLowerCaseChars}"
						name="minLowerCaseChars">
				</div>
			</div>

			<div class="mb-3 row">
				<label for="minDigits" class="col-5 col-form-label">Minimum
					number of digits (0 - 9)</label>
				<div class="col-1">
					<input type="number" class="form-control" id="minDigits"
						value="${passwordConfig.minDigits}" name="minDigits">
				</div>
			</div>

			<div class="mb-3 row">
				<label for="minSpecialChars" class="col-5 col-form-label">Minimum
					number of alphanumeric special characters (~`! @#$%^, etc.)</label>
				<div class="col-1">
					<input type="number" class="form-control" id="minSpecialChars"
						value="${passwordConfig.minSpecialChars}" name="minSpecialChars">
				</div>
			</div>

			<div class="mb-3 row">
				<label for="maxConsecutiveUserNameChars"
					class="col-5 col-form-label">Maximum consecutive characters
					allowed from user name</label>
				<div class="col-1">
					<input type="number" class="form-control"
						id="maxConsecutiveUserNameChars"
						value="${passwordConfig.maxConsecutiveUserNameChars}"
						name="maxConsecutiveUserNameChars">
				</div>
			</div>

			<button type="submit" class="btn btn-primary">Submit</button>
		</form:form>
	</div>

</body>
</html>
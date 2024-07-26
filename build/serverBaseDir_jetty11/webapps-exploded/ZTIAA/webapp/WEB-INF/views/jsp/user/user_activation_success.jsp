<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<jsp:include page='../layout/head.jsp' />
<body>

	<jsp:include page='../layout/navbar.jsp' />

	<div class="container p-auto">
		<div class="row gx-5 justify-content-center mt-5">
			<div class="col-6">
				<div
					class="bg-success-subtle border rounded-3 p-4 text-align-center">
					<div class="mb-3 mt-3">
						<p class="h4">User Activation Success</p>
					</div>

					<div class="mb-3">
						<p class="h6">Account activation was successful. Please use the new
							password that you have set for future logins.</p>
					</div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>
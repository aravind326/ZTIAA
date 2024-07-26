<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ page session="false"%>

<jsp:include page='../layout/head.jsp' />
<body>

	<jsp:include page='../layout/navbar.jsp' />

	<div class="container p-auto">
		<div class="row gx-5 justify-content-center mt-5">
			<div class="col-6">
				<div
					class="bg-danger-subtle border rounded-3 p-4 text-align-center">
					<div class="mb-3 mt-3">
						<p class="h4">Error!</p>
					</div>

					<div class="mb-3">
						<p class="h6">An error occurred while accessing the page!</p>
						<p class="h6">Error Details: ${errorMsg }</p>
						<p class="h6">If the issue persists, please contact an administrator.</p>
					</div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>
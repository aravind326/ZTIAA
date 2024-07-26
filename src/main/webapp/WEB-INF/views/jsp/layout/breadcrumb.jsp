<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<c:if test="${not empty param.active_level}">
	<header class="mb-3 border-bottom">
		<nav aria-label="breadcrumb">
			<ol class="breadcrumb pt-3 ps-5 ms-3 fs-6">
				<c:if test="${not empty param.l1}">
					<li class="breadcrumb-item"><a href="${param.l1_link}">${param.l1}</a></li>
				</c:if>
				<c:if test="${not empty param.l2}">
					<li class="breadcrumb-item"><a href="${param.l2_link}">${param.l2}</a></li>
				</c:if>
				<c:if test="${not empty param.active_level}">
					<li class="breadcrumb-item active" aria-current="page"><span class=" fw-bolder">${param.active_level}</span></li>
				</c:if>
			</ol>
		</nav>
	</header>
</c:if>
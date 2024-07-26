<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<header class="py-1 border-bottom">
	<div class="ps-5 ms-3 fs-3">
		<c:choose>
			<c:when test="${not empty param.headerVal}">
				<span>${param.headerVal}</span>
			</c:when>
			<c:otherwise>
				<span>Dummy Subheader</span>
			</c:otherwise>
		</c:choose>
	</div>
</header>
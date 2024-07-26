<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>


<style>
[data-initials]:before {
	background: #099bdd;
	color: white;
	opacity: 1;
	content: attr(data-initials);
	display: inline-block;
	font-weight: bold;
	border-radius: 50%;
	vertical-align: middle;
	margin-right: 0.5em;
	width: 32px;
	height: 32px;
	line-height: 32px;
	text-align: center;
}
</style>

<c:set var="currentUser"
	value="${pageContext.request.userPrincipal.name}" />
<c:set var="requestPath" value="${pageContext.request.servletPath}" />

<nav class="navbar navbar-expand-lg bg-body-tertiary header">
	<div class="container-fluid">
		<c:choose>
			<c:when test="${not empty pageContext.request.userPrincipal}">
				<c:choose>
					<c:when test="${pageContext.request.isUserInRole('ROLE_ADMIN')}">
						<a class="navbar-brand ms-5 fs-2" href="/ZTIAA/admin/">Self
							Service Account Activation Portal</a>
					</c:when>
					<c:otherwise>
						<a class="navbar-brand ms-5 fs-2" href="/ZTIAA/manager/">Self
							Service Account Activation Portal</a>
					</c:otherwise>
				</c:choose>
			</c:when>
			<c:otherwise>
				<a class="navbar-brand ms-5 fs-2" href="#">Self Service Account
					Activation Portal</a>
			</c:otherwise>
		</c:choose>
		<div class="d-flex align-items-center">
			<div class="flex-shrink-0 dropdown">
				<c:if test="${ not empty currentUser }">
					<a href="#" class="d-block link-body-emphasis text-decoration-none"
						data-bs-toggle="dropdown" aria-expanded="false"><div
							data-initials="${fn:toUpperCase(fn:substring(currentUser, 0, 2))}"></div>
					</a>
				</c:if>
				<ul class="dropdown-menu dropdown-menu-end text-small shadow">
					<c:if test="${fn:contains(requestPath, '/admin/')}">
						<li><a class="dropdown-item" href="/ZTIAA/manager/">Manager
								View</a></li>
						<li><hr class="dropdown-divider"></li>
					</c:if>
					<c:if test="${fn:contains(requestPath, '/manager/')}">
						<sec:authorize access="hasRole('ROLE_ADMIN')">
							<li><a class="dropdown-item" href="/ZTIAA/admin/">Admin
									View</a></li>
							<li><hr class="dropdown-divider"></li>
						</sec:authorize>
					</c:if>
					<li><a class="dropdown-item" href="/ZTIAA/logout">Sign out</a></li>
				</ul>
			</div>
		</div>
	</div>
</nav>
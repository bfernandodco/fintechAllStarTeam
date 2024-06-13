<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!doctype html>
<html lang="en" data-bs-theme="auto">
<head>
<script src="../resources/js/color-modes.js"></script>

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">

<title>Fintech</title>

<link rel="canonical"
	href="https://getbootstrap.com/docs/5.3/examples/headers/">



<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/@docsearch/css@3">

<link
	href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css"
	rel="stylesheet">


<!-- Custom styles for this template -->
<link href="${pageContext.request.contextPath}/resources/css/header.css"
	rel="stylesheet">
</head>
<body>
	<main>
		<div class="container">
			<header
				class="d-flex flex-wrap align-items-center justify-content-center justify-content-md-between py-3 mb-2 border-bottom">
				<div class="col-md-3 mb-md-0">
					<a href="/"
						class="d-inline-flex link-body-emphasis text-decoration-none">
						<h3>
							FIN<span class="text-primary">TECH</span>
						</h3>
					</a>
				</div>

				<ul class="nav nav-pills">
					<li class="nav-item"><a href="#" class="nav-link active"
						aria-current="page">Dashboard</a></li>
					<li class="nav-item"><a href="#" class="nav-link">Lançamentos</a></li>
					<li class="nav-item"><a href="#" class="nav-link">Investimentos</a></li>
					<li class="nav-item"><a href="#" class="nav-link">Objetivos</a></li>
					<li class="nav-item"><a href="#" class="nav-link">FAQ</a></li>
				</ul>

				<form class="col-12 col-lg-auto mb-3 mb-lg-0 me-lg-3" role="search">
					<input type="search" class="form-control" placeholder="Pesquisar"
						aria-label="Search">
				</form>

				<div class="dropdown text-end">
					<a href="#"
						class="d-block link-body-emphasis text-decoration-none dropdown-toggle"
						data-bs-toggle="dropdown" aria-expanded="false"> <img
						src="https://github.com/mdo.png" alt="mdo" width="32" height="32"
						class="rounded-circle">
					</a>
					<ul class="dropdown-menu text-small">
						<li><a class="dropdown-item" href="#">Configurações</a></li>
						<li><a class="dropdown-item" href="#">Perfil</a></li>
						<li><hr class="dropdown-divider"></li>
						<li><a class="dropdown-item" href="#">Sair</a></li>
					</ul>
				</div>
			</header>
		</div>

	</main>
	<script
		src="${pageContext.request.contextPath}/resources/js/bootstrap.bundle.min.js"></script>

</body>
</html>

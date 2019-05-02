<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<jsp:include page="/WEB-INF/fragments/head.jsp"></jsp:include>
<jsp:include page="./fragments/header.jsp" />
</head>


<body>
	<div class="container">
		<h1 class="text-center">Liste des enchères</h1>
		<h2 class="col-12 ">Filtres :</h2>





		<form method="post">
			<div id="z-filtre" class="row">

				<div class="row col-12 col-md-6">
					<div class="col-12 i-search order-2 order-md-1 py-2">
						<div class="input-group mb-3">
							<div class="input-group-prepend">
								<span class="input-group-text" id="select-categorie">Catégorie</span>
							</div>
							<select class="form-control" name="sCategorie"
								aria-label="Catégorie" aria-describedby="select-categorie">
								<option value="0">Toutes</option>

								<option value="1">Informatique</option>

								<option value="2">Meubles</option>

								<option value="3">Vêtement</option>

								<option value="4">Loisirs</option>

								<option value="5">Jouets</option>

							</select>
						</div>

						<div class="input-group mb-1">
							<div class="input-group-prepend">
								<span class="input-group-text" id="basic-addon1"> <span
									class="oi oi-magnifying-glass" aria-hidden="true"></span>
								</span>
							</div>
							<input type="text" class="form-control" name="snom"
								placeholder="Nom de l'article contient" aria-label="article"
								aria-describedby="basic-addon1" value="">
						</div>
					</div>

					<div class="col-12 c-search order-1 order-md-2">









						<div class="col-12 col-md-6 ml-1">
							<input type="radio" name="type-encheres" value="achats"
								id="achats" class="form-check-input"> <label
								for="achats" class="form-check-label">Achats</label>
							<div id="bloc-achats" class="col pl-4">
								<div>
									<input type="checkbox" name="encheres" value="ouvertes"
										id="ouvertes" class="form-check-input"> <label
										for="ouvertes" class="form-check-label">Enchères
										ouvertes</label>
								</div>
								<div>
									<input type="checkbox" name="encheres" value="encours"
										id="encours" class="form-check-input"> <label
										for="encours" class="form-check-label">Enchères en
										cours</label>
								</div>
								<div>
									<input type="checkbox" name="encheres" value="remportes"
										id="remportes" class="form-check-input"> <label
										for="remportes" class="form-check-label">Enchères
										remportées</label>
								</div>
							</div>
						</div>

						<div class="col-12 col-md-6 ml-1">
							<input type="radio" name="type-encheres" checked="checked"
								value="ventes" id="ventes" class="form-check-input"> 
								<label
								for="ventes" class="form-check-label">Mes ventes</label>
							<div id="bloc-ventes" class="col pl-4">
								<div>
									<input type="checkbox" name="ventes" value="vencours"
										id="vencours" class="form-check-input"> <label
										for="vencours" class="form-check-label">Ventes en
										cours</label>
								</div>
								<div>
									<input type="checkbox" checked="checked" name="ventes"
										value="nodebut" id="nodebut" class="form-check-input">
									<label for="nodebut" class="form-check-label">Ventes
										non débutées</label>
								</div>
								<div>
									<input type="checkbox" name="ventes" value="terminer"
										id="terminer" class="form-check-input"> <label
										for="terminer" class="form-check-label">Enchères
										terminées</label>
								</div>
							</div>
						</div>

					</div>

				</div>
				<div
					class="col-12 col-md-6 text-center py-2 align-middle h-100 align-self-center">
					<button class="btn btn-default btn-lg w-75 py-4" type="submit"
						id="searchbtn">Rechercher</button>
				</div>
			</div>
		</form>
		<div id="z-resultats" class="row ">







			<div class="col-12 col-md-6 p-2 detail_article" data-id="1">
				<div class="border border-dark rounded">
					<div class="d-flex">
						<div class="col-3 p-2">


							<img src="images/G_645497_A.jpg" alt="Fauteuil"
								class="img-fluid img-thumbnail" />



						</div>
						<div class="col-9 p-2">
						
									
						
						
							<c:forEach items="${articles}" var="article" >
								
								<p><c:out value="${article.nomArticle}"/></p>

								<p>Fin de l'enchère: ${article.dateFinEncheres}</p>

								<p>Prix: ${article.prixInitial}</p>

								<p>
									Vendeur :  ${utilisateur.pseudo } <a href='/mon_profil'></a>
								</p>

							</c:forEach>

						</div>
					</div>
				</div>
			</div>



		</div>
		</main>
</body>
</html>
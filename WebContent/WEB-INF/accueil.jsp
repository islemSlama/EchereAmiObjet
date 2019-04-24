<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<jsp:include page="/WEB-INF/fragments/head.jsp"></jsp:include>

<body class="container-fluid">

	<%@ include file="./fragments/header.html"%>

	<h1 class="text-center">Liste des enchères</h1>
	<h2 class="col-12 ">Filtres :</h2>





	<form method="post">
		<div id="filtre" class="row">
		
			<div class="row col-12 col-md-4">
						<div class="input-group-prepend">
							<span class="input-group-text" id="basic-addon1"> <span
								class="oi oi-magnifying-glass" aria-hidden="true"></span>
							</span>
						</div>
						<input type="text" class="form-control" name="nom"
							placeholder="Nom de l'article contient" aria-label="article"
							aria-describedby="basic-addon1" value="">
					</div>
				</div>
		

			<div class="row col-12 col-md-4">
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
						<input type="text" class="form-control" name="nom"
							placeholder="Nom de l'article contient" aria-label="article"
							aria-describedby="basic-addon1" value="">
					</div>
				</div>

			<div
				class="col-12 col-md-6 text-center py-2 align-middle h-100 align-self-center">
				<button class="btn btn-default btn-lg w-75 py-4" type="submit"
					id="searchbtn">Rechercher</button>
			</div>
		</div>
	</form>
	
	
	<div id="resultats" class="row ">







		<div class="col-12 col-md-6 p-2 detail_article" data-id="1">
			<div class="border border-dark rounded">
				<div class="d-flex">
					<div class="col-3 p-2">


						<img src="images/exqvsabrti2mpthnxlnmh7kattyicgmd.jpg"
							alt="Portable Acer" class="img-fluid img-thumbnail" />



					</div>
					<div class="col-9 p-2">
						<h3>Pc gamer pour travailler</h3>




						<p>Prix : 210 points</p>

						<p>Fin de l'enchère : 10/05/2019</p>
						<p>






							Vendeur : <a href=''>jojo44</a>
						</p>
					</div>
				</div>
			</div>
		</div>
		
		<div class="col-12 col-md-6 p-2 detail_article" data-id="1">
			<div class="border border-dark rounded">
				<div class="d-flex">
					<div class="col-3 p-2">


						<img src="images/lt-p-black-rice-cooker-1-8l-650w.jpg"
							alt="Portable Acer" class="img-fluid img-thumbnail" />



					</div>
					<div class="col-9 p-2">
						<h3>Rocketstove pour riz et pates</h3>




						<p>Prix : 185 points</p>

						<p>Fin de l'enchère : 25/06/2019</p>
						<p>






							Vendeur : <a href=''>NineJea</a>
						</p>
					</div>
				</div>
			</div>
		</div>



	</div>


</body>
</html>

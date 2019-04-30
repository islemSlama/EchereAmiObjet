<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<jsp:include page="/WEB-INF/fragments/head.jsp"></jsp:include>
<jsp:include page="./fragments/header.jsp" />
</head>


<body>


	<form action="NouvelleVente" method="post">

	<div class="container">


		<div class="row">
			<div class="col-sm-3">
				<div id="imageVente">
					<img id="blah" src="#" alt="image" />
				</div>
			</div>
			<div class="col-sm-12 col-md-12 col-lg-6">
				<form enctype="multipart/form-data" action="NouvelleVente" method="POST">
					<h1 class="center">Nouvelle vente</h1>
					<div class="form-group row">
						<label class="col-sm-3 col-md-3 col-lg-3">Article :<br></label>
						<div class="col-sm-6 col-md-9 col-lg-8">
							<input type="text" name="nomArticle" class="form-control"
								required>
						</div>
					</div>
					<div class="form-group row">
						<label class="col-sm-3 col-md-3 col-lg-3">Categorie : </label>
						<div class="col-sm-6 col-md-9 col-lg-8">
							<select class="form-control" name="no_categorie" id="selectCategories"
								aria-label="Catégorie" aria-describedby="select-categorie">
								
		<c:forEach var="p" items= "${categorie}">
			<option value='<c:out value="${p.noCategorie}"/>'><c:out value="${p.libelle}"/></option>
		</c:forEach>


							</select>
						</div>
					</div>
					<div class="form-group row">
						<label class="col-sm-3 col-md-3 col-lg-3">Description :<br></label>
						<div class="col-sm-6 col-md-9 col-lg-8">
							<textarea name="description" class="form-control noResize"
								required  ></textarea>
						</div>
					</div>
					<div class="form-group row">
						<label class="col-sm-3 col-md-3 col-lg-3">Photo de
							l'article</label>
						<div class="col-sm-6 col-md-9 col-lg-8">
							<input type="file" onchange="readURL(this);" name="file"
								id="file" accept="image/*" />
						</div>
					</div>
					<div class="form-group row">
						<label class="col-sm-3 col-md-3 col-lg-3">Mise à prix : </label>
						<div class="col-sm-6 col-md-9 col-lg-8">
							<input value="1" type="number" id="prix" name="prix" min="1"
								required>
						</div>
					</div>
					<div class="form-group row">
						<label class="col-sm-3 col-md-3 col-lg-3">Début de
							l'enchère :</label>
						<div class="col-sm-6 col-md-9 col-lg-8">
							<input type="date" name="debutEnchere" value="${dateJour}"
								min="${dateJour}" required>
						</div>
					</div>
					<div class="form-group row">
						<label class="col-sm-3 col-md-3 col-lg-3">Fin de l'enchère
							:</label>
						<div class="col-sm-6 col-md-9 col-lg-8">
							<input type="date" name="finEnchere" value="${dateJour}"
								min="${dateJour}" required>
						</div>
					</div>
					<fieldset>
						<legend>
							<h3>Retrait</h3>
						</legend>

						<div class="form-group row">
							<label class="col-sm-3">Rue :</label>
							<div class="col-sm-9 col-md-9 col-lg-9">
								<input type="text" value="${utilisateur.rue}" name="rue"
									id="rue" class="form-control" disabled>
							</div>
						</div>
						<div class="form-group row">
							<label class="col-sm-3">Code postal :</label>
							<div class="col-sm-9 col-md-9 col-lg-9">
								<input type="text" value="${utilisateur.codePostal}"
									name="codePostal" id="codePostal" class="form-control" disabled>
							</div>
						</div>
						<div class="form-group row">
							<label class="col-sm-3">Ville :</label>
							<div class="col-sm-9 col-md-9 col-lg-9">
								<input type="text" value="${utilisateur.ville}" name="ville"
									id="ville" class="form-control" disabled>
							</div>
						</div>
						<input type="hidden" id="rueUtilisateur"
							value="${utilisateurs.rue}" /> <input type="hidden"
							id="codePostalUtilisateur" value="${utilisateur.codePostal}" />
						<input type="hidden" id="villeUtilisateur"
							value="${utilisateurs.ville}" />

					</fieldset>
					<div class="row">
						<div class="col-sm-4">
							<a class="btn btn-lg" href="/Projet_Echere_Ami_Objet/profilConnecte"><button type="submit"
									class="btn btn-success">Enregistrer</button></a>
						</div>

						<div class="col-sm-4 offset-sm-4">
							<a class="btn btn-lg" href="/Projet_Echere_Ami_Objet/Accueil"><button
									type="button" class="btn btn-danger">Annuler</button></a>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>

</form>
</body>
</html>


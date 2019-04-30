<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<jsp:include page="/WEB-INF/fragments/head.jsp"></jsp:include>
<jsp:include page="./fragments/header.jsp" />
</head>


<body>
	<div class="container">


		<h2 class="text-center">Mon profil</h2>


		<div class="form-group">
			<form action="modifierProfil" method="post">
				<div class="row">
					<div class="form-group col-xs-6 col-sm-6 col-md-6 col-lg-6">
						<label>Pseudo :<br></label> <input name="pseudo"
							placeholder="Entrez votre pseudo" value="${utilisateur.pseudo}"
							type="text" class="form-control" maxlength="30">

					</div>
					<div class="form-group col-xs-6 col-sm-6 col-md-6 col-lg-6">
						<label>Nom :<br></label> <input name="nom"
							placeholder="Entrez votre nom" value="${utilisateur.nom}"
							type="text" class="form-control" maxlength="30">

					</div>
					<div class="form-group col-xs-6 col-sm-6 col-md-6 col-lg-6">
						<label>Prénom :<br></label> <input name="prenom"
							placeholder="Entrez votre prénom" value="${utilisateur.prenom}"
							type="text" class="form-control" maxlength="30">


					</div>
					<div class="form-group col-xs-6 col-sm-6 col-md-6 col-lg-6">
						<label>Email : <br></label> <input name="email"
							placeholder="Entrez votre email" value="${utilisateur.email}"
							type="text" class="form-control" maxlength="50">

					</div>
					<div class="form-group col-xs-6 col-sm-6 col-md-6 col-lg-6">
						<label>Téléphone :<br></label> <input name="telephone"
							placeholder="Entrez votre numéro de téléphone"
							value="${utilisateur.telephone}" type="text" class="form-control"
							maxlength="15">

					</div>
					<div class="form-group col-xs-6 col-sm-6 col-md-6 col-lg-6">
						<label>Code Postal :<br></label> <input name="codePostal"
							placeholder="Entrez votre code postal"
							value="${utilisateur.codePostal}" type="text"
							class="form-control" maxlength="10">

					</div>

					<div class="form-group col-xs-6 col-sm-6 col-md-6 col-lg-6">
						<label>Rue :<br></label> <input name="rue"
							placeholder="Entrez votre rue" value="${utilisateur.rue}"
							type="text" class="form-control" maxlength="30">

					</div>
					<div class="form-group col-xs-6 col-sm-6 col-md-6 col-lg-6">
						<label>Ville :<br></label> <input name="ville"
							placeholder="Entrez votre ville" value="${utilisateur.ville}"
							type="text" class="form-control" maxlength="30">

					</div>
					<div class="form-group col-xs-6 col-sm-6 col-md-6 col-lg-6">
						<label>Mot de passe actuel :<br></label> <input name="mdp"
							placeholder="Entrez votre mot de passe" type="password"
							class="form-control" maxlength="30">

					</div>

					<div class="form-group col-xs-6 col-sm-6 col-md-6 col-lg-6">


					</div>
					<div class="form-group col-xs-6 col-sm-6 col-md-6 col-lg-6">
						<label>Nouveau mot de passe :<br></label> <input
							name="nouveaumdp" placeholder="Entrez votre nouveau mot de passe"
							type="password" class="form-control" maxlength="30">

					</div>

					<div class="form-group col-xs-6 col-sm-6 col-md-6 col-lg-6">
						<label>Confirmation mot de passe :<br></label> <input
							name="mdpConf"
							placeholder="Merci de confirmer votre mot de passe"
							type="password" class="form-control" maxlength="30">

					</div>

					<div class="form-group col-xs-6 col-sm-6 col-md-6 col-lg-6">
						<label>Credit
							<p>${utilisateur.credit}</p> <br>
						</label>


					</div>
				</div>

				<div class="form-group col-xs-6 col-sm-6 col-md-6 col-lg-6"></div>


				<div class="form-group col-xs-6 col-sm-6 col-md-6 col-lg-6">
					<a class="btn btn-lg"
						href="/Projet_Echere_Ami_Objet/profilConnecte"><button
							type="submit" name="updateSubmit" value="updateSubmit"
							class="btn lienBouton bleu fatBoutonHalf">Enregistrer</button></a>
				</div>
				<div class="form-group col-xs-6 col-sm-6 col-md-6 col-lg-6">
					<a class="btn btn-lg" href="/Projet_Echere_Ami_Objet/Supressionutilisateur">Supprimer mon compte</a>
				</div>
			</form>
		</div>

	</div>


</body>
</html>
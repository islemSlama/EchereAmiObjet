<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<jsp:include page="/WEB-INF/fragments/head.jsp"></jsp:include>
<%@ include file="./fragments/header.html"%>
</head>


<body >
  <div class ="container">
  
	  
	<h2 class="text-center">Mon profil</h2>
	
	
	<div class="form-group">
	              <form action="creerProfil"  method="post">
  	        	<div class="row">
						<div class="form-group col-xs-6 col-sm-6 col-md-6 col-lg-6">
							<label>Pseudo :<br></label>
							
		
								<input name="pseudo" placeholder="Entrez votre pseudo" type="text" class="form-control"  maxlength="30">
							
						</div>
						<div class="form-group col-xs-6 col-sm-6 col-md-6 col-lg-6">
							<label>Nom :<br></label>
							
								<input name="nom" placeholder="Entrez votre nom" type="text" class="form-control"  maxlength="30">
							
						</div>
						<div class="form-group col-xs-6 col-sm-6 col-md-6 col-lg-6">
							<label>Pr�nom :<br></label>
							
							
							
								<input name="prenom" placeholder="Entrez votre pr�nom" type="text"  class="form-control"  maxlength="30">
							
							
						</div>
						<div class="form-group col-xs-6 col-sm-6 col-md-6 col-lg-6">
							<label>Email : <br></label>
							
								<input name="email" placeholder="Entrez votre email" type="text" class="form-control"  maxlength="50">
							
						</div>
						<div class="form-group col-xs-6 col-sm-6 col-md-6 col-lg-6">
							<label>T�l�phone :<br></label>
							
								<input name="telephone" placeholder="Entrez votre num�ro de t�l�phone" type="text" class="form-control"  maxlength="15">
							
						</div>
						<div class="form-group col-xs-6 col-sm-6 col-md-6 col-lg-6">
							<label>Code Postal :<br></label>
							
								<input name="codePostal" placeholder="Entrez votre code postal" type="text" class="form-control"  maxlength="10">
							
						</div>
								
						<div class="form-group col-xs-6 col-sm-6 col-md-6 col-lg-6">
							<label>Rue :<br></label>
							
								<input name="rue" placeholder="Entrez votre rue" type="text"  class="form-control"  maxlength="30">
							
						</div>
						<div class="form-group col-xs-6 col-sm-6 col-md-6 col-lg-6">
							<label>Ville :<br></label>
							
								<input name="ville" placeholder="Entrez votre ville" type="text"  class="form-control"  maxlength="30">
							
						</div>
						<div class="form-group col-xs-6 col-sm-6 col-md-6 col-lg-6">
							<label>Mot de passe :<br></label>
							<input name="mdp" placeholder="Entrez votre mot de passe" type="password" class="form-control"  maxlength="30">
							
						</div>		
						<div class="form-group col-xs-6 col-sm-6 col-md-6 col-lg-6">
							<label>Confirmation mot de passe :<br></label>
							<input name="mdpConf" placeholder="Merci de confirmer votre mot de passe" type="password" class="form-control"  maxlength="30">
							
						</div>
						<div class="form-group col-xs-6 col-sm-6 col-md-6 col-lg-6">
							<a class="btn btn-lg" href="#"><button type="submit" class="btn lienBouton bleu fatBoutonHalf">Cr�er</button></a>
						</div>
						<div class="form-group col-xs-6 col-sm-6 col-md-6 col-lg-6">
							<a class="btn btn-lg" href="Accueil"><button type="button" class="btn lienBouton red fatBoutonHalf">Annuler</button></a>
						</div>
					</div>
				</form>
			</div>
		</div>

</body>
</html>
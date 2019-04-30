<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<jsp:include page="/WEB-INF/fragments/head.jsp"></jsp:include>
		<jsp:include page="./fragments/header.jsp" />
</head>

<body>
	<div class="container">
			
			<div class="row">
	        	<div class="col-sm-3"></div>
				<form action="Connexion" method="post" class="col-sm-6">
					<div class="form-group">
					   <label>Identifiant :</label>	
					 				<input name="identifiant" placeholder="Entrez votre identifiant" value="${identifiant}" type="text" class="form-control" maxlength="50">									   
					  
						
					</div>
					<div class="form-group">
						<label>Mot de passe :</label>
						<input name="password" placeholder="Entrez votre mot de passe" type="password" class="form-control" maxlength="30">
						
					</div>
	
					<div class="row">
						<div class="col-sm-3 col-md-5 offset-sm-1 offset-md-6 offset-lg-0">
							<a class="btn btn-lg" href="listeEncheres">
								<button type="submit" class="btn vert lienBouton fatBoutonHalf">Connexion</button>
							</a>
						</div>
						<div class="col-sm-3 col-md-7 offset-md-7 offset-lg-0">
							<div class="row">
								<div class="col-sm-12 col-md-12">
									<label class="checkbox">
										<input type="checkbox" name="alzheimer">&nbsp;Se souvenir de moi
									</label>
								</div>
							</div>
							<div class="row">
								<div class="col-sm-12 col-md-12">
									<a class="mdpOublie link" href="#">Mot de passe oublié</a>
								</div>
							</div>
						</div>
					</div>
				</form>
				</div>
			<div class="row">
				<div class="col-sm-12 offset-sm-3">
					<a class="btn btn-lg" href="/Projet_Echere_Ami_Objet/creerProfil">
						<button type="button" class="btn bleu lienBouton fatBoutonFull">Créer un compte</button>
					</a>
				</div>
			</div>
		</div>
				
			
</body>

</html>






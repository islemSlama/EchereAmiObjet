<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<jsp:include page="/WEB-INF/fragments/head.jsp"></jsp:include>
<%@ include file="./fragments/headerBis.html"%>
</head>
<body>
	<div class="container">
		
	
	      	<h1 class="center">Profil de ${utilisateur.pseudo}</h1>
	      	<div class="row">
				<div class="col-sm-6 offset-sm-4">
					<div class="row">
						<div class="col-sm-3">
							<label>Pseudo :<br></label>
						</div>
						<div class="col-sm-4 offset-sm-1">
							${utilisateur.pseudo}
						</div>
					</div>
					<div class="row">
						<div class="col-sm-3">
							<label>Nom :<br></label>
						</div>
						<div class="col-sm-4 offset-sm-1">
							${utilisateur.nom}
						</div>
					</div>
					<div class="row">
						<div class="col-sm-3">
							<label>Prenom :<br></label>
						</div>
						<div class="col-sm-4 offset-sm-1">
							${utilisateur.prenom}
						</div>
					</div>
					<div class="row">
						<div class="col-sm-3">
							<label>Email :<br></label>
						</div>
						<div class="col-sm-4 offset-sm-1">
							${utilisateur.email}
						</div>
					</div>
					
					<div class="row">
						<div class="col-sm-3">
							<label>Téléphone :<br></label>
						</div>
						<div class="col-sm-4 offset-sm-1">
							${utilisateur.telephone}
						</div>
					</div>
					
					<div class="row">
						<div class="col-sm-3">
							<label>Rue :<br></label>
						</div>
						<div class="col-sm-4 offset-sm-1">
							${utilisateur.rue}
						</div>
					</div>
					
					<div class="row">
						<div class="col-sm-3">
							<label>Code Postal :<br></label>
						</div>
						<div class="col-sm-4 offset-sm-1">
							${utilisateur.codePostal}
						</div>
					</div>
					
					<div class="row">
						<div class="col-sm-3">
							<label>Ville :<br></label>
						</div>
						<div class="col-sm-4 offset-sm-1">
							${utilisateur.ville}
						</div>
					</div>
					
					
                  	<div class="row">
                     	<div class="col-sm-6">
                           <a class="btn btn-lg" href="/Projet_Echere_Ami_Objet/profilConnecte"><button type="button" class="btn btn-secondary btn-block" >Back</button></a>
                     	</div>
                     	
                     <div class="row">
                     	<div class="col-sm-6">
                           <a class="btn btn-lg" href="/Projet_Echere_Ami_Objet/modifierProfil"><button type="button" class="btn btn-secondary btn-block" >Modifier</button></a>
                     	</div>
                     	
                     	
                  </div>
				</div>
			</div>
		</div>
	   

</body>


</html>
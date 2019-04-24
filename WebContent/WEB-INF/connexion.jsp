<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Connecxion</title>
</head>
<body class="container-fluid">
	<form action="Connexion" method="post">

		<jsp:include page="/WEB-INF/fragments/head.jsp"></jsp:include>
		<%@ include file="./fragments/header.html"%>



		<input type="submit" name="Connexion" />

		<div id="username" class="row">


			<br> Identifiant : <input type="text" name="uname" /> <br>
			Mot de passe :<input type="password" name="pass" />

		</div>

		<div>
			<div id="connexion" class="row">
				<button type="submit"
				class="btn btn-default btn-lg w-75 py-4 col-12 col-md-6 text-center py-2 align-middle h-100 align-self-center"
					id="searchbtn" value="Connexion"></button>
			</div>
			<br> <input type="checkbox" name="souvenir"> Se souvenir de moi <br> <a href="/Projet_Echere_Ami_Objet/MotDePasse">Mot de passe oublié</a>

	
		</div>
</form>
	<div
		class="col-12 col-md-8 text-center py-2 align-middle h-100 align-self-center">
		<a class="btn btn-default btn-lg w-75 py-4" type="submit"
			id="searchbtn" href="/Projet_Echere_Ami_Objet/creerProfil">Creer un compte</a>
			</div>
			
</body>

</html>
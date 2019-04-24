<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action ="ConnexionServlet" method= "post">

<jsp:include page="/WEB-INF/fragments/head.jsp"></jsp:include>

<body class="container-fluid">

 <input type = "submit" name ="ConnexionServlet"/>
 
 </form>
		<div id="username" class="row"></div>

		passe : <input type="password" name="pass" /> <br>
		Identifiant : <input type="text" name="uname" /> <br> Mot de
		</div>

			<div
		<div id="connexion" class="row">
				<a class="btn btn-default btn-lg w-75 py-4" type="submit"
				class="col-12 col-md-6 text-center py-2 align-middle h-100 align-self-center">
					id="searchbtn">Connexion</a>
			</div>
			<br> <input type="checkbox" name="souvenir"> Se souvenir
			de moi <br> <a href="/Projet_Echere_Ami_Objet/MotDePasse">

				Mot de passe oubli�</a>

	</form>
		</div>
	<%@ include file="./fragments/header.html"%>
	<div
		class="col-12 col-md-8 text-center py-2 align-middle h-100 align-self-center">
		<a class="btn btn-default btn-lg w-75 py-4" type="submit"
			id="searchbtn" href="/Projet_Echere_Ami_Objet/creerProfil">Creer
	</div>
			un compte</a>

</body>
</html>
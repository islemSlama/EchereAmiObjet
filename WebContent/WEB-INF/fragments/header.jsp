<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<header class="container-fluid">


	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<a class="navbar-brand" href="/Projet_Echere_Ami_Objet/Accueil">ENI-Encheres</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarNavDropdown">

			<ul class="navbar-nav ml-auto">

				<li class="nav-item"><a class="nav-link "
					href="/Projet_Echere_Ami_Objet/">Enchere</a></li>
				<li class="nav-item"><a class="nav-link "
					href="/Projet_Echere_Ami_Objet/NouvelleVente">Vendre un article</a></li>
					
					<li class="nav-item"><a class="nav-link "
					href="/Projet_Echere_Ami_Objet/AfficherProfil">Profil</a></li>
					
					
				<li class="nav-item">
				
				<a class="nav-link " href="/Projet_Echere_Ami_Objet/modifierProfil"> <c:if
							test="${sessionScope.usename != null}">
							<p>bonjour ${sessionScope.usename}</p>
						</c:if></a></li>


				<li class="nav-item"><a class="nav-link "
					href="/Projet_Echere_Ami_Objet/Connexion"> 
					
					<c:choose>
				      <c:when test="${sessionScope.usename != null}">
				     	<a  href="/Projet_Echere_Ami_Objet/Deconnexion"> 
				     					     	
				     	 Deconnection</a>
				      </c:when>
				
				      <c:otherwise>
				      	<p>Connection</p>
				      </c:otherwise>
				    </c:choose>
			

				</a></li>
			</ul>
		</div>
	</nav>
</header>


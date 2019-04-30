package fr.eni.javaee.ProjetEnchereAmiObjet.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.javaee.ProjetEnchereAmiObjet.bll.BLLException;
import fr.eni.javaee.ProjetEnchereAmiObjet.bll.UtilisateursManager;
import fr.eni.javaee.ProjetEnchereAmiObjet.bo.Utilisateur;
import fr.eni.javaee.ProjetEnchereAmiObjet.dal.DALException;

/**
 * Servlet implementation class modifierProfil
 */
@WebServlet("/modifierProfil")
public class modifierProfil extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public modifierProfil() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		UtilisateursManager utilisateurrecupere = new UtilisateursManager();
		// Récupération de la session (Id)

		HttpSession session = request.getSession();

		int idUtilisateur = (Integer) session.getAttribute("id");

		// Récupération de l'utilisateur dans la BDD qui correspond à l'id
		Utilisateur utilisateur = new Utilisateur();
		try {
			utilisateur = utilisateurrecupere.selectionnerUtilisateur(idUtilisateur);
		} catch (BLLException e) {
			e.printStackTrace();
		}

		// On passe l'utilisateur à la JSP via des setAttribute
		request.setAttribute("utilisateur", utilisateur);

		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/modifierProfil.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();

		int idUtilisateur = (Integer) session.getAttribute("id");

		int no_utilisateur = (int) session.getAttribute("id");
		String pseudo = request.getParameter("pseudo");
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String email = request.getParameter("email");
		String telephone = request.getParameter("telephone");
		String rue = request.getParameter("rue");
		String codepostal = request.getParameter("codePostal");
		String ville = request.getParameter("ville");
		String motDePasse = request.getParameter("mdp");
		String nouveaumdp = request.getParameter("nouveaumdp");
		String motDePasseConf = request.getParameter("mdpConf");

		Utilisateur utilisateurjsp = new Utilisateur(no_utilisateur, pseudo, nom, prenom, email, telephone, rue,
				codepostal, ville, motDePasse);

		UtilisateursManager managerUtilisateurModif = new UtilisateursManager();
		//
		// try {
		//
		// if (motDePasse != motDePasseConf) {
		// // pas bon!!!!
		// // FAUTE je ne peux pas faire ça ' BLLException.getMessage("mot de passe
		// // incorrecte!!");' car je suis dans ma servlet et mes erreurs
		// // servlet je les captes avec mon request.setAttribute("clé", "valeur")
		//
		// request.setAttribute("message", "mot de passe incorrecte!!");
		// response.sendRedirect("Connexion");
		// } else {
		// managerUtilisateurModif.updateUser(utilisateurjsp);
		//
		// response.sendRedirect("profilConnecte");
		// }
		// } catch (DALException e) {
		// response.sendRedirect("Connexion");
		// } catch (BLLException e) {
		// e.printStackTrace();
		// }

		if (request.getParameter("updateSubmit") != null) {
			try {
				System.out.println(utilisateurjsp);
				managerUtilisateurModif.updateUser(utilisateurjsp, nouveaumdp, motDePasseConf);
			} catch (BLLException | DALException e) {
				e.printStackTrace();
			}
		}
		if (request.getParameter("deleteSubmit") != null) {
			try {

				managerUtilisateurModif.supprimerUtilisateur(no_utilisateur);
			} catch (BLLException e) {
				e.printStackTrace();
			}
		}

		response.sendRedirect("modifierProfil");

	}

}

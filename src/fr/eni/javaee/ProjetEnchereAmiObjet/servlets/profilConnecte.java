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
 * Servlet implementation class profilConnectÃ©
 */
@WebServlet("/profilConnecte")
public class profilConnecte extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public profilConnecte() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/AccueilConnecteVente.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String pseudo = request.getParameter("pseudo");
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String email = request.getParameter("email");
		String telephone = request.getParameter("telephone");
		String rue = request.getParameter("rue");
		String codePostal = request.getParameter("codePostal");
		String ville = request.getParameter("ville");
		String motDePasse = request.getParameter("mdp");
		String confirmation = request.getParameter("mdpConf");

		UtilisateursManager utilisateursmanager;
		try {
			utilisateursmanager = UtilisateursManager.getInstance();
			Utilisateur monNouvUtilisateur = utilisateursmanager.addUtilisateur(pseudo, nom, prenom, email, telephone,
					rue, codePostal, ville, motDePasse);
			// au moment de la création de mon utilisateur je lui créé sa session.
			HttpSession session = request.getSession();
			session.setAttribute("id", monNouvUtilisateur.getNoUtilisateur());
			session.setAttribute("usename", monNouvUtilisateur);

		} catch (BLLException | DALException e) {
			e.printStackTrace();
		}

		response.sendRedirect("profilConnecte");
	}

}

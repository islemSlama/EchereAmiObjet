package fr.eni.javaee.ProjetEnchereAmiObjet.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.javaee.ProjetEnchereAmiObjet.bll.UtilisateursManager;
import fr.eni.javaee.ProjetEnchereAmiObjet.bo.Utilisateur;
import fr.eni.javaee.ProjetEnchereAmiObjet.dal.DALException;

/**
 * Servlet implementation class ServletConnexion
 */
@WebServlet("/Connexion")
public class ServletConnexion extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletConnexion() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/connexion.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String identifiant = request.getParameter("identifiant");
		String password = request.getParameter("password");

		Utilisateur utilisateurjsp = new Utilisateur(identifiant, password);

		UtilisateursManager managerUtilisateur = new UtilisateursManager();

		try {

			boolean valide = managerUtilisateur.validate(utilisateurjsp);
			if (valide) {
				HttpSession session = request.getSession();
				session.setAttribute("id", utilisateurjsp.getNoUtilisateur());
				session.setAttribute("usename", utilisateurjsp.getPseudo());
				// il faut pas oublié que j'envois vers une servlet et pas une jsp
				response.sendRedirect("profilConnecte");
			} else {
				response.sendRedirect("Connexion");
			}

		} catch (ClassNotFoundException | DALException e) {
			response.sendRedirect("Connexion");
		}
	}

}

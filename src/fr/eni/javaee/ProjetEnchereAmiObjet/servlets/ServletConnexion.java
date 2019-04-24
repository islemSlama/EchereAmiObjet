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
@WebServlet("/ConnexionServlet")
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

		String pseudo = request.getParameter("uname");
		String mot_de_passe = request.getParameter("pass");

		Utilisateur utilisateurjsp = new Utilisateur(pseudo, mot_de_passe);

		UtilisateursManager managerUtilisateur = new UtilisateursManager();

		try {
			boolean utilisateur = managerUtilisateur.validate(utilisateurjsp);
		} catch (ClassNotFoundException | DALException e) {
			e.printStackTrace();
		}

		HttpSession session = request.getSession();

		if ((pseudo.equals(pseudo)) && (mot_de_passe.equals(mot_de_passe))) {

			session.setAttribute("usename", pseudo);
			response.sendRedirect("loginsuccess.jsp");

		} else

		{
			response.sendRedirect("connexion.jsp");
		}
	}

}

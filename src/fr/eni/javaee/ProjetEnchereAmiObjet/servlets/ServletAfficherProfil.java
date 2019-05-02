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

/**
 * Servlet implementation class ServletAfficherProfil
 */
@WebServlet("/AfficherProfil")
public class ServletAfficherProfil extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletAfficherProfil() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Utilisateur utilisateur = null;

		HttpSession session = request.getSession();

		int idUtilisateur = (Integer) session.getAttribute("id");

		UtilisateursManager managerUtilisateurModif = new UtilisateursManager();

		try {

			utilisateur = managerUtilisateurModif.selectionnerUtilisateur(idUtilisateur);

			// On passe l'utilisateur à la JSP via des setAttribute
			request.setAttribute("utilisateur", utilisateur);

			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/modifierProfil.jsp");
			rd.forward(request, response);

		} catch (BLLException e) {
			e.printStackTrace();
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

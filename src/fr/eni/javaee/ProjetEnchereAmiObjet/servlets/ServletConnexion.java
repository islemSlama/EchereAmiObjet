package fr.eni.javaee.ProjetEnchereAmiObjet.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.javaee.ProjetEnchereAmiObjet.bo.Utilisateur;

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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher rd = request.getRequestDispatcher( "/WEB-INF/connexion.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
	
		
		String uname = request.getParameter("uname");
		String pass = request.getParameter("pass");
		
		//Utilisateur utilisateurjsp = new Utilisateur(uname, pass);
		//ManagerUtilisateur managerUtilisateur =new ManagerUtilisateur();
		
	//	Utilisateur utilisateur = managerUtilisateur.seConnecter(utilisateurjsp);
		
		HttpSession session = request.getSession();
		
		if ((uname.equals("Andrea"))&& (pass.equals("bob"))) {
			
			
			
			session.setAttribute("usename", uname);
			
			
			
		}
		else
			
		{
			response.sendRedirect("connexion.jsp");
		}
	}

	}



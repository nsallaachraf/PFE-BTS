package Controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.UtilisateurDAO;
import Models.Utilisateur;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/Login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Connexion cn = Connexion.getInstance();
		//System.out.println(cn.isConnected);
		if(request.getParameterMap().containsKey("logIn")) {
			String emailUtilisateur = request.getParameter("Email");
			String passwordUtilisateur = request.getParameter("Password");
			UtilisateurDAO userDAO = new UtilisateurDAO();
			Utilisateur user = userDAO.getUserByEmail(emailUtilisateur);
			
				RequestDispatcher view;
				
				boolean isLogging = false;
		
				if(user.getEmailUtilisateur().equals(emailUtilisateur) && user.getPasswordUtilisateur().equals(passwordUtilisateur)){
						HttpSession session = request.getSession();
						isLogging = true;
						session.setAttribute("idUtilisateur", user.getIdUtilisateur());
						session.setAttribute("isLogging", "true"); //Present Continuous : it means the user is logging or not
						System.out.println(emailUtilisateur + " " + passwordUtilisateur);
						System.out.println();
						System.out.println(user);
						
				}
				
				if(isLogging){
					view = request.getRequestDispatcher("./Message.jsp");      
			        view.forward(request, response);
				} else{
					request.setAttribute("error", "Username or password incorrect");
					view = request.getRequestDispatcher("./login.jsp");  
					view.forward(request, response);
				}
		} else if(request.getParameterMap().containsKey("logOut") && !request.getSession().equals(null)) {
				request.getSession().invalidate();
				response.sendRedirect("./login.jsp");
		}
	}
}

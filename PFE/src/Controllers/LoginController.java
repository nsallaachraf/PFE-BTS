package Controllers;

import java.io.IOException;
import java.util.ArrayList;

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
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		UtilisateurDAO userdao = new UtilisateurDAO();
		ArrayList<Utilisateur> users = new ArrayList<Utilisateur>();
		RequestDispatcher view;
		boolean isLogged = false;
		
		
		users = userdao.getUsers();
		
		for(Utilisateur u : users){
			if(u.getNom_de_compte().equals(username) && u.getMot_de_pass().equals(password)){
				HttpSession session = request.getSession();
				isLogged = true;
				session.setAttribute("id", u.getId());
				session.setAttribute("isLogged", "true");
				
			}
		}
		if(isLogged){
			view = request.getRequestDispatcher("./login.jsp");      
	        view.forward(request, response);
		}else{
		request.setAttribute("error", "Username or password incorrect");
		view = request.getRequestDispatcher("/login.jsp");  
		view.forward(request, response);
		}
	}

}

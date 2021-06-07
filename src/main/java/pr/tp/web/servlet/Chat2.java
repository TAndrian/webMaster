package pr.tp.web.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name ="chat2", urlPatterns="/chat2")
public class Chat2 extends HttpServlet {
	private static final long serialVersionUID = 197811968639586823L;
	private StringBuffer chatContent;
	
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		//PARTIE 4 : Configuration du message de bienvenue
		//Recupération des paramètres de l'application
		ServletContext context = config.getServletContext();
		String contenue = context.getInitParameter("welcome");
		
		//création du contenue de la page chat
		chatContent = new StringBuffer();
		chatContent.append(contenue).append("\n");

		
		//Contenue de la page fait manuellement.
//		chatContent = new StringBuffer();
//		chatContent.append("Bienvenue sur le chat!").append("\n");
//		chatContent.append("Soyez polis").append("\n");
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		boolean create = true ;
		HttpSession session = request.getSession(create);
		//To get the user
		String user = (String) session.getAttribute("user");
		
		//Si le champ usename est vide, redirection vers la page login
		if(user == null) {
			response.sendRedirect("login");
			
		//sinon affichage de la page du chat
		}else {
			
			RequestDispatcher rd = request.getRequestDispatcher("/chat.jsp");
			request.setAttribute("content", chatContent.toString());
			rd.include(request, response);
		}
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		String action = request.getParameter("action");
		
		if (action != null && action.equals("submit")) {
		    // Ajouter la ligne au contenu
			chatContent.append(request.getParameter("ligne"));
			chatContent.append("\n");
			
			doGet(request, response);
		}
		else {
			//raffraichissment de la page : reset du son contenu
			this.init();
			doGet(request, response);
		}
	}
}

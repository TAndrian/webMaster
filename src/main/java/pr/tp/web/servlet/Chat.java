package pr.tp.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/chat")
public class Chat extends HttpServlet {
	private static final long serialVersionUID = 197811968639586823L;
	private StringBuffer chatContent;

	/**
	 * Initialisation du servlet
	 */
	public void init() throws ServletException {
		chatContent = new StringBuffer();

		chatContent.append("Bienvenue sur le chat").append("\n");

		chatContent.append("Soyez polis").append("\n");
	}
	
	
	/**
	 * Conversion du contenue du chat en string
	 * @return Le contenue du chat en string
	 */
	private String getContent() {
		return   this.chatContent.toString();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head><title>Chat anonyme</title></head>");
		out.println("<body>");
		String name = request.getParameter("name");
		if (name != null) {
			out.println("Hello " + name);
		} else {
			out.println("Hello jeune inconnue!");
		}
		
		//Affichage du contenue du message
		out.println("<pre>" + this.getContent() + "</pre>");
		
		//Formulaire
		out.println(" <form name= \"chatForm\" action= \"chat\" method=\"post\">");
		out.println("<input type=\"text\" name=\"ligne\" value=\"\"/>");
		out.println("<input type=\"submit\" name=\"action\" value=\"submit\"/>");
		out.println(" <input type=\"submit\" name=\"action\" value=\"refresh\" />");
		out.println(" </form>");
		
		out.println("</body>");
		out.println("</html>");
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		
		if (action != null && action.equals("submit")) {
		    // Ajouter la ligne au contenu
			chatContent.append(request.getParameter("ligne"));
			chatContent.append("\n");
			
			doGet(request, response);
		}
		else {
			this.init();
			doGet(request, response);
		}
	}
}

package pr.tp.web.example;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "params", urlPatterns = { "/params" })
public class ServletAvecParam extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void init(ServletConfig config) throws ServletException {
		// Récupération des paramètres de la servlet
		Enumeration<String> e2 = config.getInitParameterNames();
		while (e2.hasMoreElements()) {
			String key = e2.nextElement();
			String value = config.getInitParameter(key);
			System.out.println(" " + key + " = " + value);
		}
		// Récupération des paramètres de l'application :
		ServletContext context = config.getServletContext();
		Enumeration<String> e = context.getInitParameterNames();
		while (e.hasMoreElements()) {
			String key = e.nextElement();
			Object value = context.getInitParameter(key);
			System.out.println(" " + key + " = " + value);
		}
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getServletContext()
				.getRequestDispatcher("/index.jsp");
		dispatcher.forward(request, response);
	}
}

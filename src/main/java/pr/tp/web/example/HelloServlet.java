package pr.tp.web.example;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "hello", urlPatterns = { "/hello" })
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head><title>Hello World</title></head>");
		out.println("<body>");
		String nom = request.getParameter("nom");
		if (nom != null) {
			out.println("Hello " + nom);
		} else {
			out.println("Hello World");
		}

		out.println("</body>");
		out.println("</html>");
	}

}

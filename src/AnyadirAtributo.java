

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/anyadir")
public class AnyadirAtributo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public AnyadirAtributo() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Reuperamos los dos atributos que nos manda el formulario
		String atributo = request.getParameter("atributo");
		String valor = request.getParameter("valor");
		
		HttpSession sesion = request.getSession();
		
		//Añadimos a la sesión la información del formulario
		sesion.setAttribute(atributo, valor);
		
		//Salida del servlet para el usuario.
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='utf-8'>");
		out.println("<title> Titulo </title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>Sesión del usuario </h1>");
		
		Enumeration<String> nombresDeAtributos = sesion.getAttributeNames();
		
		
		while (nombresDeAtributos.hasMoreElements()) {
			
			 atributo =  nombresDeAtributos.nextElement();
			 valor = (String) sesion.getAttribute(atributo);
			 
			 out.println("<p>Atributo: " + atributo + "</p>");
			 out.println("<p>Valor: " + valor + "</p><hr>");
			
		}
		
		
		out.println("<p> Contenido </p>");
		out.println("</body>");
		out.println("</html>");


	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

}

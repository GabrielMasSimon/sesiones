

import java.io.IOException;
import java.io.PrintWriter;

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
		sesion.setAttribute("atributo", "valor");
		
		//Salida del servlet para el usuario.
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		
		out.write("<!DOCTYPE html>");
		out.write("<html>");
		out.write("<head>");
		out.write("<meta charset='utf-8'>");
		out.write("<title> Titulo </title>");
		out.write("</head>");
		out.write("<body>");
		out.write("<h1>Header </h1>");
		out.write("<p> Contenido </p>");
		out.write("</body>");
		out.write("</html>");


	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

}

// Con unos retoques para arreglarlo ;->)
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class RequestParameters extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws IOException, ServletException
    {
    	String nombre = request.getParameter("nombre");
    	String apell1 = request.getParameter("apell1");
    	String errorMsg = "Error  ";
	response.setContentType("text/html");
        String nextStop = "formulario1.html";
	PrintWriter out = response.getWriter();
        boolean error=false;
	//ServletContext context=getServletContext();
	
	if(nombre.equals("") || apell1.equals(""))
	{
		errorMsg+="Faltan datos a introducir";
		error=true;
	}
	if(error)
	{
		response.getWriter().print(errorMsg);
		nextStop="formulario1.html";
	}
	RequestDispatcher rd;
	//rd = getServletContext().getRequestDispatcher(nextStop);
	rd = request.getRequestDispatcher(nextStop);
	if(nextStop.equals("formulario1.html"))
	{
		//response.setAttribute(nombre,nombre);
		//(String)context.getAttribute(nombre);
		request.setAttribute("nombre",nombre);
		rd.sendRedirect(request,response);
		//rd.include(request,response);
	}
	else
	{
		rd.forward(request,response);
	}



    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
    throws IOException, ServletException
    {
        doGet(request, response);
    }
}

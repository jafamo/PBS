import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Principal extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws IOException, ServletException
    {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        Enumeration e = request.getHeaderNames();
	

        out.println("<html>");
        out.println("<body>");
        out.println("<head>");
        out.println("<title>Pagina del servlet Principal</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h3>Request Information Javier Farinos</h3>");
        
	    out.println("Method: " + request.getMethod() + "<P>");
        out.println("Request URI: " + request.getRequestURI() + "<P>");
        out.println("Protocol: " + request.getProtocol() + "<P>");
        out.println("PathInfo: " + request.getRequestURI().substring(request.getContextPath().length()) + "<P>");
        //out.println("Path URL de la llamada al servlet" + request.getServletPath() +"<P>");
        out.println("Remote Address: " + request.getRemoteAddr()+ "<P>");

	
	
        

	while (e.hasMoreElements()) 
        {
            String name = (String)e.nextElement();
            String value = request.getHeader(name);
            out.println(name + " = " + value + "<P>");
        }

	   out.println("</body>");
       out.println("</html>");
	   out.close();

    }

    /**
* We are going to perform the same operations for POST requests
* as for GET methods, so this method just sends the request to
* the doGet method.
*/

    public void doPost(HttpServletRequest request, HttpServletResponse response)
    throws IOException, ServletException
    {
        doGet(request, response);
    }
}

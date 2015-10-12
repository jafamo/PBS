import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class RequestInfo extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws IOException, ServletException
    {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<body>");
        out.println("<head>");
        out.println("<title>Request Information Example</title>");
        out.println("</head>");
        
	out.println("<body>");
        out.println("<h3>Request Information Example</h3>");
        
	out.println("Method: " + request.getMethod() + "<P>");
        
	out.println("Request URI: " + request.getRequestURI() + "<P>");
        
	out.println("Protocol: " + request.getProtocol() + "<P>");
        
	out.println("PathInfo: " + request.getPathInfo() + "<P>");
        
	out.println("Remote Address: " + request.getRemoteAddr());
        
	out.println("</body>");
        
	out.println("</html>");

	//line add 
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

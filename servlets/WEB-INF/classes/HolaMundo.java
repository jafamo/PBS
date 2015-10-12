
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class HolaMundo extends HttpServlet {
  @Override
  public void doGet(HttpServletRequest peticion,HttpServletResponse respuesta)throws ServletException, IOException {
    
	  respuesta.setContentType("text/html");
	  PrintWriter salida = respuesta.getWriter();
	  salida.println("<html>\n" +
                "<head><title>Hola Mundo!</title></head>\n" +
                "<body>\n" +
                "<h1>Hola Mundo!</h1>\n" +
                "</body></html>");
  }  
}

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;


public class Form1 extends HttpServlet
{
  public void init(ServletConfig conf)
        throws ServletException
  {
        super.init(conf);
  }

  public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
      throws ServletException, IOException {

    response.setContentType("text/html");
    PrintWriter out = response.getWriter();
    RequestDispatcher rd = request.getRequestDispatcher("formularioAComprobar.html");

    //Escribimos el principio de la página HTML
    //out.println("<html>");
    //out.println("<body>");
    //out.println("<h1>Parámetros del servlet desde un formulario HTML</h1>");


    //cogemos los nombres de los parametros
    Enumeration paramNames = request.getParameterNames();

    //vamos mostrando los parámetros en un while
    while(paramNames.hasMoreElements()) 
    {
      //cogemos el siguiente parámetro
      String paramName = (String)paramNames.nextElement();

      //Mostramos el nombre del parámetro   
      out.print(paramName + " = ");

      //Cogemos los valores del parámetro
      String[] paramValues = request.getParameterValues(paramName);




      //Miramos si tiene más de un valor 
      if (paramValues.length == 1) 
      {
        //Si tiene un sólo valor, miramos si está vacío o no
        String paramValue = paramValues[0];
        if (paramValue.length() == 0)
        {
          out.println("<i>"+paramValue+" Volver  introducir.</i><br>");
          //rd.include(request,response);
        }
        else
          out.println(paramValue + "<br>");
      }
      else {
    //Si tiene más de un sólo valor, los mostramos
        for(int i=0; i<paramValues.length; i++) 
          out.println(paramValues[i] + ", ");
    out.println("<br>");
	//ServletContext app = getServletConfig().getServletContext();

	}
    }//end while
	//out.println("<i>"+paramValue+"<P>")
	rd.include(request,response);

    //Escribimos el final de la página HTML
    out.println("</body>");
    out.println("</html>");
  }



  public void doPost(HttpServletRequest request,
                     HttpServletResponse response)
      throws ServletException, IOException {
    doGet(request, response);
  }
}

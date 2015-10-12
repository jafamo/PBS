import javax.servlet.*;
    import javax.servlet.http.*;
    import java.io.*;
    import java.util.*;

    public class Ejemplo extends HttpServlet {
        public void service (HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
            resp.setContentType("text/html");
            PrintWriter out= resp.getWriter();

            // obtiene los valores del formulario
            String lengupref  =req.getParameter("lengupref");
            String sopref     =req.getParameter("sopref");
            String[] lengusa  =req.getParameterValues("lengusa");
            String[] tecno    =req.getParameterValues("tecno");

            if (lengusa==null) lengusa= new String[0];
            if (tecno==null)  tecno = new String[0];

            // escribe los valores en un fichero
            try {
                PrintWriter fout= new PrintWriter(new FileWriter("datos",true));
                fout.println(lengupref); fout.println(sopref);
                for (int i=0; i<lengusa.length; i++) {
                    if (i>0) fout.print(", ");
                    fout.print(lengusa[i]);
                }
                for (int i=0; i<tecno.length; i++) {
                    if (i>0) fout.print(", ");
                    fout.print(tecno[i]);
                }
                fout.println(); fout.println("----------");
                fout.close();

                out.println("<HTML>\n<BODY>\n" +
                    "<H1>Gracias</H1>\n" +
                    "Gracias por participar en la encuesta\n" +
                    "</BODY>\n</HTML>\n");
            } catch (IOException e) {
                out.println("<HTML>\n<BODY>\n" +
                    "<H1>Error</H1>\n" +
                    "No se han podido grabar las respuestas" +
                    "debido a un error en el servidor\n" +
                    "</BODY>\n</HTML>\n");
            }
        }
    }

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Locale;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;

public class parametro extends HttpServlet {

	  public void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws IOException, ServletException
	    {
	        doGet(request, response);
	    }

	  public void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws IOException, ServletException
	    {		  
		    response.setContentType("text/html");
	        PrintWriter out = response.getWriter();

	        out.println("<html>");
	        out.println("<head>");
	        out.println("<title>Printenv en version Servlet</title>");
	        out.println("</head>");
	        out.println("<body>");
	        out.println("<h1><center>Parametros en version Servlet</center></h1><hr>");
	        Enumeration<String> p = request.getParameterNames();
	        
	        while(p.hasMoreElements()) {
	            String name = (String)p.nextElement();
	            String value = request.getParameter(name);
	            out.println("</br>");
	            out.println(name.toUpperCase() + ": " + value);
	        }

	        out.println("<h3><center>Entorno</center></h3><hr>");
	        Enumeration<String> e = request.getHeaderNames();
	        while(e.hasMoreElements()) {
	            String name = (String)e.nextElement();
	            String value = request.getHeader(name);
	            out.println("</br>");
	            out.println(name.toUpperCase() + ": " + value);
	        }
	        out.println("</br>METHOD: " + request.getMethod());
	        out.println("</br>PROTOCOL: " + request.getProtocol());
	        out.println("</br>REQUEST URI: " + request.getRequestURI());
	        out.println("</br>QUERY STRING: " + request.getQueryString()); 
	        out.println("</br>PATH INFO: " + request.getPathInfo());
	        out.println("</br>CONTEXT PATH: " + request.getContextPath()); 
	        out.println("</br>HOST ADDRESS: " + request.getLocalAddr());
	        out.println("</br>SERVER NAME: " + request.getServerName());
	        out.println("</br>SERVER PORT: " + request.getServerPort());
	        out.println("</br>LOCAL PORT: " + request.getLocalPort());
	        out.println("</br>REMOTE PORT: " + request.getRemotePort());         
	        out.println("</br>REMOTE ADDRESS: " + request.getRemoteAddr());
	         
	        
	        out.println("<h3><center>Informacion del sistema</center></h3><hr>");
	        
	        RuntimeMXBean bean = ManagementFactory.getRuntimeMXBean();
	       
	        String vm = bean.getName();

	        long pid = Long.valueOf(vm.split("@")[0]);
	        out.println("</br>PID = " + pid);
	        long tiempo = bean.getUptime();
	        out.println("</br>UPTIME = " + tiempo/1000 + " segundos");
	        out.println("</body>");
	        out.println("</html>");
	    }

}

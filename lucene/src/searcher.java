

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.queryParser.QueryParser;
import org.apache.lucene.search.Hits;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;

/**
 * Servlet implementation class searcher
 */
public class searcher extends HttpServlet {
	  public void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws IOException, ServletException
	    {
	        try {
				doGet(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }

	  public void doGet(HttpServletRequest request, HttpServletResponse response) 	    throws IOException, ServletException
	    {	
		  
		
		  
		    File indexDir = new File("/labos/alumnos/joviig/indexacion");
		    String q = request.getParameter("cadena");
		    String tipo= request.getParameter("opciones");
		    response.setContentType("text/html");
		     PrintWriter out = response.getWriter();	  
		     String resbusqueda = null;
		    int tipo1= Integer.parseInt(tipo);

		    if (!indexDir.exists() || !indexDir.isDirectory()) {
		     
		 
		    }

		    try {
				resbusqueda= search(indexDir, q, tipo1);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		     
		       
		       
		    	   out.println("<html>");
			       out.println("<head>");
			       out.println("<title>Formulario a comprobar</title>");
			       out.println("</head>");
			       out.println("<body bgcolor='#ddf5e7'><h3 align='center'>Buscador PBS</h1>");
			       
			       
			       out.println("<br>");
			      // out.println(tipo);
			       out.println(resbusqueda);
			       out.println("</body>");
			       out.println("</html>");	   
		       
			
		  }
		  

	  
	  

	
	 public static String search(File indexDir, String q, Integer tipo1)
	    throws Exception {
	    Directory fsDir = FSDirectory.getDirectory(indexDir, false);
	    IndexSearcher is = new IndexSearcher(fsDir);
	    String busqueda="";
	    String res="";
	    String debugg="";
	    

//	    Query query = QueryParser.parse(q, "contents", new StandardAnalyzer());   DEPRECATED
	    Query query=null;
	    
	   if (tipo1==0){
		   QueryParser qp = new QueryParser("filename", new StandardAnalyzer());
		    query = qp.parse(q);
		    debugg="filename--------";
		    
	   }else{
		   QueryParser qp = new QueryParser("contents", new StandardAnalyzer()); 
		    query = qp.parse(q);
		    debugg="contents -------";
		   
	   }
	   
//	    QueryParser qp = new QueryParser("filename", new StandardAnalyzer());
//	    query = qp.parse(q);
	    long start = new Date().getTime();
	    Hits hits = is.search(query);
	    long end = new Date().getTime();

	    System.err.println("Found " + hits.length() +
	      " document(s) (in " + (end - start) +
	      " milliseconds) that matched query '" +
	        q + "':");

	    busqueda="<br>Resultados: "+hits.length()+"<br> ";
	    for (int i = 0; i < hits.length(); i++) {
	      Document doc = hits.doc(i);
	      //System.out.println(doc.get("filename"));
	      res=doc.get("filename");
	      res=res.substring(16);
	      busqueda=busqueda+"<br><a href=http://memex.dsic.upv.es/manual/"+res+">"+res+"</a>";
	    }
	    return busqueda;
	  }
}

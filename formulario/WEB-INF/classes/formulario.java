import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class formulario
 */
public class formulario extends HttpServlet 
{
		
		public boolean isParsableToInt(String i)
		{
			try
			{
				Integer.parseInt(i);
				return true;
			}
			catch(NumberFormatException nfe)
			{
				return false;
			}
		}


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
	     
	       if(request.getParameter("numElem")==null)
	       {
	    	   out.println("<html>");
		       out.println("<head>");
		       out.println("<title>Formulario a comprobar</title>");
		       out.println("</head>");
		       out.println("<body><h2 align='center'>No has pasado ningún parámetro</h2>");
		       //lo enviamos a el formulario.html
		       out.println("<br><br><h3 align='center'><a href='formulario.html'>Ir al formulario</a></h3>");
		       out.println("</body>");
		       out.println("</html>");	   
	       }		
	       //comprobar todos los parametros contienen algo.
	       
	       
	       else
	       {
			  	boolean error=false;
			  	if (request.getParameter("numElem").length()==0)
		        {	        
		        	error=true;
		        }
		        if (request.getParameter("descripcion").length()==0)
		        {	        	
		        	error=true;
		        } 
		        if (request.getParameter("precio").length()==0)
		        {	        	
		        	error=true;
		        } 
		        if (request.getParameter("nombre").length()==0)
		        {	        	
		        	error=true;
		        } 
		        if (request.getParameter("apell1").length()==0)
		        {	        	
		        	error=true;
		        } 
		        if (request.getParameter("apell2").length()==0)
		        {	        	
		        	error=true;
		        } 
		        if (request.getParameter("direccion").length()==0)
		        {	        	
		        	error=true;
		        } 
		        if (request.getParameter("tarjeta")==null)
		        {	        	
		        	error=true;
		        } 
		        if (request.getParameter("numTarj1").length()!=12){

		        	error=true;
		        }  
		        for (int i = 0; i < request.getParameter("numTarj1").length()   ; i++)
		        {
		        	
		        	if (!isParsableToInt(String.valueOf(request.getParameter("numTarj1").charAt(i)))){
		        		error=true;
		        	}
		    
		        }
		        if (!request.getParameter("numTarj2").contentEquals(request.getParameter("numTarj1")))
		        {	        	
		        	error=true;
		        }
		        
		        if (request.getParameter("select")==null || request.getParameterValues("select").length<1 )
		        {	        	
		        	error=true;
		        }
		        if (!isParsableToInt(request.getParameter("precio")))
		        {	        	
		        	error=true;
		        } 
		        
		        
		        //mostramos el formulario si tenemos error
		        if (error)
		        {     
			        out.println("<html>");
			        out.println("<head>");
			        out.println("<title>Formulario a comprobar</title>");
			        out.println("</head>");
			        out.println("<body><h1 align='center'>Formulario a comprobar</h1><form action='formulario'>");
			        
			        //  Código del elemento
			        out.println("<br>Código del elemento: <input name='numElem' value='"+request.getParameter("numElem")+"' type='text'>");
			        if (request.getParameter("numElem").length()==0)
			        {	        
			        	 out.println("<p>Introducir numElem.</p>");
			        }
			       
			        //  Descripción 
			        out.println("<br>Descripción: <input name='descripcion' value='"+request.getParameter("descripcion")+"' type='text'>");
			        if (request.getParameter("descripcion").length()==0)
			        {	        	
			        	 out.println("<p>Introducir Descripcion.</p>");
			        } 
			     	
			     	//  Precio por unidad
			        out.println("<br>Precio por unidad: <input name='precio' value='"+request.getParameter("precio")+"' type='text'>");
			        if (request.getParameter("precio").length()==0)
			        {	        	
			        	 out.println("<p>Introduzca Precio.</p>");
			        } 
			        if (!isParsableToInt(request.getParameter("precio")))
			        {	        	
			        	 out.println("<p>Introducir número.</p>");
			        } 
			     	
			     	//  Nombre
			        out.println("<br>Nombre: <input name='nombre' value='"+request.getParameter("nombre")+"' type='text'>");
			        if (request.getParameter("nombre").length()==0)
			        {	        	
			        	 out.println("<p>Introducir Nombre.</p>");
			        } 
			    	 //  Primer apellido
			        out.println("<br>Primer apellido: <input name='apell1' value='"+request.getParameter("apell1")+"' type='text'>");
			        if (request.getParameter("apell1").length()==0)
			        {	        	
			        	 out.println("<p>Introducir Apellido 1</p>");
			        } 
			     	//  Segundo apellido
			        out.println("<br>Segundo apellido: <input name='apell2' value='"+request.getParameter("apell2")+"' type='text'>");
			        if (request.getParameter("apell2").length()==0)
			        {	        	
			        	 out.println("<p>Introducir Apellido 2</p>");
			        } 
			     	//  Dirección
			        out.println("<br>Dirección: <textarea name='direccion' rows='3' cols='40'>"+request.getParameter("direccion")+"</textarea>");
			        if (request.getParameter("direccion").length()==0)
			        {	        	
			        	 out.println("<p>Introducir direccion.</p>");
			        } 
			       
			     	//  Tarjeta de crédito
			        out.println("<br>Tarjeta de crédito: ");
			        out.println(request.getParameter("tarjeta"));
			        if ( request.getParameter("tarjeta")==null || request.getParameter("tarjeta").length()==0)
			        {	        	
			        	 out.println("<p>Introducir numero de tarjeta</font>");
			        } 
			        else{
				        
				        if ( request.getParameter("tarjeta").equals("Visa") )
				        {	        	
				        	 out.println("<br><input name='tarjeta' value='Visa' type='radio' checked> Visa<br>");
				        }   
				        else{
				        	 out.println("<br><input name='tarjeta' value='Visa' type='radio' > Visa<br>");
				        }
				        
				        if ( request.getParameter("tarjeta").equals("MasterCard"))
				        {	        	
				        	 out.println("<input name='tarjeta' value='MasterCard' type='radio' checked> MasterCard<br>");
				        } 
				        else{
				        	 out.println("<input name='tarjeta' value='MasterCard' type='radio'> MasterCard<br>");
				        }
	
				        if ( request.getParameter("tarjeta").equals("Amex"))
				        {	        	
				        	 out.println("<input name='tarjeta' value='Amex' type='radio' checked> Amex<br>");
				        } 
				        else{
				        	out.println("<input name='tarjeta' value='Amex' type='radio'> Amex<br>");
				        }
	
				        if ( request.getParameter("tarjeta").equals("Java SmartCard"))
				        {	        	
				        	 out.println("<input name='tarjeta' value='Java SmartCard' type='radio' checked> Java SmartCard<br>");
				        } 
				        else{
				        	 out.println("<input name='tarjeta' value='Java SmartCard' type='radio'> Java SmartCard<br>");
				        }
			        
			        }
			        
			     // ##### Número de tarjeta de crédito
			        out.println("<br>Número de tarjeta de crédito: <input name='numTarj1' value='"+request.getParameter("numTarj1")+"' type='text'>");
			        
			        String var1 = "";
			        String var2 = "";
			       
			        if (request.getParameter("numTarj1").length()!=12){

			        	var1="Tiene que ser de 12 digitos.";
			        }  
			        for (int i = 0; i < request.getParameter("numTarj1").length()   ; i++)
			        {
			        	
			        	if (!isParsableToInt(String.valueOf(request.getParameter("numTarj1").charAt(i)))){
			        		var2="No es un número.";
			        	}
			    
			        }
			        out.println("<p>"+var1+" "+var2+"</p>");
			        
			        
			     	//  Repita el número de tarjeta de crédito
			        out.println("<br>Repetir el número de tarjeta de crédito: <input name='numTarj2' value='"+request.getParameter("numTarj2")+"' type='text'>");
			        
			        if (!request.getParameter("numTarj2").contentEquals(request.getParameter("numTarj1")))
			        {	        	
			        	 out.println("<p>los Password no coinciden</p>");
			        } 
			        
			     	//  Departamentos visitados
			        out.println("<br>Departamentos visitados: ");
			        if (request.getParameterValues("select")==null || request.getParameterValues("select").length<1)
			        {	        	
			        	 out.println("<select name='select' size='6' multiple='multiple'>");
			        	 out.println ("<option >Informática</option>");
			        	 out.println ("<option >Alimentación</option>");
			        	 out.println ("<option >Muebles</option>");
			        	 out.println ("<option >Textil</option>");
			    		 out.println ("<option >Música</option>");
			    		 out.println ("<option >Otros</option>");
			    		 out.println ("</select>");
			    		 
			        	 out.println("<p>Introducir una opción.</p>");
			        }else{
			        	
			        out.println("<select name='select' size='6' multiple='multiple'>");
			        boolean v1=true,v2=true,v3=true,v4=true,v5=true,v6=true;
			        //informatica
			    for (int i=0; i<request.getParameterValues("select").length; i++){ 
			    	
			    	if (request.getParameterValues("select")[i].equals("Informática")){
			    		
			    		 out.println ("<option Selected>Informática</option>");
			    		 v1=false;
			    		 
			    	}
			    
			    	//alimentacion
			    	if (request.getParameterValues("select")[i].equals("Alimentación")){
			    		
			    		 out.println ("<option Selected>Alimentación</option>");
			    		 v2=false;
			    		 
			    	}
			    
			   
			       //muebles
			    	if (request.getParameterValues("select")[i].equals("Muebles")){
			    		
			    		 out.println ("<option Selected>Muebles</option>");
			    		 v3=false;
			    		 
			    	}
			    
			    	
			 
					//textil			
			    	if (request.getParameterValues("select")[i].equals("Textil")){
			    		
			    		 out.println ("<option Selected>Textil</option>");
			    		 v4=false;
			    		 
			    	}

			    	if (request.getParameterValues("select")[i].equals("Música")){
			    		
			    		 out.println ("<option Selected>Música</option>");
			    		 v5=false;
			    		 
			    	}
			    
			   
			    	if (request.getParameterValues("select")[i].equals("Otros")){
			    		 out.println ("<option Selected>Otros</option>");
			    		 out.println ("</select>");
			    		 v6=false;
			    		 
			    	}
			    }
			    if (v1==true){
					    	out.println ("<option>Informática</option>");
					    	
					    }	
			    if (v2==true){
			    	out.println ("<option>Alimentación</option>");
			    	
			    }
			    if (v3==true){
			    	out.println ("<option>Muebles</option>");
			    	
			    }
			    if (v4==true){
			    	out.println ("<option>Textil</option>");
			    	
			    }
			    if (v5==true){
			    	out.println ("<option>Música</option>");
			    	
			    }

			    if (v6==true){
			    	out.println ("<option>Otros</option>");
			    	out.println ("</select>");
			    }
			        
		        }
			        
			
			        
			        
			        out.println("<center><input value='Enviar Orden' type='submit'></center></form>");
			        out.println("</body>");
			        out.println("</html>");	      
			        }
		        
		        
		        //mostramos si no hay errores
		        else 
		        {
		            out.println("<html>");
			        out.println("<head>");
			        out.println("<title>Formulario a comprobar</title>");
			        out.println("</head>");
			        out.println("<body><h1>VALORES RECOGIDOS</h1>");		
			        
			        String tabla="<table>";
			       tabla += "<th><h2>Parámetro</h2></th><th><h2>Valor(es)</h2>";

			       tabla += "</td></tr><tr><td>numElem";
			       tabla += "</td><td>"+request.getParameter("numElem");
			       tabla += "</td></tr><tr><td>descripcion";
			        tabla += "</td><td>"+request.getParameter("descripcion");
			        tabla += "</td></tr><tr><td>precio";
			        tabla += "</td><td>"+request.getParameter("precio");



			       tabla += "</td></tr><tr><td>nombre";
			        tabla += "</td><td>"+request.getParameter("nombre");
			        tabla += "</td></tr><tr><td>apell1";
			        tabla += "</td><td>"+request.getParameter("apell1");
			        tabla += "</td></tr><tr><td>apell2";
			        tabla += "</td><td>"+request.getParameter("apell2");
			       tabla += "</th></tr><tr><td>direccion de envio";
			       tabla += "</td><td>"+request.getParameter("direccion");
			        
			        tabla += "</td></tr><tr><td>tarjeta";
			        tabla += "</td><td>"+request.getParameter("tarjeta");
			        tabla += "</td></tr><tr><td>numTarj2";
			        tabla += "</td><td>"+request.getParameter("numTarj2");
			        tabla += "</td></tr><tr><td>numTarj1";
			        tabla += "</td><td>"+request.getParameter("numTarj1");
			        
			        
			        tabla += "</td></tr><tr><td>select";
			        tabla += "</td><td>";
			        for (int i=0; i<request.getParameterValues("select").length; i++){ 
				    	
				    	
				    		
				    		tabla +=request.getParameterValues("select")[i]+ ", ";
				    		 
				    		 
				    	
			        }
			     
			        
			        
			        tabla += " </td></tr></table>";
			        out.println(tabla);
			        out.println("</body>");
			        out.println("</html>");	   		        	
		        }//fin de no hay errores
	        }//fin de comprobar si nos han pasado parametros
	    }
}

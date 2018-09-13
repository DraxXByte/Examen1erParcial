package servlet;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.math.*;
public class calcular extends HttpServlet {
    public void doPost(HttpServletRequest peticion, HttpServletResponse respuesta)
            throws ServletException, IOException {
                double result;
                double pesos;
                String conver;
            try{            
                result = 0;
                pesos = Double.parseDouble(peticion.getParameter("pesos"));
                conver = peticion.getParameter("moneda");
                if(null == conver)
               {}
               else
               switch (conver) {
                case "USD":
                    result=pesos/20;
                    break;
                case "Yenes":
                    result=pesos*20;                 
                    break;
                }
            }
            catch(Exception e)
            {
              result = 0;
                pesos = Double.parseDouble(peticion.getParameter("pesos"));
                conver = peticion.getParameter("conversión");
                if(null == conver)
               {}
            }
        PrintWriter out = new PrintWriter(respuesta.getOutputStream());
        out.println("<html>");
        out.println("<head><title>La conversión</title></head>");
        out.println("<body>");
        out.println("<p><h1><center>La conversión en: " + conver + " es  <B>" + result + "</B> </center></h1></p>");
        out.println("</body></html>");
        out.close();
    }
}


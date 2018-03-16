package com.uniminuto.taller.servlets;

import com.uniminuto.taller.servlets.vos.EntradaTaller;
import com.uniminuto.taller.servlets.vos.Producto;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author JEfer
 */
@WebServlet(name = "taller", urlPatterns = {"/taller"})
public class Taller extends HttpServlet {
    
    public static final String MASCULINO = "masculino";
    public static final String FEMENINO = "femenino";
    
    
    EntradaTaller entradaTaller;
    DecimalFormat formateador = new DecimalFormat("###,###.##");
    List<Producto> productos;
    

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<script type=\"text/javascript\" src=\"lib/jquery-1.11.2.min.js\"></script>");
            out.println("<script type=\"text/javascript\" src=\"lib/jquery.validate.min.js\"></script> ");
            out.println("<link rel=StyleSheet HREF=\"styles.css\" TYPE=\"text/css\" MEDIA=screen>");
            out.println("</head>");
            out.println("<body>");
            out.println("<div id=\"caja\"> ");
            out.println("<form action='taller' method=\"post\" required>");
            out.println("<label><strong>Nombre: </strong> <center><input type ='text' name=\"nombre\" required/></center></label></br>");
            out.println("<label><strong>Edad:</strong> <center><input type = 'text' pattern=\"[1-9]{0,2}\" name = \"edad\" title=\"Debe ser entre 1 y 99\" required/></center></br>");
            out.println("<label><strong> Femenino: </strong> <input type=\"radio\" name=\"genero\" value=\"femenino\" checked> <br>");
            out.println("<label><strong> Masculino </strong><input type=\"radio\" name=\"genero\" value=\"masculino\"><br>");
            out.println("<br>");
            out.println("<br>");
            out.println("<br>");
            out.println("<input type=\"submit\">");
            out.println("</form>");
            
            out.println("<h4>Para "+ entradaTaller.getNombre() +" con la edad de "+ entradaTaller.getEdad() +" años está disponible el siguiente catalogo de productos:</h4></br>");
            
            out.println("<table>\n" +
                    "<tr>\n" +
                    "  <th>Producto</th>\n" +
                    "  <th>Precio</th>\n" +
                    "  <th>Tipo</th>\n" +
                    "</tr>\n"); 
            out.println("<tr>");        
            
            for (Producto producto : productos) {
                out.println("<td>"+producto.getNombre()+"</td>");        
                out.println("<td>"+producto.getPrecio()+"</td>");        
                out.println("<td>"+producto.getTipo()+"</td>");        
                out.println("</tr>");        
            }
            
            out.println("</table>");
                
            out.println("");
            out.println("");
            

            out.println("</div> ");
            out.println("</body>");
            out.println("</html>");

        } finally {
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nombre = request.getParameter("nombre");
        String edad = request.getParameter("edad");
        String genero = request.getParameter("genero");
        
        entradaTaller = new EntradaTaller(nombre, edad, genero);
        productos = alimentarListas(genero, edad);
        
        processRequest(request, response);
    }
    
    public List<Producto> alimentarListas(String genero, String edad){
        
        List<Producto> productosPorTipos = new ArrayList<Producto>();
        
        Producto producto; 
        
        if (genero.equals(MASCULINO)) {
            
            if (Integer.parseInt(edad)<18) {    
                
                producto = new Producto();
                producto.setNombre("Carro");
                producto.setPrecio("$2.000");
                producto.setTipo("Juguete");
                productosPorTipos.add(producto);
                producto = new Producto();
                producto.setNombre("Muñeco");
                producto.setPrecio("$5.000");
                producto.setTipo("Juguete");
                productosPorTipos.add(producto);
                producto = new Producto();
                producto.setNombre("Crayones");
                producto.setPrecio("$3.000");
                producto.setTipo("Escolar");
                productosPorTipos.add(producto);
                
            }else{
                
                producto = new Producto();
                producto.setNombre("Cuchilla Afeitar");
                producto.setPrecio("$5.000");
                producto.setTipo("AsPersonal");
                productosPorTipos.add(producto);
                producto = new Producto();
                producto.setNombre("Espuma");
                producto.setPrecio("$17.000");
                producto.setTipo("AsPersonal");
                productosPorTipos.add(producto);
                producto = new Producto();
                producto.setNombre("Gel");
                producto.setPrecio("$12.000");
                producto.setTipo("AsPersonal");
                productosPorTipos.add(producto);
                
            }
            
        }else if (genero.equals(FEMENINO)) {
            
            if (Integer.parseInt(edad)<18) {
                
                producto = new Producto();
                producto.setNombre("Muñeca");
                producto.setPrecio("$20.000");
                producto.setTipo("Juguete");
                productosPorTipos.add(producto);
                producto = new Producto();
                producto.setNombre("Brillos");
                producto.setPrecio("$5.000");
                producto.setTipo("Belleza Infantil");
                productosPorTipos.add(producto);
                producto = new Producto();
                producto.setNombre("Moñas");
                producto.setPrecio("$5.000");
                producto.setTipo("Belleza Infantil");
                productosPorTipos.add(producto);
                
            }else{
                
                producto = new Producto();
                producto.setNombre("Pestañina");
                producto.setPrecio("$50.000");
                producto.setTipo("Belleza");
                productosPorTipos.add(producto);
                producto = new Producto();
                producto.setNombre("Cartera");
                producto.setPrecio("$200.000");
                producto.setTipo("Moda femenina");
                productosPorTipos.add(producto);
                producto = new Producto();
                producto.setNombre("Gafas");
                producto.setPrecio("$50.000");
                producto.setTipo("Moda femenina");
                productosPorTipos.add(producto);
            }
            
        }
        
        return productosPorTipos;
    }
            
    

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}



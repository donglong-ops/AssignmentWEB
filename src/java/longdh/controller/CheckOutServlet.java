/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package longdh.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import longdh.cart.CartObject;
import longdh.cart.CartDAO;
import longdh.cart.CartDTO;
import longdh.items.ItemsDAO;
import longdh.items.ItemsDTO;

/**
 *
 * @author donglong
 */
@WebServlet(name = "CheckoutServlet", urlPatterns = {"/CheckoutServlet"})
public class CheckOutServlet extends HttpServlet {

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
            throws ServletException, IOException, SQLException, NamingException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String url = "viewCarts.jsp";
        try {
            HttpSession session = request.getSession(false);
            //tim session hien co ,neu ko ton tai thi tra null, 
            //neu de true thi no tu dong tao moi session, ma ben trong ko co gi
            if (session == null) {
                url = "error.html";
            }
            if (session != null) {
                CartObject cart = (CartObject) session.getAttribute("CART");
                //String userName = (String) session.getAttribute("USERNAME");
                String name = (String) session.getAttribute("Name");
                String address = (String) session.getAttribute("Address");
                
                //test
//                if (userName == null) {
//                    url = "login.html";
//                }
//                else{
                Random rand = new Random();
                int num = rand.nextInt(1000);
                String cartID = Integer.toString(num);
//                System.out.println("CartID = " + cartID);
//                System.out.println("Username = " + userName);
                CartDTO dto = new CartDTO(cartID, name,address);
                //3 user takes list items from cart
                if (cart != null) {
                    Map<String, Integer> items = cart.getItems();
                    CartDAO cartDAO = new CartDAO();
                    ItemsDAO itemsDAO = new ItemsDAO();
                    if (items != null) {
                        try {
                            if (cartDAO.insertCart(dto)) {
                                Set<String> keyList = items.keySet();
                                for (String key : keyList) {
                                    ItemsDTO itemsDTO = new ItemsDTO(key, cartID, items.get(key));
                                    itemsDAO.insertItem(itemsDTO);
                                }
                                System.out.println("Check Out sussess");
                            }
                        } catch (SQLException e) {
                            log("CheckOutServlet " + e.getMessage());
                        }
                    }
                }
               // } // end test
            }
        } finally {
            RequestDispatcher rd = request.getRequestDispatcher(url);
            rd.forward(request, response);
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(CheckOutServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException ex) {
            Logger.getLogger(CheckOutServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(CheckOutServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException ex) {
            Logger.getLogger(CheckOutServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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

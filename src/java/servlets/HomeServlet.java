package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.User;

/**
 *
 * @author 815138
 */
public class HomeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//            if(request.getParameter("home") != null) {
//                request.setAttribute("message", "Successfully logged out!");
//                getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
//            }
            
            User user = (User) request.getSession().getAttribute("user");
            if(user != null) {
                if(user.getUsername() != null) {
                    request.setAttribute("user", user);
                    getServletContext().getRequestDispatcher("/WEB-INF/home.jsp").forward(request, response);
                    return;
                } else {
                    getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
                    return;
                }
            } else {
                getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);   
            }
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
    }
}

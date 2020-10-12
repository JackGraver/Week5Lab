package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.User;
import services.AccountService;

/**
 *
 * @author 815138
 */
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getParameter("logout") != null) {
            request.setAttribute("message", "Successfully logged out!");
            request.getSession().setAttribute("user", null);
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        }
        
        if(request.getSession().getAttribute("user") == null) {
              getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        } else {
            getServletContext().getRequestDispatcher("/WEB-INF/home.jsp").forward(request, response);
        }
      
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        AccountService serv = new AccountService();
        
        if(!username.equals("") && !password.equals("")) {
            User user = serv.login(username, password);
            if(user != null) {
                request.getSession().setAttribute("user", user);
                response.sendRedirect("home");
                return;
            } else {
                request.setAttribute("username", username);
                request.setAttribute("password", password);
                request.setAttribute("message", "Failed Authentication");
            }
        }
          getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
    }
}

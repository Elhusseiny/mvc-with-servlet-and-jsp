package net.qeema.mvc.servlet;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import net.qeema.mvc.dao.UserDao;
import net.qeema.mvc.entity.User;

import java.io.IOException;
import java.sql.SQLException;

public class LoginUserServlet extends HttpServlet {
    /*
    Model: The backend that contains all the data logic.
    View: The frontend or graphical user interface (GUI).
    Controller: The brains of the application that controls how data is displayed.
     */

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws IOException {

        String username = request.getParameter("username");
        String email = request.getParameter("email");
        User user = new User(username,email);

        try {
            HttpSession session = request.getSession();
            session.setAttribute("logged-in" , UserDao.userExists(user));
            response.sendRedirect("users/addUser");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

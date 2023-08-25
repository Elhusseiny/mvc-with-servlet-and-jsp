package net.qeema.mvc.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import net.qeema.mvc.dao.UserDao;
import net.qeema.mvc.entity.User;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

//@WebServlet(name = "saveUser", value = "/saveUser")
public class SaveUserServlet extends HttpServlet {
    /*
    Model: The backend that contains all the data logic.
    View: The frontend or graphical user interface (GUI).
    Controller: The brains of the application that controls how data is displayed.
     */

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        try {
            User user = new User(username , email) ;
            UserDao.addUser(user);
            List<User> users =  UserDao.getAllUsers();
            request.setAttribute("users" , users);
            request.getRequestDispatcher("list-user.jsp").forward(request, response);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

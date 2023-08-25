package net.qeema.mvc.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import net.qeema.mvc.dao.UserDao;

import java.io.IOException;
import java.sql.SQLException;

//@WebServlet(name = "addUser", value = "/addUser")
public class AddUserServlet extends HttpServlet {


    /*
    Model: The backend that contains all the data logic.
    View: The frontend or graphical user interface (GUI).
    Controller: The brains of the application that controls how data is displayed.
     */

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Integer count = UserDao.getUsersCount();
            req.setAttribute("count", count);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        req.getRequestDispatcher("add-user.jsp").forward(req, resp);
    }
}

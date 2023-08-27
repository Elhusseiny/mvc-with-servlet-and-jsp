package net.qeema.mvc.dao;

import net.qeema.mvc.entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
    public static Connection connectDB() {
        // connection object
        Connection connection = null;
        try {
            // returns the class object
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mvc?useSSL=false", "root", "root");
        } catch (Exception message) {
            System.out.println(message);
        }
        return connection;
    }

    public static int addUser(User user) throws SQLException {
        int result = 0;
        Connection connect = UserDao.connectDB();

        // SQL statement is precompiled and stored in a
        // PreparedStatement object.
        PreparedStatement preparedStatement
                = connect.prepareStatement(
                "insert into user(username,email) values (?,?)");

        // set the parameter to the given Java String value
        preparedStatement.setString(1, user.getUsername());
        preparedStatement.setString(2, user.getEmail());

        // execute SQl statement insert values to the
        // database
        result = preparedStatement.executeUpdate();

        // close the database connection
        connect.close();
        return result;
    }


    public static Boolean userExists(User user) throws SQLException {
        Connection connect = UserDao.connectDB();
        
        PreparedStatement preparedStatement
                = connect.prepareStatement(
                "SELECT * from user WHERE username = ? and email = ?");

        // set the parameter to the given Java String value
        preparedStatement.setString(1, user.getUsername());
        preparedStatement.setString(2, user.getEmail());

        ResultSet rs = preparedStatement.executeQuery();


        if (rs.next()) {
            connect.close();
            return true; // there is a record
        } else {
            connect.close();
            return false; // there is no record
        }
    }

    public static int updateUser(User user)
            throws SQLException {
        int result = 0;

        // create connection at the call of this method
        Connection connect = UserDao.connectDB();

        // SQL statement is precompiled and stored in a
        // PreparedStatement object
        PreparedStatement preparedStatement
                = connect.prepareStatement(
                "update user set username=?,email=? where user_id=?");

        // set the parameter to the given Java String value
        preparedStatement.setString(1, user.getUsername());
        preparedStatement.setString(2, user.getEmail());

        // execute SQl statement, insert values to the
        // database
        result = preparedStatement.executeUpdate();

        // close the database connection
        connect.close();
        return result;
    }


    public static List<User> getAllUsers()
            throws SQLException {
        // creating an empty arraylist of type User.
        List<User> list = new ArrayList<User>();

        // create connection at the call of the method
        Connection connect = UserDao.connectDB();

        // SQL statement and telling it to select from the
        // first index
        PreparedStatement preparedStatement
                = connect.prepareStatement(
                "select * from user");
        ResultSet resultSet
                = preparedStatement.executeQuery();

        // this keep iterating the list of user
        // setting the values to the corresponding integer
        while (resultSet.next()) {
            User user = new User();
            user.setUsername(resultSet.getString(2));
            user.setEmail(resultSet.getString(3));
            // store the values into the list
            list.add(user);
        }

        // close the database connection
        connect.close();

        return list;
    }


    public static Integer getUsersCount() throws SQLException {
        Integer count = 0;

        // create connection at the call of the method
        Connection connect = UserDao.connectDB();

        // SQL statement and telling it to select from the
        // first index
        PreparedStatement preparedStatement
                = connect.prepareStatement(
                "select count(*) from user");
        ResultSet resultSet
                = preparedStatement.executeQuery();


        while (resultSet.next())
            count = resultSet.getInt(1);

        // close the database connection
        connect.close();

        return count;
    }
}


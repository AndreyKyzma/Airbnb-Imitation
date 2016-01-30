
package com.controller;

import com.model.User;
import com.service.impl.UserServicess;

import java.util.logging.Logger;
import java.util.logging.Level;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet(
        name = "UserServletController",
        urlPatterns = {"/user"}
)

public class UserServletController extends HttpServlet {

    UserServicess userServicess = new UserServicess();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("searchAction");
        if (action != null) {
            switch (action) {
                case "searchUserById":
                    searchUserById(req, resp);
                    break;
                case "searchUserByName":
                    searchUserByName(req, resp);
                    break;
            }
        }
        else {
            List<User> result = userServicess.getAllUser();
            forwardListUser(req, resp, result);
        }
    }

    private void searchUserById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long idUser = Integer.valueOf(req.getParameter("idUser"));
        User user = null;
        try {
            user = userServicess.getUser(idUser);
        } catch (Exception ex) {
            Logger.getLogger(UserServletController.class.getName()).log(Level.SEVERE, null, ex);
        }
        req.setAttribute("user", user);
        req.setAttribute("action", "edit");
        String nextJSP = "/jsp/new-user.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
        dispatcher.forward(req, resp);
    }

    private void searchUserByName(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("userName");
        List<User> result = userServicess.searchUserByName(userName);
        forwardListUser(req, resp, result);
    }

    private void forwardListUser(HttpServletRequest req, HttpServletResponse resp, List userList) throws ServletException, IOException {
        String nextJSP = "/jsp/list-users.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
        req.setAttribute("userList", userList);
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        switch (action) {
            case "add":
                addUserAction(req, resp);
                break;
            case "edit":
                editUserAction(req, resp);
                break;
            case "remove":
                removeUserByName(req, resp);
                break;
        }

    }

    private void addUserAction(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String usertype = req.getParameter("usertype");
        User user = new User(name, surname, password, email, usertype);
        long idUser = userServicess.addUser(user);
        List<User> userList = userServicess.getAllUser();
        req.setAttribute("idUser", idUser);
        String message = "The new user has been successfully created.";
        req.setAttribute("message", message);
        forwardListUser(req, resp, userList);
    }

    private void editUserAction(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String usertype = req.getParameter("usertype");
        long idUser = Integer.valueOf(req.getParameter("idUser"));
        User user = new User(name, surname, password, email, usertype);
        user.setId(idUser);
        boolean success = userServicess.updateUser(user);
        String message = null;
        if (success) {
            message = "The user has been successfully updated.";
        }
        List<User> userList = userServicess.getAllUser();
        req.setAttribute("idUser", idUser);
        req.setAttribute("message", message);
        forwardListUser(req, resp, userList);
    }

    private void removeUserByName(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long idUser = Integer.valueOf(req.getParameter("idUser"));
        boolean confirm = userServicess.deleteUser(idUser);
        if (confirm){
            String message = "The user has been successfully removed.";
            req.setAttribute("message", message);
        }
        List<User> userList = userServicess.getAllUser();
        forwardListUser(req, resp, userList);
    }
}

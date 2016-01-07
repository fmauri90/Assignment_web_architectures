/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.User;
import service.LoginService;

/**
 *
 * @author maurizio
 */
@WebServlet(name = "ProfileServlet", urlPatterns = {"/ProfileServlet"})
public class ProfileServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        
        String userId = request.getParameter("userId");
        String password = request.getParameter("password");

        LoginService loginService = new LoginService();
        
        boolean result = loginService.authenticate(userId, password);
        
        if (result){
            User user = loginService.getUserById(userId);
            request.getSession().setAttribute("user", user);
            response.sendRedirect("profile.jsp");
        }else{
            response.sendRedirect("login.jsp");
        }
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        processRequest(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        processRequest(request, response);
    }
    
    @Override
    public String getServletInfo(){
        return "Short description";
    }
}
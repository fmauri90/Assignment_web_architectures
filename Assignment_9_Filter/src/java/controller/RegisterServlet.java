/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.User;
import service.RegisterService;

/**
 *
 * @author maurizio
 */
@WebServlet(name = "RegisterServlet", urlPatterns = {"/RegisterServlet"})
public class RegisterServlet extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String fName = request.getParameter("firstName");
        String lName = request.getParameter("lastName");
        String userId = request.getParameter("userId");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String emailPattern = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        
        User user = new User(fName, lName, userId, password, email);
        
        try{
            RegisterService registerService = new RegisterService();
            boolean result = false;
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Registration</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<center>");
            if(email.matches(emailPattern) && password.length() >= 6){
               result = registerService.register(user);
            }else{
               out.println("<h1>Registration Unsuccessful</h1>");
               out.println("Sorry " + user.getFirstName() + " the Email or Password are not valid <a href=register.jsp>click here</a> to re-register");               
            }
            
            if(result){
                out.println("<h1>Registration Successful</h1>");
                out.println("Thank you " + user.getFirstName() + " to register <a href=login.jsp>click here</a> to sign-in");
            }else{
                if (email.matches(emailPattern) && password.length() >= 6){
                    out.println("<h1>Registration Unsuccessful</h1>");
                    out.println("Sorry " + user.getFirstName() + " but the User Id and Password are already exist in Database <a href=register.jsp>click here</a> to re-register");               
                }
            }
            out.println("</center>");
            out.println("</body>");
            out.println("</html>");
        }finally{
            out.close();
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

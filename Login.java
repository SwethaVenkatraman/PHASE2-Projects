import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/loginpage")
public class Login extends HttpServlet {
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    response.setContentType("text/html");
    
    PrintWriter out = response.getWriter();
    
    String name = request.getParameter("userName");
    String password = request.getParameter("userPassword");
    
    HttpSession session = request.getSession();
    
    if(name.equals("admin") && password.equals("1234")){
    session.setAttribute("userName",name);
    //after set name redirect to dashboard
    
    response.sendRedirect("dashboard");
    
    }
    else {
      out.println("<font color = 'red'>Invalid Credentials!!!</font>");
      RequestDispatcher dispatcher = request.getRequestDispatcher("index.html");
      dispatcher.include(request, response);
    }
  }

}

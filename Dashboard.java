import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/dashboard")
public class Dashboard extends HttpServlet {
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    response.setContentType("text/html");
    
    PrintWriter out = response.getWriter();
    
    HttpSession session = request.getSession();
    
    if(session.getAttribute("userName") !=null) {
      
      out.println("Welcome " + session.getAttribute("userName"));
      out.println("<br> You are now Logged in...<br>");
      out.println("<form action = 'logout'> "
          + "<input type = 'submit' value = 'logout'>"
          + " </form>");
    }
    else {
      response.sendRedirect("index.html");
    }
  }

}
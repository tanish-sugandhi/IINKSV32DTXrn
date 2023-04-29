

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Login")
public class Login extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		response.setContentType("html/text");
		String name=request.getParameter("name");
		String password=request.getParameter("password");
		if(name.equals("admin")&&password.equals("S@s12345"))
		{
			response.sendRedirect("home.html");
		}
		else
		{
			//RequestDispatcher rd=request.getRequestDispatcher("index.html");
			//rd.include(request,response);
			out.println("Invalid id and password");
		}
	}

}

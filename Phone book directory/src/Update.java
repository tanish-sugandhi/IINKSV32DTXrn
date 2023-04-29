

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Update")
public class Update extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		String id=request.getParameter("id");
		String name=request.getParameter("name");
		String mobno=request.getParameter("mobno");
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","root","root");
			String qr="update directory set name=?,mobno=? where id=?";
			PreparedStatement ps=con.prepareStatement(qr);
			ps.setString(3,id);
			ps.setString(1,name);
			ps.setString(2,mobno);
			//ps.setString(3,id);
			int i=ps.executeUpdate();
			RequestDispatcher rd=request.getRequestDispatcher("update.html");
			rd.include(request,response);
			out.println(i+" record Updated");
			con.close();
		}catch(Exception e)
		{
			out.println(e);
		}
	}

}

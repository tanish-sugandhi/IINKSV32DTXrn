

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Show")
public class Show extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","root","root");
			String qr="select * from directory";
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(qr);
			if(rs.next())
			{
				out.println("<table align='center' border='1px'>");
				out.println("<th>Id</th>");
				out.println("<th>Name</th>");
				out.println("<th>Mobile Number</th>");
				do
				{
					String id=rs.getString("id");
					String name=rs.getString("name");
					String mobno=rs.getString("mobno");
					out.println("<tr>");
					out.println("<td>");
					out.println("<input type=text name=id value="+id+">");
					out.println("</td>");
					out.println("<td>");
					out.println("<input type=text name=name value="+name+">");
					out.println("</td>");
					out.println("<td>");
					out.println("<input type=text name=mobno value="+mobno+">");
					out.println("</td>");
					out.println("</tr>");
				}while(rs.next());
				out.println("</table>");
			}
		}catch(Exception e)
		{
			out.println(e);
		}
	}

}

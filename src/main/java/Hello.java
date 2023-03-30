import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/hello")
public class Hello extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();





		PreparedStatement statement;

		String firstname = request.getParameter("first_name");
		String lastname = request.getParameter("last_name");
		String dob = request.getParameter("dob");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String address = request.getParameter("address");
		String phonenumber = request.getParameter("phone");



//		Part filePart = request.getPart("image");
//		String fileName = ((Part) filePart).getSubmittedFileName();
//		InputStream ImagefileContent = filePart.getInputStream();
//
//		Part filePart1 = request.getPart("resume");
//		String fileName1 = ((Part) filePart1).getSubmittedFileName();
//		InputStream ResumefileContent = filePart1.getInputStream();


		ServletContext servletContext = getServletContext();

		try {
			Class.forName(servletContext.getInitParameter("Driver"));
			Connection con = DriverManager.getConnection(servletContext.getInitParameter("Url"), "root", "1122");

			String query = "INSERT INTO users(firstname,lastname,dob,email,password,address,phonenumber) VALUES(?,?,?,?,?,?,?);";

			statement = con.prepareStatement(query);
			statement.setString(1, firstname);
			statement.setString(2, lastname);
			statement.setString(3, dob);
			statement.setString(4, email);
			statement.setString(5, password);
			/*statement.setBinaryStream(6, ImagefileContent);
			statement.setBinaryStream(7, ResumefileContent);*/
			statement.setString(6, address);
			statement.setString(7, phonenumber);

			statement.executeUpdate();

			response.sendRedirect(request.getContextPath()+"/login.html");


		} catch (SQLException e) {
			//throw new RuntimeException(e);
			System.out.println(e);
		} catch (ClassNotFoundException e) {
			//throw new RuntimeException(e);
			System.out.println(e);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet("/login")
public class login extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        HttpSession httpSession = request.getSession();

        String email = request.getParameter("email");

        String pass = request.getParameter("password");
        ServletContext servletContext = getServletContext();
        try {
            Class.forName(servletContext.getInitParameter("Driver"));
            Connection con = DriverManager.getConnection(servletContext.getInitParameter("Url"), "root", "1122");

            Statement statement = con.createStatement();
            String query = "select email, password from users ";
            ResultSet rs = statement.executeQuery(query);
            boolean flag=true;
            while (rs.next()){
                String a = rs.getString(1);
                String b = rs.getString(2);
                if(a.equals(email) && b.equals(pass)){
                    flag=false;
                    httpSession.setAttribute("key",email);
                    response.sendRedirect("Welcome");
                }
            }
            if(flag==true) {
                out.println("No user found");
                RequestDispatcher rd = request.getRequestDispatcher("login.html");
                rd.include(request, response);
            }





        } catch (SQLException e) {
            //throw new RuntimeException(e);
            System.out.println(e);
        } catch (ClassNotFoundException e) {
            //throw new RuntimeException(e);
            System.out.println(e);
        }
    }
}

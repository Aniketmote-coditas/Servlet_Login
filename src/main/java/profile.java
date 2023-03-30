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
@WebServlet("/profile")
public class profile extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        HttpSession httpSession = req.getSession();
        PrintWriter out = resp.getWriter();
        String str = (String)httpSession.getAttribute("key");
        ServletContext servletContext = getServletContext();
        try {
            Class.forName(servletContext.getInitParameter("Driver"));
            Connection con = DriverManager.getConnection(servletContext.getInitParameter("Url"), "root", "1122");

            Statement statement = con.createStatement();
            String query = "select * from users where email='"+str+"'";
            ResultSet rs = statement.executeQuery(query);

            while (rs.next()){

                out.println(rs.getString(2));

                out.println(rs.getString(3));

                out.println(rs.getString(4));

                out.println(rs.getString(5));

                out.println(rs.getString(6));
                out.println(rs.getString(9));

                out.println(rs.getString(10));

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

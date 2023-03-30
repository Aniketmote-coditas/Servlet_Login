import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
@WebServlet("/Welcome")
public class Welcome extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        HttpSession httpSession = request.getSession();

        String str = (String)httpSession.getAttribute("key");
        if(httpSession.getAttribute("key") != null) {
            out.println(" <h1>Welcome</h1> " + str);
            out.println("<a href= 'profile'>Profile</a>");
            out.println(" <a href='logout'>logout</a>");
        }else {
            response.sendRedirect(request.getContextPath()+"/login.html");
        }

    }
}

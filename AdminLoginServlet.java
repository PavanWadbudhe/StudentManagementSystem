package Test;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
@SuppressWarnings("serial")
@WebServlet("/admin")
public class AdminLoginServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException{
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		
		AdminBean ab=new AdminLoginDAO().retrieve(req);
		if(ab==null) {
			pw.println("Invalid Login Process...");
			req.getRequestDispatcher("AdminLogin.html").include(req, res);
		}else {
			HttpSession hs=req.getSession();
			hs.setAttribute("ab",ab);
			pw.println("Welcome Admin :"+ab.getfName()+"<br>");
			req.getRequestDispatcher("link1.html").include(req, res);
		}
	}
}

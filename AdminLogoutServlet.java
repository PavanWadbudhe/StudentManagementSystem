package Test;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
@SuppressWarnings("serial")
@WebServlet("/logout")
public class AdminLogoutServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		HttpSession hs=req.getSession(false);
		if(hs==null) {
			pw.println("Session Expired...");
		}else {
			hs.removeAttribute("ab");
			hs.removeAttribute("al");
			hs.invalidate();
			pw.println("Logged out Successfully...<br>");
			req.getRequestDispatcher("home.html").include(req, res);
		}
	}
}

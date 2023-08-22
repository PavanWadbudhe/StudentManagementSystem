package Test;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
@SuppressWarnings("serial")
@WebServlet("/marks")
public class ViewMarksServlet extends HttpServlet{
	protected void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException {
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		
		HttpSession hs=req.getSession(false);
		if(hs==null) {
			pw.println("Session Expired...");
			req.getRequestDispatcher("AdminLogin.html").include(req, res);
		}else {
			StudentBean sb=new ViewMarksDAO().retrieve(req);
			hs.setAttribute("sb", sb);
			req.getRequestDispatcher("ViewMarks.jsp").forward(req, res);
		}
	}
}

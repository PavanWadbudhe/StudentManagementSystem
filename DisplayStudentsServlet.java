package Test;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
@SuppressWarnings("serial")
@WebServlet("/view")
public class DisplayStudentsServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		HttpSession hs=req.getSession(false);
		if(hs==null) {
			pw.println("Session Expired...<br>");
			req.getRequestDispatcher("home.html").include(req, res);
		}else {
			ArrayList<StudentBean> al=new ViewStudentsDAO().retrieve();
			hs.setAttribute("al", al);			
			req.getRequestDispatcher("ViewStudents.jsp").forward(req, res);
		}
	}
}

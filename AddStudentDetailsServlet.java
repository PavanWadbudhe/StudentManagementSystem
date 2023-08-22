package Test;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
@SuppressWarnings("serial")
@WebServlet("/addstu")
public class AddStudentDetailsServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		HttpSession hs=req.getSession(false);
		if(hs==null) {
			pw.println("Session Expired...");
			req.getRequestDispatcher("home.html").include(req, res);
		}else {
			StudentBean sb=new StudentBean();
			sb.setRollNo(req.getParameter("rno"));
			sb.setName(req.getParameter("sname"));
			sb.setBranch(req.getParameter("br"));
			
			int mar=Integer.parseInt(req.getParameter("mar"));
			sb.setMar(mar);			
			int hindi=Integer.parseInt(req.getParameter("hindi"));
			sb.setHindi(hindi);
			int eng=Integer.parseInt(req.getParameter("eng"));
			sb.setEng(eng);
			int math=Integer.parseInt(req.getParameter("math"));
			sb.setMath(math);
			int sci=Integer.parseInt(req.getParameter("sci"));
			sb.setSci(sci);
			int soSci=Integer.parseInt(req.getParameter("sosci"));
			sb.setSosci(soSci);
			
			int totMarks=mar+hindi+eng+math+sci+soSci;
			
			sb.setTotMarks(totMarks);
			
			float per=totMarks/6f;
			sb.setPer(per);
			
			Result re=new Result(mar,hindi,eng,math,sci,soSci);
			String result=re.getResult(per);
			sb.setResult(result);
			
			int k=new AddStudentDAO().insertStudent(sb);
			int z=new AddStuMarksDAO().insertMarks(sb);
			if(k>0 && z>0) {
				if(k==z) {
					pw.println("Student Details Added Successfully...<br>");
					req.getRequestDispatcher("link1.html").include(req, res);
				}
			}
		}
	}
}

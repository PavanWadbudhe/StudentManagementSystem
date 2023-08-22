package Test;
import java.sql.*;

import javax.servlet.http.HttpServletRequest;
public class ViewMarksDAO {
	public StudentBean sb=null;
	public StudentBean retrieve(HttpServletRequest req){
		try {
			Connection con=DBConnection.getCon();
			PreparedStatement ps=con.prepareStatement("Select * from StuMarks53 where rno=?");
			ps.setString(1, req.getParameter("rno"));
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				sb=new StudentBean();
				sb.setRollNo(rs.getString(1));
				sb.setMar(rs.getInt(2));
				sb.setHindi(rs.getInt(3));
				sb.setEng(rs.getInt(4));
				sb.setMath(rs.getInt(5));
				sb.setSci(rs.getInt(6));
				sb.setSosci(rs.getInt(7));
			}
		}catch(Exception e) {e.printStackTrace();}
		return sb;
	}
}

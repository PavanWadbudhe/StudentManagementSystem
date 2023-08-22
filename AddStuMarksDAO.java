package Test;
import java.sql.*;
public class AddStuMarksDAO {
	public int z=0;
	public int insertMarks(StudentBean sb){
		try {
			Connection con=DBConnection.getCon();
			PreparedStatement ps=con.prepareStatement("insert into StuMarks53 values(?,?,?,?,?,?,?)");
			ps.setString(1, sb.getRollNo());
			ps.setInt(2, sb.getMar());
			ps.setInt(3, sb.getHindi());
			ps.setInt(4, sb.getEng());
			ps.setInt(5, sb.getMath());
			ps.setInt(6, sb.getSci());
			ps.setInt(7, sb.getSosci());
		    z=ps.executeUpdate();
		}catch(Exception e) {e.printStackTrace();}
		return z;
	}
}

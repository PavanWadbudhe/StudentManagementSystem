package Test;
import java.sql.*;
public class AddStudentDAO {
	public int k=0;
	public int insertStudent(StudentBean sb){
		try {
			Connection con=DBConnection.getCon();
			PreparedStatement ps=con.prepareStatement("insert into Student53 values(?,?,?,?,?,?)");
			
			ps.setString(1, sb.getRollNo());
			ps.setString(2, sb.getName());
			ps.setString(3, sb.getBranch());
			ps.setFloat(4, sb.getTotMarks());
			ps.setFloat(5, sb.getPer());
			ps.setString(6, sb.getResult());
			k=ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return k;
	}
}

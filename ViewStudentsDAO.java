package Test;
import java.sql.*;
import java.util.*;
public class ViewStudentsDAO {
	ArrayList<StudentBean> al=new ArrayList<StudentBean>();
	public ArrayList<StudentBean> retrieve(){
		try {
			Connection con=DBConnection.getCon();
			PreparedStatement ps=con.prepareStatement("Select * from Student53");
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				StudentBean sb=new StudentBean();
				sb.setRollNo(rs.getString(1));
				sb.setName(rs.getString(2));
				sb.setBranch(rs.getString(3));
				sb.setTotMarks(rs.getInt(4));
				sb.setPer(rs.getFloat(5));
				sb.setResult(rs.getString(6));
				al.add(sb);
			}
		}catch(Exception e) {e.printStackTrace();}
		return al;
	}
}

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="java.util.*,Test.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>

.c2, .c3 {
    width:600px;
	box-shadow: 8px 8px 5px #444;
    padding: 20px 20px;
    background-image: linear-gradient(180deg, #fff, #ddd 40%, #ccc);
    align-items: center;
    display: flex;
    font-family: sans-serif;
    box-sizing: border-box;
    margin-top: 100px;
    margin:50px auto  auto;
    border:1px solid;
    border-radius:10px;
}
.c4{
	padding:10px 10px;
	margin:auto auto;
	width:300px;
	height:300px;
}	

</style>
</head>
<body>
	<%
		String rno=request.getParameter("rno");
		ArrayList<StudentBean> al=(ArrayList<StudentBean>)session.getAttribute("al");
		StudentBean sb=(StudentBean)session.getAttribute("sb");
		if(sb==null){
			out.println("Marks Not Available...<br>");
		}else{
			 Iterator<StudentBean> it=al.iterator();
				while(it.hasNext()){
					StudentBean sb1=(StudentBean)it.next(); 
			 		if(sb.getRollNo().equals(sb1.getRollNo())){
	%>
	<div class="c1">
	   <div class="c2">
			 	<table>
			  			<tr>
			  				<td>RollNo</td>
							<td>Name</td>
							<td>Branch</td>
							<td>TotalMarks</td>
							<td>Percentage</td>
							<td>Result</td>
			  			</tr>
			  			<tr>
			  				<td><%=sb1.getRollNo() %></td>
			  				<td><%=sb1.getName() %></td>
			  				<td><%=sb1.getBranch() %></td>
			  				<td><%=sb1.getTotMarks() %></td>
			  				<td><%=sb1.getPer() %></td>
			  				<td><%=sb1.getResult() %></td>
			  			</tr>  			
			  	</table>
	    	</div>
			 <div class="c3">
		 		<table>
			  			<tr>
			  				<td>RollNo</td>
			  				<td>Marathi</td>
			  				<td>Hindi</td>
			  				<td>English</td>
			  				<td>Math</td>
			  				<td>Science</td>
			  				<td>So-Science</td>
			  			</tr>
			  			<tr>
			  				<td><%=sb.getRollNo() %></td>
			  				<td><%=sb.getMar() %></td>
			  				<td><%=sb.getHindi() %></td>
			  				<td><%=sb.getEng() %></td>
			  				<td><%=sb.getMath() %></td>
			  				<td><%=sb.getSci() %></td>
			  				<td><%=sb.getSosci() %></td>
			  			</tr>
			  	</table>
			</div>
		</div>
		<div class="c4">
			  		<a href="ViewStudents.jsp">Back</a>&nbsp;&nbsp;&nbsp;
			  		<a href="logout">Logout</a>	
		</div>		
	<% 
			   }
			}
		 }
		
	%>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="java.util.*,Test.*"
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
.c2{
    width:600px;
	box-shadow: 8px 8px 5px #444;
    padding: 20px 20px;
    background-image: linear-gradient(180deg, #fff, #ddd 40%, #ccc);
    align-items: center;
    display: flex;
    font-family: sans-serif;
    box-sizing: border-box;
    margin: 50px  333px 0px;
}
td {
	border: 1px solid;
}
.c3{
	width:300px;
	height:300px;
	padding:10px 10px;
	margin: 10px 333px 0px;
}

</style>
</head>
<body>
	<%
		AdminBean ab=(AdminBean)session.getAttribute("ab");
		out.println("Page Belongs to :"+ab.getfName()+"<br>");
		ArrayList<StudentBean> al=(ArrayList<StudentBean>)session.getAttribute("al");
		if(al.size()==0){
			out.println("Students Not Available...<br>");
		}else{
			Iterator<StudentBean> it=al.iterator();
	%>
	<div class="c1">
	 <div class="c2">
		<table style="border: 1px">
			<tr>
				<td>RollNo</td>
				<td>Name</td>
				<td>Branch</td>
				<td>TotalMarks</td>
				<td>Percentage</td>
				<td>Result</td>
			</tr>
	<%
		while(it.hasNext()){
			StudentBean sb=it.next();
	%>
			<tr>
				<td><%=sb.getRollNo() %></td>
				<td><%=sb.getName() %></td>
				<td><%=sb.getBranch() %></td>
				<td><%=sb.getTotMarks() %></td>
				<td><%=sb.getPer() %></td>
				<td><%=sb.getResult() %></td>
				<td><a href="marks?rno=<%=sb.getRollNo()%>">ViewMarks</a></td>
			</tr>
	<%
		}
	%>
		   </table>
		  </div>
		</div>	
		<div class="c3">
			<a href="logout">Logout</a>&nbsp;&nbsp;&nbsp;
			<a href="link1.html">Back</a>
		</div>
	<%
		}
	%>
</body>
</html>
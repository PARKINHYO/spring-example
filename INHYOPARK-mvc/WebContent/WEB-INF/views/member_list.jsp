<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="org.kpu.study.domain.*, java.util.List" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="resources/member.css" type="text/css"></link>
	<title>Student List</title>
</head>
<body>
	<div align="center">
	<header>Student list</header>
	<HR>
		<table>
			<tr><td>계정</td><td>암호</td><td>이름</td><td>학번</td><td>학과</td><td>전화번호</td><td>이메일</td></tr>
		<%
			List<StudentVO> studentList = (List<StudentVO>)request.getAttribute("memberList");
			for(StudentVO vo : studentList) {
		%>
			<tr>
				<td><%=vo.getId() %></td>
				<td><%=vo.getPasswd() %></td>
				<td><%=vo.getUsername() %></td>
				<td><%=vo.getSnum() %></td>
				<td><%=vo.getDepart() %></td>
				<td><%=vo.getMobile() %></td>
				<td><%=vo.getEmail() %></td>
			</tr>
		<%
			}
		%>
		</table>
	</div>
</body>
</html>
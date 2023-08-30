<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*,java.io.*, web.bean.*,web.dao.*,web.dao.impl.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%  FilePathDaoImpl fpd = new FilePathDaoImpl();%>
	<%  List<FilePath> cdlist =fpd.load();%>
	<%  for( int i=0;i<cdlist.size();i++) {%>
		<% 	 FilePath ft=cdlist.get(i);%>
		<% 	 String path = ft.getFpath();%>
		<% 	 FileInputStream fi = new FileInputStream(path);%>
		<%InputStreamReader fs = new InputStreamReader(fi,"UTF-8") ;%>	
		<% 	 BufferedReader fr = new BufferedReader(fs);%>
		<%-- 	 FileWriter fw = new FileWriter("");--%>
		<% 	 String c=null;%>
		<% 	 while( (c = fr.readLine())!=null) {%>
			<%=c%>
			<%};%>
			<%};%>

</body>
</html>
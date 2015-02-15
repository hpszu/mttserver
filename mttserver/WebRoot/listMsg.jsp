<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="mttserver.model.Message"%>
<%@page import="mttserver.util.DBFactory"%>
<%@page import="mttserver.dao.IMessageDao"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<html>
<head>

<title>你收到的信息</title>

</head>

<body>
	<table width=600 align="center" border="1">
		<%
			IMessageDao msgDao = DBFactory.getMsgDao();
			List<Message> list = new ArrayList<Message>();
			list = msgDao.list();
			for (Message msg : list) {
		%>
		<tr>
			<td><%=msg.getId() + "、" + msg.getSchool()%>&nbsp;<%=msg.getSendTime()%>&nbsp;来自&nbsp;<%=msg.getPhoneManufacturer()%>&nbsp;<a
				href="deleteMsg.jsp?id=<%=msg.getId()%>">删除</a></td>
		</tr>
		<tr>
			<td><%=msg.getMsg()%></td>
		</tr>
		<%
			}
		%>
	</table>
</body>
</html>

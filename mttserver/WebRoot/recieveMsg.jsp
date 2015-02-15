<%@page import="mttserver.model.Message"%>
<%@page import="mttserver.dao.IMessageDao"%>
<%@page import="mttserver.util.DBFactory"%>
<%@page import="mttserver.dao.MessageDao"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<html>
<head>
</head>

<body>
	<%
		String school = request.getParameter("school");
		System.out.println(school);
		String msg = request.getParameter("msg");
		String manufacturer = request.getParameter("manufacturer");
		String time = request.getParameter("time");
	
		if(school==null||msg==null)return;
		
		IMessageDao msgDao = DBFactory.getMsgDao();
		Message recieveMsg = new Message();
		recieveMsg.setMsg(msg);
		recieveMsg.setSchool(school);
		recieveMsg.setPhoneManufacturer(manufacturer);
		recieveMsg.setSendTime(time);
		msgDao.add(recieveMsg);
	%>
</body>
</html>

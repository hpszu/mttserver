<%@page import="mttserver.util.DBFactory"%>
<%@page import="mttserver.dao.IMessageDao"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	int id=Integer.parseInt(request.getParameter("id"));
	IMessageDao msgDao = DBFactory.getMsgDao();
	msgDao.delete(id);
	response.sendRedirect("listMsg.jsp");
%>

package mttserver.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mttserver.dao.IMessageDao;
import mttserver.model.Message;
import mttserver.util.DBFactory;

@SuppressWarnings("serial")
public class MessageAction extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public MessageAction() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to
	 * post.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		IMessageDao msgDao = DBFactory.getMsgDao();
		List<Message> messages = msgDao.list();
	
		PrintWriter out = response.getWriter();
		out.println("<?xml version=" + "\"" + 1.0 + "\""
				+ " encoding=\"UTF-8\"?>");
		out.println("<messages>");
		for (Message m : messages) {
			out.println("<message>");
			out.println("<school>" + m.getSchool() + "</school>");
			out.println("<msg>" + m.getMsg() + "</msg>");
			out.println("<manufacturer>" + m.getPhoneManufacturer()
					+ "</manufacturer>");
			out.println("<time>" + m.getSendTime() + "</time>");
			out.println("</message>");
		}
		out.println("</messages>");
		
		out.flush();
		out.close();
	}

	/**
	 * Initialization of the servlet. <br>
	 * 
	 * @throws ServletException
	 *             if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}

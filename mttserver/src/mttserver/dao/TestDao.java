package mttserver.dao;

import mttserver.model.Message;
import mttserver.util.DBFactory;

public class TestDao {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IMessageDao msgdao=DBFactory.getMsgDao();
		Message msg=new Message();
		msg.setMsg("abc");
		msg.setSchool("szu");
		msgdao.add(msg);
		msg=new Message();
		msg.setMsg("gdu");
		msg.setSchool("abc");
		msgdao.add(msg);
	}

}

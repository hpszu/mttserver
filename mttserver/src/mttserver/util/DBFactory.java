package mttserver.util;

import mttserver.dao.IMessageDao;
import mttserver.dao.MessageDao;

public class DBFactory {
	public static IMessageDao getMsgDao(){
		return new MessageDao();
	}
}

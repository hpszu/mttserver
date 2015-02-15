package mttserver.dao;

import mttserver.model.Message;

public interface IMessageDao {
	public void add(Message msg);
	public void delete(int id);
	public void update(Message msg);
	public Message load(int id);
	public java.util.List<Message> list();
}

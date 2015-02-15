package mttserver.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import mttserver.model.Message;
import mttserver.util.DBUtil;

public class MessageDao implements IMessageDao {

	@Override
	public void add(Message msg) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "insert into mymtt values(null,?,?,?,?)";
		try {
			String mySQLDriver = "com.mysql.jdbc.Driver";
			String dbName = "mttmsg";
			String userName = "root";

			con = DBUtil.getMySQLConnection(mySQLDriver, null, null, dbName,
					userName, null);
			ps = con.prepareStatement(sql);
			ps.setString(1, msg.getSchool());
			ps.setString(2, msg.getMsg());
			ps.setString(3, msg.getPhoneManufacturer());
			ps.setString(4, msg.getSendTime());
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.close(ps);
			DBUtil.close(con);
		}
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "delete from mymtt where id=?";
		try {
			String mySQLDriver = "com.mysql.jdbc.Driver";
			String dbName = "mttmsg";
			String userName = "root";

			con = DBUtil.getMySQLConnection(mySQLDriver, null, null, dbName,
					userName, null);
			ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.close(ps);
			DBUtil.close(con);
		}
	}

	@Override
	public void update(Message msg) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "update mymtt set school=?,message=?,manufacturer=?,time=? where id=?";
		try {
			String mySQLDriver = "com.mysql.jdbc.Driver";
			String dbName = "mttmsg";
			String userName = "root";

			con = DBUtil.getMySQLConnection(mySQLDriver, null, null, dbName,
					userName, null);
			ps = con.prepareStatement(sql);
			ps.setString(1, msg.getSchool());
			ps.setString(2, msg.getMsg());
			ps.setString(3, msg.getPhoneManufacturer());
			ps.setString(4, msg.getSendTime());
			ps.setInt(5, msg.getId());
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.close(ps);
			DBUtil.close(con);
		}

	}

	@Override
	public Message load(int id) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Message msg = null;
		String sql = "select * from mymtt where id=?";
		try {
			String mySQLDriver = "com.mysql.jdbc.Driver";
			String dbName = "mttmsg";
			String userName = "root";

			con = DBUtil.getMySQLConnection(mySQLDriver, null, null, dbName,
					userName, null);
			ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				msg = new Message();
				msg.setId(rs.getInt("id"));
				msg.setSchool(rs.getString("school"));
				msg.setMsg(rs.getString("message"));
				msg.setPhoneManufacturer(rs.getString("manufacturer"));
				msg.setSendTime(rs.getString("time"));
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.close(rs);
			DBUtil.close(ps);
			DBUtil.close(con);
		}

		return msg;
	}

	@Override
	public List<Message> list() {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Message msg = null;
		List<Message> messages = new ArrayList<Message>();
		String sql = "select * from mymtt";
		try {
			String mySQLDriver = "com.mysql.jdbc.Driver";
			String dbName = "mttmsg";
			String userName = "root";

			con = DBUtil.getMySQLConnection(mySQLDriver, null, null, dbName,
					userName, null);
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				msg = new Message();
				msg.setId(rs.getInt("id"));
				msg.setSchool(rs.getString("school"));
				msg.setMsg(rs.getString("message"));
				msg.setPhoneManufacturer(rs.getString("manufacturer"));
				msg.setSendTime(rs.getString("time"));
				messages.add(msg);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.close(rs);
			DBUtil.close(ps);
			DBUtil.close(con);
		}
		return messages;
	}

}

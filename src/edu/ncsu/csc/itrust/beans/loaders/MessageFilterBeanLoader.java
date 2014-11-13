package edu.ncsu.csc.itrust.beans.loaders;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.ncsu.csc.itrust.beans.MessageFilterBean;

/**
 * A loader for MessageFilterBeans.
 * 
 * Loads in information to/from beans using ResultSets and PreparedStatements. Use the superclass to enforce consistency. 
 * For details on the paradigm for a loader (and what its methods do), see {@link BeanLoader}
 */
public class MessageFilterBeanLoader implements BeanLoader<MessageFilterBean> {

	public List<MessageFilterBean> loadList(ResultSet rs) throws SQLException {
		List<MessageFilterBean> list = new ArrayList<MessageFilterBean>();
		while (rs.next())
			list.add(loadSingle(rs));
		return list;
	}

	public PreparedStatement loadParameters(PreparedStatement ps, MessageFilterBean messagef) throws SQLException {
		ps.setLong(1, messagef.getMID());
		ps.setString(2, messagef.getSender());
		ps.setString(3, messagef.getInSubject());
		ps.setString(4, messagef.getReceivedDate().toString());
		ps.setString(5, messagef.getReceiver());
		ps.setString(6, messagef.getOutSubject());
		ps.setString(7, messagef.getSentDate().toString());
		
		return ps;
	}

	@Override
	public MessageFilterBean loadSingle(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

/*	public MessageFilterBean loadSingle(ResultSet rs) throws SQLException {
		MessageFilterBean messagef = new MessageFilterBean();
		messagef.setMessageId(rs.getLong("message_id"));
		messagef.setFrom(rs.getLong("from_id"));
		messagef.setTo(rs.getLong("to_id"));
		messagef.setSubject(rs.getString("subject"));
		messagef.setBody(rs.getString("message"));
		messagef.setSentDate(rs.getTimestamp("sent_date"));
		messagef.setRead(rs.getInt("been_read"));
		messagef.setParentMessageId(rs.getLong("parent_msg_id"));
		messagef.setOriginalMessageId(rs.getLong("original_msg_id"));
		return messagef;
	}*/


}

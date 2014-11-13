package edu.ncsu.csc.itrust.dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import edu.ncsu.csc.itrust.DBUtil;
import edu.ncsu.csc.itrust.beans.MessageFilterBean;
import edu.ncsu.csc.itrust.beans.loaders.MessageFilterBeanLoader;
import edu.ncsu.csc.itrust.dao.DAOFactory;
import edu.ncsu.csc.itrust.exception.DBException;

/**
 * Used for the logging mechanism.
 * 
 * DAO stands for Database Access Object. All DAOs are intended to be reflections of the database, that is,
 * one DAO per table in the database (most of the time). For more complex sets of queries, extra DAOs are
 * added. DAOs can assume that all data has been validated and is correct.
 * 
 * DAOs should never have setters or any other parameter to the constructor than a factory. All DAOs should be
 * accessed by DAOFactory (@see {@link DAOFactory}) and every DAO should have a factory - for obtaining JDBC
 * connections and/or accessing other DAOs.
 * 
 *  
 * 
 */
public class MessageFilterDAO {
	private DAOFactory factory;
	private MessageFilterBeanLoader mfbLoader;

	/**
	 * The typical constructor.
	 * @param factory The {@link DAOFactory} associated with this DAO, which is used for obtaining SQL connections, etc.
	 */
	public MessageFilterDAO(DAOFactory factory) {
		this.factory = factory;
		this.mfbLoader = new MessageFilterBeanLoader();
	}
	
	/**
	 * Adds a message to the database.
	 * @param mBean A bean representing the message to be added.
	 * @throws SQLException
	 * @throws DBException 
	 */
	public void addMessageFilter(MessageFilterBean mfBean) throws SQLException, DBException {
		Connection conn = null;
		PreparedStatement ps = null;
		try{
		conn = factory.getConnection();
		ps = conn.prepareStatement(
			"INSERT INTO messagefilter (mid, sender, insubject, received, receiver, outsubject, sent) "
		  + "  VALUES (?, ?, ?, ?, ?, ?, ?)");
		this.mfbLoader.loadParameters(ps, mfBean);

		ps.executeUpdate();
		ps.close();

	} catch(SQLException e) {
		
		throw new DBException(e);
	}finally{
		DBUtil.closeConnection(conn, ps);
	}

	}

}
	

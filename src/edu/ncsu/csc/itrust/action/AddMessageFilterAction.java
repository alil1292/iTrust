package edu.ncsu.csc.itrust.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.ncsu.csc.itrust.EmailUtil;
import edu.ncsu.csc.itrust.beans.Email;
import edu.ncsu.csc.itrust.beans.MessageBean;
import edu.ncsu.csc.itrust.beans.MessageFilterBean;
import edu.ncsu.csc.itrust.beans.PatientBean;
import edu.ncsu.csc.itrust.beans.PersonnelBean;
import edu.ncsu.csc.itrust.dao.DAOFactory;
import edu.ncsu.csc.itrust.dao.mysql.MessageFilterDAO;
import edu.ncsu.csc.itrust.dao.mysql.PatientDAO;
import edu.ncsu.csc.itrust.dao.mysql.PersonnelDAO;
import edu.ncsu.csc.itrust.exception.DBException;
import edu.ncsu.csc.itrust.exception.FormValidationException;
import edu.ncsu.csc.itrust.exception.ITrustException;
import edu.ncsu.csc.itrust.validate.EMailValidator;
import edu.ncsu.csc.itrust.validate.MessageValidator;


public class AddMessageFilterAction {
	private long loggedInMID;
	private MessageFilterDAO messageFilterDAO;
	
	public AddMessageFilterAction(DAOFactory factory, long loggedInMID) {
		this.messageFilterDAO = factory.getMessageFilterDAO();
		this.loggedInMID = loggedInMID;
	}
	
	public void AddMessageFilter(MessageFilterBean mfBean) throws ITrustException, SQLException {
		messageFilterDAO.addMessageFilter(mfBean);
	}
}

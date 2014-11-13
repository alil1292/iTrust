package edu.ncsu.csc.itrust.beans;

import java.sql.Timestamp;

/**
 * A bean for storing data about a message filter set by a user.
 * 
 * A bean's purpose is to store data. Period. Little or no functionality is to be added to a bean 
 * (with the exception of minor formatting such as concatenating phone numbers together). 
 * A bean must only have Getters and Setters (Eclipse Hint: Use Source > Generate Getters and Setters
 * to create these easily)
 */
public class MessageFilterBean {
	private long mid;
	
	private String sender;
	private String insubject;
	private Timestamp received;
	private String receiver;
	private String outsubject;
	private Timestamp sent;

	
	public long getMID()
	{
		return mid;
	}
	
	public void setMID(long mid) {
		this.mid = mid;
	}

	
	/**
	 * Gets the subject of this message from inbox
	 * @return
	 */
	public String getInSubject() {
		return insubject;
	}
	
	/**
	 * Gets the subject of this message from outbox
	 * @return
	 */
	public String getOutSubject() {
		return outsubject;
	}
	
	/**
	 * Sets the subject of this message from inbox
	 * @param subject
	 */
	public void setInSubject(String insubject) {
		this.insubject = insubject;
	}
	
	/**
	 * Sets the subject of this message from outbox
	 * @param subject
	 */
	public void setOutSubject(String outsubject) {
		this.outsubject = outsubject;
	}


	/**
	 * Gets the sender of this message
	 * @return
	 */
	public String getSender() {
		return sender;
	}
	
	/**
	 * Sets the sender of this message
	 * @param body
	 */
	public void setSender(String sender) {
		this.sender = sender;
	}
	
	/**
	 * Gets the receiver of this message
	 * @return
	 */
	public String getReceiver() {
		return receiver;
	}
	
	/**
	 * Sets the receiver of this message
	 * @param body
	 */
	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	/**
	 * Gets the sent time for this message
	 * @return
	 */
	public Timestamp getSentDate() {
		return (Timestamp) this.sent.clone();
	}

	/**
	 * Sets the sent time for this message
	 * @param timestamp
	 */
	public void setSentDate(Timestamp sent) {
		this.sent = (Timestamp) sent.clone();
	}
	
	/**
	 * Gets the received time for this message
	 * @return
	 */
	public Timestamp getReceivedDate() {
		return (Timestamp) this.received.clone();
	}

	/**
	 * Sets the received time for this message
	 * @param timestamp
	 */
	public void setReceivedDate(Timestamp received) {
		this.received = (Timestamp) received.clone();
	}
	

}

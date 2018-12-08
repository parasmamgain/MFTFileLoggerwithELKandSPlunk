package com.tika.document.entity;

public class TransferStarted {

	private String time;
	private String ID;
	private String type;
	private String resultCode;
	private String sourceAgentName;
	private String sourceAgentQMgr;
	private String sourceAgentType;
	private String destinationAgentName;
	private String destinationAgentQMgr;
	private String userID;
	private String jobname;
	private String metaData;
	public String getMetaData() {
		return metaData;
	}

	public void setMetaData(String metaData) {
		this.metaData = metaData;
	}
	public TransferStarted(String time, String iD, String type, String resultCode, String sourceAgentName,
			String sourceAgentQMgr, String sourceAgentType, String destinationAgentName, String destinationAgentQMgr,
			String userID, String jobname, String metaData) {
		super();
		this.time = time;
		ID = iD;
		this.type = type;
		this.resultCode = resultCode;
		this.sourceAgentName = sourceAgentName;
		this.sourceAgentQMgr = sourceAgentQMgr;
		this.sourceAgentType = sourceAgentType;
		this.destinationAgentName = destinationAgentName;
		this.destinationAgentQMgr = destinationAgentQMgr;
		this.userID = userID;
		this.jobname = jobname;
		this.metaData = metaData;
	}

	public TransferStarted(String time, String iD, String type, String resultCode, String sourceAgentName,
			String sourceAgentQMgr, String sourceAgentType, String destinationAgentName, String destinationAgentQMgr,
			String userID, String jobname) {
		super();
		this.time = time;
		ID = iD;
		this.type = type;
		this.resultCode = resultCode;
		this.sourceAgentName = sourceAgentName;
		this.sourceAgentQMgr = sourceAgentQMgr;
		this.sourceAgentType = sourceAgentType;
		this.destinationAgentName = destinationAgentName;
		this.destinationAgentQMgr = destinationAgentQMgr;
		this.userID = userID;
		this.jobname = jobname;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getResultCode() {
		return resultCode;
	}

	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}

	public String getSourceAgentName() {
		return sourceAgentName;
	}

	public void setSourceAgentName(String sourceAgentName) {
		this.sourceAgentName = sourceAgentName;
	}

	public String getSourceAgentQMgr() {
		return sourceAgentQMgr;
	}

	public void setSourceAgentQMgr(String sourceAgentQMgr) {
		this.sourceAgentQMgr = sourceAgentQMgr;
	}

	public String getSourceAgentType() {
		return sourceAgentType;
	}

	public void setSourceAgentType(String sourceAgentType) {
		this.sourceAgentType = sourceAgentType;
	}

	public String getDestinationAgentName() {
		return destinationAgentName;
	}

	public void setDestinationAgentName(String destinationAgentName) {
		this.destinationAgentName = destinationAgentName;
	}

	public String getDestinationAgentQMgr() {
		return destinationAgentQMgr;
	}

	public void setDestinationAgentQMgr(String destinationAgentQMgr) {
		this.destinationAgentQMgr = destinationAgentQMgr;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getJobName() {
		return jobname;
	}

	public void setName(String jobname) {
		this.jobname = jobname;
	}

}

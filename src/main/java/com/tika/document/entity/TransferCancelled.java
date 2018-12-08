package com.tika.document.entity;

public class TransferCancelled {
	private String time;
	private String ID;
	private String type;
	private String resultCode;
	private String sourceAgentName;
	private String sourceAgentQMgr;
	private String sourceAgentType;
	private String destinationAgentName;
	private String destinationAgentQMgr;
	private String destinationAgentType;
	private String originatoruserID;
	private String jobname;
	private String statussupplement;
	private String metaData;

	
	public TransferCancelled(String time, String iD, String type, String resultCode, String sourceAgentName,
			String sourceAgentQMgr, String sourceAgentType, String destinationAgentName, String destinationAgentQMgr,
			String destinationAgentType, String originatoruserID, String jobname, String statussupplement) {
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
		this.destinationAgentType = destinationAgentType;
		this.originatoruserID = originatoruserID;
		this.jobname = jobname;
		this.statussupplement = statussupplement;
	}

	public TransferCancelled(String time, String iD, String type, String resultCode, String sourceAgentName,
			String sourceAgentQMgr, String sourceAgentType, String destinationAgentName, String destinationAgentQMgr,
			String destinationAgentType, String originatoruserID, String jobname, String statussupplement,
			String metaData) {
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
		this.destinationAgentType = destinationAgentType;
		this.originatoruserID = originatoruserID;
		this.jobname = jobname;
		this.statussupplement = statussupplement;
		this.metaData = metaData;
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

	public String getresultCode() {
		return resultCode;
	}

	public void setresultCode(String resultCode) {
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

	public String getDestinationAgentType() {
		return destinationAgentType;
	}

	public void setDestinationAgentType(String destinationAgentType) {
		this.destinationAgentType = destinationAgentType;
	}

	public String getOriginatoruserID() {
		return originatoruserID;
	}

	public void setOriginatoruserID(String originatoruserID) {
		this.originatoruserID = originatoruserID;
	}

	public String getJobname() {
		return jobname;
	}

	public void setJobname(String jobname) {
		this.jobname = jobname;
	}

	public String getStatussupplement() {
		return statussupplement;
	}

	public void setStatussupplement(String statussupplement) {
		this.statussupplement = statussupplement;
	}

	public String getMetaData() {
		return metaData;
	}

	public void setMetaData(String metaData) {
		this.metaData = metaData;
	}

}

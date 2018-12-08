package com.tika.document.entity;

public class TransferProgress {
	private String time;
	private String ID;
	private String type;
	private String resultCode;
	private String source;
	private String sourcesize;
	private String sourcetype;
	private String sourcedisposition;
	private String sourcealias;
	private String sourcefilespace;
	private String sourcecorrelationBoolean1;
	private String sourcecorrelationNum1;
	private String sourcecorrelationString1;
	private String destination;
	private String destinationsize;
	private String destinationtype;
	private String destinationexist;
	private String destinationalias;
	private String destinationfilespace;
	private String destinationtruncateRecords;
	private String destinationcorrelationBoolean1;
	private String destinationcorrelationNum1;
	private String destinationcorrelationString1;
	private String statussupplement;
	private String metaData;
	public String getMetaData() {
		return metaData;
	}

	public void setMetaData(String metaData) {
		this.metaData = metaData;
	}
	public TransferProgress(String time, String iD, String type, String resultCode, String source, String sourcesize,
			String sourcetype, String sourcedisposition, String sourcealias, String sourcefilespace,
			String sourcecorrelationBoolean1, String sourcecorrelationNum1, String sourcecorrelationString1,
			String destination, String destinationsize, String destinationtype, String destinationexist,
			String destinationalias, String destinationfilespace, String destinationtruncateRecords,
			String destinationcorrelationBoolean1, String destinationcorrelationNum1,
			String destinationcorrelationString1, String statussupplement) {
		super();
		this.time = time;
		this.ID = iD;
		this.type = type;
		this.resultCode = resultCode;
		this.source = source;
		this.sourcesize = sourcesize;
		this.sourcetype = sourcetype;
		this.sourcedisposition = sourcedisposition;
		this.sourcealias = sourcealias;
		this.sourcefilespace = sourcefilespace;
		this.sourcecorrelationBoolean1 = sourcecorrelationBoolean1;
		this.sourcecorrelationNum1 = sourcecorrelationNum1;
		this.sourcecorrelationString1 = sourcecorrelationString1;
		this.destination = destination;
		this.destinationsize = destinationsize;
		this.destinationtype = destinationtype;
		this.destinationexist = destinationexist;
		this.destinationalias = destinationalias;
		this.destinationfilespace = destinationfilespace;
		this.destinationtruncateRecords = destinationtruncateRecords;
		this.destinationcorrelationBoolean1 = destinationcorrelationBoolean1;
		this.destinationcorrelationNum1 = destinationcorrelationNum1;
		this.destinationcorrelationString1 = destinationcorrelationString1;
		this.statussupplement = statussupplement;
	}

	public TransferProgress(String time, String iD, String type, String resultCode, String source, String sourcesize,
			String sourcetype, String sourcedisposition, String sourcealias, String sourcefilespace,
			String sourcecorrelationBoolean1, String sourcecorrelationNum1, String sourcecorrelationString1,
			String destination, String destinationsize, String destinationtype, String destinationexist,
			String destinationalias, String destinationfilespace, String destinationtruncateRecords,
			String destinationcorrelationBoolean1, String destinationcorrelationNum1,
			String destinationcorrelationString1, String statussupplement, String metaData) {
		super();
		this.time = time;
		ID = iD;
		this.type = type;
		this.resultCode = resultCode;
		this.source = source;
		this.sourcesize = sourcesize;
		this.sourcetype = sourcetype;
		this.sourcedisposition = sourcedisposition;
		this.sourcealias = sourcealias;
		this.sourcefilespace = sourcefilespace;
		this.sourcecorrelationBoolean1 = sourcecorrelationBoolean1;
		this.sourcecorrelationNum1 = sourcecorrelationNum1;
		this.sourcecorrelationString1 = sourcecorrelationString1;
		this.destination = destination;
		this.destinationsize = destinationsize;
		this.destinationtype = destinationtype;
		this.destinationexist = destinationexist;
		this.destinationalias = destinationalias;
		this.destinationfilespace = destinationfilespace;
		this.destinationtruncateRecords = destinationtruncateRecords;
		this.destinationcorrelationBoolean1 = destinationcorrelationBoolean1;
		this.destinationcorrelationNum1 = destinationcorrelationNum1;
		this.destinationcorrelationString1 = destinationcorrelationString1;
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

	public String getResultCode() {
		return resultCode;
	}

	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getSourcesize() {
		return sourcesize;
	}

	public void setSourcesize(String sourcesize) {
		this.sourcesize = sourcesize;
	}

	public String getSourcetype() {
		return sourcetype;
	}

	public void setSourcetype(String sourcetype) {
		this.sourcetype = sourcetype;
	}

	public String getSourcedisposition() {
		return sourcedisposition;
	}

	public void setSourcedisposition(String sourcedisposition) {
		this.sourcedisposition = sourcedisposition;
	}

	public String getSourcealias() {
		return sourcealias;
	}

	public void setSourcealias(String sourcealias) {
		this.sourcealias = sourcealias;
	}

	public String getSourcefilespace() {
		return sourcefilespace;
	}

	public void setSourcefilespace(String sourcefilespace) {
		this.sourcefilespace = sourcefilespace;
	}

	public String getSourcecorrelationBoolean1() {
		return sourcecorrelationBoolean1;
	}

	public void setSourcecorrelationBoolean1(String sourcecorrelationBoolean1) {
		this.sourcecorrelationBoolean1 = sourcecorrelationBoolean1;
	}

	public String getSourcecorrelationNum1() {
		return sourcecorrelationNum1;
	}

	public void setSourcecorrelationNum1(String sourcecorrelationNum1) {
		this.sourcecorrelationNum1 = sourcecorrelationNum1;
	}

	public String getSourcecorrelationString1() {
		return sourcecorrelationString1;
	}

	public void setSourcecorrelationString1(String sourcecorrelationString1) {
		this.sourcecorrelationString1 = sourcecorrelationString1;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getDestinationsize() {
		return destinationsize;
	}

	public void setDestinationsize(String destinationsize) {
		this.destinationsize = destinationsize;
	}

	public String getDestinationtype() {
		return destinationtype;
	}

	public void setDestinationtype(String destinationtype) {
		this.destinationtype = destinationtype;
	}

	public String getDestinationexist() {
		return destinationexist;
	}

	public void setDestinationexist(String destinationexist) {
		this.destinationexist = destinationexist;
	}

	public String getDestinationalias() {
		return destinationalias;
	}

	public void setDestinationalias(String destinationalias) {
		this.destinationalias = destinationalias;
	}

	public String getDestinationfilespace() {
		return destinationfilespace;
	}

	public void setDestinationfilespace(String destinationfilespace) {
		this.destinationfilespace = destinationfilespace;
	}

	public String getDestinationtruncateRecords() {
		return destinationtruncateRecords;
	}

	public void setDestinationtruncateRecords(String destinationtruncateRecords) {
		this.destinationtruncateRecords = destinationtruncateRecords;
	}

	public String getDestinationcorrelationBoolean1() {
		return destinationcorrelationBoolean1;
	}

	public void setDestinationcorrelationBoolean1(String destinationcorrelationBoolean1) {
		this.destinationcorrelationBoolean1 = destinationcorrelationBoolean1;
	}

	public String getDestinationcorrelationNum1() {
		return destinationcorrelationNum1;
	}

	public void setDestinationcorrelationNum1(String destinationcorrelationNum1) {
		this.destinationcorrelationNum1 = destinationcorrelationNum1;
	}

	public String getDestinationcorrelationString1() {
		return destinationcorrelationString1;
	}

	public void setDestinationcorrelationString1(String destinationcorrelationString1) {
		this.destinationcorrelationString1 = destinationcorrelationString1;
	}

	public String getStatussupplement() {
		return statussupplement;
	}

	public void setStatussupplement(String statussupplement) {
		this.statussupplement = statussupplement;
	}
}

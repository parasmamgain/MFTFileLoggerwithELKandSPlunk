package com.tika.document.entity;

import java.util.HashMap;
import java.util.Map;

public class MyCustomDocument {
	private String fileName;
	private String filePath;
	private String fileContent;
	private Map<String, String> fileMetaData;
	
	public MyCustomDocument(){
		this.fileMetaData = new HashMap<String,String>();
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getFileContent() {
		return fileContent;
	}

	public void setFileContent(String fileContent) {
		this.fileContent = fileContent;
	}

	public Map<String, String> getFileMetaData() {
		return fileMetaData;
	}

	public void setFileMetaData(Map<String, String> metaDataMap) {
		this.fileMetaData = metaDataMap;
	}

}

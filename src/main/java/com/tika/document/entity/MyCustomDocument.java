package com.tika.document.entity;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author parasmamgain
 * @github : https://github.com/parasmamgain/
 * @email : mamgain.paras@outlook.com
 *
 */
public class MyCustomDocument {
	private String fileName;
	private String filePath;
	private Object fileContent;
	private Map<String, String> fileMetaData;

	public MyCustomDocument() {
		this.fileMetaData = new HashMap<String, String>();
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

	public Object getFileContent() {
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

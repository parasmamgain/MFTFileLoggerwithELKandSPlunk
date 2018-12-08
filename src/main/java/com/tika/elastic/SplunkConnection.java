package com.tika.elastic;

import java.net.UnknownHostException;
import java.util.concurrent.ExecutionException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.splunk.Args;
import com.splunk.HttpService;
import com.splunk.Index;
import com.splunk.IndexCollection;
import com.splunk.IndexCollectionArgs;
import com.splunk.SSLSecurityProtocol;
import com.splunk.Service;
import com.tika.common.resources.ConfigurationProperties;
import com.tika.document.entity.TransferCancelled;
import com.tika.document.entity.TransferComplete;
import com.tika.document.entity.TransferDeleted;
import com.tika.document.entity.TransferProgress;
import com.tika.document.entity.TransferStarted;

public class SplunkConnection {
	private final static String SPLUNK_HOST_NAME = ConfigurationProperties.splunkHostName;
	private final static Integer SPLUNK_PORT_NUMBER = ConfigurationProperties.splunkPortNumber;
	private final static String SPLUNK_INDEX_NAME = ConfigurationProperties.splunkIndexName;
	private final static String SPLUNK_USER_NAME = ConfigurationProperties.splunkUserName;
	private final static String SPLUNK_PASSWORD = ConfigurationProperties.splunkPassword;
	private final static boolean SPLUNK_ENABLED= ConfigurationProperties.splunkEnabled;
	private final static String SPLUNK_CLUSTER_NAME = ConfigurationProperties.splunkClusterName;
	private static Service service = null;
	
	
	@SuppressWarnings({ "resource", "unused" })
	private static Service getSplunkService() throws UnknownHostException {
		if (SplunkConnection.service == null) {
			//Service service = new Service(SPLUNK_HOST_NAME, SPLUNK_PORT_NUMBER);
			//service.login(SPLUNK_USER_NAME, SPLUNK_PASSWORD);
			Service service = new Service(SPLUNK_HOST_NAME, SPLUNK_PORT_NUMBER);
			service.login(SPLUNK_USER_NAME, SPLUNK_PASSWORD);
			SplunkConnection.service = service;
		}

		return service;
	}

	public static String IndexFile(TransferStarted document) throws UnknownHostException, JsonProcessingException {
		Index index = getIndex(SPLUNK_INDEX_NAME);
		ObjectMapper mapper = new ObjectMapper(); // create once, reuse
		mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
		byte[] json = mapper.writeValueAsBytes(document);
		String jsonString = new String(json);
		Args eventArgs = new Args();
		eventArgs.put("sourcetype", "transferLog.log");
		eventArgs.put("type", "transferStarted");
		System.out.println(index);
		System.out.println(eventArgs);
		System.out.println(jsonString);;
		index.submit(eventArgs, jsonString);
		return "";
	}

	@SuppressWarnings({ "unused" })
	public static String IndexFile(TransferCancelled document)
			throws UnknownHostException, JsonProcessingException, InterruptedException, ExecutionException {
		Index index = getIndex(SPLUNK_INDEX_NAME);
		ObjectMapper mapper = new ObjectMapper(); // create once, reuse
		mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
		byte[] json = mapper.writeValueAsBytes(document);
		String jsonString = new String(json);
		Args eventArgs = new Args();
		eventArgs.put("sourcetype", "transferLog.log");
		eventArgs.put("type", "transferCancelled");
		
		index.submit(eventArgs, jsonString);;
		return "";
	}

	@SuppressWarnings({ "unused" })
	public static String IndexFile(TransferDeleted document)
			throws UnknownHostException, JsonProcessingException, InterruptedException, ExecutionException {
		Index index = getIndex(SPLUNK_INDEX_NAME);
		ObjectMapper mapper = new ObjectMapper(); // create once, reuse
		mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
		byte[] json = mapper.writeValueAsBytes(document);
		String jsonString = new String(json);
		Args eventArgs = new Args();
		eventArgs.put("sourcetype", "transferLog.log");
		eventArgs.put("type", "transferDeleted");
		
		index.submit(eventArgs, jsonString);
		return "";
	}

	@SuppressWarnings({ "unused" })
	public static String IndexFile(TransferProgress document)
			throws UnknownHostException, JsonProcessingException, InterruptedException, ExecutionException {
		Index index = getIndex(SPLUNK_INDEX_NAME);
		ObjectMapper mapper = new ObjectMapper(); // create once, reuse
		mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
		byte[] json = mapper.writeValueAsBytes(document);
		String jsonString = new String(json);
		Args eventArgs = new Args();
		eventArgs.put("sourcetype", "transferLog.log");
		eventArgs.put("type", "transferProgress");
		
		index.submit(eventArgs, jsonString);
		return "";
	}

	@SuppressWarnings({ "unused" })
	public static String IndexFile(TransferComplete document)
			throws UnknownHostException, JsonProcessingException, InterruptedException, ExecutionException {
		Index index = getIndex(SPLUNK_INDEX_NAME);
		ObjectMapper mapper = new ObjectMapper(); // create once, reuse
		mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
		byte[] json = mapper.writeValueAsBytes(document);
		String jsonString = new String(json);
		Args eventArgs = new Args();
		eventArgs.put("sourcetype", "transferLog.log");
		eventArgs.put("type", "transferComplete");
		
		index.submit(eventArgs, jsonString);
		return "";
	}
	
	private static Index getIndex(String indexName) throws UnknownHostException{
		boolean flag = false;
		Index myIndex = null;
		// Retrieve the collection of indexes, sorted by number of events
		IndexCollectionArgs indexcollArgs = new IndexCollectionArgs();
		Service service = getSplunkService();
		IndexCollection myIndexes = service.getIndexes(indexcollArgs);
		// List the indexes and their event counts
		for (Index entity: myIndexes.values()) {
		    if(entity.getName().equalsIgnoreCase(indexName))
		    	{
		    		flag = true;
		    		break;
		    	}
		}
		
		if (flag == false) {
			//Create a new index
			myIndex = myIndexes.create(indexName);
		}
		
		myIndex = service.getIndexes().get(indexName);
		
		return myIndex;
	}

}

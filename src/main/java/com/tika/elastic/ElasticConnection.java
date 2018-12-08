package com.tika.elastic;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.concurrent.ExecutionException;

import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.rest.RestStatus;
import org.elasticsearch.transport.client.PreBuiltTransportClient;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.tika.common.resources.ConfigurationProperties;
import com.tika.document.entity.TransferCancelled;
import com.tika.document.entity.TransferComplete;
import com.tika.document.entity.TransferDeleted;
import com.tika.document.entity.TransferProgress;
import com.tika.document.entity.TransferStarted;

/**
 * 
 * @author parasmamgain
 * @github : https://github.com/parasmamgain/
 * @email : mamgain.paras@outlook.com
 *
 */
public class ElasticConnection {
	private final static String HOST_NAME = ConfigurationProperties.hostName;
	private final static Integer PORT_NUMBER = ConfigurationProperties.portNumber;
	private final static String INDEX_NAME = ConfigurationProperties.indexName;
	private final static String CLUSTER_NAME = ConfigurationProperties.clusterName;
	private final static String ELASTICUSERNAME = ConfigurationProperties.elasticUserName;
	private final static String ELASTICPASSWORD = ConfigurationProperties.elasticPassword;
	private final static String DOCUMENT_TYPE = "transfer";

	private static TransportClient client = null;

	@SuppressWarnings({ "resource", "unused" })
	private static TransportClient getElasticClient() throws UnknownHostException {
		if (ElasticConnection.client == null) {
			TransportClient client = null;
			Settings settings = Settings.builder().put("cluster.name", CLUSTER_NAME).build();
			if(ELASTICPASSWORD != null && !ELASTICPASSWORD.isEmpty()){
				settings = Settings.builder().put("elasticsearch.password", ELASTICPASSWORD).build();
			}
			if(ELASTICUSERNAME != null && !ELASTICUSERNAME.isEmpty()){
				settings = Settings.builder().put("elasticsearch.username", ELASTICUSERNAME).build();
			}
			if(PORT_NUMBER >= 0){
			client = new PreBuiltTransportClient(Settings.EMPTY)
					.addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName(HOST_NAME), PORT_NUMBER));
			}
			else{
				
			}
			ElasticConnection.client = client;
		}

		return client;
	}

	public static String IndexFile(TransferStarted document) throws UnknownHostException, JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper(); // create once, reuse
		mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
		byte[] json = mapper.writeValueAsBytes(document);
		TransportClient transportClient = getElasticClient();
		IndexResponse response = transportClient.prepareIndex(INDEX_NAME, DOCUMENT_TYPE, document.getID())
				.setSource(json).get();
		RestStatus status = response.status();
		String result = document.getID() + ":" + status;
		return result;
	}

	@SuppressWarnings({ "unused" })
	public static String IndexFile(TransferCancelled document)
			throws UnknownHostException, JsonProcessingException, InterruptedException, ExecutionException {
		ObjectMapper mapper = new ObjectMapper(); // create once, reuse
		mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
		byte[] json = mapper.writeValueAsBytes(document);
		TransportClient transportClient = getElasticClient();
		IndexRequest indexRequest = new IndexRequest(INDEX_NAME, DOCUMENT_TYPE, document.getID()).source(json);
		UpdateRequest request = new UpdateRequest(INDEX_NAME, DOCUMENT_TYPE, document.getID()).doc(json)
				.upsert(indexRequest);
		UpdateResponse response = client.update(request).get();
		RestStatus status = response.status();
		String result = document.getID() + ":" + status;
		return result;
	}

	@SuppressWarnings({ "unused" })
	public static String IndexFile(TransferDeleted document)
			throws UnknownHostException, JsonProcessingException, InterruptedException, ExecutionException {
		ObjectMapper mapper = new ObjectMapper(); // create once, reuse
		mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
		byte[] json = mapper.writeValueAsBytes(document);
		TransportClient transportClient = getElasticClient();
		IndexRequest indexRequest = new IndexRequest(INDEX_NAME, DOCUMENT_TYPE, document.getID()).source(json);
		UpdateRequest request = new UpdateRequest(INDEX_NAME, DOCUMENT_TYPE, document.getID()).doc(json)
				.upsert(indexRequest);
		UpdateResponse response = client.update(request).get();
		RestStatus status = response.status();
		String result = document.getID() + ":" + status;
		return result;
	}

	@SuppressWarnings({ "unused" })
	public static String IndexFile(TransferProgress document)
			throws UnknownHostException, JsonProcessingException, InterruptedException, ExecutionException {
		ObjectMapper mapper = new ObjectMapper(); // create once, reuse
		mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
		byte[] json = mapper.writeValueAsBytes(document);
		TransportClient transportClient = getElasticClient();
		IndexRequest indexRequest = new IndexRequest(INDEX_NAME, DOCUMENT_TYPE, document.getID()).source(json);
		UpdateRequest request = new UpdateRequest(INDEX_NAME, DOCUMENT_TYPE, document.getID()).doc(json)
				.upsert(indexRequest);
		UpdateResponse response = client.update(request).get();
		RestStatus status = response.status();
		String result = document.getID() + ":" + status;
		return result;
	}

	@SuppressWarnings({ "unused" })
	public static String IndexFile(TransferComplete document)
			throws UnknownHostException, JsonProcessingException, InterruptedException, ExecutionException {
		ObjectMapper mapper = new ObjectMapper(); // create once, reuse
		mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
		byte[] json = mapper.writeValueAsBytes(document);
		TransportClient transportClient = getElasticClient();
		IndexRequest indexRequest = new IndexRequest(INDEX_NAME, DOCUMENT_TYPE, document.getID()).source(json);
		UpdateRequest request = new UpdateRequest(INDEX_NAME, DOCUMENT_TYPE, document.getID()).doc(json)
				.upsert(indexRequest);
		UpdateResponse response = client.update(request).get();
		RestStatus status = response.status();
		String result = document.getID() + ":" + status;
		return result;
	}


}

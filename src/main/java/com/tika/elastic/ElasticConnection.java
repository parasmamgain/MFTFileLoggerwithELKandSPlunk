package com.tika.elastic;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.rest.RestStatus;
import org.elasticsearch.transport.client.PreBuiltTransportClient;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.tika.document.entity.MyCustomDocument;

public class ElasticConnection {
	private final static String HOST_NAME = "localhost";
	private final static Integer PORT_NUMBER = 9300;
	private final static String INDEX_NAME = "ajayindex";
	private final static String CLUSTER_NAME = "elasticsearch";

	private static TransportClient client = null;

	@SuppressWarnings({ "resource", "unchecked", "unused" })
	private static TransportClient getElasticClient() throws UnknownHostException {
		if (ElasticConnection.client == null) {
			Settings settings = Settings.builder().put("cluster.name", CLUSTER_NAME).build();
			TransportClient client = new PreBuiltTransportClient(Settings.EMPTY)
					.addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName(HOST_NAME), PORT_NUMBER));
			ElasticConnection.client = client;
		}

		return client;
	}

	@SuppressWarnings({ "unused" })
	public static String IndexFile(MyCustomDocument document) throws UnknownHostException, JsonProcessingException {

		/*
		 * MyCustomDocument doc = new MyCustomDocument(); String filePath =
		 * "d://file2.pdf";
		 */
		// doc = new ContentExtraction().extractFileContent(filePath);

		// instance a json mapper
		ObjectMapper mapper = new ObjectMapper(); // create once, reuse
		mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
		// generate json
		byte[] json = mapper.writeValueAsBytes(document);
		TransportClient transportClient = getElasticClient();

		IndexResponse response = transportClient.prepareIndex(INDEX_NAME, "document",document.getFileName()).setSource(json).get();

		// Index name
		String _index = response.getIndex();
		// Type name
		String _type = response.getType();
		// Document ID (generated or not)
		String _id = response.getId();
		// Version (if it's the first time you index this document, you will
		// get: 1)
		long _version = response.getVersion();
		// status has stored current instance statement.
		RestStatus status = response.status();
		String result = document.getFileName() + ":" + status;
		return result;
	}

}

package com.tika.document;

import java.io.File;
import java.net.UnknownHostException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.tika.document.entity.MyCustomDocument;
import com.tika.elastic.ElasticConnection;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		String path = "D:\\elasticDocs";
		MyCustomDocument doc = new MyCustomDocument();
		try {

			// Path myPath = Paths.get(path);
			File file = new File(path);
			if (file.exists()) {
				if (file.isDirectory()) {
					for (File individualFile : file.listFiles()) {
						doc = ContentExtraction.extractFileContent(individualFile.getAbsolutePath());
						System.out.println(ElasticConnection.IndexFile(doc));

					}
				} else if (file.isFile()) {
					doc = ContentExtraction.extractFileContent(path);
					System.out.println(ElasticConnection.IndexFile(doc));
				}
			}

		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}

package com.tika.document;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.Parser;
import org.apache.tika.sax.BodyContentHandler;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;
import com.tika.document.entity.MyCustomDocument;

public class ContentExtraction {

	public static MyCustomDocument extractFileContent(String filePath) {

		MyCustomDocument tempDocument = new MyCustomDocument();
		String target = filePath;
		File document = new File(target);
		Parser parser = new AutoDetectParser();

		ContentHandler handler = new BodyContentHandler();
		Metadata metadata = new Metadata();
		Map<String, String> metaDataMap = new HashMap<String, String>();
		try {
			parser.parse(new FileInputStream(document), handler, metadata, new ParseContext());

			String[] metadataNames = metadata.names();
			for (String name : metadataNames) {
				metaDataMap.put(name, metadata.get(name));
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (TikaException e) {
			e.printStackTrace();
		}
		String fileName = "";
		if (filePath.contains("\\")) {
			fileName = filePath.substring(filePath.lastIndexOf("\\") + 1);
		} else if (filePath.contains("/") || filePath.contains("//")) {
			fileName = filePath.substring(filePath.lastIndexOf("/") + 1);
		} else {
			fileName = filePath;
		}

		tempDocument.setFilePath(filePath);
		tempDocument.setFileContent(handler.toString());
		tempDocument.setFileName(fileName);
		tempDocument.setFileMetaData(metaDataMap);
		return tempDocument;
	}

}

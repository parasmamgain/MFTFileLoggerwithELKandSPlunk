package com.tika.document;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.UnknownHostException;
import java.util.concurrent.ExecutionException;

import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.Parser;
import org.apache.tika.sax.BodyContentHandler;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.tika.document.entity.TransferCancelled;
import com.tika.document.entity.TransferComplete;
import com.tika.document.entity.TransferDeleted;
import com.tika.document.entity.TransferProgress;
import com.tika.document.entity.TransferStarted;
import com.tika.elastic.ElasticConnection;

/**
 * 
 * @author parasmamgain
 * @github : https://github.com/parasmamgain/
 * @email : mamgain.paras@outlook.com
 *
 */
public class ContentExtraction {

	public static void extractMFTTransferLog(String filePath)
			throws UnknownHostException, JsonProcessingException, InterruptedException, ExecutionException {

		TransferStarted transferDocument = null;
		TransferComplete transferCompleted = null;
		TransferProgress transferProgres = null;
		TransferDeleted transferDeleted = null;
		TransferCancelled transferCancelled = null;

		String target = filePath;
		File document = new File(target);
		Parser parser = new AutoDetectParser();

		ContentHandler handler = new BodyContentHandler();
		Metadata metadata = new Metadata();
		try {
			parser.parse(new FileInputStream(document), handler, metadata, new ParseContext());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (TikaException e) {
			e.printStackTrace();
		}
		/*
		 * String fileName = ""; if (filePath.contains("\\")) { fileName =
		 * filePath.substring(filePath.lastIndexOf("\\") + 1); } else if
		 * (filePath.contains("/") || filePath.contains("//")) { fileName =
		 * filePath.substring(filePath.lastIndexOf("/") + 1); } else { fileName
		 * = filePath; }
		 */
		String[] contentList = (handler.toString()).split("\\n");
		for (String transferRecord : contentList) {

			String[] td = transferRecord.split(";");

			if (td.length <= 2) {
				break;
			}

			switch (td[2].trim()) {
			case "[TSTR]": {
				if (td.length == 14) {
					transferDocument = new TransferStarted(td[0], td[1], td[2], td[3], td[4], td[5], td[6], td[7],
							td[8], td[9], td[10], td[11]);
					System.out.println(ElasticConnection.IndexFile(transferDocument));
				} else {
					// raise exception
				}
				break;
			}
			case "[TCAN]": {
				if (td.length == 15) {
					transferCancelled = new TransferCancelled(td[0], td[1], td[2], td[3], td[4], td[5], td[6], td[7],
							td[8], td[9], td[10], td[11], td[12], td[13]);
					System.out.println(ElasticConnection.IndexFile(transferCancelled));
				} else {
					// raise exception
				}
				break;
			}
			case "[TCOM]": {
				if (td.length == 15) {
					transferCompleted = new TransferComplete(td[0], td[1], td[2], td[3], td[4], td[5], td[6], td[7],
							td[8], td[9], td[10], td[11], td[12], td[13]);
					System.out.println(ElasticConnection.IndexFile(transferCompleted));
				} else {
					// raise exception
				}
				break;
			}
			case "[TDEL]": {
				if (td.length == 15) {
					transferDeleted = new TransferDeleted(td[0], td[1], td[2], td[3], td[4], td[5], td[6], td[7], td[8],
							td[9], td[10], td[11], td[12], td[13]);
					System.out.println(ElasticConnection.IndexFile(transferDeleted));
				} else {
					// raise exception
				}
				break;
			}
			case "[TPRO]": {
				if (td.length == 25) {
					transferProgres = new TransferProgress(td[0], td[1], td[2], td[3], td[4], td[5], td[6], td[7],
							td[8], td[9], td[10], td[11], td[12], td[13], td[14], td[15], td[16], td[17], td[18],
							td[19], td[20], td[21], td[22], td[23], td[24]);
					System.out.println(ElasticConnection.IndexFile(transferProgres));
				} else {
					// raise exception
				}
				break;
			}
			default: {

				System.out.println("Invalid Log format detected:" + td[2].trim());
			}
			}
		}

	}

}

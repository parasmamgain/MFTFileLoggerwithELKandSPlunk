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
import com.tika.common.resources.ConfigurationProperties;
import com.tika.document.entity.TransferCancelled;
import com.tika.document.entity.TransferComplete;
import com.tika.document.entity.TransferDeleted;
import com.tika.document.entity.TransferProgress;
import com.tika.document.entity.TransferStarted;
import com.tika.elastic.ElasticConnection;
import com.tika.elastic.SplunkConnection;

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
		System.out.println("Extracting Content");
		TransferStarted transferDocument = null;
		TransferComplete transferCompleted = null;
		TransferProgress transferProgres = null;
		TransferDeleted transferDeleted = null;
		TransferCancelled transferCancelled = null;

		String target = filePath;
		File document = new File(target);
		Parser parser = new AutoDetectParser();

		ContentHandler handler = new BodyContentHandler(-1);
		Metadata metadata = new Metadata();
		try {
			System.out.println("STarting parser");
			parser.parse(new FileInputStream(document), handler, metadata, new ParseContext());
			System.out.println("Parsing done");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (TikaException e) {
			e.printStackTrace();
		} catch (Exception e) {
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
			System.out.println(transferRecord);
			String[] td = transferRecord.split(";");

			if (td.length <= 2) {
				continue;
			}

			switch (td[2].trim()) {
			case "[TSTR]": {
				if (td.length == 14) {
					transferDocument = new TransferStarted(td[0], td[1], td[2], td[3], td[4], td[5], td[6], td[7],
							td[8], td[9], td[10], td[11]);
					logData(transferDocument);
				} else {
					System.out.println("Unable to parse TSTR");
				}
				break;
			}
			case "[TCAN]": {
				if (td.length == 15) {
					transferCancelled = new TransferCancelled(td[0], td[1], td[2], td[3], td[4], td[5], td[6], td[7],
							td[8], td[9], td[10], td[11], td[12], td[13]);
					logData(transferCancelled);
				} else {
					// raise exception
					System.out.println("Unable to parse TCAN");
				}
				break;
			}
			case "[TCOM]": {
				if (td.length == 15) {
					transferCompleted = new TransferComplete(td[0], td[1], td[2], td[3], td[4], td[5], td[6], td[7],
							td[8], td[9], td[10], td[11], td[12], td[13]);
					logData(transferCompleted);
				} else {
					System.out.println("Unable to parse TCOM");
				}
				break;
			}
			case "[TDEL]": {
				if (td.length == 15) {
					transferDeleted = new TransferDeleted(td[0], td[1], td[2], td[3], td[4], td[5], td[6], td[7], td[8],
							td[9], td[10], td[11], td[12], td[13]);
					logData(transferDeleted);
				} else {
					System.out.println("Unable to parse TDEL");
				}
				break;
			}
			case "[TPRO]": {
				if (td.length == 25) {
					transferProgres = new TransferProgress(td[0], td[1], td[2], td[3], td[4], td[5], td[6], td[7],
							td[8], td[9], td[10], td[11], td[12], td[13], td[14], td[15], td[16], td[17], td[18],
							td[19], td[20], td[21], td[22], td[23], td[24]);
					logData(transferProgres);
				} else {
					System.out.println("Unable to parse TPRO");
				}
				break;
			}
			default: {
				System.out.println("Invalid Log format detected:" + td[2].trim());
			}
			}
		}

	}

	private static void logData(Object transferRecord) throws UnknownHostException, JsonProcessingException, InterruptedException, ExecutionException {

		boolean elasticEnabled = ConfigurationProperties.elasticSearchEnabled;
		boolean splunkEnabled = ConfigurationProperties.splunkEnabled;
		//boolean loggingServiceEnabled = ConfigurationProperties.loggingServiceEnabled;

		if (elasticEnabled) {
			if (transferRecord instanceof TransferStarted) {
				System.out.println(ElasticConnection.IndexFile((TransferStarted) transferRecord));
			}

			if (transferRecord instanceof TransferProgress) {
				System.out.println(ElasticConnection.IndexFile((TransferProgress) transferRecord));
			}

			if (transferRecord instanceof TransferComplete) {
				System.out.println(ElasticConnection.IndexFile((TransferComplete) transferRecord));
			}

			if (transferRecord instanceof TransferDeleted) {
				System.out.println(ElasticConnection.IndexFile((TransferDeleted) transferRecord));
			}

			if (transferRecord instanceof TransferCancelled) {
				System.out.println(ElasticConnection.IndexFile((TransferCancelled) transferRecord));
			}
		} else {
			System.out.println("Flag for ELASTICSEARCHENABLED is false , data will not be logged in the Elastic Search");
		}
		
		// Logging Data for Splunk
		if (splunkEnabled) {
			if (transferRecord instanceof TransferStarted) {
				System.out.println(SplunkConnection.IndexFile((TransferStarted) transferRecord));
			}

			if (transferRecord instanceof TransferProgress) {
				System.out.println(SplunkConnection.IndexFile((TransferProgress) transferRecord));
			}

			if (transferRecord instanceof TransferComplete) {
				System.out.println(SplunkConnection.IndexFile((TransferComplete) transferRecord));
			}

			if (transferRecord instanceof TransferDeleted) {
				System.out.println(SplunkConnection.IndexFile((TransferDeleted) transferRecord));
			}

			if (transferRecord instanceof TransferCancelled) {
				System.out.println(SplunkConnection.IndexFile((TransferCancelled) transferRecord));
			}
		} else {
			System.out.println("Flag for SplunKEnabled is false , data will not be logged in the Splunk");
		}

		
		/*if (loggingServiceEnabled) {
			if (transferRecord instanceof TransferStarted) {
				System.out.println(LoggingService.IndexFile((TransferStarted) transferRecord));
			}

			if (transferRecord instanceof TransferProgress) {
				System.out.println(LoggingService.IndexFile((TransferProgress) transferRecord));
			}

			if (transferRecord instanceof TransferComplete) {
				System.out.println(LoggingService.IndexFile((TransferComplete) transferRecord));
			}

			if (transferRecord instanceof TransferDeleted) {
				System.out.println(LoggingService.IndexFile((TransferDeleted) transferRecord));
			}

			if (transferRecord instanceof TransferCancelled) {
				System.out.println(LoggingService.IndexFile((TransferCancelled) transferRecord));
			}
		} else {
			System.out.println("Flag for LOGGINGSERVICEENABLED is false , data will not be logged in the Elastic Search");
		}*/

	}
}

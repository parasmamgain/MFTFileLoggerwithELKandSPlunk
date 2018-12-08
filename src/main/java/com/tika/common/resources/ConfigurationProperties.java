package com.tika.common.resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 
 * @author parasmamgain
 * @github : https://github.com/parasmamgain/
 * @email : mamgain.paras@outlook.com
 *
 */
public class ConfigurationProperties {
	
	// Configuration Properties for the Elastic Search hosted within the reachable network
	public static String hostName = "";
	public static String indexName = "";
	public static Integer portNumber;
	public static String time = "";
	public static String clusterName = "";
	public static String elasticUserName = "";
	public static String elasticPassword = "";	
	public static boolean elasticSearchEnabled = false;
	
	
	// Splunk Configuration Parameters
	public static String splunkHostName = "";
	public static Integer splunkPortNumber ;
	public static String splunkIndexName ="";
	public static boolean splunkEnabled = false;
	public static String splunkUserName = "";
	public static String splunkPassword = "";
	public static String splunkClusterName = "";
	
	
	//Common Property Parameter
	public static Integer daysInterval;
	public static String timePeriod = "5";
	public static String sourcePath = "";
	
	
	public static void LoadProperties(String propertyFilePath) {
		Properties prop = new Properties();
		InputStream input = null;
		try {

			input = new FileInputStream(propertyFilePath);

			// load a properties file
			prop.load(input);

			// Configuration Properties for IBM Logging Service (Elastic Search in own server)
			
			if (prop.getProperty("ELASTICSEARCHENABLED") == null || prop.getProperty("ELASTICSEARCHENABLED").isEmpty()) {
				elasticSearchEnabled = false;
			} else {
				String flag = prop.getProperty("ELASTICSEARCHENABLED").trim();
				if(flag.equalsIgnoreCase("true"))
					elasticSearchEnabled = true;
			}
			
			if (prop.getProperty("HOSTNAME") == null || prop.getProperty("HOSTNAME").isEmpty()) {
				hostName = "localhost";
			} else {
				hostName = prop.getProperty("HOSTNAME").trim();
			}
			if (prop.getProperty("INDEXNAME") == null || prop.getProperty("INDEXNAME").isEmpty()) {
				indexName = "mftindex";
			} else {
				indexName = prop.getProperty("INDEXNAME").trim();
			}
			if (prop.getProperty("PORTNUMBER") == null || prop.getProperty("PORTNUMBER").isEmpty()) {
				portNumber = 9300;
			} else {
				portNumber = Integer.parseInt(prop.getProperty("PORTNUMBER").trim());
			}
			if (prop.getProperty("SOURCEPATH") == null || prop.getProperty("SOURCEPATH").isEmpty()) {
				sourcePath = "";
			} else {
				sourcePath = prop.getProperty("SOURCEPATH").trim();
			}
			if (prop.getProperty("TIME") == null || prop.getProperty("TIME").isEmpty()) {
				time = "01:00 AM"; // DateFormat dateFormat = new
									// SimpleDateFormat("hh:mm a");
			} else {
				time = prop.getProperty("TIME").trim();
			}
			if (prop.getProperty("CLUSTERNAME") == null || prop.getProperty("CLUSTERNAME").isEmpty()) {
				clusterName = "elasticsearch";
			} else {
				clusterName = prop.getProperty("CLUSTERNAME").trim();
			}
			if (prop.getProperty("DAYSINTERVAL") == null || prop.getProperty("DAYSINTERVAL").isEmpty()) {
				daysInterval = 1;
			} else {
				daysInterval = Integer.parseInt(prop.getProperty("DAYSINTERVAL").trim());
			}
			if (prop.getProperty("ELASTICUSERNAME") == null || prop.getProperty("ELASTICUSERNAME").isEmpty()) {
				elasticUserName = "";
			} else {
				elasticUserName = prop.getProperty("DAYSINTERVAL").trim();
			}
			if (prop.getProperty("ELASTICPASSWORD") == null || prop.getProperty("ELASTICPASSWORD").isEmpty()) {
				elasticPassword = "";
			} else {
				elasticPassword = prop.getProperty("ELASTICPASSWORD").trim();
			}
			if (prop.getProperty("TIMEPERIOD") == null || prop.getProperty("TIMEPERIOD").isEmpty()) {
				timePeriod = "";
			} else {
				timePeriod = prop.getProperty("TIMEPERIOD").trim();
			}
			
			//Configuration Properties For SPLUNK
			
			if (prop.getProperty("SPLUNKENABLED") == null || prop.getProperty("SPLUNKENABLED").isEmpty()) {
				splunkEnabled = false;
			} else {
				String flag = prop.getProperty("SPLUNKENABLED").trim();
				if(flag.equalsIgnoreCase("true"))
					splunkEnabled = true;
			}
			
			if (prop.getProperty("SPLUNKHOSTNAME") == null || prop.getProperty("SPLUNKHOSTNAME").isEmpty()) {
				splunkHostName = "";
			} else {
				splunkHostName = prop.getProperty("SPLUNKHOSTNAME").trim();
			}
			
			if (prop.getProperty("SPLUNKPORTNUMBER") == null || prop.getProperty("SPLUNKPORTNUMBER").isEmpty()) {
				splunkPortNumber = 0;
			} else {
				splunkPortNumber = Integer.parseInt(prop.getProperty("SPLUNKPORTNUMBER").trim());
			}
			
			if (prop.getProperty("SPLUNKUSERNAME") == null || prop.getProperty("SPLUNKUSERNAME").isEmpty()) {
				splunkUserName = "";
			} else {
				splunkUserName = prop.getProperty("SPLUNKUSERNAME").trim();
			}
			
			if (prop.getProperty("SPLUNKPASSWORD") == null || prop.getProperty("SPLUNKPASSWORD").isEmpty()) {
				splunkPassword = "";
			} else {
				splunkPassword = prop.getProperty("SPLUNKPASSWORD").trim();
			}
			
			if (prop.getProperty("SPLUNKINDEXNAME") == null || prop.getProperty("SPLUNKINDEXNAME").isEmpty()) {
				splunkIndexName = "";
			} else {
				splunkIndexName = prop.getProperty("SPLUNKINDEXNAME").trim();
			}
			
			// Configuration Properties for IBM Logging Service (IBM Log Analysis)
			/*if (prop.getProperty("LOGGINGSERVICEENABLED") == null || prop.getProperty("LOGGINGSERVICEENABLED").isEmpty()) {
				loggingServiceEnabled = false;
			} else {
				String flag = prop.getProperty("LOGGINGSERVICEENABLED").trim();
				if(flag.equalsIgnoreCase("true"))
					loggingServiceEnabled = true;
			}
			
			if (prop.getProperty("SPACEID") == null || prop.getProperty("SPACEID").isEmpty()) {
				spaceId = "";
			} else {
				spaceId = prop.getProperty("SPACEID").trim();
			}
			
			if (prop.getProperty("LOGGINGTOKEN") == null || prop.getProperty("LOGGINGTOKEN").isEmpty()) {
				loggingToken = "";
			} else {
				loggingToken = prop.getProperty("LOGGINGTOKEN").trim();
			}
			
			if (prop.getProperty("LOGGINGURL") == null || prop.getProperty("LOGGINGURL").isEmpty()) {
				loggingUrl = "";
			} else {
				loggingUrl = prop.getProperty("LOGGINGURL").trim();
			}	*/		

		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}




}

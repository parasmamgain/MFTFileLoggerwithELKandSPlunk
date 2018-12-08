package com.tika.document;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.net.UnknownHostException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.splunk.HttpService;
import com.splunk.SSLSecurityProtocol;
import com.tika.common.resources.ConfigurationProperties;

/**
 * 
 * @author parasmamgain
 * @github : https://github.com/parasmamgain/
 * @email : mamgain.paras@outlook.com
 *
 */
public class App {

	public static void main(String[] args) {
		String path = "";
		System.setProperty("com.ibm.jsse2.disableSSLv3", "false");
		HttpService.setSslSecurityProtocol(SSLSecurityProtocol.TLSv1_2);
		PrintStream console = System.out;
		File outputFile = new File("logger.log");
		try {
			System.out.println("Starting MFT FileLogger to ELK Stack Migration :");
			FileOutputStream fos = new FileOutputStream(outputFile);
			PrintStream ps = new PrintStream(fos);
			System.setOut(ps);
			if (args.length > 0) {
				File propertyFile = new File(args[0].toString().trim());
				//File propertyFile = new File(tempPath);
				if (propertyFile.exists() && propertyFile.isFile()) {
					System.out.println("[INFO]:Reading Property File");
					String propertyFilePath = args[0].trim();
					ConfigurationProperties.LoadProperties(propertyFilePath);
					path = ConfigurationProperties.sourcePath;
					System.out.println("[INFO]:Source Path is :" + path);
				} else {
					System.out.println("[ERROR]:Invalid Property File Path.Exiting Program:" + args[0]);
					System.exit(0);
				}
			} else {
				System.out.println("[ERROR]:Invalid Property File Path.Exiting Program:");
				System.exit(0);
			}
			
			while(true){
			File file = new File(path);
			detectFileType(file);
			String minForSleep = ConfigurationProperties.timePeriod;
			long timeForSleep = Integer.parseInt(minForSleep) * 60000;
			System.out.println("Going to sleep at "+ new java.util.Date() +" for " + minForSleep + " minutes");
			Thread.sleep(timeForSleep);
			}

		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) { // TODO Auto-generated catch
			e.printStackTrace();
		} finally {
			System.setOut(console);
		}

	}

	private static void detectFileType(File file)
			throws UnknownHostException, JsonProcessingException, InterruptedException, ExecutionException {
		System.out.println("Detecting File type for path :" + file.getAbsolutePath());
		if (file.exists()) {
			if (file.isDirectory()) {
				pathIsADirectory(file);

			} else if (file.isFile()) {
				pathIsAFile(file);
			} else {
				System.out.println("No File or FilePath Pound");
			}
		} else {
			pathIsADirectory(file);
		}
	}

	private static void pathIsADirectory(File file)
			throws UnknownHostException, JsonProcessingException, InterruptedException, ExecutionException {
		System.out.println("Detecting Directory type for path :" + file.getAbsolutePath());
		for (File tempFile : file.listFiles()) {
			System.out.println(tempFile.getName());
			if (tempFile.isDirectory()) {
				pathIsADirectory(tempFile);
			} else if (tempFile.isFile()) {
				pathIsAFile(tempFile);

			}
		}
	}

	private static void pathIsAFile(File file)
			throws UnknownHostException, JsonProcessingException, InterruptedException, ExecutionException {
		long lastModified = file.lastModified();
		long fileSize = file.length();
		System.out.println("File Detected with name: "+ file.getName() );
		if (fileSize == 0) {
			System.out.printf("[INFO]:File:%s is empty there fore will not be parsed and will be ignored.\n",file.getAbsolutePath());
		} else {
			long currentTime = System.currentTimeMillis();
			int daysInterval = ConfigurationProperties.daysInterval;
			long milliseconds = currentTime - lastModified;
			long days = TimeUnit.MILLISECONDS.toDays(milliseconds);
			if (days <= daysInterval)
				ContentExtraction.extractMFTTransferLog(file.getAbsolutePath());
			else
				System.out.printf("\n[INFO]:File %s is older than %s therefore will be ignored.\n", file, daysInterval);
		}
	}

}

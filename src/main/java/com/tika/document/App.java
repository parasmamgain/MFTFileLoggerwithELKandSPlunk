package com.tika.document;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.net.UnknownHostException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import com.fasterxml.jackson.core.JsonProcessingException;
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

		PrintStream console = System.out;
		File outputFile = new File("output.txt");
		try {
			FileOutputStream fos = new FileOutputStream(outputFile);
			PrintStream ps = new PrintStream(fos);
			String path = "";
			System.setOut(ps);
			if (args.length > 0) {
				File propertyFile = new File(args[0].toString().trim());
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

			File file = new File(path);
			detectFileType(file);

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
		if (file.exists()) {
			if (file.isDirectory()) {
				pathIsADirectory(file);

			} else if (file.isFile()) {
				pathIsAFile(file);
			}
		}
	}

	private static void pathIsADirectory(File file)
			throws UnknownHostException, JsonProcessingException, InterruptedException, ExecutionException {
		for (File tempFile : file.listFiles()) {

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

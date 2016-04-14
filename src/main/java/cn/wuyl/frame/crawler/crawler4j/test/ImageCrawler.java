package cn.wuyl.frame.crawler.crawler4j.test;

import java.io.File;
import java.io.IOException;
import java.util.UUID;
import java.util.regex.Pattern;

import com.google.common.io.Files;

import edu.uci.ics.crawler4j.crawler.Page;
import edu.uci.ics.crawler4j.crawler.WebCrawler;
import edu.uci.ics.crawler4j.parser.BinaryParseData;
import edu.uci.ics.crawler4j.url.WebURL;

public class ImageCrawler extends WebCrawler {
	 private static final Pattern filters = Pattern
	     .compile(".*(\\.(css|js|mid|mp2|mp3|mp4|wav|avi|mov|mpeg|ram|m4v|pdf" + "|rm|smil|wmv|swf|wma|zip|rar|gz))$");
	
	 private static final Pattern imgPatterns = Pattern.compile(".*(\\.(bmp|gif|jpe?g|png|tiff?))$");
	
	 private static File storageFolder;
	 private static String[] crawlDomains;
	
	 public static void configure(String[] domain, String storageFolderName) {
	   crawlDomains = domain;
	
	   storageFolder = new File(storageFolderName);
	   if (!storageFolder.exists()) {
	     storageFolder.mkdirs();
	   }
	 }
	
	 public boolean shouldVisit(Page referringPage, WebURL url) {
	   String href = url.getURL().toLowerCase();
	   if (filters.matcher(href).matches()) {
	     return false;
	   }
	
	   if (imgPatterns.matcher(href).matches()) {
	     return true;
	   }
	
	   for (String domain : crawlDomains) {
	     if (href.startsWith(domain)) {
	       return true;
	     }
	   }
	   return false;
	 }
	
	 public void visit(Page page) {
		WebURL wu = page.getWebURL();
		String url = wu.getURL();
		short depth = wu.getDepth();
	
	   // We are only interested in processing images which are bigger than 10k
	   if (!imgPatterns.matcher(url).matches() ||
	       !((page.getParseData() instanceof BinaryParseData) || (page.getContentData().length < (10 * 1024)))) {
	     return;
	   }
	
	   // get a unique name for storing this image
	   String extension = url.substring(url.lastIndexOf('.'));
	   String hashedName = UUID.randomUUID() + extension;
	
	   // store image
	   String filename = storageFolder.getAbsolutePath() + "/" + hashedName;
	   try {
	     Files.write(page.getContentData(), new File(filename));
	     System.out.println("Stored: {" + depth + "}"+ url);
	   } catch (IOException iox) {
		   System.out.println("Failed to write file: " + filename + "   " + iox);
	   }
	 }
}

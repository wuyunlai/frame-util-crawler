package cn.wuyl.frame.crawler.crawler4j.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.uci.ics.crawler4j.crawler.CrawlConfig;
import edu.uci.ics.crawler4j.crawler.CrawlController;
import edu.uci.ics.crawler4j.fetcher.PageFetcher;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtConfig;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtServer;

/**
 * @author Yasser Ganjisaffar
 */
public class ImageCrawlController {
  private static final Logger logger = LoggerFactory.getLogger(ImageCrawlController.class);

  public static void main(String[] args) throws Exception {
//    if (args.length < 3) {
//      logger.info("Needed parameters: ");
//      logger.info("\t rootFolder (it will contain intermediate crawl data)");
//      logger.info("\t numberOfCralwers (number of concurrent threads)");
//      logger.info("\t storageFolder (a folder for storing downloaded images)");
//      return;
//    }
    String crawlrootFolder = "e:/crawler/data/root";
    String crawlStorageFolder = "e:/crawler/data/images";
    String rootFolder = crawlrootFolder;//args[0];
    int numberOfCrawlers = 7;//Integer.parseInt(args[1]);
    String storageFolder = crawlStorageFolder;//args[2];

    CrawlConfig config = new CrawlConfig();

    config.setCrawlStorageFolder(rootFolder);

    /*
     * Since images are binary content, we need to set this parameter to
     * true to make sure they are included in the crawl.
     */
    config.setIncludeBinaryContentInCrawling(true);

    String[] crawlDomains = {"http://girlsluntan.net/thread-htm-fid-20.html","http://image.baidu.com/"};
    
    PageFetcher pageFetcher = new PageFetcher(config);
    RobotstxtConfig robotstxtConfig = new RobotstxtConfig();
    RobotstxtServer robotstxtServer = new RobotstxtServer(robotstxtConfig, pageFetcher);
    CrawlController controller = new CrawlController(config, pageFetcher, robotstxtServer);
    for (String domain : crawlDomains) {
      controller.addSeed(domain);
    }

    ImageCrawler.configure(crawlDomains, storageFolder);

    controller.start(ImageCrawler.class, numberOfCrawlers);
  }
}
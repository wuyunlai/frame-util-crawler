package cn.wuyl.frame.crawler.crawler4j.test;

import edu.uci.ics.crawler4j.crawler.CrawlConfig;
import edu.uci.ics.crawler4j.crawler.CrawlController;
import edu.uci.ics.crawler4j.fetcher.PageFetcher;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtConfig;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtServer;

public class Controller {
    public static void main(String[] args) throws Exception {
        String crawlStorageFolder = "e:/crawler/data/root";
        int numberOfCrawlers = 7;

        CrawlConfig config = new CrawlConfig();
        
        /* 
         * 深度，即从入口URL开始算，URL是第几层。如入口A是1，从A中找到了B，B中又有C，则B是2，C是3 
         */  
        config.setMaxDepthOfCrawling(5);  
          
        /* 
         * 最多爬取多少个页面 
         */  
        config.setMaxPagesToFetch(20);  
        
        config.setCrawlStorageFolder(crawlStorageFolder);

        /*
         * Instantiate the controller for this crawl.
         */
        PageFetcher pageFetcher = new PageFetcher(config);
        RobotstxtConfig robotstxtConfig = new RobotstxtConfig();
        RobotstxtServer robotstxtServer = new RobotstxtServer(robotstxtConfig, pageFetcher);
        CrawlController controller = new CrawlController(config, pageFetcher, robotstxtServer);

        /*
         * For each crawl, you need to add some seed urls. These are the first
         * URLs that are fetched and then the crawler starts following links
         * which are found in these pages
         */
//        controller.addSeed("http://www.ics.uci.edu/~lopes/");
//        controller.addSeed("http://www.ics.uci.edu/~welling/");
//        controller.addSeed("http://www.ics.uci.edu/");
//        controller.addSeed("http://news.baidu.com/");
//        controller.addSeed("http://user.qzone.qq.com/11622697/infocenter?ptsig=T9j7yH8tHlqX2uwGcH6V5CB8DoXWJHc7-5kGWqyBjLo_");
//        controller.addSeed("http://image.baidu.com/search/index?tn=baiduimage&ipn=r&ct=201326592&cl=2&lm=-1&st=-1&fm=index&fr=&sf=1&fmq=&pv=&ic=0&nc=1&z=&se=1&showtab=0&fb=0&width=&height=&face=0&istype=2&ie=utf-8&word=gif&oq=gif&rsp=-1");
        controller.addSeed("http://girlsluntan.net/thread-htm-fid-20.html");
//        controller.addSeed("http://girlsluntan.net/thread-htm-fid-51-page-2.html");
        /*
         * Start the crawl. This is a blocking operation, meaning that your code
         * will reach the line after this only when crawling is finished.
         */
        controller.start(Crawler.class, numberOfCrawlers);
    }
}
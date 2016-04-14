package cn.wuyl.frame.crawler.crawler4j.tests;

import edu.uci.ics.crawler4j.url.WebURL;


/**
 * Created by Avi on 8/19/2014.
 *
 */
public class WebURLTest {

  public void testNoLastSlash() {
    WebURL webUrl = new WebURL();
    webUrl.setURL("http://google.com");
  }
}
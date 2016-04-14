package cn.wuyl.frame.crawler.crawler4j.tests;

import edu.uci.ics.crawler4j.url.URLCanonicalizer;
import edu.uci.ics.crawler4j.url.WebURL;

public class TLDListTest {

  private final WebURL webUrl = new WebURL();

  private void setUrl(String url) {
    webUrl.setURL(URLCanonicalizer.getCanonicalURL(url));
  }

  public void testTLD() {

    setUrl("http://example.com");
    System.out.println("example.com"+ webUrl.getDomain());
    System.out.println(""+ webUrl.getSubDomain());

    setUrl("http://test.example.com");
    System.out.println("example.com"+ webUrl.getDomain());
    System.out.println("test"+ webUrl.getSubDomain());

    setUrl("http://test2.test.example.com");
    System.out.println("example.com"+ webUrl.getDomain());
    System.out.println("test2.test"+ webUrl.getSubDomain());

    setUrl("http://test3.test2.test.example.com");
    System.out.println("example.com"+ webUrl.getDomain());
    System.out.println("test3.test2.test"+ webUrl.getSubDomain());

    setUrl("http://www.example.ac.jp");
    System.out.println("example.ac.jp"+ webUrl.getDomain());
    System.out.println("www"+ webUrl.getSubDomain());

    setUrl("http://example.ac.jp");
    System.out.println("example.ac.jp"+ webUrl.getDomain());
    System.out.println(""+ webUrl.getSubDomain());
  }
}
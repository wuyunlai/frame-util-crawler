package cn.wuyl.frame.crawler.crawler4j.tests;

import edu.uci.ics.crawler4j.url.URLCanonicalizer;

public class URLCanonicalizerTest {

  public void testCanonizalier() {

    System.out.println("http://www.example.com/display?category=foo%2Fbar%2Bbaz" +
                 URLCanonicalizer.getCanonicalURL("http://www.example.com/display?category=foo/bar+baz"));

    System.out.println("http://www.example.com/?q=a%2Bb"+ URLCanonicalizer.getCanonicalURL("http://www.example.com/?q=a+b"));

    System.out.println("http://www.example.com/display?category=foo%2Fbar%2Bbaz" +
                 URLCanonicalizer.getCanonicalURL("http://www.example.com/display?category=foo%2Fbar%2Bbaz"));

    System.out.println("http://somedomain.com/uploads/1/0/2/5/10259653/6199347.jpg?1325154037"+ URLCanonicalizer
                     .getCanonicalURL("http://somedomain.com/uploads/1/0/2/5/10259653/6199347.jpg?1325154037"));

    System.out.println("http://hostname.com/"+ URLCanonicalizer.getCanonicalURL("http://hostname.com"));

    System.out.println("http://hostname.com/"+ URLCanonicalizer.getCanonicalURL("http://HOSTNAME.com"));

    System.out.println("http://www.example.com/index.html" +
                 URLCanonicalizer.getCanonicalURL("http://www.example.com/index.html?&"));

    System.out.println("http://www.example.com/index.html" +
                 URLCanonicalizer.getCanonicalURL("http://www.example.com/index.html?"));

    System.out.println("http://www.example.com/"+ URLCanonicalizer.getCanonicalURL("http://www.example.com"));

    System.out.println("http://www.example.com/bar.html" +
                 URLCanonicalizer.getCanonicalURL("http://www.example.com:80/bar.html"));

    System.out.println("http://www.example.com/index.html?name=test&rame=base" +
                 URLCanonicalizer.getCanonicalURL("http://www.example.com/index.html?name=test&rame=base#123"));

    System.out.println("http://www.example.com/~username/" +
                 URLCanonicalizer.getCanonicalURL("http://www.example.com/%7Eusername/"));

    System.out.println("http://www.example.com/A/B/index.html" +
                 URLCanonicalizer.getCanonicalURL("http://www.example.com//A//B/index.html"));

    System.out.println("http://www.example.com/index.html?x=y" +
                 URLCanonicalizer.getCanonicalURL("http://www.example.com/index.html?&x=y"));

    System.out.println("http://www.example.com/a.html" +
                 URLCanonicalizer.getCanonicalURL("http://www.example.com/../../a.html"));

    System.out.println("http://www.example.com/a/c/d.html" +
                 URLCanonicalizer.getCanonicalURL("http://www.example.com/../a/b/../c/./d.html"));

    System.out.println("http://foo.bar.com/?baz=1"+ URLCanonicalizer.getCanonicalURL("http://foo.bar.com?baz=1"));

    System.out.println("http://www.example.com/index.html?c=d&e=f&a=b" +
                 URLCanonicalizer.getCanonicalURL("http://www.example.com/index.html?&c=d&e=f&a=b"));

    System.out.println("http://www.example.com/index.html?q=a%20b" +
                 URLCanonicalizer.getCanonicalURL("http://www.example.com/index.html?q=a b"));

    System.out.println("http://www.example.com/search?width=100%&height=100%" +
                 URLCanonicalizer.getCanonicalURL("http://www.example.com/search?width=100%&height=100%"));

    System.out.println("http://foo.bar/mydir/myfile?page=2" +
                 URLCanonicalizer.getCanonicalURL("?page=2" + "http://foo.bar/mydir/myfile"));

  }
}
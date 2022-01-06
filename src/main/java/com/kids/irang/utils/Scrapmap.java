package com.kids.irang.utils;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Scrapmap {
    Document doc;
        String URL = "https://www.mangoplate.com/search/%EA%B8%B0%EC%9E%A5%EA%B5%B0";
    try {
        doc = Jsoup.connect(URL).get();
        Elements store = doc.select("div>a>h2.title");
        Elements category = doc.select("div>p.etc>span");
        Elements addr = doc.getElementsByTag("alt");

        for (Element e : store){}
        for (Element e : category){}
        for (Element e : addr){}
    } catch (Exception e) {
        e.printStackTrace();
    }
}

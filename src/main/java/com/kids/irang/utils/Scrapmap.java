package com.kids.irang.utils;

import com.kids.irang.dto.KidsmapDto;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

public class ScrapMap {
    public static List<KidsmapDto> scrap(String search) {
        List<KidsmapDto> list = new ArrayList<>();
        Document doc;
        try {
            doc = Jsoup.connect("https://www.mangoplate.com/search/" + search).get();
            Elements store = doc.select(".lazy");
            Elements category = doc.select("div>p.etc>span");
//        Elements store = doc.select("div>a>h2.title");
//        Elements addr = doc.getElementsByTag("alt");

            // body > main > article > div.column-wrapper > div > div > section > div.search-list-restaurants-inner-wrap > ul > li:nth-child(1) > div:nth-child(1) > figure > a > div > img
            List<String> tmpList = new ArrayList<>();
            for (Element e : category) {
                tmpList.add(e.text());
            }
            int i = 0;
            for (Element e : store) {
//                KidsmapDto d = new KidsmapDto();
                String[] sp = e.attr("alt").split("사진 - ");
                String sName = sp[0];
                String sAddr = sp[1];
                System.out.println(sName);
                System.out.println(sAddr);
                list.add(KidsmapDto.builder()
                        .store(sName)
                        .addr(sAddr)
                        .category(tmpList.get(i++))
                        .build());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
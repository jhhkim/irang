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
            //search list 만들어서 for로 돌리면 전국 결과가 나올듯
            
            doc = Jsoup.connect("https://www.mangoplate.com/search/" + search).get();
            Elements store = doc.select(".lazy");
            Elements category = doc.select("div>p.etc>span");
//        Elements store = doc.select("div>a>h2.title");
//        Elements addr = doc.getElementsByTag("alt");
            String city[] = {"서울시 종로구", "서울시 중구","서울시 용산구", "서울시 성동구", "서울시 광진구", "서울시 동대문구",
            "서울시 중랑구", "서울시 성북구", "서울시 강북구", "서울시 도봉구", "서울시 노원구", "서울시 은평구", "서울시 서대문구",
            "서울시 마포구", "서울시 양천구", "서울시 강서구", "서울시 구로구", "서울시 금천구", "서울시 영등포구", "서울시 동작구",
            "서울시 관악구", "서울시 서초구", "서울시 강남구", "서울시 송파구", "서울시 강동구"};
            
            List<String> tmpList = new ArrayList<>();
            for(int c=0; c<25; c++){
                search = city[c];
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
            }
            // body > main > article > div.column-wrapper > div > div > section > div.search-list-restaurants-inner-wrap > ul > li:nth-child(1) > div:nth-child(1) > figure > a > div > img
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
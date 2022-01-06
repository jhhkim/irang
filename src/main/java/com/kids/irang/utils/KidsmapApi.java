package com.kids.irang.utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



import com.kids.irang.dto.KidsmapDto;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class KidsmapApi {
    public static List<KidsmapDto> getKidsmapList(){
        List<KidsmapDto> list = new ArrayList<KidsmapDto>();
        String URL = "https://www.mangoplate.com/search/%EA%B8%B0%EC%9E%A5%EA%B5%B0";

        try{
            Document doc = Jsoup.connect(URL).get();

            Elements store = doc.select("div>a>h2.title");
            Elements addr = doc.select("div.thumb>img.center-croping lazy");
            addr.attr("alt"); //"사진 - "을 기준으로 자르고 addr[1]을 db에 넣어야하는데
            Elements category = doc.select("div>p.etc>span");


            List<String> tmpList = new ArrayList<>();
            for(Element e: store)
            {
                tmpList.add(e.text());
            }
            for(Element e : addr)
            {
                tmpList.add(e.text());
            } 
            for(Element e : category)
            {
                tmpList.add(e.text());
            } 

        }
        catch (IOException e1){
            e1.printStackTrace();
        }
        return list;
           
    }
}

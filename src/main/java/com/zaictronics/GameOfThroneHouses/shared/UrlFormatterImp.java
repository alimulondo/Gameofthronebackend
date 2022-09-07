package com.zaictronics.GameOfThroneHouses.shared;

import org.springframework.stereotype.Service;


@Service
public class UrlFormatterImp implements UrlFormatter {

    private String[] url;


    @Override
    public String formatUrl(String url) {
        if(url == null || url.isEmpty()) return url;
        String[] subUrl = url.split("//");

        this.url = subUrl[1].split("/");

        if(this.url.length < 4) throw new RuntimeException("No url id found");

        return this.url[this.url.length - 1];
    }
}

package com.emailSender;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;

public class ParserUtil {
    public static String getBrentPrice() throws IOException {
        Document document = Jsoup.connect("https://markets.ft.com/data/commodities/tearsheet/summary?c=Brent+Crude+Oil").get();
        Element price = document.select("body > div.o-grid-container.mod-container > div:nth-child(2) > section:nth-child(1) > div > div > div.mod-tearsheet-overview__overview.clearfix > div.mod-tearsheet-overview__quote > ul > li:nth-child(1) > span.mod-ui-data-list__value").get(0);

        assert price != null;

        return price.text();
    }
}

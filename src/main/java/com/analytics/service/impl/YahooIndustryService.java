package com.analytics.service.impl;

import com.analytics.exception.NotFoundCompanyException;
import com.analytics.service.IIndustryService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;
import java.io.IOException;

@Service
public class YahooIndustryService implements IIndustryService {

    @Override
    public String getIndustry(String companyName) throws IOException, NotFoundCompanyException {
        Document document = Jsoup.connect("https://finance.yahoo.com/quote/"+companyName+"/profile?p="+companyName)
                .get();

        Elements span = document.getElementsByClass("D(ib) Va(t)");

        try {
            Element list = span.get(0);

            Elements spanList = list.getElementsByTag("span");

            Element industry = spanList.get(3);

            return industry.text();

        }catch (IndexOutOfBoundsException e){
            throw new NotFoundCompanyException("");
        }

    }
}

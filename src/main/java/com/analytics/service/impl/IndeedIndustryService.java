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
public class IndeedIndustryService implements IIndustryService {

    @Override
    public String getIndustry(String companyName) throws IOException {
        Document document = Jsoup.connect("https://www.indeed.com/cmp/"+companyName)
                .get();

        Elements industry = document.getElementsByClass("css-1w0iwyp e1wnkr790");

        try {

            Element element1 = industry.get(2);

            return element1.text();

        }catch (IndexOutOfBoundsException e){
            throw new NotFoundCompanyException("");
        }
    }
}

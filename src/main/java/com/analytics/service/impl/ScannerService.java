package com.analytics.service.impl;

import com.analytics.dto.ResultDto;
import com.analytics.entity.Company;
import com.analytics.exception.NotFoundCompanyException;
import com.analytics.repository.CompanyRepository;
import com.analytics.service.IScannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ScannerService implements IScannerService {

    @Autowired
    private CompanyRepository repository;

    @Autowired
    private IndeedIndustryService indeedIndustryService;

    @Autowired
    private YahooIndustryService yahooIndustryService;

    @Override
    public List<ResultDto> getMergedIndustries() throws IOException, NotFoundCompanyException {
        List<ResultDto> resultList = new ArrayList<>();

        for (Company cmp: getCompanyFromRepository()) {
            ResultDto dto = new ResultDto();

            dto.setIndeed(indeedIndustryService.getIndustry(cmp.getIndeedCompanyName()));
            dto.setYahoo(yahooIndustryService.getIndustry(cmp.getYahooCompanyName()));
            dto.setMergeIndustries(dto.getIndeed()+" & "+dto.getYahoo());

            resultList.add(dto);

        }

        return resultList;
    }

    private List<Company> getCompanyFromRepository(){
        List<Company> companyList = new ArrayList<>();

        for (Company cmp: repository.findAll()) {
            companyList.add(cmp);
        }

        return companyList;
    }
}

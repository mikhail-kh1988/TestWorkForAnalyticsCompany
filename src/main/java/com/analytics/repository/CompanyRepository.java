package com.analytics.repository;

import com.analytics.entity.Company;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends CrudRepository<Company, Long> {

    Company findByIndeedCompanyName(String name);
    Company findByYahooCompanyName(String name);

}

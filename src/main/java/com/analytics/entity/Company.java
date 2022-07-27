package com.analytics.entity;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "company")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;

    @Column(name = "indeed_name")
    private String indeedCompanyName;

    @Column(name = "yahoo_name")
    private String yahooCompanyName;

}

package com.analytics.service;

import com.analytics.dto.ResultDto;

import java.io.IOException;
import java.util.List;

public interface IScannerService {

    List<ResultDto> getMergedIndustries() throws IOException;

}

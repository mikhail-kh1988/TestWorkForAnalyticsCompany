package com.analytics.contoller;

import com.analytics.dto.ResultDto;
import com.analytics.service.IScannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.io.IOException;

@RestController
@RequestMapping("/merge")
public class IndustryController {

    @Autowired
    private IScannerService scannerService;

    @GetMapping("/")
    public ResponseEntity<List<ResultDto>> getIndustries() throws IOException {
        return ResponseEntity.ok(scannerService.getMergedIndustries());
    }

}

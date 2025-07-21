package com.cms.cms.controller;

import com.cms.cms.enums.LoggType;
import com.cms.cms.model.CommonResponse;
import com.cms.cms.service.impl.CustomerServiceImpl;
import com.cms.cms.util.LoggerUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);
    private final CustomerServiceImpl customerService;

    @Autowired
    public CustomerController(CustomerServiceImpl customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/upload")
    public ResponseEntity<CommonResponse> uploadExcelFile(@RequestParam("file") MultipartFile file) {
        LoggerUtil.loggerMsg(logger, "Controller | Start | Uploading Excel File", LoggType.INFO);

        CommonResponse response = new CommonResponse();

        if (file.isEmpty()) {
            LoggerUtil.loggerMsg(logger, "Controller | Error | No file selected for upload", LoggType.ERROR);
            response.setMessage("Please select a file!");
            response.setSuccess(false);
            response.setCode(HttpStatus.BAD_REQUEST.value());
            return ResponseEntity.badRequest().body(response);
        }

        response = customerService.readAndSaveCustomerData(file);

        if (!response.isSuccess()) {
            LoggerUtil.loggerMsg(logger, "Controller | Error | Failed to process the file: " + response.getMessage(), LoggType.ERROR);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }

        LoggerUtil.loggerMsg(logger, "Controller | Success | File processed successfully", LoggType.INFO);
        return ResponseEntity.ok(response);
    }
}

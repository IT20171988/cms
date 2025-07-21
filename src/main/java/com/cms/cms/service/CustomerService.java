package com.cms.cms.service;

import com.cms.cms.model.CommonResponse;
import org.springframework.web.multipart.MultipartFile;


public interface CustomerService {


    CommonResponse readAndSaveCustomerData(MultipartFile CustomerDataFile);

}

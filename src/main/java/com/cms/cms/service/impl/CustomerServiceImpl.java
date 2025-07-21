package com.cms.cms.service.impl;

import com.cms.cms.entity.Customer;
import com.cms.cms.model.CommonResponse;
import com.cms.cms.repository.CustomerRepository;
import com.cms.cms.service.CustomerService;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Iterator;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public CommonResponse readAndSaveCustomerData(MultipartFile customerDataFile) {
        CommonResponse response = new CommonResponse();

        try (InputStream inputStream = customerDataFile.getInputStream();
             Workbook workbook = new XSSFWorkbook(inputStream)) {

            Sheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rowIterator = sheet.iterator();

            // Skip header
            if (rowIterator.hasNext()) {
                rowIterator.next();
            }

            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                System.out.println(row.getRowNum());
            }

            response.setSuccess(true);
            response.setCode(HttpStatus.OK.value());
            response.setMessage("File processed and customers saved.");

        } catch (Exception e) {
            response.setSuccess(false);
            response.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
            response.setMessage("Error reading file: " + e.getMessage());
        }

        return response;
    }

    private String getCellValue(Cell cell) {
        if (cell == null) return "";
        if (cell.getCellType() == CellType.STRING) return cell.getStringCellValue();
        if (cell.getCellType() == CellType.NUMERIC) {
            if (DateUtil.isCellDateFormatted(cell)) {
                return new SimpleDateFormat("yyyy-MM-dd").format(cell.getDateCellValue());
            } else {
                return String.valueOf((long) cell.getNumericCellValue());
            }
        }
        return "";
    }

    private String parseDate(Cell cell) {
        if (cell != null && DateUtil.isCellDateFormatted(cell)) {
            return new SimpleDateFormat("yyyy-MM-dd").format(cell.getDateCellValue());
        }
        return null;
    }
}

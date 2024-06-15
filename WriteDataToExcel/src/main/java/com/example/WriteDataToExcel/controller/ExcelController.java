package com.example.WriteDataToExcel.controller;

import com.example.WriteDataToExcel.service.WriteToExcelService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/excel")
public class ExcelController {

    private WriteToExcelService writeToExcelService;

    ExcelController(WriteToExcelService writeToExcelService) {
        this.writeToExcelService = writeToExcelService;
    }

    @PostMapping("/write")
    public void writeToExcel() {
        writeToExcelService.writeToExcel();
    }
}

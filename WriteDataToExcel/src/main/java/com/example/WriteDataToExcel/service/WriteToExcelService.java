package com.example.WriteDataToExcel.service;

import com.example.WriteDataToExcel.model.Users;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Service
public class WriteToExcelService {

    public void writeToExcel() {
        String[] row_headers = {"First_Name", "Last_Name", "Email", "Mobile_Number"};
        List<Users> dataList = getUsersData();
        XSSFWorkbook workbook = null;
        FileOutputStream fileOutputStream = null;
        try {
            String fileName = "TestFile.xlsx";
            workbook = new XSSFWorkbook();
            XSSFSheet userDetailSheet = workbook.createSheet("User Details");

            // set the Header Row Details
            Row headerRow = userDetailSheet.createRow(0);
            for (int i = 0; i < row_headers.length; i++) {
                Cell headerCell = headerRow.createCell(i);
                headerCell.setCellValue(row_headers[i]);
            }

            int i = 0;
            while (i < dataList.size()) {
                // setting each data row
                Row dataRow = userDetailSheet.createRow(i + 1);

                // setting the cell values of data into the spread sheet
                dataRow.createCell(0).setCellValue(dataList.get(0).getFirstName());
                dataRow.createCell(0).setCellValue(dataList.get(0).getLastName());
                dataRow.createCell(0).setCellValue(dataList.get(0).getEmailId());
                dataRow.createCell(0).setCellValue(dataList.get(0).getMobileNumber());

            }

            String currentPath = Paths.get("").toAbsolutePath().toString();
            File file = new File(currentPath + "/" + fileName);
            fileOutputStream = new FileOutputStream(file);

            workbook.write(fileOutputStream);
            workbook.close();
            fileOutputStream.close();
            System.out.println("Done: "+currentPath);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public List<Users> getUsersData() {
        List<Users> userList = new ArrayList<>();
        userList.add(new Users("firstName1", "lastName1", "firstLast1@gmail.com", "123456"));
        userList.add(new Users("firstName2", "lastName2", "firstLast2@gmail.com", "123456"));
        userList.add(new Users("firstName3", "lastName3", "firstLast3@gmail.com", "123456"));
        userList.add(new Users("firstName4", "lastName4", "firstLast4@gmail.com", "123456"));
        userList.add(new Users("firstName5", "lastName5", "firstLast5@gmail.com", "123456"));

        return userList;
    }
}

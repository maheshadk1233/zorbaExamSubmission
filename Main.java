package org.example;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

        public class WriteToExcel {
            public static void main(String[] args) throws Exception {
                String[][] data = {
                        {"1001", "Jack", "1482.45 0809808008", "NYC"},
                        {"1002", "Joy ", "5282.12 9809808008 ", "SD"},
                        {"1003", "Nick", "3454.11", "8976876786", "Dayton"},
                        {"1004", "Joe", "6482.45", "8809808008", "NYC"},
                        {"1005", "Nick", "5482.45 ", "5809808008", "CA"},
                        {"1006", "Hyder", "9482.45", "2809808008", "LA"},
                        {"1007", "Harry", "1182.45", "4809808008", "Ohio"}
                };

                FileInputStream fileInputStream = new FileInputStream("C:\\Users\\adhik\\java1\\src\\main\\resources");
                XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
                Sheet sheet = workbook.getSheetAt(0);
                int rowNum = sheet.getLastRowNum() + 1;
                for (String[] rowData : data) {
                    Row row = sheet.createRow(rowNum++);
                    int colNum = 0;
                    for (String field : rowData) {
                        Cell cell = row.createCell(colNum++);
                        cell.setCellValue(field);
                    }
                }
                FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\adhik\\java1\\src\\main\\resources");
                workbook.write((fileOutputStream));
                System.out.println("all Data inserted");
            }
        }



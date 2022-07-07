package com.javaIo;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class ApplicationForCreateExcelFile {
    private static String[] columns = {"ID", "FirstName", "LastName"};

    public static void main(String[] args) {

//Blank workbook
        XSSFWorkbook workbook = new XSSFWorkbook();

//Create a blank sheet
        XSSFSheet sheet = workbook.createSheet("Cricketer Data");

//This data needs to be written (Object[])
        Map<String, Object[]> data = new TreeMap<String, Object[]>();

        data.put("2", new Object[]{1, "Armin", "Aliani"});
        data.put("3", new Object[]{2, "Arian", "Aliani"});
        data.put("4", new Object[]{3, "Reza", "Aliani"});
        data.put("5", new Object[]{4, "Ali", "Aliani"});

//Iterate over data and write to sheet
        Set<String> keyset = data.keySet();
        int rownum = 1;

// Create a Font for styling header cells
        Font headerFont = workbook.createFont();
        headerFont.setBold(true);
        headerFont.setFontHeightInPoints((short) 14);
        headerFont.setColor(IndexedColors.BLUE.getIndex());

// Create a CellStyle with the font
        CellStyle headerCellStyle = workbook.createCellStyle();
        headerCellStyle.setFont(headerFont);
        headerCellStyle.setAlignment(HorizontalAlignment.CENTER);

// Create a Header Row
        Row headerRow = sheet.createRow(0);

// Create cells
        for (int i = 0; i < columns.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(columns[i]);
            cell.setCellStyle(headerCellStyle);
        }

        for (String key : keyset) {
            Row row = sheet.createRow(rownum++);
            Object[] objArr = data.get(key);
            int cellnum = 0;
            for (Object obj : objArr) {
                Cell cell = row.createCell(cellnum++);
                if (obj instanceof String)
                    cell.setCellValue((String) obj);
                else if (obj instanceof Integer)
                    cell.setCellValue((Integer) obj);
            }
        }
        try {
//Write the workbook in file system
            FileOutputStream out = new FileOutputStream(new File("TechBlogStation.xlsx"));
            workbook.write(out);
            out.close();
            System.out.println("****File written successfully*****");
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
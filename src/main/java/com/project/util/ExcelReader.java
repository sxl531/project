package com.project.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellReference;

public class ExcelReader {

    /**
     * 读取文件，得到标题列
     * @param file
     * @return
     * @throws IOException
     */
    public static List<Object> readExcelTitleField(File file) throws IOException{
        List<Object> resultList = new ArrayList<Object>();
        InputStream in = new FileInputStream(file);
        Workbook wb = new HSSFWorkbook(in);
        Sheet sheet1 = wb.getSheetAt(0);
        Row row = sheet1.getRow(0);
        for (Cell cell : row) {
//			CellReference cellRef = new CellReference(cell.getRowIndex(), cell.getColumnIndex(), false, false);
//			System.out.print(cellRef.formatAsString());
//			System.out.print(" - ");
            switch (cell.getCellType()) {
                case Cell.CELL_TYPE_STRING:
                    resultList.add(cell.getRichStringCellValue());
//				System.out.println(cell.getRichStringCellValue().getString());
                    break;
                case Cell.CELL_TYPE_NUMERIC:
                    if(DateUtil.isCellDateFormatted(cell)) {
                        resultList.add(cell.getDateCellValue());
//					System.out.println(cell.getDateCellValue());
                    } else {
                        resultList.add(cell.getNumericCellValue());
//					System.out.println(cell.getNumericCellValue());
                    }
                    break;
                case Cell.CELL_TYPE_BOOLEAN:
                    resultList.add(cell.getBooleanCellValue());
//				System.out.println(cell.getBooleanCellValue());
                    break;
                case Cell.CELL_TYPE_FORMULA:
                    resultList.add(cell.getCellFormula());
//				System.out.println(cell.getCellFormula());
                    break;
                default:
//				System.out.println();
            }
        }
        return resultList;
    }
    /**
     * 读取文件,得到文件内容列表
     * @param file
     * @return
     * @throws IOException
     */
    public static List<Object[]> readExcelContent(File file) throws IOException{
        return readExcelContent(file, 0);
    }
    /**
     * 读取文件,得到文件内容列表
     * @param file
     * @return
     * @throws IOException
     */
    public static List<Object[]> readExcelContent(File file, int len) throws IOException{
        List<Object[]> resultList = new ArrayList<Object[]>();
        InputStream in = new FileInputStream(file);
        Workbook wb = new HSSFWorkbook(in);
        Sheet sheet1 = wb.getSheetAt(0);
        Row row = null;
        for (int i = 1; i <= sheet1.getLastRowNum(); i++) {
            row = sheet1.getRow(i);
            Object[] obj = null;
            if(len == 0){
                obj =  new Object[row.getLastCellNum()];
            }else{
                obj =  new Object[len];
            }
            for (Cell cell : row) {
//				CellReference cellRef = new CellReference(cell.getRowIndex(), cell.getColumnIndex(), false, false);
//				System.out.print(cellRef.formatAsString());
//				System.out.print(" - ");
                int j = cell.getColumnIndex();//obj游标
                switch (cell.getCellType()) {
                    case Cell.CELL_TYPE_STRING:
                        obj[j] = cell.getRichStringCellValue().getString();
//					System.out.println(cell.getRichStringCellValue().getString());
                        break;
                    case Cell.CELL_TYPE_NUMERIC:
                        if(DateUtil.isCellDateFormatted(cell)) {
                            obj[j] = cell.getDateCellValue();
//						System.out.println(cell.getDateCellValue());
                        } else {
                            obj[j] = cell.getNumericCellValue();
//						System.out.println(cell.getNumericCellValue());
                        }
                        break;
                    case Cell.CELL_TYPE_BOOLEAN:
                        obj[j] = cell.getBooleanCellValue();
//					System.out.println(cell.getBooleanCellValue());
                        break;
                    case Cell.CELL_TYPE_FORMULA:
                        obj[j] = cell.getCellFormula();
//					System.out.println(cell.getCellFormula());
                        break;
                    default:
                        obj[j] = cell.getStringCellValue();
//					System.out.println();
                }
            }
            resultList.add(obj);
        }
        return resultList;
    }

    public static List<Object[]> readExcelContentNumber(File file, int len) throws IOException{
        List<Object[]> resultList = new ArrayList<Object[]>();
        InputStream in = new FileInputStream(file);
        Workbook wb = new HSSFWorkbook(in);
        Sheet sheet1 = wb.getSheetAt(0);
        Row row = null;
        for (int i = 1; i <= sheet1.getLastRowNum(); i++) {
            row = sheet1.getRow(i);
            Object[] obj = null;
            if(len == 0){
                obj =  new Object[row.getLastCellNum()];
            }else{
                obj =  new Object[len];
            }
            for (Cell cell : row) {
                int j = cell.getColumnIndex();//obj游标
                switch (cell.getCellType()) {
                    case Cell.CELL_TYPE_STRING:
                        obj[j] = cell.getRichStringCellValue().getString();
                        break;
                    case Cell.CELL_TYPE_NUMERIC:
                        Double value = cell.getNumericCellValue();
                        String num= "";
                        if(value == value.longValue()){
                            num+= value.longValue();
                        }else{
                            num=String.valueOf(value);
                        }
                        System.out.println(num);
                        obj[j]=num.toString();
                        break;
                    case Cell.CELL_TYPE_BOOLEAN:
                        obj[j] = cell.getBooleanCellValue();
                        break;
                    case Cell.CELL_TYPE_FORMULA:
                        obj[j] = cell.getCellFormula();
                        break;
                    default:
                        obj[j] = cell.getStringCellValue();
                }
            }
            resultList.add(obj);
        }
        return resultList;
    }

}

package com.jeesite.modules.test.utils;


import com.jeesite.modules.test.entity.ParseExcel;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class ReadExcel {

    // 总行数
    private int totalRows = 0;
    // 总条数
    private int totalCells = 0;
    // 错误信息接收器
    private String errorMsg;

    // 构造方法
    public ReadExcel() {
    }

    // 获取总行数
    public int getTotalRows() {
        return totalRows;
    }

    // 获取总列数
    public int getTotalCells() {
        return totalCells;
    }

    // 获取错误信息
    public String getErrorInfo() {
        return errorMsg;
    }

    /**
     * 读EXCEL文件，获取信息集合
     *
     * @param //fielName
     * @return
     */
    public List<ParseExcel> getExcelInfo(MultipartFile mFile) {
        List<ParseExcel> parseExcelList = new ArrayList<ParseExcel>();
        String fileName = mFile.getOriginalFilename();// 获取文件名
        System.out.println("getExcelInfo");
        try {
            if (!validateExcel(fileName)) {// 验证文件名是否合格
                return null;
            }
            boolean isExcel2003 = true;// 根据文件名判断文件是2003版本还是2007版本
            if (isExcel2007(fileName)) {
                isExcel2003 = false;
            }
             parseExcelList = createExcel(mFile.getInputStream(), isExcel2003);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return parseExcelList;
    }

    /**
     * 根据excel里面的内容读取客户信息
     *
     * @param// is输入流
     * @param isExcel2003 excel是2003还是2007版本
     * @return
     * @throws IOException
     */
    public List<ParseExcel> createExcel(InputStream is, boolean isExcel2003) {
        System.out.println("createExcel");
        List<ParseExcel> parseExcelList = new ArrayList<ParseExcel>();

        try {
            Workbook wb = null;
            if (isExcel2003) {// 当excel是2003时,创建excel2003
                wb = new HSSFWorkbook(is);
            } else {// 当excel是2007时,创建excel2007
                wb = new XSSFWorkbook(is);
            }
            parseExcelList = readExcelValue(wb);// 读取Excel里面客户的信息
        } catch (IOException e) {
            e.printStackTrace();
        }
        return parseExcelList;
    }

    /**
     * 读取Excel里面客户的信息
     *
     * @param wb
     * @return
     */
    private List<ParseExcel> readExcelValue(Workbook wb) {
        System.out.println("readExcelValue");
        // 得到第一个shell
        Sheet sheet = wb.getSheetAt(0);
        // 得到Excel的行数
        this.totalRows = sheet.getPhysicalNumberOfRows();
        // 得到Excel的列数(前提是有行数)
        if (totalRows > 1 && sheet.getRow(0) != null) {
            this.totalCells = sheet.getRow(0).getPhysicalNumberOfCells();
        }
        List<ParseExcel> parseExcelList = new ArrayList<ParseExcel>();
        // 循环Excel行数
        for (int r = 1; r < totalRows; r++) {
            Row row = sheet.getRow(r);
            if (row == null) {
                continue;
            }
            ParseExcel parseExcel = new ParseExcel();
            // 循环Excel的列
            for (int c = 0; c < this.totalCells; c++) {
                Cell cell = row.getCell(c);
                if (null != cell) {
                    if (c == 0) {
                        // 如果是纯数字,比如写的是25,cell.getNumericCellValue()获得是25.0,通过截取字符串去掉.0获得25

                            parseExcel.setAccount_ownership(cell.getStringCellValue());// 账户归属

                    } else if (c == 1) {

                            parseExcel.setAccount(cell.getNumericCellValue());// 账号

                    } else if (c == 2) {

                            parseExcel.setName(cell.getStringCellValue());// 姓名

                    }else if (c == 3) {

                            parseExcel.setOrder_number(cell.getNumericCellValue());// 订单号


                    }else if (c == 4) {

                            parseExcel.setVariety(cell.getStringCellValue());// 品种

                    }else if (c == 5) {

                            parseExcel.setTransaction_type(cell.getStringCellValue());// 交易类型

                    }else if (c == 6) {

                            parseExcel.setTrading_volume(cell.getNumericCellValue());// 交易量

                    }else if (c == 7) {

                            parseExcel.setBilling_time(cell.getStringCellValue());// 开单时间

                    }else if (c == 8) {

                            parseExcel.setBilling_price(cell.getNumericCellValue());// 开单价格

                    }else if (c == 9) {

                            parseExcel.setStop_loss(cell.getNumericCellValue());// 止损

                    }else if (c == 10) {

                            parseExcel.setTake_profit(cell.getNumericCellValue());// 止盈

                    }else if (c == 11) {

                            parseExcel.setClosing_time(cell.getStringCellValue());// 平仓时间

                    }else if (c == 12) {

                            parseExcel.setClosing_price(cell.getNumericCellValue());// 平仓价格

                    }else if (c == 13) {

                            parseExcel.setHandling_fee(cell.getNumericCellValue());// 手续费

                    }else if (c == 14) {

                            parseExcel.setInterest(cell.getNumericCellValue());// 利息

                    }else if (c == 15) {

                            parseExcel.setProfit_and_loss(cell.getNumericCellValue());// 盈亏

                    }else if (c == 16) {

                            parseExcel.setKsremarks(cell.getStringCellValue());// 备注

                    }

                }
            }
            // 添加到list
            parseExcelList.add(parseExcel);
        }
        return parseExcelList;
    }

    /**
     * 验证EXCEL文件
     * @param filePath
     * @return
     */
    public boolean validateExcel(String filePath) {
        if (filePath == null || !(isExcel2003(filePath) || isExcel2007(filePath))) {
            errorMsg = "文件名不是excel格式";
            return false;
        }
        return true;
    }

    // @描述：是否是2003的excel，返回true是2003
    public static boolean isExcel2003(String filePath) {
        return filePath.matches("^.+\\.(?i)(xls)$");
    }

    // @描述：是否是2007的excel，返回true是2007
    public static boolean isExcel2007(String filePath) {
        return filePath.matches("^.+\\.(?i)(xlsx)$");
    }
}
package com.hunasys.labelsketch.common.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import com.hunasys.labelsketch.orders.vo.OrdersVo;

public class ExcelView extends AbstractXlsxView {

    @Override
    protected void buildExcelDocument(Map<String, Object> modelMap, Workbook workbook, HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        
    	String sCurTime = null;
        sCurTime = new SimpleDateFormat("yyyyMMdd", Locale.KOREA).format(new Date());
        String excelName = sCurTime + "_주문목록.xlsx";

        Sheet worksheet = null;
        Row row = null;
        CellStyle head_style = workbook.createCellStyle();
        CellStyle center_style = workbook.createCellStyle(); // 셀 스타일을 위한 변수
        CellStyle left_style = workbook.createCellStyle(); // 셀 스타일을 위한 변수
        CellStyle right_style = workbook.createCellStyle(); // 셀 스타일을 위한 변수
        
        Font font = workbook.createFont(); // 폰트
        font.setColor(IndexedColors.WHITE.getIndex());

        head_style.setAlignment(org.apache.poi.ss.usermodel.HorizontalAlignment.CENTER); // 글위치를 중앙으로 설정
        head_style.setVerticalAlignment(org.apache.poi.ss.usermodel.VerticalAlignment.CENTER); //상하 위치 중앙 설정
        head_style.setFillForegroundColor(IndexedColors.BLUE_GREY.getIndex());
        head_style.setFillPattern(FillPatternType.SOLID_FOREGROUND); // 배경색 변경
        head_style.setFont(font); // 글자 색상
        
        head_style.setAlignment(org.apache.poi.ss.usermodel.HorizontalAlignment.CENTER); // 글위치를 중앙으로 설정
        head_style.setVerticalAlignment(org.apache.poi.ss.usermodel.VerticalAlignment.CENTER); //상하 위치 중앙 설정
        head_style.setFillForegroundColor(IndexedColors.ORANGE.getIndex());
        head_style.setFillPattern(FillPatternType.SOLID_FOREGROUND); // 배경색 변경
        head_style.setFont(font); // 글자 색상

        center_style.setFillForegroundColor(IndexedColors.WHITE.getIndex());
        center_style.setFillPattern(FillPatternType.SOLID_FOREGROUND);  //배경색 설정
        center_style.setAlignment(org.apache.poi.ss.usermodel.HorizontalAlignment.CENTER); // 글위치를 중앙으로 설정
        
        left_style.setFillForegroundColor(IndexedColors.WHITE.getIndex());
        left_style.setFillPattern(FillPatternType.SOLID_FOREGROUND);  //배경색 설정
        left_style.setAlignment(org.apache.poi.ss.usermodel.HorizontalAlignment.LEFT); // 글위치를 중앙으로 설정
        
        right_style.setFillForegroundColor(IndexedColors.WHITE.getIndex());
        right_style.setFillPattern(FillPatternType.SOLID_FOREGROUND);  //배경색 설정
        right_style.setAlignment(org.apache.poi.ss.usermodel.HorizontalAlignment.RIGHT); // 글위치를 중앙으로 설정
        
        List<OrdersVo> listExcel = (List<OrdersVo>)modelMap.get("datalist");

        // 새로운 sheet를 생성한다.
        worksheet = workbook.createSheet("주문목록");

        // 가장 첫번째 줄에 제목을 만든다.
        row = worksheet.createRow(0);

        // 칼럼 길이 설정
        worksheet.setColumnWidth(0, 4000);
        worksheet.setColumnWidth(1, 4000);
        worksheet.setColumnWidth(2, 4000);
        worksheet.setColumnWidth(3, 4000);
        worksheet.setColumnWidth(4, 4000);
        worksheet.setColumnWidth(5, 4000);
        worksheet.setColumnWidth(6, 4000);
        worksheet.setColumnWidth(7, 4000);
        worksheet.setColumnWidth(8, 4000);
        worksheet.setColumnWidth(9, 4000);
        worksheet.setColumnWidth(10, 4000);
        worksheet.setColumnWidth(11, 4000);
        worksheet.setColumnWidth(12, 4000);
        worksheet.setColumnWidth(13, 4000);
        worksheet.setColumnWidth(14, 4000);

        // 헤더 설정
        row = worksheet.createRow(0);
        row.createCell(0).setCellValue("자산코드");
        row.createCell(1).setCellValue("자산명");
        row.createCell(2).setCellValue("관리자");
        row.createCell(3).setCellValue("단가");
        row.createCell(4).setCellValue("수량");
        row.createCell(5).setCellValue("금액");
        row.createCell(6).setCellValue("내용연수");
        row.createCell(7).setCellValue("상각방법");
        row.createCell(8).setCellValue("상각률");
        row.createCell(9).setCellValue("상각완료");
        row.createCell(10).setCellValue("취득일자");
        row.createCell(11).setCellValue("매각");
        row.createCell(12).setCellValue("폐기");
        row.createCell(13).setCellValue("임대");
        row.createCell(14).setCellValue("반출");

        row.getCell(0).setCellStyle(head_style);
        row.getCell(1).setCellStyle(head_style);
        row.getCell(2).setCellStyle(head_style);
        row.getCell(3).setCellStyle(head_style);
        row.getCell(4).setCellStyle(head_style);
        row.getCell(5).setCellStyle(head_style);
        row.getCell(6).setCellStyle(head_style);
        row.getCell(7).setCellStyle(head_style);
        row.getCell(8).setCellStyle(head_style);
        row.getCell(9).setCellStyle(head_style);
        row.getCell(10).setCellStyle(head_style);
        row.getCell(11).setCellStyle(head_style);
        row.getCell(12).setCellStyle(head_style);
        row.getCell(13).setCellStyle(head_style);
        row.getCell(14).setCellStyle(head_style);


        int rowIndex = 1;

        for (OrdersVo item : listExcel) {
            row = worksheet.createRow(rowIndex);
//            row.createCell(0).setCellValue(item.get);
//            row.createCell(1).setCellValue(item.getvAssetsName());
//            row.createCell(2).setCellValue(item.getvEmplNo());
//            row.createCell(3).setCellValue(item.getnCost());
//            row.createCell(4).setCellValue(item.getnQuantity());
//            row.createCell(5).setCellValue(item.getnAmount());
//            row.createCell(6).setCellValue(item.getvAssetsYear());
//            row.createCell(7).setCellValue(item.getvDepreciationMethod());
//            row.createCell(8).setCellValue(item.getnDepreciationRate());
//            row.createCell(9).setCellValue(item.getvDepreciationEnd());
//            row.createCell(10).setCellValue(item.getvAcquire());
//            row.createCell(11).setCellValue(item.getvDisposal());
//            row.createCell(12).setCellValue(item.getvDisuse());
//            row.createCell(13).setCellValue(item.getvLease());
//            row.createCell(14).setCellValue(item.getvAssetsCarry());

            
            //스타일 적용
            row.getCell(0).setCellStyle(center_style); 
            row.getCell(1).setCellStyle(center_style);
            row.getCell(2).setCellStyle(center_style);
            row.getCell(3).setCellStyle(center_style);
            row.getCell(4).setCellStyle(center_style);
            row.getCell(5).setCellStyle(center_style);
            row.getCell(6).setCellStyle(right_style);
            row.getCell(7).setCellStyle(center_style);
            row.getCell(8).setCellStyle(center_style);
            row.getCell(9).setCellStyle(center_style);
            row.getCell(10).setCellStyle(center_style);
            row.getCell(11).setCellStyle(center_style);
            row.getCell(12).setCellStyle(center_style);
            row.getCell(13).setCellStyle(center_style);
            row.getCell(14).setCellStyle(center_style);
            
            rowIndex++;
        }

        try {
            response.setHeader("Content-Disposition",
                "attachement; filename=\"" + java.net.URLEncoder.encode(excelName, "UTF-8") + "\";charset=\"UTF-8\"");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}

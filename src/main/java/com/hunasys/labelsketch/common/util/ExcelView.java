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
        left_style.setAlignment(org.apache.poi.ss.usermodel.HorizontalAlignment.LEFT); // 글위치를 왼쪽으로 설정
        
        right_style.setFillForegroundColor(IndexedColors.WHITE.getIndex());
        right_style.setFillPattern(FillPatternType.SOLID_FOREGROUND);  //배경색 설정
        right_style.setAlignment(org.apache.poi.ss.usermodel.HorizontalAlignment.RIGHT); // 글위치를 오른쪽으로 설정
        
        @SuppressWarnings("unchecked")
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
        worksheet.setColumnWidth(15, 4000);
        worksheet.setColumnWidth(16, 4000);
        worksheet.setColumnWidth(17, 4000);
        worksheet.setColumnWidth(18, 4000);
        worksheet.setColumnWidth(19, 4000);
        worksheet.setColumnWidth(20, 4000);
        worksheet.setColumnWidth(21, 4000);
        worksheet.setColumnWidth(22, 4000);
        worksheet.setColumnWidth(23, 4000);
        worksheet.setColumnWidth(24, 4000);
        worksheet.setColumnWidth(25, 4000);
        worksheet.setColumnWidth(26, 4000);
        worksheet.setColumnWidth(27, 4000);
        worksheet.setColumnWidth(28, 4000);
        worksheet.setColumnWidth(29, 4000);
        worksheet.setColumnWidth(30, 4000);
        worksheet.setColumnWidth(31, 4000);
        worksheet.setColumnWidth(32, 4000);

        // 헤더 설정
        row = worksheet.createRow(0);
        
        row.createCell(0).setCellValue("주문코드");     
        row.createCell(1).setCellValue("주문구분");     
        row.createCell(2).setCellValue("주문구분");     
        row.createCell(3).setCellValue("발주회사");     
        row.createCell(4).setCellValue("품명");       
        row.createCell(5).setCellValue("규격");       
        row.createCell(6).setCellValue("수량");       
        row.createCell(7).setCellValue("용지1");
        row.createCell(8).setCellValue("용지1");
        row.createCell(9).setCellValue("용지2");
        row.createCell(10).setCellValue("용지2");
        row.createCell(11).setCellValue("용지3");
        row.createCell(12).setCellValue("용지3");
        row.createCell(13).setCellValue("용지4");
        row.createCell(14).setCellValue("용지4");
        row.createCell(15).setCellValue("지관");
        row.createCell(16).setCellValue("지관");
        row.createCell(17).setCellValue("1롤당 수량");
        row.createCell(18).setCellValue("납기일");
        row.createCell(19).setCellValue("납품방법");
        row.createCell(20).setCellValue("납품방법");
        row.createCell(21).setCellValue("기타설명");
        row.createCell(22).setCellValue("첨부파일1");
        row.createCell(23).setCellValue("첨부파일1");
        row.createCell(24).setCellValue("첨부파일2");
        row.createCell(25).setCellValue("첨부파일2");

        row.createCell(26).setCellValue("완료일");
        row.createCell(27).setCellValue("완료시각");
        
        row.createCell(28).setCellValue("작성자");
        row.createCell(29).setCellValue("생성일/주문일");
        row.createCell(30).setCellValue("생성시각/주문시각");
        row.createCell(31).setCellValue("수정일");
        row.createCell(32).setCellValue("수정시각");
        
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
        row.getCell(15).setCellStyle(head_style);
        row.getCell(16).setCellStyle(head_style);
        row.getCell(17).setCellStyle(head_style);
        row.getCell(18).setCellStyle(head_style);
        row.getCell(19).setCellStyle(head_style);
        row.getCell(20).setCellStyle(head_style);
        row.getCell(21).setCellStyle(head_style);
        row.getCell(22).setCellStyle(head_style);
        row.getCell(23).setCellStyle(head_style);
        row.getCell(24).setCellStyle(head_style);
        row.getCell(25).setCellStyle(head_style);
        row.getCell(26).setCellStyle(head_style);
        row.getCell(27).setCellStyle(head_style);
        row.getCell(28).setCellStyle(head_style);
        row.getCell(29).setCellStyle(head_style);
        row.getCell(30).setCellStyle(head_style);
        row.getCell(31).setCellStyle(head_style);
        row.getCell(32).setCellStyle(head_style);

        int rowIndex = 1;

        for (OrdersVo item : listExcel) {
            row = worksheet.createRow(rowIndex);
            row.createCell(0).setCellValue(item.getOrderId());
            row.createCell(1).setCellValue(item.getItemCls());
            row.createCell(2).setCellValue(item.getItemClsNm());
            row.createCell(3).setCellValue(item.getCompany());
            row.createCell(4).setCellValue(item.getItemNm());
            row.createCell(5).setCellValue(item.getItemSpecX());
            row.createCell(6).setCellValue(item.getTotalQty());
            row.createCell(7).setCellValue(item.getPaper1());
            row.createCell(8).setCellValue(item.getPaper1Nm());
            row.createCell(9).setCellValue(item.getPaper2());
            row.createCell(10).setCellValue(item.getPaper2Nm());
            row.createCell(11).setCellValue(item.getPaper3());
            row.createCell(12).setCellValue(item.getPaper3Nm());
            row.createCell(13).setCellValue(item.getPaper4());
            row.createCell(14).setCellValue(item.getPaper4Nm());
            row.createCell(15).setCellValue(item.getParerRoll());
            row.createCell(16).setCellValue(item.getParerRollNm());
            row.createCell(17).setCellValue(item.getRollQty());
            row.createCell(18).setCellValue(item.getDueDate());
            row.createCell(19).setCellValue(item.getDelivery());
            row.createCell(20).setCellValue(item.getDeliveryNm());
            row.createCell(21).setCellValue(item.getDescription());
            row.createCell(22).setCellValue(item.getFile1());
            row.createCell(23).setCellValue(item.getFile1Name());
            row.createCell(24).setCellValue(item.getFile2());
            row.createCell(25).setCellValue(item.getFile2Name());

            row.createCell(26).setCellValue(item.getEndDate());
            row.createCell(27).setCellValue(item.getEndTime());
            
            row.createCell(28).setCellValue(item.getUserId());
            row.createCell(29).setCellValue(item.getNewDate());
            row.createCell(30).setCellValue(item.getNewTime());
            row.createCell(31).setCellValue(item.getModDate());
            row.createCell(32).setCellValue(item.getModTime());
            
            
            //스타일 적용
            row.getCell(0).setCellStyle(center_style);
            row.getCell(1).setCellStyle(center_style);
            row.getCell(2).setCellStyle(center_style);
            row.getCell(3).setCellStyle(center_style);
            row.getCell(4).setCellStyle(center_style);
            row.getCell(5).setCellStyle(center_style);
            row.getCell(6).setCellStyle(center_style);
            row.getCell(7).setCellStyle(center_style);
            row.getCell(8).setCellStyle(center_style);
            row.getCell(9).setCellStyle(center_style);
            row.getCell(10).setCellStyle(center_style);
            row.getCell(11).setCellStyle(center_style);
            row.getCell(12).setCellStyle(center_style);
            row.getCell(13).setCellStyle(center_style);
            row.getCell(14).setCellStyle(center_style);
            row.getCell(15).setCellStyle(center_style);
            row.getCell(16).setCellStyle(center_style);
            row.getCell(17).setCellStyle(center_style);
            row.getCell(18).setCellStyle(center_style);
            row.getCell(19).setCellStyle(center_style);
            row.getCell(20).setCellStyle(center_style);
            row.getCell(21).setCellStyle(center_style);
            row.getCell(22).setCellStyle(center_style);
            row.getCell(23).setCellStyle(center_style);
            row.getCell(24).setCellStyle(center_style);
            row.getCell(25).setCellStyle(center_style);
            row.getCell(26).setCellStyle(center_style);
            row.getCell(27).setCellStyle(center_style);
            row.getCell(28).setCellStyle(center_style);
            row.getCell(29).setCellStyle(center_style);
            row.getCell(30).setCellStyle(center_style);
            row.getCell(31).setCellStyle(center_style);
            row.getCell(32).setCellStyle(center_style);
            
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

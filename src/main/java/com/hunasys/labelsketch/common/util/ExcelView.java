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
        String excelName = sCurTime + "_�ֹ����.xlsx";

        Sheet worksheet = null;
        Row row = null;
        CellStyle head_style = workbook.createCellStyle();
        CellStyle center_style = workbook.createCellStyle(); // �� ��Ÿ���� ���� ����
        CellStyle left_style = workbook.createCellStyle(); // �� ��Ÿ���� ���� ����
        CellStyle right_style = workbook.createCellStyle(); // �� ��Ÿ���� ���� ����
        
        Font font = workbook.createFont(); // ��Ʈ
        font.setColor(IndexedColors.WHITE.getIndex());

        head_style.setAlignment(org.apache.poi.ss.usermodel.HorizontalAlignment.CENTER); // ����ġ�� �߾����� ����
        head_style.setVerticalAlignment(org.apache.poi.ss.usermodel.VerticalAlignment.CENTER); //���� ��ġ �߾� ����
        head_style.setFillForegroundColor(IndexedColors.BLUE_GREY.getIndex());
        head_style.setFillPattern(FillPatternType.SOLID_FOREGROUND); // ���� ����
        head_style.setFont(font); // ���� ����
        
        head_style.setAlignment(org.apache.poi.ss.usermodel.HorizontalAlignment.CENTER); // ����ġ�� �߾����� ����
        head_style.setVerticalAlignment(org.apache.poi.ss.usermodel.VerticalAlignment.CENTER); //���� ��ġ �߾� ����
        head_style.setFillForegroundColor(IndexedColors.ORANGE.getIndex());
        head_style.setFillPattern(FillPatternType.SOLID_FOREGROUND); // ���� ����
        head_style.setFont(font); // ���� ����

        center_style.setFillForegroundColor(IndexedColors.WHITE.getIndex());
        center_style.setFillPattern(FillPatternType.SOLID_FOREGROUND);  //���� ����
        center_style.setAlignment(org.apache.poi.ss.usermodel.HorizontalAlignment.CENTER); // ����ġ�� �߾����� ����
        
        left_style.setFillForegroundColor(IndexedColors.WHITE.getIndex());
        left_style.setFillPattern(FillPatternType.SOLID_FOREGROUND);  //���� ����
        left_style.setAlignment(org.apache.poi.ss.usermodel.HorizontalAlignment.LEFT); // ����ġ�� �߾����� ����
        
        right_style.setFillForegroundColor(IndexedColors.WHITE.getIndex());
        right_style.setFillPattern(FillPatternType.SOLID_FOREGROUND);  //���� ����
        right_style.setAlignment(org.apache.poi.ss.usermodel.HorizontalAlignment.RIGHT); // ����ġ�� �߾����� ����
        
        List<OrdersVo> listExcel = (List<OrdersVo>)modelMap.get("datalist");

        // ���ο� sheet�� �����Ѵ�.
        worksheet = workbook.createSheet("�ֹ����");

        // ���� ù��° �ٿ� ������ �����.
        row = worksheet.createRow(0);

        // Į�� ���� ����
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

        // ��� ����
        row = worksheet.createRow(0);
        row.createCell(0).setCellValue("�ڻ��ڵ�");
        row.createCell(1).setCellValue("�ڻ��");
        row.createCell(2).setCellValue("������");
        row.createCell(3).setCellValue("�ܰ�");
        row.createCell(4).setCellValue("����");
        row.createCell(5).setCellValue("�ݾ�");
        row.createCell(6).setCellValue("���뿬��");
        row.createCell(7).setCellValue("�󰢹��");
        row.createCell(8).setCellValue("�󰢷�");
        row.createCell(9).setCellValue("�󰢿Ϸ�");
        row.createCell(10).setCellValue("�������");
        row.createCell(11).setCellValue("�Ű�");
        row.createCell(12).setCellValue("���");
        row.createCell(13).setCellValue("�Ӵ�");
        row.createCell(14).setCellValue("����");

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

            
            //��Ÿ�� ����
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

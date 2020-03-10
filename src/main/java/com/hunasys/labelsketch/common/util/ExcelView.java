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
        left_style.setAlignment(org.apache.poi.ss.usermodel.HorizontalAlignment.LEFT); // ����ġ�� �������� ����
        
        right_style.setFillForegroundColor(IndexedColors.WHITE.getIndex());
        right_style.setFillPattern(FillPatternType.SOLID_FOREGROUND);  //���� ����
        right_style.setAlignment(org.apache.poi.ss.usermodel.HorizontalAlignment.RIGHT); // ����ġ�� ���������� ����
        
        @SuppressWarnings("unchecked")
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

        // ��� ����
        row = worksheet.createRow(0);
        
        row.createCell(0).setCellValue("�ֹ��ڵ�");     
        row.createCell(1).setCellValue("�ֹ�����");     
        row.createCell(2).setCellValue("�ֹ�����");     
        row.createCell(3).setCellValue("����ȸ��");     
        row.createCell(4).setCellValue("ǰ��");       
        row.createCell(5).setCellValue("�԰�");       
        row.createCell(6).setCellValue("����");       
        row.createCell(7).setCellValue("����1");
        row.createCell(8).setCellValue("����1");
        row.createCell(9).setCellValue("����2");
        row.createCell(10).setCellValue("����2");
        row.createCell(11).setCellValue("����3");
        row.createCell(12).setCellValue("����3");
        row.createCell(13).setCellValue("����4");
        row.createCell(14).setCellValue("����4");
        row.createCell(15).setCellValue("����");
        row.createCell(16).setCellValue("����");
        row.createCell(17).setCellValue("1�Ѵ� ����");
        row.createCell(18).setCellValue("������");
        row.createCell(19).setCellValue("��ǰ���");
        row.createCell(20).setCellValue("��ǰ���");
        row.createCell(21).setCellValue("��Ÿ����");
        row.createCell(22).setCellValue("÷������1");
        row.createCell(23).setCellValue("÷������1");
        row.createCell(24).setCellValue("÷������2");
        row.createCell(25).setCellValue("÷������2");

        row.createCell(26).setCellValue("�Ϸ���");
        row.createCell(27).setCellValue("�Ϸ�ð�");
        
        row.createCell(28).setCellValue("�ۼ���");
        row.createCell(29).setCellValue("������/�ֹ���");
        row.createCell(30).setCellValue("�����ð�/�ֹ��ð�");
        row.createCell(31).setCellValue("������");
        row.createCell(32).setCellValue("�����ð�");
        
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
            
            
            //��Ÿ�� ����
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

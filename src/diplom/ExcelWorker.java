package diplom;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
public class ExcelWorker {
	@SuppressWarnings("resource")
	ExcelWorker() throws ParseException {
		CellStyle cellStyle;
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet("Календарь выплат");
		String[] head = {"Дата", "Платёж в месяц", "Основной долг", "Проценты", "Остаток"};
		int rowNum = 0;
		
		//создание шапки
		HSSFRow rowOld = sheet.createRow(rowNum);
		for (int i = 0; i < 5; i++){
			rowOld.createCell(i).setCellValue(head[i]);
		}
        rowNum++;
        
        //создание строки 1
        rowOld = sheet.createRow(rowNum);
        cellStyle = workbook.createCellStyle();
        cellStyle.setDataFormat((short) 2);
        rowOld.createCell(0).setCellValue(port_creadit.jftfPayDate.getText());
        rowOld.createCell(1).setCellValue(Float.parseFloat(port_creadit.jtfMonthPay.getText()));
        rowOld.getCell(1).setCellStyle(cellStyle);
        rowOld.createCell(3).setCellFormula((Float.parseFloat(port_creadit.jtfProcent.getText())/100)/12 + "*" + Integer.parseInt(port_creadit.jtfSum.getText()));
        rowOld.getCell(3).setCellStyle(cellStyle);
        rowOld.createCell(2).setCellFormula("B2-D2");
        rowOld.getCell(2).setCellStyle(cellStyle);
        rowOld.createCell(4).setCellFormula(Integer.parseInt(port_creadit.jtfSum.getText()) + "-C2");
        rowOld.getCell(4).setCellStyle(cellStyle);
        int rowOldNum = rowNum;
        rowNum++;    
        
        for (int rowNewNum = rowNum; rowNewNum <= Integer.parseInt(port_creadit.jtfSrok.getText()); rowNewNum++){
        	HSSFRow rowNew = sheet.createRow(rowNewNum);
        	rowNew.createCell(0).setCellValue(changeMonth(rowOld.getCell(0).getStringCellValue()));
        	rowNew.createCell(1).setCellValue(Float.parseFloat(port_creadit.jtfMonthPay.getText()));
        	rowNew.getCell(1).setCellStyle(cellStyle);
        	rowNew.createCell(3).setCellFormula((Float.parseFloat(port_creadit.jtfProcent.getText())/100)/12 + "*E" + (rowOldNum+1));
        	rowNew.getCell(3).setCellStyle(cellStyle);
        	rowNew.createCell(2).setCellFormula("B" + (rowNewNum+1) + "-D" + (rowNewNum+1));
        	rowNew.getCell(2).setCellStyle(cellStyle);
        	rowNew.createCell(4).setCellFormula("E" + (rowOldNum+1) + "-C" + (rowNewNum+1));
        	rowNew.getCell(4).setCellStyle(cellStyle);
        	rowOld = rowNew;
        	rowOldNum = rowNewNum;
        }
        for (int i = 0; i < 4; i++) {
        	sheet.autoSizeColumn(i);
        }
        sheet.setColumnWidth(4, 2800);
        
                
        try (FileOutputStream out = new FileOutputStream(new File("C:\\Users\\Nikita\\Desktop\\универ\\diplom\\diplom_prog\\paymentCalendar.xls"))) {
            workbook.write(out);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Excel файл успешно создан!");
	}
	
	
	private static String changeMonth(String curMonth){
		curMonth = curMonth.replace(".", ",");
		String[] curMonthArray = curMonth.split(",");
		if (curMonthArray[1].equals("12")){
			curMonthArray[2] = (Integer.parseInt(curMonthArray[2]) + 1) + "";
			curMonthArray[1] = "01";
		}else{
			curMonthArray[1] = (Integer.parseInt(curMonthArray[1]) + 1) + "";
		}
		if (curMonthArray[1].length() == 2){
			curMonth = curMonthArray[0] + "." + curMonthArray[1] + "." + curMonthArray[2];
		}else{
			curMonth = curMonthArray[0] + ".0" + curMonthArray[1] + "." + curMonthArray[2];
		}
		return curMonth;
	}
}
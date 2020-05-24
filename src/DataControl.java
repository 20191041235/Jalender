import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class DataControl {
	File file = new File(".\\assets\\data.xls");
	
	public void createExcel()
	{	
		HSSFWorkbook excel = new HSSFWorkbook(); // 새 엑셀 생성
        HSSFSheet sheet1 = excel.createSheet("학사일정"); // 새 시트(Sheet) 생성
        HSSFSheet sheet2 = excel.createSheet("사용자일정"); // 새 시트(Sheet) 생성
        HSSFRow row = sheet1.createRow(0); // 엑셀의 행은 0번부터 시작
        HSSFCell cell = row.createCell(0); // 행의 셀은 0번부터 시작
        //cell.setCellValue("test"); //생성한 셀에 데이터 삽입
        try {
            FileOutputStream fout = new FileOutputStream(file);
            excel.write(fout);
            fout.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	public void loadData(int year) {
		
		//Todo : 엑셀로부터 값 가져와서 캘린더에 반영하면 됨. 어떻게 할건지 토의 필요
		
		
	}
	
	public void writeData(String mode, String data, int type) {
		HSSFWorkbook excel;
		FileInputStream fin = null;
		
		try {
			fin = new FileInputStream(file);
		} catch (FileNotFoundException e2) {
			createExcel();
			try {
				fin = new FileInputStream(file);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
				return;
			}
		}
		
		try {
			excel = new HSSFWorkbook(fin);
			HSSFSheet sheet = excel.getSheet(mode);	//학사일정 / 사용자일정으로 나눔
			HSSFRow row = null;
			
			if(type == 0) 
				row = sheet.createRow(sheet.getLastRowNum() + 1);
			else
				row = sheet.getRow(sheet.getLastRowNum());
			
			HSSFCell cell = row.createCell(type);	//type : 1data / 0content
			
			//HSSFSheet sheet1 = excel.createSheet("학사일정"); // 새 시트(Sheet) 생성
	        //HSSFSheet sheet2 = excel.createSheet("사용자일정"); // 새 시트(Sheet) 생성
	        //HSSFRow row = sheet1.createRow(0); // 엑셀의 행은 0번부터 시작
	        //HSSFCell cell = row.createCell(0); // 행의 셀은 0번부터 시작
	        
	        cell.setCellValue(data); //생성한 셀에 데이터 삽입
	        FileOutputStream fout = new FileOutputStream(file);
	        excel.write(fout);
		} catch (IOException e1) {
			e1.printStackTrace();
			System.out.println("Cannot open excel file!");
		} 
        
		try {
			fin.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

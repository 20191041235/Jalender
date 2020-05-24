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
		HSSFWorkbook excel = new HSSFWorkbook(); // �� ���� ����
        HSSFSheet sheet1 = excel.createSheet("�л�����"); // �� ��Ʈ(Sheet) ����
        HSSFSheet sheet2 = excel.createSheet("���������"); // �� ��Ʈ(Sheet) ����
        HSSFRow row = sheet1.createRow(0); // ������ ���� 0������ ����
        HSSFCell cell = row.createCell(0); // ���� ���� 0������ ����
        //cell.setCellValue("test"); //������ ���� ������ ����
        try {
            FileOutputStream fout = new FileOutputStream(file);
            excel.write(fout);
            fout.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	public void loadData(int year) {
		
		//Todo : �����κ��� �� �����ͼ� Ķ������ �ݿ��ϸ� ��. ��� �Ұ��� ���� �ʿ�
		
		
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
			HSSFSheet sheet = excel.getSheet(mode);	//�л����� / ������������� ����
			HSSFRow row = null;
			
			if(type == 0) 
				row = sheet.createRow(sheet.getLastRowNum() + 1);
			else
				row = sheet.getRow(sheet.getLastRowNum());
			
			HSSFCell cell = row.createCell(type);	//type : 1data / 0content
			
			//HSSFSheet sheet1 = excel.createSheet("�л�����"); // �� ��Ʈ(Sheet) ����
	        //HSSFSheet sheet2 = excel.createSheet("���������"); // �� ��Ʈ(Sheet) ����
	        //HSSFRow row = sheet1.createRow(0); // ������ ���� 0������ ����
	        //HSSFCell cell = row.createCell(0); // ���� ���� 0������ ����
	        
	        cell.setCellValue(data); //������ ���� ������ ����
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

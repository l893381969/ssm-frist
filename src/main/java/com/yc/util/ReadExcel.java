package com.yc.util;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import com.yc.po.PlanPO;

/**
 * Excel处理函数
 * @author 38929
 *
 */
public class ReadExcel {
	
	//总行数
	private int totalRows = 0;
	//每一行总单元格数
	private int totalCells = 0;
	//错误信息接收器
	private String errorMsg;
	
	//构造方法
	public ReadExcel(){
		
	}
	
	//每一行总单元格数
	public int getTotalRows(){
		return totalRows;
	}
	
	//获取总条数
	public int getTotalCells(){
		return totalCells;
	}
	
	//获取错误信息
	public String getErrorInfo(){
		return errorMsg;
	}
	
	/**
	 * 读Excel文件 获取信息集合
	 * @param mFile
	 * @return
	 */
	public List<PlanPO> getExcelInfo(MultipartFile mFile){
		String fileName = mFile.getOriginalFilename();//获取文件名
		List<PlanPO> planList= null;
		try {
			if (!validateExcel(fileName)) {//验证文件名是否合格
				return null;
			}
			boolean isExcel2003 = true;//根据文件名判断文件是2003版本还是2007版本
			if (isExcel2007(fileName)) {
				isExcel2003 = false;
			}
			planList = createExcel(mFile.getInputStream(), isExcel2003);
		} catch (Exception e) {
			e.printStackTrace();
		}	
		return planList;
	}

	 /**      
	  * 根据excel里面的内容读取客户信息         
	  * @param is输入流     
	  * @param isExcel2003 excel是2003还是2007版本     
	  * @param userList 
	  * @return     
	  * @throws IOException     
	  */    
	public List<PlanPO> createExcel(InputStream is, boolean isExcel2003) {
		List<PlanPO> userList= null;
		try {   
			Workbook wb = null;       
			if (isExcel2003) {// 当excel是2003时,创建excel2003                
				wb = new HSSFWorkbook(is);           
			} else {// 当excel是2007时,创建excel2007   
				wb = new XSSFWorkbook(is);           
			}          
			userList = readExcelValue(wb);// 读取Excel里面客户的信息		
		} catch (IOException e) {  
			e.printStackTrace();      
		}
		return userList;  
	}    
	
	/**  
	 * 读取Excel里面客户的信息       
	 * @param wb     
	 * @return     
	 */    
	private List<PlanPO> readExcelValue(Workbook wb) { 
		// 得到第一个shell        
		Sheet sheet = wb.getSheetAt(0);       
		// 得到Excel的行数        
		this.totalRows = sheet.getPhysicalNumberOfRows();  
		// 得到Excel的列数(前提是有行数)        
		if (totalRows > 2 && sheet.getRow(0) != null) {  
			this.totalCells = sheet.getRow(0).getPhysicalNumberOfCells();  		
			List<PlanPO> planList = new ArrayList<PlanPO>(); 
			// 循环Excel行数        
			for (int r = 2; r < totalRows; r++) {      
				Row row = sheet.getRow(r);          
				if (row == null) {            
					continue;         
				}            
				PlanPO planPO = new PlanPO(); 			
				// 循环Excel的列        
				for (int cellNum = 0; cellNum < this.totalCells; cellNum++) { 
					Cell cell = row.getCell(cellNum); 
					//System.out.println(cell);		
					if (null != cell) {  
						if (cellNum == 0) {//课程名称        
							// 如果是纯数字,比如你写的是25,cell.getNumericCellValue()获得是25.0,通过截取字符串去掉.0获得25   
							if (cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {							
								String direction = String.valueOf(cell.getNumericCellValue());     
								planPO.setDirection(direction.substring(0, direction.length() - 2 > 0 ? direction.length() - 2 : 1));//                   
							} else {      					
								planPO.setDirection(cell.getStringCellValue());//     
							}                
						} else if (cellNum == 1) {//开课院系 
							if (cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
								String college = String.valueOf(cell.getNumericCellValue()); 
								planPO.setCollege(college.substring(0, college.length() - 2 > 0 ? college.length() - 2 : 1));//                  
							} else {   
								planPO.setCollege(cell.getStringCellValue());//                       
							}           
						} else if (cellNum == 2) {//上课院系  
							if (cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) { 
								String department = String.valueOf(cell.getNumericCellValue());     
								planPO.setDepartment(department.substring(0, department.length() - 2 > 0 ? department.length() - 2 : 1));//     
							} else {                      
								planPO.setDepartment(cell.getStringCellValue());//            
							}                         
						} else if (cellNum == 3) {//考试班级  
							if (cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) { 
								String classname = String.valueOf(cell.getNumericCellValue());     
								planPO.setClassname(classname.substring(0, classname.length() - 2 > 0 ? classname.length() - 2 : 1));//     
							} else {                      
								planPO.setClassname(cell.getStringCellValue());//            
							}                          
						} else if (cellNum == 4){//参考人数
							if (cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) { 
								String num = String.valueOf(cell.getNumericCellValue());     
								planPO.setNum(Integer.parseInt(num.substring(0, num.length() - 2 > 0 ? num.length() - 2 : 1)));//     
							} else {                      
								planPO.setNum(Integer.parseInt(cell.getStringCellValue()));//        
							}                
						} else if (cellNum == 5) {//考试地点 
							if (cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
								String classroom = String.valueOf(cell.getNumericCellValue()); 
								planPO.setClassroom(classroom.substring(0, classroom.length() - 2 > 0 ? classroom.length() - 2 : 1));//                  
							} else {   
								planPO.setClassroom(cell.getStringCellValue());//                       
								}           
						} else if (cellNum == 6) {//考试楼栋  
							if (cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) { 
							String building = String.valueOf(cell.getNumericCellValue());     
							planPO.setBuilding(building.substring(0, building.length() - 2 > 0 ? building.length() - 2 : 1));//     
							} else {                      
								planPO.setBuilding(cell.getStringCellValue());//            
							}                          
						} else if (cellNum == 7) {//监考日期  
							if (cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) { 	
								SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
								String date = String.valueOf(sdf.format(cell.getDateCellValue())); 
								//System.out.println(date);
								planPO.setDate(date);							  
							} else {    
								planPO.setDate(cell.getDateCellValue().toString());//            	
							}       
						} else if (cellNum == 8){//监考时间
							if (cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) { 
								String time = String.valueOf(cell.getNumericCellValue());     
								planPO.setTime(time.substring(0, time.length() - 2 > 0 ? time.length() - 2 : 1));   
							} else {                      
								planPO.setTime(cell.getStringCellValue());//           
							}               
						}else if (cellNum == 9) {//监考员 
							if (cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) { 
								String uname = String.valueOf(cell.getNumericCellValue());     
								planPO.setUname(uname.substring(0, uname.length() - 2 > 0 ? uname.length() - 2 : 1));    
							} else {                      
								planPO.setUname(cell.getStringCellValue());           
							}                          
						} else if(cellNum == 10){//联系方式
							if (cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) { 
								String tel = String.valueOf(cell.getNumericCellValue());     
								planPO.setUtel(tel.substring(0, tel.length() - 2 > 0 ? tel.length() - 2 : 1));
							} else {                      
								planPO.setUtel(cell.getStringCellValue());           
							}               
						} 					
					}	
				}
				// 添加到list       
				planList.add(planPO); 				    				
			}
			return planList; 
		}else{
			System.out.println("数据不足，请上传齐全的Excel文件");		
		}        
		return null;   
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



package com.cecep.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.util.CellRangeAddress;

import com.cecep.model.DtUser;
import com.cecep.model.kq.KqCollect;
import com.cecep.model.kq.KqRecord;
import com.cecep.model.kq.StatisticsInfo;
import com.cecep.model.mess.DepNum;
import com.cecep.model.mess.MessConsumeInfo;
import com.cecep.model.mess.MessQuery;
import com.cecep.model.mess.MessStatisticsInfo;
import com.cecep.model.mess.MessSummary;
/**
 * 考勤Excel报表导出
 */
public class ExportExcel {

	/**
	 * 迟到早退  导出excel
	 * @param username 
	 * @throws FileNotFoundException 
	 */
	@SuppressWarnings({ "unchecked" })
	public static void exportKq( Map<String, Object> map, String username ,Integer personal ) throws Exception{
		int rowIndex = 0;
		StatisticsInfo info = (StatisticsInfo) map.get("statisticsInfo");
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet();
		
		//考勤记录表格格式
		CellStyle setBorder = workbook.createCellStyle();
		setBorder.setBorderBottom(CellStyle.BORDER_THIN); // 下边框
		setBorder.setBorderLeft(CellStyle.BORDER_THIN);// 左边框
		setBorder.setBorderTop(CellStyle.BORDER_THIN);// 上边框
		setBorder.setBorderRight(CellStyle.BORDER_THIN);// 右边框
		setBorder.setAlignment(CellStyle.ALIGN_LEFT);
		setBorder.setWrapText(true);// 设置自动换行

		//设置列的宽度
		sheet.setColumnWidth(0, 3766);
		sheet.setColumnWidth(1, 3766);
		sheet.setColumnWidth(2, 3766);
		sheet.setColumnWidth(3, 3766);
		sheet.setColumnWidth(4, 3766);
		sheet.setColumnWidth(5, 3766);
		sheet.setColumnWidth(6, 3766);
		sheet.setColumnWidth(7, 3766);
		sheet.setColumnWidth(8, 3766);
		sheet.setColumnWidth(9, 3766);
		
		//合并单元格
		sheet.addMergedRegion(new CellRangeAddress(0,0,0,9));
		sheet.addMergedRegion(new CellRangeAddress(1,1,0,9));
		sheet.addMergedRegion(new CellRangeAddress(2,2,7,9));
		sheet.addMergedRegion(new CellRangeAddress(3,3,0,9));
		// 居中显示
		CellStyle style1 = workbook.createCellStyle();
		style1.setAlignment(CellStyle.ALIGN_CENTER);
		// 居右显示
		CellStyle style2 = workbook.createCellStyle();
		style2.setAlignment(CellStyle.ALIGN_RIGHT);
		// 第一行标题
		HSSFRow row1 = sheet.createRow(rowIndex++);
		row1.setHeight((short)400);
		HSSFCell cell1 = row1.createCell(0);
		cell1.setCellStyle(style1);
		cell1.setCellValue("考勤记录表");
		// 2
		HSSFRow row2 = sheet.createRow(rowIndex++);
		row2.setHeight((short)400);
		HSSFCell cell2 = row2.createCell(0);
		cell2.setCellValue(info.getDepInfo());
		// 3
		HSSFRow row3 = sheet.createRow(rowIndex++);
		row3.setHeight((short)400);
		HSSFCell cell3 = row3.createCell(7);
		cell3.setCellValue("部门主任签字：");
		//4
		HSSFRow row4 = sheet.createRow(rowIndex++);
		row4.setHeight((short)400);
		HSSFCell cell4 = row4.createCell(0);
		cell4.setCellStyle(style2);
		cell4.setCellValue(info.getDateInfo());
		//5
		HSSFRow row5 = sheet.createRow(rowIndex++);
		HSSFCell cell5 = row5.createCell(0);
		cell5.setCellValue("全勤人员");
		String [] names = null;
		String allWorkInfo = info.getAllWorkInfo();
		if(allWorkInfo!=null&&allWorkInfo.length()>0){
			names = info.getAllWorkInfo().split(",");
			for(int i = 0;i<names.length;i++){
				HSSFRow rowAllwork = sheet.createRow(rowIndex++);
				HSSFCell cellAllwork = rowAllwork.createCell(0);
				cellAllwork.setCellValue(names[i]);
			}
		}
		//空一行
		rowIndex++;
		//表格标题
		//员工姓名	晚到(次)	晚到日期	早走(次)	早走日期	无记录(次)	无记录日期	晚到原因	早走原因	无记录原因
		HSSFRow titleRow = sheet.createRow(rowIndex++);
		HSSFCell titleCell1 = titleRow.createCell(0);
		titleCell1.setCellStyle(setBorder);
		titleCell1.setCellValue("员工姓名");
		HSSFCell titleCell2 = titleRow.createCell(1);
		titleCell2.setCellStyle(setBorder);
		titleCell2.setCellValue("晚到(次)");
		HSSFCell titleCell3 = titleRow.createCell(2);
		titleCell3.setCellStyle(setBorder);
		titleCell3.setCellValue("晚到日期");
		HSSFCell titleCell4 = titleRow.createCell(3);
		titleCell4.setCellStyle(setBorder);
		titleCell4.setCellValue("早走(次)");
		HSSFCell titleCell5 = titleRow.createCell(4);
		titleCell5.setCellStyle(setBorder);
		titleCell5.setCellValue("早走日期");
		HSSFCell titleCell6 = titleRow.createCell(5);
		titleCell6.setCellStyle(setBorder);
		titleCell6.setCellValue("无记录(次)");
		HSSFCell titleCell7 = titleRow.createCell(6);
		titleCell7.setCellStyle(setBorder);
		titleCell7.setCellValue("无记录日期");
		HSSFCell titleCell8 = titleRow.createCell(7);
		titleCell8.setCellStyle(setBorder);
		titleCell8.setCellValue("晚到原因");
		HSSFCell titleCell9 = titleRow.createCell(8);
		titleCell9.setCellStyle(setBorder);
		titleCell9.setCellValue("早走原因");
		HSSFCell titleCell10 = titleRow.createCell(9);
		titleCell10.setCellStyle(setBorder);
		titleCell10.setCellValue("无记录原因");
		
		List<KqCollect> list = (List<KqCollect>) map.get("rows");
		for(int i = 0;i<list.size();i++){
			HSSFRow recordRow = sheet.createRow(rowIndex++);
			String [] ss1 = list.get(i).getLateTimes().split(",");
			String [] ss2 = list.get(i).getLeaveEarlyTimes().split(",");
			String [] ss3 = list.get(i).getGoOutTimes().split(",");
			int len = Math.max(ss1.length, ss2.length);
			len = Math.max(len, ss3.length);
			recordRow.setHeight((short)(260*len));
			HSSFCell recordCell1 = recordRow.createCell(0);
			recordCell1.setCellStyle(setBorder);
			recordCell1.setCellValue(list.get(i).getUsername());
			HSSFCell recordCell2 = recordRow.createCell(1);
			recordCell2.setCellStyle(setBorder);
			recordCell2.setCellValue(list.get(i).getLateCount());
			HSSFCell recordCell3 = recordRow.createCell(2);
			recordCell3.setCellStyle(setBorder);
			recordCell3.setCellValue(new HSSFRichTextString(list.get(i).getLateTimes().replaceAll("<br>", "").replaceAll(",", ",\r\n")));
			HSSFCell recordCell4 = recordRow.createCell(3);
			recordCell4.setCellStyle(setBorder);
			recordCell4.setCellValue(list.get(i).getLeaveEarlyCount());
			HSSFCell recordCell5 = recordRow.createCell(4);
			recordCell5.setCellStyle(setBorder);
			recordCell5.setCellValue(new HSSFRichTextString(list.get(i).getLeaveEarlyTimes().replaceAll("<br>", "").replaceAll(",", ",\r\n")));
			HSSFCell recordCell6 = recordRow.createCell(5);
			recordCell6.setCellStyle(setBorder);
			recordCell6.setCellValue(list.get(i).getGoOutCount());
			HSSFCell recordCell7 = recordRow.createCell(6);
			recordCell7.setCellStyle(setBorder);
			recordCell7.setCellValue(new HSSFRichTextString(list.get(i).getGoOutTimes().replaceAll("<br>", "").replaceAll(",", ",\r\n")));
			HSSFCell recordCell8 = recordRow.createCell(7);
			recordCell8.setCellStyle(setBorder);
			recordCell8.setCellValue(new HSSFRichTextString(""));
			HSSFCell recordCell9 = recordRow.createCell(8);
			recordCell9.setCellStyle(setBorder);
			recordCell9.setCellValue(new HSSFRichTextString(""));
			HSSFCell recordCell10 = recordRow.createCell(9);
			recordCell10.setCellStyle(setBorder);
			recordCell10.setCellValue(new HSSFRichTextString(""));
		}
		String path = ExportExcel.class.getResource("/")+"excel/"+username+"_kq.xls";
		path = path.substring(6);
		File file = new File(path);
		file.deleteOnExit();
		FileOutputStream out = new FileOutputStream(path);
		workbook.write(out);
		out.close();
	}
	
	/**
	 * 加班  导出excel
	 * @throws FileNotFoundException 
	 */
	@SuppressWarnings({  "unchecked" })
	public static void exportJiaban( Map<String, Object> map, String username, Integer personal) throws Exception{
		int rowIndex = 0;
		StatisticsInfo info = null;
		String title = (String) map.get("title");
		if(title==null){
			info = (StatisticsInfo) map.get("statisticsInfo");
		}
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet();
		
		//考勤记录表格格式
		CellStyle setBorder = workbook.createCellStyle();
		setBorder.setWrapText(true);// 设置自动换行
		setBorder.setBorderBottom(CellStyle.BORDER_THIN); // 下边框
		setBorder.setBorderLeft(CellStyle.BORDER_THIN);// 左边框
		setBorder.setBorderTop(CellStyle.BORDER_THIN);// 上边框
		setBorder.setBorderRight(CellStyle.BORDER_THIN);// 右边框

		//设置列的宽度
		sheet.setColumnWidth(0, 3766);
		sheet.setColumnWidth(1, 7000);
		sheet.setColumnWidth(2, 3766);
		sheet.setColumnWidth(3, 3766);
		
		//合并单元格
		sheet.addMergedRegion(new CellRangeAddress(0,0,0,3));
		if(title==null&&personal!=1){
			sheet.addMergedRegion(new CellRangeAddress(1,1,0,3));
			sheet.addMergedRegion(new CellRangeAddress(2,2,0,3));
		}
		// 居中显示
		CellStyle style1 = workbook.createCellStyle();
		style1.setAlignment(CellStyle.ALIGN_CENTER);
		// 第一行标题
		HSSFRow row1 = sheet.createRow(rowIndex++);
		row1.setHeight((short)400);
		HSSFCell cell1 = row1.createCell(0);
		cell1.setCellStyle(style1);
		if(personal==1){
			cell1.setCellValue("个人加班记录表");
		}else{
			if(title==null){
				cell1.setCellValue("加班记录表");
			}else{
				cell1.setCellValue(title);
			}
		}
		if(title==null&&personal!=1){
			// 2
			HSSFRow row2 = sheet.createRow(rowIndex++);
			row2.setHeight((short)400);
			HSSFCell cell2 = row2.createCell(0);
			cell2.setCellValue(info.getDepInfo());
			// 3
			HSSFRow row3 = sheet.createRow(rowIndex++);
			row3.setHeight((short)400);
			HSSFCell cell3 = row3.createCell(0);
			cell3.setCellValue(info.getDateInfo());
		}

		//表格标题
		setBorder.setAlignment(CellStyle.ALIGN_LEFT);
		HSSFRow titleRow = sheet.createRow(rowIndex++);
		HSSFCell titleCell1 = titleRow.createCell(0);
		titleCell1.setCellStyle(setBorder);
		titleCell1.setCellValue("员工姓名");
		HSSFCell titleCell2 = titleRow.createCell(1);
		titleCell2.setCellStyle(setBorder);
		titleCell2.setCellValue("部门");
		HSSFCell titleCell4 = titleRow.createCell(2);
		titleCell4.setCellStyle(setBorder);
		titleCell4.setCellValue("加班(次)");
		HSSFCell titleCell5 = titleRow.createCell(3);
		titleCell5.setCellStyle(setBorder);
		titleCell5.setCellValue("加班日期");
		
		List<KqCollect> list = (List<KqCollect>) map.get("rows");
		for(int i = 0;i<list.size();i++){
			HSSFRow recordRow = sheet.createRow(rowIndex++);
			int len = list.get(i).getJbTime().size();
			recordRow.setHeight((short)(260*len));
			HSSFCell recordCell1 = recordRow.createCell(0);
			recordCell1.setCellStyle(setBorder);
			recordCell1.setCellValue(list.get(i).getUsername());
			HSSFCell recordCell2 = recordRow.createCell(1);
			recordCell2.setCellStyle(setBorder);
			recordCell2.setCellValue(list.get(i).getDepName());
			HSSFCell recordCell4 = recordRow.createCell(2);
			recordCell4.setCellStyle(setBorder);
			recordCell4.setCellValue(list.get(i).getJbCount());
			HSSFCell recordCell5 = recordRow.createCell(3);
			recordCell5.setCellStyle(setBorder);
			recordCell5.setCellValue(list.get(i).getJbTimes().replaceAll("<br>", "").replaceAll(",", ",\r\n"));
		}
		String path = ExportExcel.class.getResource("/")+"excel/"+username+"_kq.xls";
		path = path.substring(6);
		FileOutputStream out = new FileOutputStream(path);
		workbook.write(out);
		out.close();
	}
	
	/**
	 * 食堂消费查询结果
	 * @param total 
	 * @param username 
	 * @throws FileNotFoundException 
	 */
	public static void exportMessQuery( MessQuery query, List<MessConsumeInfo> list,
			DtUser currUser, int total ) throws Exception{
		SimpleDateFormat format = new  SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
		int rowIndex = 0;
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet();
		
		//考勤记录表格格式
		CellStyle setBorder = workbook.createCellStyle();
		setBorder.setWrapText(true);// 设置自动换行
		setBorder.setBorderBottom(CellStyle.BORDER_THIN); // 下边框
		setBorder.setBorderLeft(CellStyle.BORDER_THIN);// 左边框
		setBorder.setBorderTop(CellStyle.BORDER_THIN);// 上边框
		setBorder.setBorderRight(CellStyle.BORDER_THIN);// 右边框

		//设置列的宽度
		sheet.setColumnWidth(0, 7000);
		sheet.setColumnWidth(1, 3766);
		sheet.setColumnWidth(2, 3766);
		sheet.setColumnWidth(3, 3766);
		sheet.setColumnWidth(4, 3766);
		sheet.setColumnWidth(5, 3766);
		sheet.setColumnWidth(6, 3766);
		sheet.setColumnWidth(7, 3766);
		sheet.setColumnWidth(8, 3766);
		sheet.setColumnWidth(9, 7000);
		sheet.setColumnWidth(10, 3766);
		sheet.setColumnWidth(11, 3766);
		sheet.setColumnWidth(12, 3766);
		
		//合并单元格
		sheet.addMergedRegion(new CellRangeAddress(0,0,0,12));
		sheet.addMergedRegion(new CellRangeAddress(1,1,0,12));
		
		// 居中显示
		CellStyle style1 = workbook.createCellStyle();
		style1.setAlignment(CellStyle.ALIGN_CENTER);
		// 居右显示
		CellStyle style2 = workbook.createCellStyle();
		style2.setAlignment(CellStyle.ALIGN_RIGHT);
		// 第一行标题
		HSSFRow row1 = sheet.createRow(rowIndex++);
		row1.setHeight((short)400);
		HSSFCell cell1 = row1.createCell(0);
		cell1.setCellStyle(style1);
		cell1.setCellValue("结算帐户明细表");
		// 2
		HSSFRow row2 = sheet.createRow(rowIndex++);
		row2.setHeight((short)400);
		HSSFCell cell2 = row2.createCell(0);
		cell2.setCellValue("时间范围："+query.getKssj()+" 00:00 至 "+query.getJssj()+" 23:59");
		//表格标题
		//员工姓名	晚到(次)	晚到日期	早走(次)	早走日期	无记录(次)	无记录日期	晚到原因	早走原因	无记录原因
		setBorder.setAlignment(CellStyle.ALIGN_CENTER);
		HSSFRow titleRow = sheet.createRow(rowIndex++);
		HSSFCell titleCell1 = titleRow.createCell(0);
		titleCell1.setCellStyle(setBorder);
		titleCell1.setCellValue("部门");
		HSSFCell titleCell2 = titleRow.createCell(1);
		titleCell2.setCellStyle(setBorder);
		titleCell2.setCellValue("所在区域");
		HSSFCell titleCell3 = titleRow.createCell(2);
		titleCell3.setCellStyle(setBorder);
		titleCell3.setCellValue("机器");
		HSSFCell titleCell4 = titleRow.createCell(3);
		titleCell4.setCellStyle(setBorder);
		titleCell4.setCellValue("姓名");
		HSSFCell titleCell5 = titleRow.createCell(4);
		titleCell5.setCellStyle(setBorder);
		titleCell5.setCellValue("卡号");
		HSSFCell titleCell6 = titleRow.createCell(5);
		titleCell6.setCellStyle(setBorder);
		titleCell6.setCellValue("人员编号");
		HSSFCell titleCell7 = titleRow.createCell(6);
		titleCell7.setCellStyle(setBorder);
		titleCell7.setCellValue("证件号码");
		HSSFCell titleCell8 = titleRow.createCell(7);
		titleCell8.setCellStyle(setBorder);
		titleCell8.setCellValue("交易金额");
		HSSFCell titleCell9 = titleRow.createCell(8);
		titleCell9.setCellStyle(setBorder);
		titleCell9.setCellValue("余额");
		HSSFCell titleCell10 = titleRow.createCell(9);
		titleCell10.setCellStyle(setBorder);
		titleCell10.setCellValue("交易日期");
		HSSFCell titleCell11 = titleRow.createCell(10);
		titleCell11.setCellStyle(setBorder);
		titleCell11.setCellValue("餐类");
		HSSFCell titleCell12 = titleRow.createCell(11);
		titleCell12.setCellStyle(setBorder);
		titleCell12.setCellValue("操作员");
		HSSFCell titleCell13 = titleRow.createCell(12);
		titleCell13.setCellStyle(setBorder);
		titleCell13.setCellValue("结算账户");
		
		for(int i = 0;i<list.size();i++){
			MessConsumeInfo info = list.get(i);
			HSSFRow recordRow = sheet.createRow(rowIndex++);
			HSSFCell recordCell1 = recordRow.createCell(0);
			recordCell1.setCellStyle(setBorder);
			recordCell1.setCellValue(info.getDepName());
			HSSFCell recordCell2 = recordRow.createCell(1);
			recordCell2.setCellStyle(setBorder);
			recordCell2.setCellValue(info.getRegion());
			HSSFCell recordCell3 = recordRow.createCell(2);
			recordCell3.setCellStyle(setBorder);
			recordCell3.setCellValue(info.getMachine());
			HSSFCell recordCell4 = recordRow.createCell(3);
			recordCell4.setCellStyle(setBorder);
			recordCell4.setCellValue(info.getUsername());
			HSSFCell recordCell5 = recordRow.createCell(4);
			recordCell5.setCellStyle(setBorder);
			recordCell5.setCellValue(info.getCardSerial());
			HSSFCell recordCell6 = recordRow.createCell(5);
			recordCell6.setCellStyle(setBorder);
			recordCell6.setCellValue(info.getUserNo());
			HSSFCell recordCell7 = recordRow.createCell(6);
			recordCell7.setCellStyle(setBorder);
			recordCell7.setCellValue(info.getCertificateNo());
			HSSFCell recordCell8 = recordRow.createCell(7);
			recordCell8.setCellStyle(setBorder);
			recordCell8.setCellValue(info.getMoney());
			HSSFCell recordCell9 = recordRow.createCell(8);
			recordCell9.setCellStyle(setBorder);
			recordCell9.setCellValue(info.getRemainMoney());
			HSSFCell recordCell10 = recordRow.createCell(9);
			recordCell10.setCellStyle(setBorder);
			String date = format.format(info.getTradeDate());
			recordCell10.setCellValue(date);
			HSSFCell recordCell11 = recordRow.createCell(10);
			recordCell11.setCellStyle(setBorder);
			recordCell11.setCellValue(info.getType());
			HSSFCell recordCell12 = recordRow.createCell(11);
			recordCell12.setCellStyle(setBorder);
			recordCell12.setCellValue(info.getOperator());
			HSSFCell recordCell13 = recordRow.createCell(12);
			recordCell13.setCellStyle(setBorder);
			recordCell13.setCellValue(info.getAccount());
		}
		HSSFRow recordRow = sheet.createRow(rowIndex++);
		HSSFCell recordCell1 = recordRow.createCell(8);
		recordCell1.setCellStyle(setBorder);
		recordCell1.setCellValue("总计：");
		HSSFCell recordCell2 = recordRow.createCell(9);
		recordCell2.setCellStyle(setBorder);
		recordCell2.setCellValue(total);
		String path = ExportExcel.class.getResource("/")+"excel/"+currUser.getUserLname()+"_messQuery.xls";
		path = path.substring(6);
		FileOutputStream out = new FileOutputStream(path);
		workbook.write(out);
		out.close();
	}

	/**
	 * 食堂消费查询结果
	 * @param username 
	 * @throws FileNotFoundException 
	 */
	public static void exportMessStatistics( MessQuery query, List<MessStatisticsInfo> list,
			DtUser currUser , MessSummary summary, Integer personal ) throws Exception{
		if(list==null||currUser==null||summary==null||query==null){
			return;
		}
		int rowIndex = 0;
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet();
		
		//考勤记录表格格式
		CellStyle setBorder = workbook.createCellStyle();
		setBorder.setWrapText(true);// 设置自动换行
		setBorder.setBorderBottom(CellStyle.BORDER_THIN); // 下边框
		setBorder.setBorderLeft(CellStyle.BORDER_THIN);// 左边框
		setBorder.setBorderTop(CellStyle.BORDER_THIN);// 上边框
		setBorder.setBorderRight(CellStyle.BORDER_THIN);// 右边框

		//设置列的宽度
		sheet.setColumnWidth(0, 5766);
		sheet.setColumnWidth(1, 7000);
		sheet.setColumnWidth(2, 3766);
		sheet.setColumnWidth(3, 3766);
		sheet.setColumnWidth(4, 3766);
		sheet.setColumnWidth(5, 3766);
		sheet.setColumnWidth(6, 3766);
		sheet.setColumnWidth(7, 3766);
		sheet.setColumnWidth(8, 3766);
		sheet.setColumnWidth(9, 3766);
		sheet.setColumnWidth(10, 3766);
		sheet.setColumnWidth(11, 3766);
		sheet.setColumnWidth(12, 3766);
		sheet.setColumnWidth(13, 3766);
		
		//合并单元格
		sheet.addMergedRegion(new CellRangeAddress(0,0,0,13));
		sheet.addMergedRegion(new CellRangeAddress(1,1,0,13));
		sheet.addMergedRegion(new CellRangeAddress(2,2,12,13));
		
		sheet.addMergedRegion(new CellRangeAddress(2,3,0,0));
		sheet.addMergedRegion(new CellRangeAddress(2,3,1,1));
		sheet.addMergedRegion(new CellRangeAddress(2,3,2,2));
		sheet.addMergedRegion(new CellRangeAddress(2,3,3,3));
		sheet.addMergedRegion(new CellRangeAddress(2,3,4,4));
		sheet.addMergedRegion(new CellRangeAddress(2,3,5,5));
		sheet.addMergedRegion(new CellRangeAddress(2,3,6,6));
		sheet.addMergedRegion(new CellRangeAddress(2,3,7,7));
		sheet.addMergedRegion(new CellRangeAddress(2,3,8,8));
		sheet.addMergedRegion(new CellRangeAddress(2,3,9,9));
		sheet.addMergedRegion(new CellRangeAddress(2,3,10,10));
		sheet.addMergedRegion(new CellRangeAddress(2,3,11,11));
		
		// 居中显示
		CellStyle style1 = workbook.createCellStyle();
		style1.setAlignment(CellStyle.ALIGN_CENTER);
		// 居右显示
		CellStyle style2 = workbook.createCellStyle();
		style2.setAlignment(CellStyle.ALIGN_RIGHT);
		// 第一行标题
		HSSFRow row1 = sheet.createRow(rowIndex++);
		row1.setHeight((short)400);
		HSSFCell cell1 = row1.createCell(0);
		cell1.setCellStyle(style1);
		cell1.setCellValue("营业报表");
		// 2
		HSSFRow row2 = sheet.createRow(rowIndex++);
		row2.setHeight((short)400);
		HSSFCell cell2 = row2.createCell(0);
		cell2.setCellValue("时间范围："+query.getKssj()+" 00:00 至 "+query.getJssj()+" 23:59");
		//表格标题
		//员工姓名	晚到(次)	晚到日期	早走(次)	早走日期	无记录(次)	无记录日期	晚到原因	早走原因	无记录原因
		setBorder.setAlignment(CellStyle.ALIGN_CENTER);
		HSSFRow titleRow = sheet.createRow(rowIndex++);
		HSSFCell titleCell1 = titleRow.createCell(0);
		titleCell1.setCellStyle(setBorder);
		titleCell1.setCellValue("日期");
		HSSFCell titleCell2 = titleRow.createCell(1);
		titleCell2.setCellStyle(setBorder);
		titleCell2.setCellValue("所在部门");
		HSSFCell titleCell3 = titleRow.createCell(2);
		titleCell3.setCellStyle(setBorder);
		if(personal==1){
			titleCell3.setCellValue("员工姓名");
		}else{
			titleCell3.setCellValue("区域");
		}
		HSSFCell titleCell4 = titleRow.createCell(3);
		titleCell4.setCellStyle(setBorder);
		titleCell4.setCellValue("机器");
		HSSFCell titleCell5 = titleRow.createCell(4);
		titleCell5.setCellStyle(setBorder);
		titleCell5.setCellValue("早餐");
		HSSFCell titleCell6 = titleRow.createCell(5);
		titleCell6.setCellStyle(setBorder);
		titleCell6.setCellValue("早餐笔数");
		HSSFCell titleCell7 = titleRow.createCell(6);
		titleCell7.setCellStyle(setBorder);
		titleCell7.setCellValue("中餐");
		HSSFCell titleCell8 = titleRow.createCell(7);
		titleCell8.setCellStyle(setBorder);
		titleCell8.setCellValue("中餐笔数");
		HSSFCell titleCell9 = titleRow.createCell(8);
		titleCell9.setCellStyle(setBorder);
		titleCell9.setCellValue("晚餐");
		HSSFCell titleCell10 = titleRow.createCell(9);
		titleCell10.setCellStyle(setBorder);
		titleCell10.setCellValue("晚餐笔数");
		HSSFCell titleCell11 = titleRow.createCell(10);
		titleCell11.setCellStyle(setBorder);
		titleCell11.setCellValue("夜宵");
		HSSFCell titleCell12 = titleRow.createCell(11);
		titleCell12.setCellStyle(setBorder);
		titleCell12.setCellValue("夜宵笔数");
		HSSFCell titleCell13 = titleRow.createCell(12);
		titleCell13.setCellStyle(setBorder);
		titleCell13.setCellValue("小计");
		HSSFCell titleCell14 = titleRow.createCell(13);
		titleCell14.setCellStyle(setBorder);
		titleCell14.setCellValue(new HSSFRichTextString(""));

		HSSFRow titleRow1 = sheet.createRow(rowIndex++);
		for(int i = 0;i<12;i++){
			HSSFCell titleCell44 = titleRow1.createCell(i);
			titleCell44.setCellStyle(setBorder);
			titleCell44.setCellValue(new HSSFRichTextString(""));
		}
		HSSFCell titleCell21 = titleRow1.createCell(12);
		titleCell21.setCellStyle(setBorder);
		titleCell21.setCellValue("金额小计");
		HSSFCell titleCell22 = titleRow1.createCell(13);
		titleCell22.setCellStyle(setBorder);
		titleCell22.setCellValue("笔数小计");
		
		for(int i = 0;i<list.size();i++){
			MessStatisticsInfo info = list.get(i);
			HSSFRow recordRow = sheet.createRow(rowIndex++);
			HSSFCell recordCell1 = recordRow.createCell(0);
			recordCell1.setCellStyle(setBorder);
			recordCell1.setCellValue(info.getDate());
			HSSFCell recordCell2 = recordRow.createCell(1);
			recordCell2.setCellStyle(setBorder);
			recordCell2.setCellValue(info.getDepName());
			HSSFCell recordCell3 = recordRow.createCell(2);
			recordCell3.setCellStyle(setBorder);
			recordCell3.setCellValue(info.getRegion());
			HSSFCell recordCell4 = recordRow.createCell(3);
			recordCell4.setCellStyle(setBorder);
			recordCell4.setCellValue(info.getMachine());
			HSSFCell recordCell5 = recordRow.createCell(4);
			recordCell5.setCellStyle(setBorder);
			recordCell5.setCellValue(info.getZaocMoney());
			HSSFCell recordCell6 = recordRow.createCell(5);
			recordCell6.setCellStyle(setBorder);
			recordCell6.setCellValue(info.getZaocCount());
			HSSFCell recordCell7 = recordRow.createCell(6);
			recordCell7.setCellStyle(setBorder);
			recordCell7.setCellValue(info.getZcMoney());
			HSSFCell recordCell8 = recordRow.createCell(7);
			recordCell8.setCellStyle(setBorder);
			recordCell8.setCellValue(info.getZcCount());
			HSSFCell recordCell9 = recordRow.createCell(8);
			recordCell9.setCellStyle(setBorder);
			recordCell9.setCellValue(info.getWcMoney());
			HSSFCell recordCell10 = recordRow.createCell(9);
			recordCell10.setCellStyle(setBorder);
			recordCell10.setCellValue(info.getWcCount());
			HSSFCell recordCell11 = recordRow.createCell(10);
			recordCell11.setCellStyle(setBorder);
			recordCell11.setCellValue(info.getYxMoney());
			HSSFCell recordCell12 = recordRow.createCell(11);
			recordCell12.setCellStyle(setBorder);
			recordCell12.setCellValue(info.getYxCount());
			HSSFCell recordCell13 = recordRow.createCell(12);
			recordCell13.setCellStyle(setBorder);
			recordCell13.setCellValue(info.getTotalPrice());
			HSSFCell recordCell14 = recordRow.createCell(13);
			recordCell14.setCellStyle(setBorder);
			recordCell14.setCellValue(info.getTotalCount());
		}
		//汇总结果数据
		HSSFRow totalRow = sheet.createRow(rowIndex++);
		HSSFCell recordCell1 = totalRow.createCell(3);
		recordCell1.setCellStyle(setBorder);
		recordCell1.setCellValue("汇总：");
		HSSFCell recordCell2 = totalRow.createCell(4);
		recordCell2.setCellStyle(setBorder);
		recordCell2.setCellValue(summary.getZaocMoney());
		HSSFCell recordCell3 = totalRow.createCell(5);
		recordCell3.setCellStyle(setBorder);
		recordCell3.setCellValue(summary.getZaocCount());
		HSSFCell recordCell4 = totalRow.createCell(6);
		recordCell4.setCellStyle(setBorder);
		recordCell4.setCellValue(summary.getZcMoney());
		HSSFCell recordCell5 = totalRow.createCell(7);
		recordCell5.setCellStyle(setBorder);
		recordCell5.setCellValue(summary.getZcCount());
		HSSFCell recordCell6 = totalRow.createCell(8);
		recordCell6.setCellStyle(setBorder);
		recordCell6.setCellValue(summary.getWcMoney());
		HSSFCell recordCell7 = totalRow.createCell(9);
		recordCell7.setCellStyle(setBorder);
		recordCell7.setCellValue(summary.getWcCount());
		HSSFCell recordCell8 = totalRow.createCell(10);
		recordCell8.setCellStyle(setBorder);
		recordCell8.setCellValue(summary.getYxMoney());
		HSSFCell recordCell9 = totalRow.createCell(11);
		recordCell9.setCellStyle(setBorder);
		recordCell9.setCellValue(summary.getYxCount());
		HSSFCell recordCell10 = totalRow.createCell(12);
		recordCell10.setCellStyle(setBorder);
		recordCell10.setCellValue(summary.getTotalPrice());
		HSSFCell recordCell11 = totalRow.createCell(13);
		recordCell11.setCellStyle(setBorder);
		recordCell11.setCellValue(summary.getTotalCount());
		
		String path = ExportExcel.class.getResource("/")+"excel/"+currUser.getUserLname()+"_messStatistics.xls";
		path = path.substring(6);
		FileOutputStream out = new FileOutputStream(path);
		workbook.write(out);
		out.close();
	}
	
	/**
	 * 个人记录导出  导出excel
	 * @param username 
	 * @throws FileNotFoundException 
	 */
	public static void exportQueryDetail(String title,String columnName, List<KqRecord> list, String username ) throws Exception{
		int rowIndex = 0;
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet();
		
		//考勤记录表格格式
		CellStyle setBorder = workbook.createCellStyle();
		setBorder.setWrapText(true);// 设置自动换行
		setBorder.setBorderBottom(CellStyle.BORDER_THIN); // 下边框
		setBorder.setBorderLeft(CellStyle.BORDER_THIN);// 左边框
		setBorder.setBorderTop(CellStyle.BORDER_THIN);// 上边框
		setBorder.setBorderRight(CellStyle.BORDER_THIN);// 右边框

		//设置列的宽度
		sheet.setColumnWidth(0, 3766);
		sheet.setColumnWidth(1, 7000);
		sheet.setColumnWidth(2, 7000);
		
		//合并单元格
		sheet.addMergedRegion(new CellRangeAddress(0,0,0,2));
		// 居中显示
		CellStyle style1 = workbook.createCellStyle();
		style1.setAlignment(CellStyle.ALIGN_CENTER);
		// 第一行标题
		HSSFRow row1 = sheet.createRow(rowIndex++);
		row1.setHeight((short)400);
		HSSFCell cell1 = row1.createCell(0);
		cell1.setCellStyle(style1);
		cell1.setCellValue(title);
		//表格标题
		setBorder.setAlignment(CellStyle.ALIGN_LEFT);
		HSSFRow titleRow = sheet.createRow(rowIndex++);
		HSSFCell titleCell1 = titleRow.createCell(0);
		titleCell1.setCellStyle(setBorder);
		titleCell1.setCellValue("员工姓名");
		HSSFCell titleCell2 = titleRow.createCell(1);
		titleCell2.setCellStyle(setBorder);
		titleCell2.setCellValue("所属部门");
		HSSFCell titleCell4 = titleRow.createCell(2);
		titleCell4.setCellStyle(setBorder);
		titleCell4.setCellValue(columnName);
		
		for(int i = 0;i<list.size();i++){
			HSSFRow recordRow = sheet.createRow(rowIndex++);
			HSSFCell recordCell1 = recordRow.createCell(0);
			recordCell1.setCellStyle(setBorder);
			recordCell1.setCellValue(list.get(i).getUsername());
			HSSFCell recordCell2 = recordRow.createCell(1);
			recordCell2.setCellStyle(setBorder);
			recordCell2.setCellValue(list.get(i).getDepName());
			HSSFCell recordCell4 = recordRow.createCell(2);
			recordCell4.setCellStyle(setBorder);
			recordCell4.setCellValue(list.get(i).getDate());
			}
		String path = ExportExcel.class.getResource("/")+"excel/"+username+"_personal.xls";
		path = path.substring(6);
		FileOutputStream out = new FileOutputStream(path);
		workbook.write(out);
		out.close();
	}
	
	public static void exportDepNum( List<DepNum> list, String username ,int total ) throws Exception{

		int rowIndex = 0;
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet();
		
		//考勤记录表格格式
		CellStyle setBorder = workbook.createCellStyle();
		setBorder.setWrapText(true);// 设置自动换行
		setBorder.setBorderBottom(CellStyle.BORDER_THIN); // 下边框
		setBorder.setBorderLeft(CellStyle.BORDER_THIN);// 左边框
		setBorder.setBorderTop(CellStyle.BORDER_THIN);// 上边框
		setBorder.setBorderRight(CellStyle.BORDER_THIN);// 右边框

		//设置列的宽度
		sheet.setColumnWidth(0, 7000);
		sheet.setColumnWidth(1, 3766);
		sheet.setColumnWidth(2, 7000);
		sheet.setColumnWidth(3, 3766);
		
		//合并单元格
		sheet.addMergedRegion(new CellRangeAddress(0,0,0,3));
		
		// 居中显示
		CellStyle style1 = workbook.createCellStyle();
		style1.setAlignment(CellStyle.ALIGN_CENTER);
		// 居右显示
		CellStyle style2 = workbook.createCellStyle();
		style2.setAlignment(CellStyle.ALIGN_RIGHT);
		// 第一行标题
		HSSFRow row1 = sheet.createRow(rowIndex++);
		row1.setHeight((short)400);
		HSSFCell cell1 = row1.createCell(0);
		cell1.setCellStyle(style1);
		cell1.setCellValue("各部门就餐人数统计表");
		//表格标题
		//员工姓名	晚到(次)	晚到日期	早走(次)	早走日期	无记录(次)	无记录日期	晚到原因	早走原因	无记录原因
		setBorder.setAlignment(CellStyle.ALIGN_CENTER);
		HSSFRow titleRow = sheet.createRow(rowIndex++);
		HSSFCell titleCell1 = titleRow.createCell(0);
		titleCell1.setCellStyle(setBorder);
		titleCell1.setCellValue("部门名称");
		HSSFCell titleCell2 = titleRow.createCell(1);
		titleCell2.setCellStyle(setBorder);
		titleCell2.setCellValue("部门编号");
		HSSFCell titleCell3 = titleRow.createCell(2);
		titleCell3.setCellStyle(setBorder);
		titleCell3.setCellValue("上级部门");
		HSSFCell titleCell4 = titleRow.createCell(3);
		titleCell4.setCellStyle(setBorder);
		titleCell4.setCellValue("可用餐人数");
		
		for(int i = 0;i<list.size();i++){
			DepNum info = list.get(i);
			HSSFRow recordRow = sheet.createRow(rowIndex++);
			HSSFCell recordCell1 = recordRow.createCell(0);
			recordCell1.setCellStyle(setBorder);
			recordCell1.setCellValue(info.getDepName());
			HSSFCell recordCell2 = recordRow.createCell(1);
			recordCell2.setCellStyle(setBorder);
			recordCell2.setCellValue(info.getDepNo());
			HSSFCell recordCell3 = recordRow.createCell(2);
			recordCell3.setCellStyle(setBorder);
			recordCell3.setCellValue(info.getDepParent());
			HSSFCell recordCell4 = recordRow.createCell(3);
			recordCell4.setCellStyle(setBorder);
			recordCell4.setCellValue(info.getNum());
		}
		HSSFRow recordRow = sheet.createRow(rowIndex++);
		HSSFCell recordCell1 = recordRow.createCell(2);
		recordCell1.setCellStyle(setBorder);
		recordCell1.setCellValue("总计：");
		HSSFCell recordCell2 = recordRow.createCell(3);
		recordCell2.setCellStyle(setBorder);
		recordCell2.setCellValue(total);
		String path = ExportExcel.class.getResource("/")+"excel/"+username+"_depNum.xls";
		path = path.substring(6);
		FileOutputStream out = new FileOutputStream(path);
		workbook.write(out);
		out.close();
	
	}
	
}

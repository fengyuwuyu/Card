package com.cecep.controller.kq;

import java.io.FileInputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.cecep.model.DtUser;
import com.cecep.model.KqSjManage;
import com.cecep.model.kq.KqQuery;
import com.cecep.model.kq.KqRecord;
import com.cecep.model.kq.WorkTime;
import com.cecep.service.kq.KqRecordServiceI;
import com.cecep.util.ExportExcel;
import com.cecep.util.ThreadPool;

/**
 * 打卡记录查询
 * 
 * @author lilei
 * 
 */
@Controller
@RequestMapping(value = "kqRecordController")
@SessionAttributes(value = "currUser")
public class KqRecordController {

	private KqRecordServiceI kqRecordService;
	private Logger log = Logger.getLogger(KqRecordController.class);

	@Autowired
	public void setkqRecordService(KqRecordServiceI kqRecordService) {
		this.kqRecordService = kqRecordService;
	}

	/**
	 * 返回考勤统计分析结果
	 * */
	@RequestMapping(value = "dataList.do")
	@ResponseBody
	public Map<String, Object> dataList(@ModelAttribute("currUser") DtUser currUser, KqQuery record,
			HttpServletRequest request, HttpServletResponse response) {
		return this.kqRecordService.dataList(record,currUser);
	}
	
	/**
	 * 根据条件查询加班记录
	 */
	@RequestMapping(value = "personalQuery.do")
	public String personalQuery(@ModelAttribute("currUser") final DtUser currUser,String cardSerial, String depName, KqQuery query, Model model) {
		final int queryType = query.getQueryType();
		String temp = "迟到";
		String title = "刷卡时间";
		switch(queryType){
		case 1:
			break;
		case 2:
			temp = "早退";
			break;
		case 3:
			temp = "外出";
			title = "外出日期";
			break;
		case 4:
			temp = "加班";
			break;
		}
		final String tt = "个人"+temp+"记录查询结果，日期"+query.getKssj()+"至"+query.getJssj();
		List<String> jbList = this.kqRecordService.getRecordDataList(query);
		String username = null;
		try {
			username = new String((query.getUsername()).getBytes("iso-8859-1"),"UTF-8");
			depName = new String(depName.getBytes("iso-8859-1"), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		final List<KqRecord> list = new ArrayList<KqRecord>();
		for (String date : jbList) {
			if(queryType!=3){
				KqRecord record = new KqRecord(username, depName, cardSerial, date.substring(0, 19));
				list.add(record);
			}else{
				KqRecord record = new KqRecord(username, depName, cardSerial, date);
				list.add(record);
			}
		}
		//导出Excel
		ThreadPool.execute(new Runnable() {
			
			public void run() {
				try {
					String title1 = "刷卡时间";
					if(queryType==3){
						title1 = "外出日期";
					}
					ExportExcel.exportQueryDetail(tt, title1, list, currUser.getUserLname());
				}catch (Exception e) {
					log.error(e);
					e.printStackTrace();
				}
			}
		});
		model.addAttribute("title", title);
		model.addAttribute("list", list);
		return "view/kq/personalQuery";
	}
	

	/**
	 * 返回上班时间列表
	 */
	@RequestMapping(value = "sbsj.do")
	@ResponseBody
	public List<WorkTime> beginWorkTime(HttpServletRequest request,
			HttpServletResponse response) {
		return this.kqRecordService.getBeginWorkTime();
	}

	/**
	 * 返回下班时间列表
	 */
	@RequestMapping(value = "xbsj.do")
	@ResponseBody
	public List<WorkTime> endWorkTime(HttpServletRequest request,
			HttpServletResponse response) {
		return this.kqRecordService.getEndWorkTime();
	}

	@RequestMapping(value = "exportExcel.do")
	public void download(@ModelAttribute("currUser") DtUser currUser, int type , String filename, HttpServletRequest request, HttpServletResponse response) throws Exception{
		String username = currUser.getUserLname();
		FileInputStream in  = null;
		if(type==1){
			response.setHeader("Content-Disposition", "attachment;filename=Work.xls");
			response.setContentType("application/x-excel;charset=utf-8");
			in = new FileInputStream((KqRecordController.class.getResource("/")+"excel/"+username+filename).substring(6));
//			in = new FileInputStream((KqRecordController.class.getResource("/")+"excel/"+username+"_detail.xls").substring(6));
		}else if(type==2){
			response.setHeader("Content-Disposition", "attachment;filename=Work.doc");
			response.setContentType("application/vnd.openxmlformats-officedocument.wordprocessingml.document;charset=utf-8");
			in = new FileInputStream((KqRecordController.class.getResource("/")+"excel/"+username+"_work.doc").substring(6));
		}
		IOUtils.copy(in, response.getOutputStream());
	}
	
	@RequestMapping("kqQuery.do")
	@ResponseBody
	public Map<String,Object> kqQuery(@ModelAttribute("currUser") final DtUser currUser,KqQuery query){
		return this.kqRecordService.kqQuery(currUser,query);
	}
	
	/**
	 * 返回个人刷卡异常记录
	 */
	@RequestMapping("kqDescribe.do")
	@ResponseBody
	public Map<String,Object> kqDescribe(@ModelAttribute("currUser") final DtUser currUser,KqQuery query){
		return this.kqRecordService.kqDescribe(currUser,query);
	}
	
	@RequestMapping("kqSjManageDataList.do")
	@ResponseBody
	public Map<String,Object> kqSjManageDataList(){
		return this.kqRecordService.kqSjManageDataList();
	}
	
	@RequestMapping("kqSjManageSave.do")
	@ResponseBody
	public Map<String,Object> kqSjManageSave(KqSjManage query){
		return this.kqRecordService.kqSjManageSave(query);
	}
	
	@RequestMapping("kqSjManageGetById.do")
	@ResponseBody
	public Map<String,Object> kqSjManageGetById(KqSjManage query){
		return this.kqRecordService.kqSjManageGetById(query);
	}
}

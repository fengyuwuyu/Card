package com.cecep.service.impl;

import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cecep.dao.VisitorRecordMapper;
import com.cecep.model.VisitorRecord;
import com.cecep.service.VisitorRecordServiceI;
import com.cecep.util.EETemplate;
@Service("visitorRecordService")
public class VisitorRecordServiceImpl implements VisitorRecordServiceI {

	private VisitorRecordMapper visitorRecordMapper;
	
	@Autowired
	public void setVisitorRecordMapper(VisitorRecordMapper visitorRecordMapper) {
		this.visitorRecordMapper = visitorRecordMapper;
	}


	public Map<String, Object> dataList(VisitorRecord record) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<VisitorRecord> list = this.visitorRecordMapper.selectByPage(record);
		Integer count = this.visitorRecordMapper.selectCount(record);
		map.put("rows", list);
		map.put("total",count);
		return map;
	}


	public void export(VisitorRecord record, HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<VisitorRecord> list = this.visitorRecordMapper.export(record);
		EETemplate<VisitorRecord> ee = new EETemplate<VisitorRecord>();
		String[] headers = { "姓名", "性别", "民族", "家庭地址", "身份证号", "单位", "电话", "邮箱", "访问时间", "来访是由", "受访人员", "受访人员电话", "受访单位", "来访备注" };
		String[] fields = { "userLname", "userSex", "userNation", "userAddress", "userId", "userDepname", "userTelephone", "userEmail", "time", "visitorReason", "visitorUser", "visitorPhone", "visitorDep", "visitorDes" };
		response.setContentType("octets/stream");
		Date currentTime = Calendar.getInstance().getTime();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
		String fileName = sdf.format(currentTime) + ".xls";
		response.addHeader("Content-Disposition","attachment;filename=" + fileName);
		OutputStream out = response.getOutputStream();
		ee.callExportExcel("访客记录详情", headers, fields, list, out);
		out.close();
	}

}

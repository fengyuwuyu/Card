package com.cecep.service.impl;



import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;


import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cecep.dao.DtCardMapper;
import com.cecep.dao.DtUserMapper;
import com.cecep.dao.VisitorBlacklistMapper;
import com.cecep.dao.VisitorRecordMapper;
import com.cecep.model.DtAcType;
import com.cecep.model.DtCard;
import com.cecep.model.DtDep;
import com.cecep.model.DtUser;
import com.cecep.model.VisitorBlacklist;
import com.cecep.model.VisitorRecord;
import com.cecep.service.VisitorBlacklistServiceI;
import com.cecep.util.CommonsUtil;
import com.cecep.util.EETemplate;
@Service("visitorBlacklistService")
public class VisitorBlacklistServiceImpl implements VisitorBlacklistServiceI {
	
	private VisitorBlacklistMapper visitorBlacklistMapper;
	private DtUserMapper dtUserMapper;
	private VisitorRecordMapper visitorRecordMapper;
	private DtCardMapper dtCardMapper;
	
	@Autowired
	public void setDtCardMapper(DtCardMapper dtCardMapper) {
		this.dtCardMapper = dtCardMapper;
	}
	
	@Autowired
	public void setVisitorBlacklistMapper(
			VisitorBlacklistMapper visitorBlacklistMapper) {
		this.visitorBlacklistMapper = visitorBlacklistMapper;
	}
	
	@Autowired
	public void setDtUserMapper(DtUserMapper dtUserMapper) {
		this.dtUserMapper = dtUserMapper;
	}
	
	@Autowired
	public void setVisitorRecordMapper(VisitorRecordMapper visitorRecordMapper) {
		this.visitorRecordMapper = visitorRecordMapper;
	}

	public Map<String, Object> dataList(VisitorBlacklist record) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<VisitorBlacklist> list = this.visitorBlacklistMapper.selectByPage(record);
		Integer count = this.visitorBlacklistMapper.selectCount(record);
		map.put("rows", list);
		map.put("total",count);
		return map;
	}


	public Map<String, Object> delete(VisitorBlacklist record) {
		Map<String, Object> map = new HashMap<String, Object>();
		this.visitorBlacklistMapper.updateByPrimaryKeySelective(record);		
		map.put("success", true);
		return map;
	}


	public Map<String, Object> getById(VisitorBlacklist record) {
		Map<String, Object> map = new HashMap<String, Object>();
		VisitorBlacklist visitor = this.visitorBlacklistMapper.selectByPrimaryKey(record.getId());
		map.put("data", visitor);	
		map.put("success", true);
		return map;
	}


	public Map<String, Object> save(VisitorBlacklist visitor,DtUser user) {
		Map<String, Object> map = new HashMap<String, Object>();		
		if(visitor.getId() == null) { 
	        Integer count = this.visitorBlacklistMapper.selectBySelective(visitor);
			if(count == 0) {
				this.dtUserMapper.updateUserSerial();
				Integer serial = this.dtUserMapper.selectMaxUserSerial();
				String userSerial = String.valueOf(serial);
				//序号				
				visitor.setUserSerial(Long.parseLong(userSerial));
				user.setUserSerial(Long.parseLong(userSerial));
				//TODO 工号
				user.setUserNo("00000000");
				//TODO 角色主键
				user.setRoleId(3);
				this.dtUserMapper.insertRoleUser(user);					
				//考勤密码
				user.setUserPassword("123456");
				//TODO 状态
				user.setUserType((short)36);
				//业务无关
				user.setUserFinger("0000000000");
				user.setUserLevel(0);
				user.setUserPhoto(0);
				user.setKqTiaoxiu(0);
				user.setUserAc(0);
				this.visitorBlacklistMapper.insert(visitor);
				this.dtUserMapper.insert(user);				
				//TODO 账户编号
				user.setAcBh("0000000000000002");
				DtAcType ac = this.dtUserMapper.selectDtAcTypeByPrimaryKey(user.getAcBh());
				Integer limit = ac.getAcLimit();
				Integer unit = ac.getAcUnit();
				Date sj = ac.getAcJssj();
				Calendar calendar = Calendar.getInstance();
				Calendar calendar2 = Calendar.getInstance();
				Date date = calendar.getTime();
				SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
				Random rand = new Random();	
				//账户开始时间
				user.setAcBegin(date);
				//账户结束时间
				if(limit == 0 && sj != null) {				
					user.setAcEnd(sj);
				}else {
					if(unit ==0) {					
						int year = calendar2.get(Calendar.YEAR);
						year = year + limit;
						calendar2.set(Calendar.YEAR, year);
						user.setAcEnd(calendar2.getTime());
					}else if(unit ==1) {
						int month = calendar2.get(Calendar.MONTH);
						month = month + limit;
						calendar2.set(Calendar.MONTH, month);
						user.setAcEnd(calendar2.getTime());
					}else if(unit ==2) {
						int day = calendar2.get(Calendar.DAY_OF_MONTH);
						day = day + limit;
						calendar2.set(Calendar.DAY_OF_MONTH, day);
						user.setAcEnd(calendar2.getTime());
					}				
				}
				//业务无关
				user.setUser1(sdf.format(date) + rand.nextInt(100));
				this.dtUserMapper.insertDtAcUser(user);
				this.dtUserMapper.updateUserAcByPrimaryKey(user.getUserSerial());
				this.dtUserMapper.insertDtAcLink(user);
				this.dtUserMapper.insertWtPublic(user);
				map.put("userSerial", visitor.getUserSerial());
				map.put("success", true);
			}else {	
				map.put("msg", "注册失败，该身份证号已注册！");	
				map.put("success", false);								
			}
		}else {
			this.dtUserMapper.updateByPrimaryKeySelective(user);
			map.put("userSerial", visitor.getUserSerial());
			map.put("success", true);
		}		
		return map;
	}

	public Map<String, Object> openCard(VisitorRecord visitor, DtCard card, Integer userDep) {	
		Map<String, Object> map = new HashMap<String, Object>();	
		Integer count = this.visitorBlacklistMapper.selectDtCardBySelective(card);
		if(count == 0) {
			this.visitorBlacklistMapper.updateCardSerial();
			Integer serial = this.visitorBlacklistMapper.selectMaxCardSerial();
			String cardSerial = String.valueOf(serial);
			//卡片序号
			card.setCardSerial("00000000".substring(0, 8 - cardSerial.length()) + cardSerial);
			//存储过程类型--预处理
			card.setLx(0);
			//卡片类型
			card.setCardLx(8);
			//卡片状态
			card.setCardType(4);
			//业务无关
			card.setDevSerial("");			
			card.setAcType("");
			card.setJmkh("");			
			card.setCardWork(0);			
			card.setRegSerial("");
			this.visitorBlacklistMapper.openCard(card);
			//存储过程类型--更新结果状态
			card.setLx(1);
			//卡片状态
			card.setCardType(0);
			this.visitorBlacklistMapper.openCard(card);	
			DtDep dep = this.dtUserMapper.selectDtDepByPrimaryKey(Long.parseLong(userDep + ""));
			//受访部门
			visitor.setVisitorDep(dep.getDepName());
			this.visitorRecordMapper.insert(visitor);	
			map.put("msg", "开卡成功。");	
			map.put("success", true);			
		}else {
			map.put("msg", "开卡失败，此卡片正在使用中。");	
			map.put("success", false);				
		}	
		return map;
	}

	public Map<String, Object> returnCard(DtCard record) {
		Map<String, Object> map = new HashMap<String, Object>();
		//存储过程类型--预处理
		record.setLx(0);
		//卡片状态
		record.setCardType(4);
		//业务无关
		record.setCardVerify("");
		record.setCardForm("");		
		record.setRegSerial("");
		record.setVersionNo(0);
		this.visitorBlacklistMapper.returnCard(record);	
		//存储过程类型--更新结果状态
		record.setLx(1);
		//卡片状态
		record.setCardType(2);
		this.visitorBlacklistMapper.returnCard(record);
		map.put("msg", "退卡成功");	
		map.put("success", true);				
		return map;
	}

	public void returnCard2() {
		VisitorBlacklist record = new VisitorBlacklist();
		record.setCardLx(0);
		List<DtCard> list = this.visitorBlacklistMapper.selectDtCard();
		if(list.size() > 0) {
			for(DtCard card:list) {
				//存储过程类型--预处理
				card.setLx(0);
				//卡片状态
				card.setCardType(4);
				//业务无关
				card.setCardVerify("");
				card.setCardForm("");		
				card.setRegSerial("");
				card.setVersionNo(0);
				this.visitorBlacklistMapper.returnCard2(card);	
				//存储过程类型--更新结果状态
				card.setLx(1);
				//卡片状态
				card.setCardType(2);
				this.visitorBlacklistMapper.returnCard2(card);
			}
		}
	}
	
	/**
	 * 退掉达到截止日期的卡
	 */
	public void returnCard3() {
		List<DtCard> list = this.visitorBlacklistMapper.selectDtCardByDeadline();
		if(list.size() > 0) {
			for(DtCard card:list) {
				card.setDeadline(null);
				this.dtCardMapper.updateDeadline(card);
				card.setIp(CommonsUtil.getLocalIp());
				card.setGlyNo("system");
				//存储过程类型--预处理
				card.setLx(0);
				//卡片状态
				card.setCardType(4);
				//业务无关
				card.setCardVerify("");
				card.setCardForm("");		
				card.setRegSerial("");
				card.setVersionNo(0);
				this.visitorBlacklistMapper.returnCard2(card);	
				//存储过程类型--更新结果状态
				card.setLx(1);
				//卡片状态
				card.setCardType(2);
				this.visitorBlacklistMapper.returnCard2(card);
			}
		}
	}

	public void export(VisitorBlacklist record, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		List<VisitorBlacklist> list = this.visitorBlacklistMapper.export(record);
		EETemplate<VisitorBlacklist> ee = new EETemplate<VisitorBlacklist>();
		String[] headers = { "姓名", "性别", "民族", "家庭地址", "身份证号", "单位", "电话", "邮箱", "登记|修改时间", "开卡次数", "系统退卡次数", "手动还卡次数" };
		String[] fields = { "userLname", "userSex", "userNation", "userAddress", "userId", "userDepname", "userTelephone", "userEmail", "userSj", "count", "autoCount", "manualCount" };
		response.setContentType("octets/stream");
		Date currentTime = Calendar.getInstance().getTime();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
		String fileName = sdf.format(currentTime) + ".xls";
		response.addHeader("Content-Disposition","attachment;filename=" + fileName);
		OutputStream out = response.getOutputStream();
		ee.callExportExcel("访客名单", headers, fields, list, out);
		out.close();
	}

	



	

}

package com.cecep.service.impl;

import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cecep.dao.MedAccountMapper;
import com.cecep.model.DtDep;
import com.cecep.model.DtUser;
import com.cecep.model.MedAccount;
import com.cecep.service.MedAccountServiceI;
import com.cecep.util.EETemplate;


@Service("medAccountService")
public class MedAccountServiceImpl implements MedAccountServiceI {
	MedAccountMapper  medAccountMapper;
	
	@Autowired
	public void setMedAccountMapper(MedAccountMapper medAccountMapper) {
		this.medAccountMapper = medAccountMapper;
	}

	public Map<String, Object> dataList(MedAccount record) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MedAccount> list = this.medAccountMapper.selectCardNum(record);
		if(list.size()>0){
			for (MedAccount medAccount : list) {
				int  i=this.medAccountMapper.getNum(medAccount.getUserSerial()); //查询卡号是否在医药账户里        
				if(i==0){//如果是0  插入数据创建医药账户
					this.medAccountMapper.insertCardHao(medAccount.getUserSerial());
				}
			}
		}
		List<MedAccount> list1 = this.medAccountMapper.selectByPage(record);
		Integer count = this.medAccountMapper.selectCount(record);
		map.put("rows", list1);
		map.put("total",count);
		return map;
	}

	public Map<String, Object> getById(MedAccount record) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		MedAccount medaccount = this.medAccountMapper.selectEmployeeByKey(record.getUserSerial());
		resultMap.put("data", medaccount);	
		resultMap.put("success", true);
		return resultMap;
	}
	
	
	
	public Map<String, Object> save(MedAccount record) {
		Map<String, Object> map = new HashMap<String, Object>();
		this.medAccountMapper.updateByPrimaryKey(record);		
		map.put("success", true);
		return map;
	}
	
	
	
	
	/**
	 * 充值记录
	 */
	public Map<String, Object> rechargeList(MedAccount record) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MedAccount> list1 = this.medAccountMapper.selectCardNum(record);
		if(list1.size()>0){
			for (MedAccount medAccount : list1) {
				int  i=this.medAccountMapper.getNum(medAccount.getUserSerial()); //查询卡号是否在医药账户里        
				if(i==0){//如果是0  插入数据创建医药账户
					this.medAccountMapper.insertCardHao(medAccount.getUserSerial());
				}
			}
		}
		List<MedAccount> list = this.medAccountMapper.selectByPage1(record);
		Integer count = this.medAccountMapper.selectCount1(record);
		map.put("rows", list);
		map.put("total",count);
		return map;
	}
	
	
	public Map<String, Object> saveMoney(MedAccount record) {
		Map<String, Object> map = new HashMap<String, Object>();
		String  AccountId[]= record.getAccountIds().split(",");
		for (String string : AccountId) {
			record.setCardNumber(Integer.parseInt(string));
			this.medAccountMapper.rechargeMoney(record);//修改充值金额	
			this.medAccountMapper.addMedicineRecord(record);//添加充值金额记录  
		}
		map.put("success", true);
		return map;
	}

	public int cardnum(Integer userno) {
		int card=this.medAccountMapper.cardnum(userno);
		return card;
	}
	
	public Map<String, Object> dtUserList(MedAccount record) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MedAccount> list = this.medAccountMapper.selectByPage2(record);
		Integer count = this.medAccountMapper.selectCount2(record);
		map.put("rows", list);
		map.put("total",count);
		return map;
	}

	public Map<String, Object> updateMoney(MedAccount record) {
		Map<String, Object> map = new HashMap<String, Object>();
		this.medAccountMapper.updateMoney1(record);
		this.medAccountMapper.updateMoney2(record);	
		/**
		 * 添加充值记录
		 */
		this.medAccountMapper.addrecord(record);	
		
		map.put("success", true);
		return map;
	}
	
	public Map<String, Object> userMessageGrid(MedAccount record) {
		Map<String, Object> map = new HashMap<String, Object>();
		Integer  dep=record.getDepSerial();
		if(dep!=0){
			List<MedAccount> list = this.medAccountMapper.selectByPage5(record);
			Integer count = this.medAccountMapper.selectCount5(record);
			map.put("rows", list);
			map.put("total",count);
		}else{
			List<MedAccount> list = this.medAccountMapper.selectByPage3(record);
			Integer count = this.medAccountMapper.selectCount3(record);
			map.put("rows", list);
			map.put("total",count);	
		}
		return map;
	}
	
	
	public Map<String, Object> dataList1(MedAccount record) {
		Map<String, Object> map = new HashMap<String, Object>();
		String  type=record.getSelectType();
		if("1".equals(type)){
			List<MedAccount> list1 = this.medAccountMapper.selectByPage4(record);
			Integer count = this.medAccountMapper.selectCount4(record);
			map.put("rows", list1);
			map.put("total",count);
		}else{
			List<MedAccount> list1 = this.medAccountMapper.selectByPage10(record);
			Integer count = this.medAccountMapper.selectCount10(record);
			map.put("rows", list1);
			map.put("total",count);
		}
		
		return map;
	}
	
	
	
	public Map<String, Object> ExportExcel1(MedAccount record,HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String  type=record.getSelectType();
		EETemplate<MedAccount>  eet=new  EETemplate<MedAccount>();
		response.setContentType("octets/stream");
		Date current = Calendar.getInstance().getTime();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
		String fileName = sdf.format(current) + ".xls";
		response.addHeader("Content-Disposition","attachment;filename=" + fileName);
		OutputStream out=null;
		try {
			out = response.getOutputStream();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		if("1".equals(type)){
			String [] str = record.getDepSerials().split(",");  
			List<Integer> list=new ArrayList<Integer>();
			for (String string : str) {
				list.add(Integer.parseInt(string));
			}
			record.setResult(list);
			List<MedAccount> list1 = this.medAccountMapper.selectByPage6(record);
			String[] headers={"单位","充值金额"};
			String[] fields={"depName","amount1"};
			try {
				eet.callExportExcel("单位充值信息", headers, fields, list1,out);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else{
			List<MedAccount> list1 = this.medAccountMapper.selectByPage7(record);
			String[] headers={"员工姓名","工号","部门","账户余额","充值总金额"};
			String[] fields={"userLname","userNo","userDepname","amount","amount1"};
			
			try {
				eet.callExportExcel("人员充值信息", headers, fields, list1,out);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		map.put("success", true);
		map.put("msg","导出成功！");
		try {
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}	
		return map;
	}
	
	public Map<String, Object> ExportExcel2(MedAccount record,HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		EETemplate<MedAccount>  eet=new  EETemplate<MedAccount>();
		response.setContentType("octets/stream");
		Date current = Calendar.getInstance().getTime();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
		String fileName = sdf.format(current) + ".xls";
		response.addHeader("Content-Disposition","attachment;filename=" + fileName);
		OutputStream out=null;
		
		Map<String, Object> map1 = this.medAccountMapper.selectByUser(record);
		String userDepname=(String) map1.get("user_depname");
		String userLname=(String) map1.get("user_lname");
		try {
			out = response.getOutputStream();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		String  selectType=record.getSelectType();
		if(selectType.equals("1")){
			List<MedAccount> list = this.medAccountMapper.selectByPage8(record);
			String[] headers={"员工姓名","工号","充值金额"};
			String[] fields={"userLname","userNo","amount2"};	
			try {
				eet.exportExcelTotal(userDepname+"人员充值信息", headers, fields, list,out,"yyy-MM-dd","充值金额总计:"+record.getAmount1(),2);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else{
			List<MedAccount> list = this.medAccountMapper.selectByPage9(record);
			String[] headers={"充值金额","充值时间"};
			String[] fields={"amount","createTime"};	
			try {
				eet.exportExcelTotal(userLname+"充值信息", headers, fields, list,out,"yyy-MM-dd HH:mm:ss","充值金额总计:"+record.getAmount1(),0);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		try {
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}	
		map.put("success", true);
		map.put("msg","导出成功！");
		return map;
	}

	public Map<String, Object> personalRecharge(DtUser currUser,MedAccount record) {
		Map<String, Object> map = new HashMap<String, Object>();
		Long user=currUser.getUserSerial();
		record.setUserSerial1(user);
		List<MedAccount> list = this.medAccountMapper.personalRecharge(record);
		Integer count = this.medAccountMapper.personalRechargeCou(record);
		map.put("rows", list);
		map.put("total",count);
		return map;
	}

	public Object dataList2(MedAccount record) {
		if(record.getDepParent() ==null) {
			record.setDepParent(0);
			Map<String, Object> map = new HashMap<String, Object>();
			List<MedAccount> list = this.medAccountMapper.selectByPage4(record);
			Integer count = this.medAccountMapper.selectCount4(record);
			map.put("rows", list);
			map.put("total",count);
			return map;
		}else {
			List<MedAccount> list = this.medAccountMapper.selectByPage4(record);
			return list;
		}
	}
	
	

}

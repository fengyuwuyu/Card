package com.cecep.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cecep.dao.DtCardMapper;
import com.cecep.dao.DtUserMapper;
import com.cecep.model.DtCard;
import com.cecep.model.DtUser;
import com.cecep.service.DtCardServiceI;
@Service("dtCardService")
public class DtCardServiceImpl implements DtCardServiceI {
	
	private DtCardMapper dtCardMapper;
	private DtUserMapper dtUserMapper;
	
	@Autowired
	public void setDtCardMapper(DtCardMapper dtCardMapper) {
		this.dtCardMapper = dtCardMapper;
	}
	
	@Autowired
	public void setDtUserMapper(DtUserMapper dtUserMapper) {
		this.dtUserMapper = dtUserMapper;
	}

	public Map<String, Object> openCard(DtCard record) {
		Map<String, Object> map = new HashMap<String, Object>();
		DtCard card = this.dtCardMapper.selectBySelective(record);
		if(card == null) {
			if(record.getDeadline()!=null){
				this.dtCardMapper.updateDeadline(record);
			}
			this.dtCardMapper.updateCardSerial();
			Integer serial = this.dtCardMapper.selectMaxCardSerial();
			String cardSerial = String.valueOf(serial);
			//卡片序号
			record.setCardSerial("00000000".substring(0, 8 - cardSerial.length()) + cardSerial);
			//存储过程类型--预处理
			record.setLx(0);
			//卡片类型
			record.setCardLx(8);
			//卡片状态
			record.setCardType(4);
			//业务无关
			record.setDevSerial("");			
			record.setAcType("");
			record.setJmkh("");			
			record.setCardWork(0);			
			record.setRegSerial("");
			this.dtCardMapper.openCard(record);
			//存储过程类型--更新结果状态
			record.setLx(1);
			//卡片状态
			record.setCardType(0);
			this.dtCardMapper.openCard(record);	
			map.put("msg", "开卡成功。");	
			map.put("success", true);			
		}else {
			map.put("msg", "开卡失败，此卡片正在使用中。");	
			map.put("success", false);				
		}	
		return map;
	}

	public Map<String, Object> lockCard(DtCard record) {
		Map<String, Object> map = new HashMap<String, Object>();	
		//存储过程类型--预处理
		record.setLx(1);
		//业务无关
		record.setRegSerial("");
		this.dtCardMapper.lockCard(record);
		map.put("msg", "挂失成功。");	
		map.put("success", true);				
		return map;
	}
	
	public Map<String, Object> readCard(String cardHao) {
		Map<String, Object> map = new HashMap<String, Object>();	
		DtUser user = this.dtCardMapper.readCard(cardHao);	
		if(user == null) {
			map.put("msg", "读卡成功，此卡片无人使用。");	
			map.put("success", false);			
		}else {
			map.put("user", user);	
			map.put("msg", "读卡成功。");	
			map.put("success", true);			
		}			
		return map;
	}

	public Map<String, Object> unlockCard(DtCard record) {
		Map<String, Object> map = new HashMap<String, Object>();	
		//存储过程类型--预处理
		record.setLx(1);
		//业务无关
		record.setRegSerial("");
		this.dtCardMapper.unlockCard(record);
		map.put("msg", "解挂成功。");	
		map.put("success", true);			
		return map;
	}

	public Map<String, Object> returnCard(DtCard record) {
		//更新cecep_user_privilege中的deadline
		record.setDeadline(null);
		this.dtCardMapper.updateDeadline(record);
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
		this.dtCardMapper.returnCard2(record);	
		//存储过程类型--更新结果状态
		record.setLx(1);
		//卡片状态
		record.setCardType(2);
		this.dtCardMapper.returnCard2(record);
		map.put("msg", "退卡成功。");	
		map.put("success", true);				
		return map;
	}

	public Map<String, Object> upCard(DtCard record,String physicsCard) {
		Map<String, Object> map = new HashMap<String, Object>();
		DtCard c = new DtCard();c.setCardHao(physicsCard);		
		DtCard card = this.dtCardMapper.selectBySelective(c);
		if(card == null) {
			//----------退卡----------
			//存储过程类型--预处理
			record.setLx(0);
			//卡片状态
			record.setCardType(4);
			//业务无关
			record.setCardVerify("");
			record.setCardForm("");		
			record.setRegSerial("");
			record.setVersionNo(0);
			record.setDevSerial("");			
			record.setAcType("");
			record.setJmkh("");			
			record.setCardWork(0);			
			this.dtCardMapper.returnCard(record);	
			//存储过程类型--更新结果状态
			record.setLx(1);
			//卡片状态
			record.setCardType(2);
			this.dtCardMapper.returnCard(record);	
			//----------重新开卡----------
			DtUser user = this.dtUserMapper.selectByPrimaryKey(record.getUserSerial());
			if(user.getCardXh() == null) {
				//卡片物理卡号
				record.setCardHao(physicsCard);
				this.dtCardMapper.updateCardSerial();
				Integer serial = this.dtCardMapper.selectMaxCardSerial();
				String cardSerial = String.valueOf(serial);
				//卡片序号
				record.setCardSerial("00000000".substring(0, 8 - cardSerial.length()) + cardSerial);		
				//存储过程类型--预处理
				record.setLx(0);
				//卡片状态
				record.setCardType(4);
				this.dtCardMapper.openCard2(record);
				//存储过程类型--更新结果状态
				record.setLx(1);
				//卡片状态
				record.setCardType(0);
				this.dtCardMapper.openCard2(record);			
				map.put("msg", "补卡成功。");	
				map.put("success", true);		
			}else {
				map.put("msg", "补卡失败。");	
				map.put("success", true);	
			}
		}else {
			map.put("msg", "补卡失败，此卡片正在使用中。");	
			map.put("success", false);				
		}			
		return map;
	}

}

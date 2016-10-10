package com.cecep.service.impl.mess;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cecep.cache.DepCache;
import com.cecep.dao.mess.WhiteListMapper;
import com.cecep.model.DtUser;
import com.cecep.model.mess.WhiteList;
import com.cecep.service.mess.WhiteListServiceI;
import com.cecep.util.MapUtils;

@Service
public class WhiteListServiceImpl implements WhiteListServiceI {
	
	private WhiteListMapper  whiteListMapper;
	
	@Autowired
	public void setWhiteListMapper(WhiteListMapper whiteListMapper) {
		this.whiteListMapper = whiteListMapper;
	}

	public Map<String, Object> save(WhiteList query,DtUser currUser) {
		this.whiteListMapper.deteleDtAcDepUser(query);
		query.setSj(new Date());
		this.whiteListMapper.insertDtAcDepUser(query);
		this.whiteListMapper.execWhiteListAll(query);
		this.whiteListMapper.updateDtUSerSj(query);
		query.setUserLname(currUser.getUserLname());
 		this.whiteListMapper.insertWtXfLog(query);
// 		throw new RuntimeException();
		return MapUtils.createSuccessMap("msg","添加成功！");
	}

	public Map<String, Object> delete(Integer [] ids) {
		if(ids!=null&&ids.length>0){
			for(Integer xh : ids){
				this.deleteByXh(xh);
			}
		}
		return MapUtils.createSuccessMap("msg","删除成功！");
	}
	
	private void deleteByXh(Integer xh){
		WhiteList whiteList = this.whiteListMapper.selectByXh(xh);
		List<Long> userSerials = new ArrayList<Long>();
		userSerials.add(whiteList.getUserSerial());
		whiteList.setUserSerials(userSerials);
		this.whiteListMapper.deteleDtAcDepUser(whiteList);
		whiteList.setSj(new Date());
		this.whiteListMapper.insertWtXfLog(whiteList);
		this.whiteListMapper.execWhiteListInfo(whiteList);
	}

	public Map<String, Object> dataList(WhiteList query) {
		if(query.getAcdepSerial()==null){
			return MapUtils.createEmptyDataListMap();
		}
		if(query.getDepSerials()!=null&&query.getDepSerials().toString().indexOf("10000")==-1){
			query.setDepSerialss(DepCache.getChildren(query.getDepSerials()));
		}
		List<WhiteList> list = this.whiteListMapper.dataList(query);
		Integer total = this.whiteListMapper.getTotal(query);
		return MapUtils.createSuccessMap("rows",list,"total",total);
	}

	public Map<String, Object> saveList(WhiteList query,DtUser currUser) {
		if(query.getDepSerials()!=null&&query.getDepSerials().size()>0){
			query.setDepSerialss(DepCache.getChildren(query.getDepSerials()));
		}
		this.whiteListMapper.deteleDtAcDepUserByDep(query);
		query.setSj(new Date());
		this.whiteListMapper.insertDtAcDepUserByDep(query);
		this.whiteListMapper.execWhiteListAll(query);
		this.whiteListMapper.updateDtUSerSjByDep(query);
		query.setUserLname(currUser.getUserLname());
 		this.whiteListMapper.insertWtXfLogByDep(query);
// 		throw new RuntimeException();
		return MapUtils.createSuccessMap("msg","添加白名单成功！");
	}

	public Map<String, Object> deleteByQuery(WhiteList query) {
		this.whiteListMapper.deleteByQuery(query);
		this.whiteListMapper.execWhiteListAll(query);
		System.out.println("--------");
		return MapUtils.createSuccessMap("msg","批量删除成功！");
	}

}

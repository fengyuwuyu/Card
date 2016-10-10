package com.cecep.service.dwr;

import java.util.Date;

import org.directwebremoting.Browser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cecep.dao.ExceptionLogMapper;
import com.cecep.dao.MidDepMapper;
import com.cecep.dao.MidUserMapper;
import com.cecep.dwr.DWRScriptSessionListener;
import com.cecep.dwr.dep.SynchronizeDepFilter;
import com.cecep.dwr.dep.SynchronizeDepUtil;
import com.cecep.model.ExceptionLog;
import com.cecep.service.MidUserServiceI;
import com.cecep.util.CommonsUtil;
import com.cecep.util.KqStatisticsUtil;

@Service
public class SynchronizeDepServiceImpl {
	/** 表示同步部门*/
	public static final int SYNCHRONIZEDEP = 1;
	/** 表示同步员工*/
	public static final int SYNCHRONIZEUSER = 2;
	/** 一段时间插入第一条记录后休眠时间，允许调用者设置*/
	public static Long SLEEPTIMME = 60000L;
	private MidDepMapper midDepMapper;
	private MidUserMapper midUserMapper;
	private ExceptionLogMapper exceptionLogMapper;
	private volatile boolean isNotify = false;
	private MidUserServiceI midUserServiceI;
	
	@Autowired
	public void setMidUserServiceI(MidUserServiceI midUserServiceI) {
		this.midUserServiceI = midUserServiceI;
	}

	@Autowired
	public void setMidDepMapper(MidDepMapper midDepMapper) {
		this.midDepMapper = midDepMapper;
	}
	
	@Autowired
	public void setMidUserMapper(MidUserMapper midUserMapper) {
		this.midUserMapper = midUserMapper;
	}

	@Autowired
	public void setExceptionLogMapper(ExceptionLogMapper exceptionLogMapper) {
		this.exceptionLogMapper = exceptionLogMapper;
	}

	public void synchronize(int type){
		if(DWRScriptSessionListener.hasValidSession()){
			if(!isNotify){
				this.isNotify = true;
				try {
					Thread.sleep(SLEEPTIMME);
				} catch (InterruptedException e) {
					this.exceptionLogMapper.insert(new ExceptionLog(KqStatisticsUtil.formatDateToString3(new Date()), this.getClass().getName(), "synchronize", "等待时被非法中断！", CommonsUtil.join(e.getStackTrace(), ",\n\r")));
					e.printStackTrace();
				}
				Integer count = null;
				if(type == SYNCHRONIZEDEP){
					count = this.midDepMapper.selectIsSynchronized();
				}else if(type == SYNCHRONIZEUSER){
					//执行一次自动同步
					this.midUserServiceI.synchronize();
					count = this.midUserMapper.midUserSynchronizeCount();
				}
//				count = 10;
				if(count>0){
					SynchronizeDepUtil util = new SynchronizeDepUtil(count,type);
					SynchronizeDepFilter filter = new SynchronizeDepFilter(SynchronizeDepUtil.TAG);
					Browser.withAllSessionsFiltered(filter, util);
				}
				this.isNotify = false;
			}
		}
	}
}

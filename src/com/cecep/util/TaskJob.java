package com.cecep.util;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ApplicationObjectSupport;

import com.cecep.service.VisitorBlacklistServiceI;






	
public class TaskJob extends ApplicationObjectSupport {

    public void execute() {    	
		System.out.println("系统后台开始退卡...");
		ApplicationContext applicationContext = this.getApplicationContext();
		VisitorBlacklistServiceI visitorBlacklistServiceI = (VisitorBlacklistServiceI) applicationContext.getBean("visitorBlacklistService");
		visitorBlacklistServiceI.returnCard2();  
		visitorBlacklistServiceI.returnCard3();   
    }
    
    
}


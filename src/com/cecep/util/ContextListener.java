package com.cecep.util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;
import java.util.ResourceBundle;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.cecep.cache.DepCache;
import com.cecep.dao.DtDepMapper;
import com.cecep.service.MidDepServiceI;

public class ContextListener implements ServletContextListener {

	public void contextDestroyed(ServletContextEvent arg0) {
		arg0.getServletContext().removeAttribute("msUrl");

	}

	public void contextInitialized(ServletContextEvent arg0) {
		//初始化DepCache
		ApplicationContext ac = WebApplicationContextUtils.getWebApplicationContext(arg0.getServletContext());
		DtDepMapper depMapper = ac.getBean(DtDepMapper.class);
		DepCache.init(depMapper);
		ServletContext context = arg0.getServletContext();
		ResourceBundle rb = ResourceBundle.getBundle("urls");
		String msUrl = rb.getString("msUrl");
		context.setAttribute("msUrl", msUrl);
		// 第一次同步部门数据后，更改配置文件，确保只起一次作用
		Properties properties = new Properties();
		try {
			String file = this.getClass().getClassLoader()
					.getResource("synchronizeDep.properties").getFile()
					.substring(1);
			InputStream in = new FileInputStream(file);
			properties.load(in);
			boolean initSynchronizeDep = Boolean.valueOf(properties
					.getProperty("initSynchronizeDep"));
			if (initSynchronizeDep) {
				OutputStream out = new FileOutputStream(file);
				properties.setProperty("initSynchronizeDep", "false");
				properties.store(out, "change initSynchronizeDep to false");
				out.close();
				//根据cecep_dep表中的数据初始化dt_dep表
				MidDepServiceI depServiceI = (MidDepServiceI) ac.getBean("midDepService");
				depServiceI.synchronizeFirst("10000000");
			}
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}

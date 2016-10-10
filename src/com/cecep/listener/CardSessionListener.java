package com.cecep.listener;

import java.io.File;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.apache.log4j.Logger;

import com.cecep.model.DtUser;

public class CardSessionListener implements HttpSessionListener {
	
	private Logger log = Logger.getLogger(getClass());
	
	public void sessionCreated(HttpSessionEvent arg0) {
		log.debug("session被创建了。。。");
	}

	public void sessionDestroyed(HttpSessionEvent arg0) {
		log.debug("session销毁时删除缓存的下载文件。。。");
		// TODO session被摧毁时删除导出的excel报表
		String path = CardSessionListener.class.getResource("/").getFile()
				.substring(1);
		DtUser user = (DtUser) arg0.getSession().getAttribute("currUser");
		if(user!=null){
			String username = user.getUserLname();
			String filename = path + "excel/" + username + "_work.xls";
			File file = new File(filename);
			if(file.exists()){
				file.delete();
			}
		}
	}

}

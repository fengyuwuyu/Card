package com.cecep.dwr;

import org.directwebremoting.impl.DefaultScriptSessionManager;

public class DWRScriptSessionManager extends DefaultScriptSessionManager {
	public DWRScriptSessionManager(){
		this.addScriptSessionListener(new DWRScriptSessionListener());
		System.out.println("bind DWRScriptSessionListener");
	}
}

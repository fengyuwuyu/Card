package com.cecep.dwr.dep;

import java.util.List;

import org.directwebremoting.ScriptSession;
import org.directwebremoting.ScriptSessionFilter;

import com.cecep.dwr.DWRScriptSessionListener;

public class SynchronizeDepFilter implements ScriptSessionFilter {

	private String attributeName;
	
	public SynchronizeDepFilter(String attributeName){
		this.attributeName = attributeName;
	}
	
	public boolean match(ScriptSession arg0) {
		System.out.println(arg0.getId());
		List<ScriptSession> scriptSession = DWRScriptSessionListener.getSessionsByTag(attributeName);
		if(scriptSession!=null&&scriptSession.size()>0){
			System.out.println(attributeName+"  长度是：  "+scriptSession.size());
			return true;
		}
		return false;
	}

}

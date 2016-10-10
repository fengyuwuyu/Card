package com.cecep.dwr.dep;

import java.util.List;

import org.directwebremoting.ScriptBuffer;
import org.directwebremoting.ScriptSession;

import com.cecep.dwr.DWRScriptSessionListener;

public class SynchronizeDepUtil implements Runnable{
	
	private int count;//更新结果：1、成功--2、失败
	private Integer type ;
	public static final String TAG = "synchronizeDep";
	
	public SynchronizeDepUtil(int count,int type){
		this.count = count;
		this.type = type;
	}
	
	public void run() {
		synchronizeDepNotify(TAG);
		
	}
	
	public void synchronizeDepNotify(String sessionTag){
		ScriptBuffer scriptBuffer = new ScriptBuffer();
		scriptBuffer.appendCall(sessionTag,count,type);
		List<ScriptSession> list = DWRScriptSessionListener.getSessionsByTag(sessionTag);
		for(ScriptSession scriptSession : list){
			if(scriptSession == null){
				System.out.println("scriptSession为空");
			}else{
				System.out.println(scriptSession.getId());
				scriptSession.addScript(scriptBuffer);
			}
		}
	}
	
}

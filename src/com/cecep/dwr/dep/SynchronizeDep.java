package com.cecep.dwr.dep;

import java.util.Map;

import org.directwebremoting.ScriptSession;
import org.directwebremoting.WebContextFactory;
import org.directwebremoting.annotations.RemoteMethod;
import org.directwebremoting.annotations.RemoteProxy;

import com.cecep.dwr.DWRScriptSessionListener;
@RemoteProxy(name="SynchronizeDep")
public class SynchronizeDep {
	
	@RemoteMethod
	public void onPageLoad(final String content){
		System.out.println("与SynchronizeDep建立连接进入onPageLoad方法");
        ScriptSession scriptSession = WebContextFactory.get().getScriptSession();
        System.out.println("session id ----"+WebContextFactory.get().getSession().getId());
        System.out.println("scriptSession:"+scriptSession);
        scriptSession.setAttribute( "content", content);
        String removeKey = null;
        for(Map.Entry<String, ScriptSession> entry:DWRScriptSessionListener.scriptSessionMap.entrySet()){
        	System.out.println("key:"+entry.getKey()+";content : "+entry.getValue().getAttribute("content"));
        	if(entry.getValue().getAttribute("content")==null){
        		removeKey = entry.getKey();
        	}
        }
        if(removeKey!=null){
        	DWRScriptSessionListener.scriptSessionMap.remove(removeKey);
        }
        System.out.println("DWRScriptSessionListener.scriptSessionMap.size():"+DWRScriptSessionListener.scriptSessionMap.size());
        System.out.println( "setAttribute："+(String)scriptSession.getAttribute("content"));
	}
}

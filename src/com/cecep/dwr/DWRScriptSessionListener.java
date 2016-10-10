package com.cecep.dwr;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.http.HttpSession;

import org.directwebremoting.ScriptSession;
import org.directwebremoting.WebContext;
import org.directwebremoting.WebContextFactory;
import org.directwebremoting.event.ScriptSessionEvent;
import org.directwebremoting.event.ScriptSessionListener;

public class DWRScriptSessionListener implements ScriptSessionListener {

	public static final Map<String, ScriptSession> scriptSessionMap = new ConcurrentHashMap<String, ScriptSession>();
	
	/**
	 * ScriptSession的创建事件
	 */
	public void sessionCreated(ScriptSessionEvent ev) {
		System.out.println("sessionCreated"+ev.getSession()+"--"+ev.getSession().getId());
		WebContext webContext = WebContextFactory.get();
		HttpSession session = webContext.getSession();
		ScriptSession scriptSession = ev.getSession();
		scriptSessionMap.put(session.getId(), scriptSession);
        System.out.println("剩余sessionScript的长度  ： "+scriptSessionMap.size());
	}
	
	/**
	 * ScriptSession的销毁事件
	 */
	public void sessionDestroyed(ScriptSessionEvent ev) {
		System.out.println("sessionDestroyed : "+ev.getSession()+"--"+ev.getSession().getId());
        ScriptSession scriptSession = ev.getSession();
        WebContext webContext = WebContextFactory.get();
		HttpSession session = webContext.getSession();
        if(scriptSession != null){
        	scriptSessionMap.remove(session.getId());  //移除scriptSession
        }else{
        	System.out.println("sessionDestoryed's scriptSession is null");
        }
        System.out.println("剩余sessionScript的长度  ： "+scriptSessionMap.size());
	}
	
	/**
	 * 获取所有的ScriptSession
	 * @return
	 */
	public static Collection<ScriptSession> getScriptSessions(){
		Collection<ScriptSession> c = scriptSessionMap.values();
		Iterator<ScriptSession> i = c.iterator();
		while(i.hasNext()){
			System.out.println("i.next():"+i.next());
		}
		return c;
	}
	
	public static List<ScriptSession> getSessionsByTag(String str){
		if(str == null){
			throw new IllegalArgumentException("参数不能为空！");
		}
		List<ScriptSession> sessions = new ArrayList<ScriptSession>();
		Collection<ScriptSession> all = getScriptSessions();
		for(ScriptSession sess : all){
			String value = (String) sess.getAttribute("content");
			if(str.equals(value)){
				sessions.add(sess);
			}
		}
		return sessions;
	}
	
	public static ScriptSession getOneScriptSession(String str){
		List<ScriptSession> sessions =  getSessionsByTag(str);
		if(sessions!=null&&sessions.size()>0){
			return sessions.get(sessions.size()-1);
		}
		return null;
	}
	
	public static ScriptSession getOneScriptSession(){
		 Collection<ScriptSession> sessions = getScriptSessions();
		 if(sessions.size() == 1){
			 for(ScriptSession session : sessions){
				 return session;
			 }
		 }
		 return null;
	}
	
	public static boolean hasValidSession(){
		return scriptSessionMap.size()>0?true:false;
	}

}

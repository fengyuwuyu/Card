package com.cecep.util;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Map;

import org.apache.commons.io.IOUtils;

public class HttpUrlConnectionUtil {
	
	public static final String ENCODING = "UTF-8";
	
	public static byte[] post(String url,Map<String, String> params) throws Exception{
		if(url==null||url.equals("")){
			return null;
		}
		return post(new URL(url),params);
	}

	public static byte[] post(URL url , Map<String,String> params) throws Exception{
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		// http正文内，因此需要设为true, 默认情况下是false; 
		connection.setDoOutput(true); 

		// Post 请求不能使用缓存 
		connection.setUseCaches(false); 

		// 设定传送的内容类型是可序列化的java对象 
		// (如果不设此项,在传送序列化对象时,当WEB服务默认的不是这种类型时可能抛java.io.EOFException) 
//		connection.setRequestProperty("Content-type", "application/x-java-serialized-object"); 

		// 设定请求的方法为"POST"，默认是GET 
		connection.setRequestMethod("POST"); 
		//设置超时时间
		connection.setConnectTimeout(5000);
		//设置读取数据超时时间
		connection.setReadTimeout(3000);
		if(params!=null&&params.size()>0){
			String content = getEncodeParamsByMap(params);
			OutputStream out = connection.getOutputStream();
			out.write(content.getBytes(ENCODING));
		}

		// 连接，从上述第2条中url.openConnection()至此的配置必须要在connect之前完成， 
		InputStream in = connection.getInputStream(); 
//		IOUtils.copy(in, System.out);
		byte[] bs = IOUtils.toByteArray(in);
		in.close();
		connection.disconnect();
		return bs;
	}
	
	public static byte[] get(String url,Map<String,String> params) throws Exception{
		if(url==null||url.equals("")){
			return null;
		}
		if(params!=null&&params.size()>0){
			StringBuilder realUrl = new StringBuilder();
			realUrl.append(url+"?"+getGetParamsByMap(params));
			return get(new URL(realUrl.toString()));
		}else{
			return get(new URL(url));
		}
	}
	
	public static byte[] get(URL url) throws Exception{
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		// http正文内，因此需要设为true, 默认情况下是false; 
		connection.setDoOutput(true); 
		
		// 设定传送的内容类型是可序列化的java对象 
		// (如果不设此项,在传送序列化对象时,当WEB服务默认的不是这种类型时可能抛java.io.EOFException) 
//		connection.setRequestProperty("Content-type", "application/x-java-serialized-object"); 
		
		// 设定请求的方法为"POST"，默认是GET 
		connection.setRequestMethod("GET"); 
		//设置超时时间
		connection.setConnectTimeout(5000);
		//设置读取数据超时时间
		connection.setReadTimeout(3000);
		// 连接，从上述第2条中url.openConnection()至此的配置必须要在connect之前完成
		InputStream in = connection.getInputStream(); 
		byte[] bs = IOUtils.toByteArray(in);
		in.close();
		connection.disconnect();
		return bs;
	}
	
	/**
	 * 对传入的params进行URL编码
	 * @param params 需要UrlEncode编码的参数
	 * @return
	 * @throws Exception
	 */
	public static String getEncodeParamsByMap(Map<String,String> params) throws Exception{
		StringBuilder param = new StringBuilder();
		String content = null;
		param.append("[{");
		if(params!=null&&params.size()>0){
			for(String key : params.keySet()){
				param.append("\""+key+"\":"+"\""+params.get(key)+"\",");
			}
			content = param.substring(0, param.length()-1);
			content = content+"}]";
		}
		return URLEncoder.encode(content, ENCODING);
	}
	
	public static String getGetParamsByMap(Map<String,String> params) throws Exception{
		StringBuilder param = new StringBuilder();
		if(params!=null&&params.size()>0){
			for(String key : params.keySet()){
				param.append(key+"="+params.get(key)+"&");
			}
		}
		return param.substring(0, param.length()-1);
	}
}

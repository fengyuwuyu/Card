package com.cecep.ssologin;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.List;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.bind.JAXBElement;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.cecep.dao.DtUserMapper;
import com.cecep.model.DtUser;
import com.cecep.model.SysMenu;
import com.serv.act.SsoWS;
import com.serv.act.SsoWSPortType;
import com.serv.imp.module.xsd.SsologinResponse;
import com.serv.imp.module.xsd.UserAccountToken;
@SessionAttributes(value = "currUser")
public class ssologinServlet extends HttpServlet {

		
	/**
	 * 单点登录
	 */
	private static final long serialVersionUID = 7876070794468615864L;
	public void doGet(HttpServletRequest request, HttpServletResponse response)	throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		/**
		 * 读取服务器路径配置文件
		 */
		Properties prop = new Properties(); 
		InputStream in = this.getClass().getResourceAsStream("/urls.properties");
		prop.load(in);
		String ticket=request.getParameter("ticket");
		/**
		 * 获取客户端IP地址
		 */
	   String clientIp = request.getHeader("x-forwarded-for");
       if(clientIp == null || clientIp.length() == 0 || "unknown".equalsIgnoreCase(clientIp)) {
           clientIp = request.getHeader("Proxy-Client-clientIp");
       }
       if(clientIp == null || clientIp.length() == 0 || "unknown".equalsIgnoreCase(clientIp)) {
           clientIp = request.getHeader("WL-Proxy-Client-clientIp");
       }
       if(clientIp == null || clientIp.length() == 0 || "unknown".equalsIgnoreCase(clientIp)) {
           clientIp = request.getRemoteAddr();
       }
       System.out.println("客户端IP地址"+clientIp);
		if(ticket==null){
			request.setAttribute("msg", "票据为空，请重新登录！");
			request.getRequestDispatcher("/ssologinError.jsp").forward(request, response);
			return;
		}
		SsoWS s=new  SsoWS();
		SsoWSPortType  st=s.getSsoWSHttpSoap11Endpoint();
		/**
		 * servicename是你们系统的简称  	oa
			mainservicename固定值为	portal
		 */
		String servicename="oa";
		String mainservicename="portal";
		//st.ssologin(ticket, clientIp, servicename, mainservicename);
		SsologinResponse  ssologinresponse=	st.ssologin(ticket, clientIp, servicename, mainservicename);
		/* * String flag  校验状态位：0校验成功 1票据无效 2 IP非法
		 * message: String   返回错误消息
		 * user: User   用户详细信息
		 *	0校验成功 通过账号查找信息存入session
		 *  1票据无效 和2 IP非法跳转登录页面 提示信息
		 * */
		String flag=ssologinresponse.getFlag().getValue();
		String   message =ssologinresponse.getMessage().getValue();
		System.out.println("返回flag========"+flag);
		System.out.println("返回message======="+message);
		if("0".equals(flag)){
			//通过账号查找信息存入session
			JAXBElement<UserAccountToken> user=ssologinresponse.getUser();
			UserAccountToken  userAccount=user.getValue();
			String userMsg= userAccount.getUserAccount().getValue();//账号
		 /**
			 * 查询员工信息出入session
			 */
			
			String resource = "mybatis-config.xml";  
            Reader reader = Resources.getResourceAsReader(resource);  
            SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(reader);  
            SqlSession session = ssf.openSession();  
		try {
			DtUserMapper mappeer=session.getMapper(DtUserMapper.class);
            DtUser user2=mappeer.selectSsologinUser("30040894");//userMsg  
            if(user2!=null){
            	 List<SysMenu> list = mappeer.getMenuTree(user2.getRoleId());
                 request.setAttribute("currUser", user2);
                 request.setAttribute("menuList", list);
     			HttpSession se=request.getSession();
     			se.setAttribute("currUser", user2);
            }
			//System.out.println("ssogin==================单点登录"+se.getId());
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}
		/**
		 * 校验通过跳转到主页面
		 */
		
			//request.getRequestDispatcher("/view/main/main.jsp").forward(request, response);
			response.sendRedirect(prop.get("serverUrl")+"main/main.html");
		}
		
		
		if("1".equals(flag)||"2".equals(flag)){
			//1票据无效 2 IP非法
			String msg="";
			if("1".equals(flag)){
				msg="票据无效 ";
			}else if("2".equals(flag)){
				msg="IP非法";
			}
			request.setAttribute("msg", msg+",请重新登录！");
			request.getRequestDispatcher("/ssologinError.jsp").forward(request, response);
		}
		
	
	}
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String method=req.getMethod();
		if(method.equalsIgnoreCase("GEt")){
			 this.doPost(req, resp);
		}else{
			 this.doPost(req, resp);
		}
		
	}
	
}

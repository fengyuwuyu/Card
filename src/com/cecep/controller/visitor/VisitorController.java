package com.cecep.controller.visitor;

import it.sauronsoftware.base64.Base64;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.cecep.controller.BaseController;
import com.cecep.model.DtCard;
import com.cecep.model.DtUser;
import com.cecep.model.VisitorBlacklist;
import com.cecep.model.VisitorRecord;
import com.cecep.service.VisitorBlacklistServiceI;
import com.cecep.service.VisitorRecordServiceI;
import com.cecep.util.MapUtils;

@Controller
@RequestMapping(value = "visitorController")
@SessionAttributes(value = "currUser")
public class VisitorController extends BaseController {

	private VisitorBlacklistServiceI visitorBlacklistServiceI;
	private VisitorRecordServiceI visitorRecordServiceI;

	@Autowired
	public void setVisitorBlacklistServiceI(
			VisitorBlacklistServiceI visitorBlacklistServiceI) {
		this.visitorBlacklistServiceI = visitorBlacklistServiceI;
	}

	@Autowired
	public void setVisitorRecordServiceI(
			VisitorRecordServiceI visitorRecordServiceI) {
		this.visitorRecordServiceI = visitorRecordServiceI;
	}

	/**
	 * 访客--分页查询（白名单）
	 * 
	 * @return Map
	 * @author BYP
	 * @date 2016-03-10
	 * */
	@RequestMapping(value = "visitorDataList.do")
	@ResponseBody
	public Map<String, Object> visitorDataList(VisitorBlacklist record,
			HttpServletRequest request, HttpServletResponse response) {
		// 白名单
		record.setFlag(0);
		Map<String, Object> map = this.visitorBlacklistServiceI
				.dataList(record);
		return map;
	}

	/**
	 * 访客--导出（白名单）
	 * 
	 * @author BYP
	 * @date 2016-03-10
	 * */
	@RequestMapping(value = "visitorExport.do")
	public String visitorExport(VisitorBlacklist record,
			HttpServletRequest request, HttpServletResponse response) {
		// 白名单
		record.setFlag(0);
		try {
			this.visitorBlacklistServiceI.export(record, request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 访客--分页查询（黑名单）
	 * 
	 * @return Map
	 * @author BYP
	 * @date 2016-03-10
	 * */
	@RequestMapping(value = "visitorDataList2.do")
	@ResponseBody
	public Map<String, Object> visitorDataList2(VisitorBlacklist record,
			HttpServletRequest request, HttpServletResponse response) {
		// 黑名单
		record.setFlag(1);
		Map<String, Object> map = this.visitorBlacklistServiceI
				.dataList(record);
		return map;
	}

	/**
	 * 访客--导出（黑名单）
	 * 
	 * @author BYP
	 * @date 2016-03-10
	 * */
	@RequestMapping(value = "visitorExport2.do")
	public String visitorExport2(VisitorBlacklist record,
			HttpServletRequest request, HttpServletResponse response) {
		// 白名单
		record.setFlag(1);
		try {
			this.visitorBlacklistServiceI.export(record, request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 访客--主键查询
	 * 
	 * @return Map
	 * @author BYP
	 * @date 2016-03-10
	 * */
	@RequestMapping(value = "visitorGetById.do")
	@ResponseBody
	public Map<String, Object> visitorGetById(VisitorBlacklist record,
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = this.visitorBlacklistServiceI.getById(record);
		return map;
	}

	/**
	 * 访客--保存
	 * 
	 * @return Map
	 * @author BYP
	 * @date 2016-03-10
	 * */
	@RequestMapping(value = "visitorSave.do")
	@ResponseBody
	public Map<String, Object> visitorSave(
			@ModelAttribute("currUser") DtUser currUser,
			VisitorBlacklist visitor, DtUser user, HttpServletRequest request,
			HttpServletResponse response) {
		// 用户IP
		user.setIp(request.getRemoteAddr());
		// 用户姓名
		user.setGlyNo(currUser.getUserLname());
		Map<String, Object> map = this.visitorBlacklistServiceI.save(visitor,
				user);
		return map;
	}

	/**
	 * 访客--移除黑名单
	 * 
	 * @return Map
	 * @author BYP
	 * @date 2016-03-10
	 * */
	@RequestMapping(value = "visitorDelete.do")
	@ResponseBody
	public Map<String, Object> visitorDelete(VisitorBlacklist record,
			HttpServletRequest request, HttpServletResponse response) {
		// 黑名单
		record.setFlag(0);
		Map<String, Object> map = this.visitorBlacklistServiceI.delete(record);
		return map;
	}

	/**
	 * 访客--开卡
	 * 
	 * @return Map
	 * @author BYP
	 * @date 2016-03-10
	 * */
	@RequestMapping(value = "openCard.do")
	@ResponseBody
	public Map<String, Object> openCard(
			@ModelAttribute("currUser") DtUser currUser, VisitorRecord visitor,
			DtCard card, Integer userDep, HttpServletRequest request,
			HttpServletResponse response) {
		// 用户IP
		card.setIp(request.getRemoteAddr());
		// 用户姓名
		card.setGlyNo(currUser.getUserLname());
		Map<String, Object> map = this.visitorBlacklistServiceI.openCard(
				visitor, card, userDep);
		return map;
	}

	/**
	 * 访客--退卡
	 * 
	 * @return Map
	 * @author BYP
	 * @date 2016-03-10
	 * */
	@RequestMapping(value = "returnCard.do")
	@ResponseBody
	public Map<String, Object> returnCard(DtCard record,
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = this.visitorBlacklistServiceI
				.returnCard(record);
		return map;
	}

	/**
	 * 访客记录--分页查询
	 * 
	 * @return Map
	 * @author BYP
	 * @date 2016-03-10
	 * */
	@RequestMapping(value = "recordDataList.do")
	@ResponseBody
	public Map<String, Object> recordDataList(VisitorRecord record,
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = this.visitorRecordServiceI.dataList(record);
		return map;
	}

	/**
	 * 访客记录--导出
	 * 
	 * @author BYP
	 * @date 2016-03-10
	 * */
	@RequestMapping(value = "recordExport.do")
	public String recordExport(VisitorRecord record,
			HttpServletRequest request, HttpServletResponse response) {
		try {
			this.visitorRecordServiceI.export(record, request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@SuppressWarnings("finally")
	@RequestMapping(value = "identityPhoto.do")
	@ResponseBody
	public Map<String, Object> identityPhoto(String base64, String userId,
			HttpServletRequest request) throws IOException {
		String path = request.getSession().getServletContext()
				.getRealPath("file/photos");
		String filename = userId + ".jpg";
		boolean exception = false;
		try {
			// Base64解码
			byte[] b = Base64.decode(base64.getBytes());
			for (int i = 0; i < b.length; ++i) {
				if (b[i] < 0) {// 调整异常数据
					b[i] += 256;
				}
			}
			// 生成jpg图片
			String imgFilePath = path + "/" + filename;// 新生成的图片
			OutputStream out = new FileOutputStream(imgFilePath);
			out.write(b);
			out.flush();
			out.close();
		} catch (Exception e) {
			exception = true;
			throw new RuntimeException(e);
		} finally {
			if(exception){
				return MapUtils.createFailedMap();
			}else{
				return MapUtils.createSuccessMap();
			}
		}
		
	}

}

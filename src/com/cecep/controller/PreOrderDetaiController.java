package com.cecep.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.cecep.model.PreOrderDetail;
import com.cecep.service.PreOrderDetaiServiceI;

@Controller
@RequestMapping(value = "PreOrderDetaiController")
@SessionAttributes(value = "currUser")
public class PreOrderDetaiController {
	private  PreOrderDetaiServiceI  preOrderDetaiService;
	@Autowired
	public void setPreOrderDetaiService(PreOrderDetaiServiceI preOrderDetaiService) {
		this.preOrderDetaiService = preOrderDetaiService;
	}
	
	/**
	 * 申请代购人信息
	 * @return Map
	 * @author FLD
	 * @date 2016-04-11
	 * */
	@RequestMapping(value = "dataList.do")
	@ResponseBody
	public Map<String, Object> dataList(PreOrderDetail record,HttpServletRequest request,HttpSession session,HttpServletResponse response) {
		Map<String, Object> map = this.preOrderDetaiService.dataList(record);	
		return map;
	}
	
	
	
	/**
	 * 保存申请代购人信息
	 * @return Map
	 * @author FLD
	 * @date 2016-04-11
	 * */
	@RequestMapping(value = "save.do")
	@ResponseBody
	public Map<String, Object> save(PreOrderDetail record,HttpServletRequest request,HttpSession session,HttpServletResponse response) {
		Map<String, Object> map = this.preOrderDetaiService.save(record);	
		return map;
	}
	/**
	 * 修改申请代购人信息
	 * @return Map
	 * @author FLD
	 * @date 2016-04-11
	 * */
	@RequestMapping(value = "getById.do")
	@ResponseBody
	public Map<String, Object> getById(PreOrderDetail record,HttpServletRequest request,HttpSession session,HttpServletResponse response) {
		Map<String, Object> map = this.preOrderDetaiService.getById(record);	
		return map;
	}
	
	
	
	
		/**
		 * 修改申请代购人信息
		 * @return Map
		 * @author FLD
		 * @date 2016-04-11
		 * */
		@RequestMapping(value = "delete.do")
		@ResponseBody
		public Map<String, Object> delete(PreOrderDetail record,HttpServletRequest request,HttpSession session,HttpServletResponse response) {
			Map<String, Object> map = this.preOrderDetaiService.delete(record);	
			return map;
		}
	
	
	
	
	/**
	 * 添加代购药品页面
	 * @return
	 */
	
	
	
	@RequestMapping(value = "goPage.do")
	public String goPage(@RequestParam("updateId")  Integer  updateId,ModelMap model) {
		model.addAttribute("updateId", updateId);
		return "view/medicine/addMedcine";
	}
	
	/**
	 * 代购详细药品页面
	 * @return
	 */
	@RequestMapping(value = "checkMedcinePage.do")
	public String checkMedcinePage(@RequestParam("updateId")  Integer  updateId,ModelMap model) {
		model.addAttribute("updateId", updateId);
		return "view/medicine/checkMedcinePage";
	}
	
	
	
	
	/**
	 * 添加代购药品信息
	 * @return Map
	 * @author FLD
	 * @date 2016-04-11
	 * */
	@RequestMapping(value = "addMedicineMsg.do")
	@ResponseBody
	public Map<String, Object> addMedicineMsg(PreOrderDetail record,HttpServletRequest request,HttpSession session,HttpServletResponse response) {
		Map<String, Object> map = this.preOrderDetaiService.addMedicineMsg(record);	
		return map;
	}
	
	
	/**
	 * 代购药品信息
	 * @return Map
	 * @author FLD
	 * @param preOrderId1 
	 * @date 2016-04-11
	 * */
	@RequestMapping(value = "getUserMedcineList.do")
	@ResponseBody
	public Map<String, Object> getUserMedcineList(@RequestParam("preOrderId1")Integer preOrderId1,PreOrderDetail record,HttpServletRequest request,HttpSession session,HttpServletResponse response) {
		Map<String, Object> map = this.preOrderDetaiService.getUserMedcineList(preOrderId1, record);	
		return map;
	}
	/**
	 * 结算代购药品
	 * @return Map
	 * @author FLD
	 * @date 2016-04-15
	 * */
	
	@RequestMapping(value = "settlement.do")
	@ResponseBody
	public Map<String, Object> settlement(PreOrderDetail record,HttpServletRequest request,HttpSession session,HttpServletResponse response) {
		Map<String, Object> map = this.preOrderDetaiService.settlement(record);	
		return map;
	}
	
	/**
	 * 查询出打印的数据
	 * @param record
	 * @param request
	 * @param session
	 * @param response
	 * @return
	 */
	
	@RequestMapping(value = "goPrintPage.do")
	public String goPrintPage(PreOrderDetail record,ModelMap model) {
		List<Map<String,Object>> list= this.preOrderDetaiService.printPage(record);	
		model.addAttribute("list", list);
		return "view/medicine/printPage";
	}
}

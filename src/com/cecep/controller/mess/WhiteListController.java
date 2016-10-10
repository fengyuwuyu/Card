package com.cecep.controller.mess;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.cecep.model.DtUser;
import com.cecep.model.mess.WhiteList;
import com.cecep.service.mess.WhiteListServiceI;

@Controller("whiteListController")
@RequestMapping("/whiteListController")
@SessionAttributes(value="currUser")
public class WhiteListController {

	private WhiteListServiceI whiteListService;
	
	@Autowired
	public void setWhiteListServiceI(WhiteListServiceI whiteListService) {
		this.whiteListService = whiteListService;
	}

	@RequestMapping("save.do")
	@ResponseBody
	public Map<String,Object> save(@ModelAttribute("currUser") DtUser currUser,WhiteList query,HttpServletRequest request){
		return this.whiteListService.save(query,currUser);
	}
	
	@RequestMapping("saveList.do")
	@ResponseBody
	public Map<String,Object> saveList(@ModelAttribute("currUser") DtUser currUser,WhiteList query){
		return this.whiteListService.saveList(query,currUser);
	}
	
	@RequestMapping("delete.do")
	@ResponseBody
	public Map<String,Object> delete(@RequestBody Integer [] ids){
		return this.whiteListService.delete(ids);
	}
	
	@RequestMapping("deleteByQuery.do")
	@ResponseBody
	public Map<String,Object> deleteByQuery(WhiteList query){
		return this.whiteListService.deleteByQuery(query);
	}
	
	@RequestMapping("dataList.do")
	@ResponseBody
	public Map<String,Object> dataList(WhiteList query){
		return this.whiteListService.dataList(query);
	}
	
}

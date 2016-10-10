package com.cecep.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import com.cecep.model.DtDep;
import com.cecep.model.DtUser;
import com.cecep.model.MedAccount;
import com.cecep.service.MedAccountServiceI;


@Controller
@RequestMapping(value = "MedAccountController")
@SessionAttributes(value = "currUser")
public class MedAccountController {
	private  MedAccountServiceI  medAccountService;

	@Autowired
	public void setMedAccountService(MedAccountServiceI medAccountService) {
		this.medAccountService = medAccountService;
	}
	
	/**
	 * 根据条件分页查询员工医药账号信息
	 * @return Map
	 * @author FLD
	 * @date 2016-03-21
	 * */
	@RequestMapping(value = "dataList.do")
	@ResponseBody
	public Map<String, Object> dataList(MedAccount record,HttpServletRequest request,HttpServletResponse response) {
		Map<String,Object> map = this.medAccountService.dataList(record);
		return map;
	}

	/**
	 * 根据条件查询员工信息
	 * @return Map
	 * @author FLD
	 * @date 2016-03-22
	 * */
	@RequestMapping(value = "getById.do")
	@ResponseBody
	public Map<String, Object> getById(MedAccount record,HttpServletRequest request,HttpSession session,HttpServletResponse response) {
		Map<String,Object> map = this.medAccountService.getById(record);
		return map;
	}
	/**
	 * 修改用户是否为特殊用户
	 * @return Map
	 * @author FLD
	 * @date 2016-03-21
	 * */
	@RequestMapping(value = "save.do", method= RequestMethod.POST, produces = "text/htm;charset=UTF-8")  
	@ResponseBody
	public Map<String, Object> save(MedAccount record,HttpServletRequest request,HttpServletResponse response) {
		Map<String,Object> map = this.medAccountService.save(record);
		return map;
	}
	
	
	/**
	 * 医药账户管理			end
	 * ==================================================================================================
	 *	充值管理  				begin
	 */
	
	
	/**
	 * 根据条件分页查询员工医药账号信息进行充值
	 * @return Map
	 * @author FLD
	 * @date 2016-03-21
	 * */
	@RequestMapping(value = "rechargeList.do")
	@ResponseBody
	public Map<String, Object> rechargeList(MedAccount record,HttpServletRequest request,HttpServletResponse response) {
		Map<String,Object> map = this.medAccountService.rechargeList(record);
		return map;
	}
	
	/**
	 * 给用户充值
	 * @return Map
	 * @author FLD
	 * @date 2016-03-21
	 * */
	@RequestMapping(value = "saveMoney.do")
	@ResponseBody
	public Map<String, Object> saveMoney(MedAccount record,HttpServletRequest request,HttpServletResponse response) {
		Map<String,Object> map = this.medAccountService.saveMoney(record);
		return map;
	}
	
	
	
	/**
	 * 给用户批量充值
	 * @return Map
	 * @author FLD
	 * @date 2016-03-21
	 * */
	@RequestMapping(value ="fileUpload.do")
	@ResponseBody
	public Map<String, Object> fileUpload(@RequestParam MultipartFile file, HttpServletRequest request, MedAccount record) {
		Map<String,Object> map=new  HashMap<String,Object>();
		String fileName = file.getOriginalFilename();  
		 String path1=request.getSession().getServletContext().getRealPath("/")+"FileUpload/";
		 String path=path1+fileName;
		 File f=new File(path1);
		 if(f.exists()) {  
	            File[] files = f.listFiles();  
	            if(files != null) {  
	                for(File file1 : files)  
	                        file1.delete(); 
	            	}
	            }
		  try {
				file.transferTo(new File(path));//转存文件
				Workbook book = Workbook.getWorkbook(new File(path));// 获得xls文件 
                Sheet sheet = book.getSheet(0);// 获得第一个工作簿 
                int count = sheet.getRows();// 取得记录数，count行  
                if (0 == sheet.getRows()) {
    				map.put("success", false);
    				map.put("msg", "请输入员工充值记录!");
    				return map;
    			}
                for (int i = 0; i < count; i++) {  
            	//getCell(x,y)   第y行的第x列 
            	String end_sign = sheet.getCell(0, i+2).getContents().trim();	
            	if ((end_sign==null||"".equals("")) && end_sign.equals("数据结束")) {
					book.close();// 关闭workBook
					map.put("success", true);
					map.put("msg", "充值成功！");
					return map;
				}
            	
            	String	 dept = sheet.getCell(0, i+2).getContents().trim();// 部门
				String post = sheet.getCell(1, i+2).getContents().trim();// 职务
				String name = sheet.getCell(2, i+2).getContents().trim();// 姓名
				String  userno = sheet.getCell(3, i+2).getContents().trim();// 工号
				String 	money = sheet.getCell(4, i+2).getContents().trim();// 金额
				if (dept == null || dept.equals("")) {
					map.put("success", false);
    				map.put("msg", "请输入员工所属部门!");
    				return map;
				}
				if (post == null || post.equals("")) {
					map.put("success", false);
    				map.put("msg", "请输入员工职务!");
    				return map;
				}
				if (name == null || name.equals("")) {
					map.put("success", false);
    				map.put("msg", "请输入员工姓名!");
    				return map;
				}
				if (userno == null || userno.equals("")) {
					map.put("success", false);
    				map.put("msg", "请输入员工工号!");
    				return map;
				}
				if (money == null || money.equals("")) {
					map.put("success", false);
    				map.put("msg", "请输入员工充值金额!");
    				return map;
				}
              }
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (BiffException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return map; 
		  
	}
	//跳转到选择员工页面
	@RequestMapping(value="changeMoney.do")  
	public String addInventory(@RequestParam  Integer userSerial  ,HttpServletRequest request){  
		request.setAttribute("userSerial", userSerial);
		return "view/medicine/dtUser";  
	} 
	
	
	/**
	 * 查询出员工的医药账户
	 * @return Map
	 * @author FLD
	 * @date 2016-03-24
	 * */
	@RequestMapping(value = "dtUserList.do")
	@ResponseBody
	public Map<String, Object> dtUserList(MedAccount record,HttpServletRequest request,HttpServletResponse response) {
		Map<String,Object> map = this.medAccountService.dtUserList(record);
		return map;
	}
	
	/**
	 * 转移员工的医药账户
	 * @return Map
	 * @author FLD
	 * @date 2016-03-24
	 * */
	@RequestMapping(value = "updateMoney.do")
	@ResponseBody
	public Map<String, Object> updateMoney(MedAccount record) {
		Map<String,Object> map = this.medAccountService.updateMoney(record);
		return map;
	}
	@RequestMapping(value="userMessage.do") 
	public String inventoryList(){  
		return "view/medicine/userMessage";  
	} 
	/**
	 * 查询出员工的医药账户充值记录
	 * @return Map
	 * @author FLD
	 * @date 2016-03-24
	 * */
	@RequestMapping(value = "userMessageGrid.do")
	@ResponseBody
	public Map<String, Object> userMessageGrid(MedAccount record,HttpServletRequest request,HttpServletResponse response) {
		Map<String,Object> map = this.medAccountService.userMessageGrid(record);
		return map;
	}
	
	
	/**
	 * 根据条件分页查询员工医药账号信息
	 * @return Map
	 * @author FLD
	 * @date 2016-03-21
	 * */
	@RequestMapping(value = "dataList1.do")
	@ResponseBody
	public Map<String, Object> dataList1(MedAccount record,HttpServletRequest request,HttpServletResponse response) {
		Map<String,Object> map = this.medAccountService.dataList1(record);
		return map;
	}
	
	
	
	/**
	 * 部门--分页查询
	 * @return Map
	 * @author BYP
	 * @date 2016-02-23
	 * */
	@RequestMapping(value = "dataList2.do")
	@ResponseBody
	public Object dtDepDataList(Integer id,MedAccount record,HttpServletRequest request,HttpServletResponse response) {
		record.setDepParent(id);
		Object o = this.medAccountService.dataList2(record);
		return o;
	}
	
	
	
	
	
	
	/**
	 * 充值信息导出
	 * @param record
	 * @param request
	 * @param response
	 * @return
	 */
	
	@RequestMapping(value = "ExportExcel1.do")
	@ResponseBody
	public Map<String, Object> ExportExcel1(Integer id,MedAccount record,HttpServletRequest request,HttpServletResponse response) {
		record.setDepParent(id);
		Map<String,Object> map = this.medAccountService.ExportExcel1(record, request, response);
		return map;
	}
	
	/**
	 * 充值信息导出
	 * @param record
	 * @param request
	 * @param response
	 * @return
	 */
	
	@RequestMapping(value = "ExportExcel2.do")
	@ResponseBody
	public Map<String, Object> ExportExcel2(MedAccount record,HttpServletRequest request,HttpServletResponse response) {
		Map<String,Object> map = this.medAccountService.ExportExcel2(record, request, response);
		return map;
	}
	
	/**
	 * 个人充值记录
	 * @param currUser
	 * @param record
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "personalRecharge.do")
	@ResponseBody
	public Map<String, Object> personalRecharge(@ModelAttribute("currUser") DtUser currUser,MedAccount record,HttpServletRequest request,HttpServletResponse response) {
		Map<String,Object> map = this.medAccountService.personalRecharge(currUser,record);
		return map;
	}

	
}

package com.cecep.service.impl;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cecep.cache.DepCache;
import com.cecep.dao.DtUserMapper;
import com.cecep.dao.MidUserMapper;
import com.cecep.model.DtAcType;
import com.cecep.model.DtDep;
import com.cecep.model.DtUser;
import com.cecep.model.SysMenu;
import com.cecep.model.TreeNode;
import com.cecep.model.XfAcTime;
import com.cecep.service.DtUserServiceI;
import com.cecep.util.MapUtils;

@Service("dtUserService")
public class DtUserServiceImpl implements DtUserServiceI {

	private DtUserMapper dtUserMapper;
	private MidUserMapper midUserMapper;

	@Autowired
	public void setMidUserMapper(MidUserMapper midUserMapper) {
		this.midUserMapper = midUserMapper;
	}

	@Autowired
	public void setDtUserMapper(DtUserMapper dtUserMapper) {
		this.dtUserMapper = dtUserMapper;
	}

	public Map<String, Object> dataList(DtUser record) {
		Map<String, Object> map = new HashMap<String, Object>();
		if(record.getAll()!=null&&record.getAll()){
			if(record.getUserDep()!=null){
				Set<Long> userDeps = DepCache.getChildren(Long.valueOf(record.getUserDep()+""));
				record.setUserDeps(userDeps);
				record.setUserDep(null);
			}
		}
		if(record.getDepSerials()!=null&&record.getDepSerials().size()>0){
			Set<Long> userDeps = DepCache.getChildren(record.getDepSerials());
			record.setUserDeps(userDeps);
		}
		List<DtUser> list = this.dtUserMapper.selectByPage(record);
		Integer count = this.dtUserMapper.selectCount(record);
		map.put("rows", list);
		map.put("total", count);
		return map;
	}

	public Map<String, Object> getById(DtUser record) {
		Map<String, Object> map = new HashMap<String, Object>();
		DtUser user = this.dtUserMapper.selectByPrimaryKey(record
				.getUserSerial());
		map.put("data", user);
		map.put("success", true);
		return map;
	}

	public DtUser login(DtUser record) {
		DtUser user = this.dtUserMapper.selectBySelective(record);
		return user;
	}

	public List<SysMenu> getMenuTree(Integer roleId) {
		List<SysMenu> list = this.dtUserMapper.getMenuTree(roleId);
		return list;
	}

	public Map<String, Object> save(DtUser record, String[] doorBhs) {
		if (record.getUserSerial() == null) {
			this.dtUserMapper.updateUserSerial();
			Integer serial = this.dtUserMapper.selectMaxUserSerial();
			String userSerial = String.valueOf(serial);
			// 序号
			record.setUserSerial(Long.parseLong(userSerial));
			// 将相关权限插入到cecep_user_privilege表中
			Map<String, Object> paramMap = MapUtils.createMap("userSerial",
					record.getUserSerial(), "mj", record.getMj(), "st", 1);
			this.midUserMapper.insertUserPrivilege(paramMap);
			// 工号
			if(record.getUserNo()==null||record.getUserNo().equals("")){
				record.setUserNo("00000000");
			}
			this.dtUserMapper.insertRoleUser(record);
			DtDep dep = this.dtUserMapper.selectDtDepByPrimaryKey(Long
					.parseLong(record.getUserDep() + ""));
			// 部门名称
			record.setUserDepname(dep.getDepName());
			// 部门编号
			record.setDepNo(dep.getDepNo());
			// 考勤密码
			record.setUserPassword("111111");
			// 业务无关
			record.setUserFinger("0000000000");
			record.setUserLevel(0);
			record.setUserPhoto(0);
			record.setKqTiaoxiu(0);
			record.setUserAc(0);
			this.dtUserMapper.insert(record);
			DtAcType ac = this.dtUserMapper.selectDtAcTypeByPrimaryKey(record
					.getAcBh());
			Integer limit = ac.getAcLimit();
			Integer unit = ac.getAcUnit();
			Date sj = ac.getAcJssj();
			Calendar calendar = Calendar.getInstance();
			Calendar calendar2 = Calendar.getInstance();
			Date date = calendar.getTime();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
			Random rand = new Random();
			// 账户开始时间
			record.setAcBegin(date);
			// 账户结束时间
			if (limit == 0 && sj != null) {
				record.setAcEnd(sj);
			} else {
				if (unit == 0) {
					int year = calendar2.get(Calendar.YEAR);
					year = year + limit;
					calendar2.set(Calendar.YEAR, year);
					record.setAcEnd(calendar2.getTime());
				} else if (unit == 1) {
					int month = calendar2.get(Calendar.MONTH);
					month = month + limit;
					calendar2.set(Calendar.MONTH, month);
					record.setAcEnd(calendar2.getTime());
				} else if (unit == 2) {
					int day = calendar2.get(Calendar.DAY_OF_MONTH);
					day = day + limit;
					calendar2.set(Calendar.DAY_OF_MONTH, day);
					record.setAcEnd(calendar2.getTime());
				}
			}
			// 业务无关
			record.setUser1(sdf.format(date) + rand.nextInt(100));
			this.dtUserMapper.insertDtAcUser(record);
			this.dtUserMapper.updateUserAcByPrimaryKey(record.getUserSerial());
			this.dtUserMapper.insertDtAcLink(record);
			this.dtUserMapper.insertWtPublic(record);
			//设置员工的排序序号，本系统添加的员工默认排在最后
			this.dtUserMapper.updateUserOrder(record.getUserSerial());
		} else {
			this.dtUserMapper.updateRoleUser(record);
			DtDep dep = this.dtUserMapper.selectDtDepByPrimaryKey(Long
					.parseLong(record.getUserDep() + ""));
			// 部门名称
			record.setUserDepname(dep.getDepName());
			// 部门编号
			record.setDepNo(dep.getDepNo());
			this.dtUserMapper.updateByPrimaryKeySelective(record);
			DtUser user = this.dtUserMapper.selectByPrimaryKey(record
					.getUserSerial());
			Map<String, Object> paramMap = MapUtils.createMap("userSerial",
					record.getUserSerial(), "mj", record.getMj());
			this.midUserMapper.updateUserPrivilege(paramMap);
			if (user.getAcBh()==null||!user.getAcBh().equals(record.getAcBh())) {
				DtAcType ac = this.dtUserMapper
						.selectDtAcTypeByPrimaryKey(record.getAcBh());
				Integer limit = ac.getAcLimit();
				Integer unit = ac.getAcUnit();
				Date sj = ac.getAcJssj();
				Calendar calendar = Calendar.getInstance();
				Calendar calendar2 = Calendar.getInstance();
				Date date = calendar.getTime();
				// 账户开始时间
				record.setAcBegin(date);
				// 账户结束时间
				if (limit == 0 && sj != null) {
					record.setAcEnd(sj);
				} else {
					if (unit == 0) {
						int year = calendar2.get(Calendar.YEAR);
						year = year + limit;
						calendar2.set(Calendar.YEAR, year);
						record.setAcEnd(calendar2.getTime());
					} else if (unit == 1) {
						int month = calendar2.get(Calendar.MONTH);
						month = month + limit;
						calendar2.set(Calendar.MONTH, month);
						record.setAcEnd(calendar2.getTime());
					} else if (unit == 2) {
						int day = calendar2.get(Calendar.DAY_OF_MONTH);
						day = day + limit;
						calendar2.set(Calendar.DAY_OF_MONTH, day);
						record.setAcEnd(calendar2.getTime());
					}
				}
				this.dtUserMapper.updateDtAcUser(record);
			}
			this.dtUserMapper.deleteJrealUpdate(record);
			this.dtUserMapper.deleteMjUserRuleReal(record);
			if (user.getUserCard()!=null&&!user.getUserCard().equals("")&&doorBhs != null) {
				Map<String, Object> parameterMap = new HashMap<String, Object>();
				parameterMap.put("userSerial", record.getUserSerial());
				parameterMap.put("glyNo", record.getGlyNo());
				parameterMap.put("cardHao", user.getCardHao());
				parameterMap.put("doorBhs", doorBhs);
				this.dtUserMapper.insertJrealUpdate(parameterMap);
				this.dtUserMapper.insertMjUserRuleReal(parameterMap);
			}

		}
		return MapUtils.createSuccessMap();
	}

	public Map<String, Object> editPwd(DtUser record) {
		Map<String, Object> map = new HashMap<String, Object>();
		this.dtUserMapper.updateUserPassword(record);
		map.put("msg", "密码修改成功！");
		map.put("success", true);
		return map;
	}

	public Map<String, Object> getPwd(DtUser record) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> password = this.dtUserMapper
				.selectUserPassword(record);
		map.put("data", password);
		map.put("success", true);
		return map;
	}

	public List<XfAcTime> selectXfAcTime(DtUser record) {
		List<XfAcTime> list = this.dtUserMapper.selectXfAcTime(record);
		return list;
	}

	public List<TreeNode> getDoorTree(Integer depSerial) {
		List<TreeNode> list = this.dtUserMapper.getDoorTree(depSerial);
		return list;
	}

	public List<Map<String, Object>> selectStDoorReal(DtUser record) {
		List<Map<String, Object>> list = this.dtUserMapper
				.selectStDoorReal(record);
		return list;
	}

	public int needServerNotify(Long userSerial) {
		return this.dtUserMapper.needServerNotify(userSerial);
	}

	public void deleteAllUser() {
		// 1.清空role_user表中的数据
		this.dtUserMapper.clearRoleUser();
		// 2.清空dt_ac_user表中的数据
		this.dtUserMapper.clearDtAcUser();
		// 3.清空dt_ac_link表中的数据
		this.dtUserMapper.clearDtAcLink();
		// 4.根据user_serial删除wt_public表中的数据
		List<Long> users = this.dtUserMapper.selectAllSerial();
		for (Long userSerial : users) {
			this.dtUserMapper.deleteWtPublicUser(userSerial);
		}
		// 5.清空dt_user表中的数据
		this.dtUserMapper.clearDtUser();
		// 6.update wt_module set module_user = '20000001' where module_id =
		// '0002'
		this.dtUserMapper.updateWtModuleUser();
	}

	public List<Map<String, Object>> selectAcType() {

		return this.dtUserMapper.selectAcType();
	}

	public Map<String, Object> delete(DtUser record) {
		this.dtUserMapper.deleteByPrimaryKey(MapUtils.createMap("userSerial",
				record.getUserSerial()));
		return MapUtils.createSuccessMap();
	}

	public boolean checkUserManager(DtUser currUser, String url) {
		int count = this.dtUserMapper.checkUserManager(MapUtils.createMap("userSerial",currUser.getUserSerial(),"url",url));
		if(count==0){
			return false;
		}
		return true;
	}

}

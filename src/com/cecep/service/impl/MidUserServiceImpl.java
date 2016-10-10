package com.cecep.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cecep.dao.DtAcDepMapper;
import com.cecep.dao.DtDepMapper;
import com.cecep.dao.DtUserMapper;
import com.cecep.dao.MidUserMapper;
import com.cecep.model.DtAcType;
import com.cecep.model.DtDep;
import com.cecep.model.DtUser;
import com.cecep.model.MidUser;
import com.cecep.service.MidUserServiceI;
import com.cecep.util.MapUtils;

@Service("midUserService")
public class MidUserServiceImpl implements MidUserServiceI {
	/** 用于存储有重复记录的中间表记录 */
	private DtUser dtUser = null;
	private MidUserMapper midUserMapper;
	private DtUserMapper dtUserMapper;
	private DtDepMapper dtDepMapper;
	private DtAcDepMapper dtAcDepMapper;
//	private SynchronizeDepServiceImpl synchronizeDepServiceImpl;

	// @Autowired
	// public void setSynchronizeDepServiceImpl(
	// SynchronizeDepServiceImpl synchronizeDepServiceImpl) {
	// this.synchronizeDepServiceImpl = synchronizeDepServiceImpl;
	// }

	@Autowired
	public void setDtAcDepMapper(DtAcDepMapper dtAcDepMapper) {
		this.dtAcDepMapper = dtAcDepMapper;
	}

	@Autowired
	public void setDtDepMapper(DtDepMapper dtDepMapper) {
		this.dtDepMapper = dtDepMapper;
	}

	@Autowired
	public void setMidUserMapper(MidUserMapper midUserMapper) {
		this.midUserMapper = midUserMapper;
	}

	@Autowired
	public void setDtUserMapper(DtUserMapper dtUserMapper) {
		this.dtUserMapper = dtUserMapper;
	}

	public Map<String, Object> selectIsSynchronized(MidUser record) {
		Map<String, Object> map = new HashMap<String, Object>();
		Integer count = this.midUserMapper.selectIsSynchronized();
		map.put("count", count);
		return map;
	}

	public void save(MidUser record) {
		Integer count = this.midUserMapper.selectByPrimaryKey(record.getDm());
		if (count > 0) {
			this.midUserMapper.updateByPrimaryKey(record);
		} else {
			this.midUserMapper.insert(record);
		}
	}

	/**
	 * 根据mid_internal_dep表初始化员工数据
	 * 
	 * @return
	 */
	public Map<String, Object> initInternalUser() {
		// 1.将cecep_compare表中的数据插入到dt_user表中
		List<DtUser> users = this.midUserMapper.synchronizeByDnEn();
		this.saveUsers(users);
		return MapUtils.createSuccessMap();
	}

	/**
	 * 根据mid_external_dep表初始化外部人员数据
	 * 
	 * @return
	 */
	public Map<String, Object> initExternalUser() {
		List<DtUser> list = this.midUserMapper.synchronizeExternalUser();
		this.saveExternalUsers(list);
		return MapUtils.createSuccessMap();
	}
	
	public Map<String,Object> midUserSynchronize(){
		List<DtUser> list = this.midUserMapper.midUserSynchronize();
		return MapUtils.createSuccessMap("data",list);
	}

	/**
	 * 用于将中间表mid_user中的新增数据同步到dt_user中，若存在已开卡的人员与
	 */
//	public Map<String, Object> synchronize(String[] depNos, String[] userTypes) {
//		Map<String, Object> resultMap = new HashMap<String, Object>();
//		Map<String, Object> parameterMap = new HashMap<String, Object>();
//		if (depNos != null) {
//			parameterMap.put("depNos", depNos);
//		} else {
//			parameterMap.put("depNos", null);
//		}
//		if (userTypes != null) {
//			Short[] userTypes_s = new Short[userTypes.length];
//			for (int i = 0; i < userTypes.length; i++) {
//				userTypes_s[i] = Short.parseShort(userTypes[i]);
//			}
//			parameterMap.put("userTypes", userTypes_s);
//		} else {
//			parameterMap.put("userTypes", null);
//		}
//		// 当存在部门和姓名均相同的实习生时添加到此List中
//		List<DtUser> showList = new ArrayList<DtUser>();
//		List<DtUser> list = this.midUserMapper.synchronize(parameterMap);
//		if (list.size() > 0) {
//			for (DtUser user : list) {
//				List<DtUser> tempList = null;
//				Map<String, String> map = new HashMap<String, String>();
//				if (user.getUserSerial() == null) { // 未与主数据表同步： 1、本地员工表中没有该员工记录
//													// 2、本地员工表中已存在该员工记录
//					map.put("userLname", user.getUserLname());
//					map.put("userDepname", user.getUserDepname());
//					tempList = this.dtUserMapper.selectSynchronizeUser(map);
//					int length = tempList.size();
//					if (length > 1) { // 表明本地表中包含多个相同部门及相同姓名的实习生记录
//						showList.addAll(tempList);
//						dtUser = user;
//					} else if (length == 1) { // 存在一条记录，未与主数据同步过
//						user.setUserSerial(Long.valueOf(tempList.get(0)
//								.getUserSerial()));
//						this.dtUserMapper.updateByPrimaryKeySelective(user);
//					} else { // 不存在记录，直接插入到数据库中
//						this.dtUserMapper.updateUserSerial();
//						Integer serial = this.dtUserMapper
//								.selectMaxUserSerial();
//						// 序号
//						user.setUserSerial(Long.parseLong(String
//								.valueOf(serial)));
//						// TODO 角色主键
//						user.setRoleId(2);
//						this.dtUserMapper.insertRoleUser(user);
//						// 考勤密码
//						user.setUserPassword("111111");
//						// 业务无关
//						user.setUserFinger("0000000000");
//						user.setUserLevel(0);
//						user.setUserPhoto(0);
//						user.setKqTiaoxiu(0);
//						user.setUserAc(0);
//						this.dtUserMapper.insert(user);
//						// TODO 账户编号
//						user.setAcBh("0000000000000001");
//						DtAcType ac = this.dtUserMapper
//								.selectDtAcTypeByPrimaryKey(user.getAcBh());
//						Integer limit = ac.getAcLimit();
//						Integer unit = ac.getAcUnit();
//						Date sj = ac.getAcJssj();
//						Calendar calendar = Calendar.getInstance();
//						Calendar calendar2 = Calendar.getInstance();
//						Date date = calendar.getTime();
//						// 账户开始时间
//						user.setAcBegin(date);
//						// 账户结束时间
//						if (limit == 0 && sj != null) {
//							user.setAcEnd(sj);
//						} else {
//							if (unit == 0) {
//								int year = calendar2.get(Calendar.YEAR);
//								year = year + limit;
//								calendar2.set(Calendar.YEAR, year);
//								user.setAcEnd(calendar2.getTime());
//							} else if (unit == 1) {
//								int month = calendar2.get(Calendar.MONTH);
//								month = month + limit;
//								calendar2.set(Calendar.MONTH, month);
//								user.setAcEnd(calendar2.getTime());
//							} else if (unit == 2) {
//								int day = calendar2.get(Calendar.DAY_OF_MONTH);
//								day = day + limit;
//								calendar2.set(Calendar.DAY_OF_MONTH, day);
//								user.setAcEnd(calendar2.getTime());
//							}
//						}
//						this.dtUserMapper.insertDtAcUser(user);
//						this.dtUserMapper.updateUserAcByPrimaryKey(user
//								.getUserSerial());
//						this.dtUserMapper.insertDtAcLink(user);
//						this.dtUserMapper.insertWtPublic(user);
//					}
//				} else {
//					// 如果有userSerial则表明dt_user表中的该用户已经于主数据同步过；
//					this.dtUserMapper.updateByPrimaryKeySelective(user);
//				}
//			}
//
//		}
//		if (showList.size() > 0) {
//			resultMap.put("check", true);
//			resultMap.put("showList", showList);
//			list.removeAll(showList);
//		}
//		this.midUserMapper.updateIsSynchronized(list);
//		resultMap.put("success", true);
//		return resultMap;
//	}
	
	/**
	 * 用于将中间表mid_user中的新增数据同步到dt_user中，若存在已开卡的人员与
	 */
	public Map<String, Object> synchronize() {
		List<DtUser> list = this.midUserMapper.synchronize();
		List<DtUser> hasSynchroized = new ArrayList<DtUser>();
		if (list.size() > 0) {
			for (DtUser user : list) {
				//1.根据user_no能够查到的人自动同步
				if(user.getUserSerial()!=null){
					//2.将状态为退休且是总部的员工同步到总部退休员工部门下
					user.setUserDep(null);
					user.setDepNo(null);
					user.setUserDepname(null);
					this.dtUserMapper.updateByPrimaryKeySelective(user);
					hasSynchroized.add(user);
				}else{
					//3.根据部门序号、姓名能够唯一匹配同步，且未同步过
					DtUser record = new DtUser();
					record.setUserLname(user.getUserLname());
					record.setUserDep(user.getUserDep());
					record.setRows(100);
					record.setPage(0);
					//根据员工姓名和所属公司查找dt_user表
					List<DtUser> users = this.dtUserMapper.selectByNameAndCompany(record);
					//如果在该公司下未同步员工只有一个，则同步
					if(users.size()==1){
						user.setUserSerial(users.get(0).getUserSerial());
						user.setUserDep(null);
						user.setDepNo(null);
						user.setUserDepname(null);
						this.dtUserMapper.updateByPrimaryKeySelective(user);
						hasSynchroized.add(user);
					}else if(users.size()==0){  //如果不存在未同步且姓名相同的人，直接插入
						this.insert(user);
						hasSynchroized.add(user);
					}
				}
			}
		}
		this.midUserMapper.updateIsSynchronized(hasSynchroized);
		return  MapUtils.createSuccessMap();
	}
	
	private void insert(DtUser user){
		 // 不存在记录，直接插入到数据库中
		this.dtUserMapper.updateUserSerial();
		Integer serial = this.dtUserMapper.selectMaxUserSerial();
		// 序号
		user.setUserSerial(Long.parseLong(String.valueOf(serial)));
		// TODO 角色主键
		user.setRoleId(2);
		this.dtUserMapper.insertRoleUser(user);
		// 考勤密码
		user.setUserPassword("111111");
		// 业务无关
		user.setUserFinger("0000000000");
		user.setUserLevel(0);
		user.setUserPhoto(0);
		user.setKqTiaoxiu(0);
		user.setUserAc(0);
		this.dtUserMapper.insert(user);
		// TODO 账户编号
		user.setAcBh("0000000000000001");
		DtAcType ac = this.dtUserMapper
				.selectDtAcTypeByPrimaryKey(user.getAcBh());
		Integer limit = ac.getAcLimit();
		Integer unit = ac.getAcUnit();
		Date sj = ac.getAcJssj();
		Calendar calendar = Calendar.getInstance();
		Calendar calendar2 = Calendar.getInstance();
		Date date = calendar.getTime();
		// 账户开始时间
		user.setAcBegin(date);
		// 账户结束时间
		if (limit == 0 && sj != null) {
			user.setAcEnd(sj);
		} else {
			if (unit == 0) {
				int year = calendar2.get(Calendar.YEAR);
				year = year + limit;
				calendar2.set(Calendar.YEAR, year);
				user.setAcEnd(calendar2.getTime());
			} else if (unit == 1) {
				int month = calendar2.get(Calendar.MONTH);
				month = month + limit;
				calendar2.set(Calendar.MONTH, month);
				user.setAcEnd(calendar2.getTime());
			} else if (unit == 2) {
				int day = calendar2.get(Calendar.DAY_OF_MONTH);
				day = day + limit;
				calendar2.set(Calendar.DAY_OF_MONTH, day);
				user.setAcEnd(calendar2.getTime());
			}
		}
		this.midUserMapper.insertUserPrivilege(MapUtils.createMap("userSerial",
				serial, "mj", 1, "st", 1,"userOrder",user.getUserOrder()));
		this.dtUserMapper.insertDtAcUser(user);
		this.dtUserMapper.updateUserAcByPrimaryKey(user
				.getUserSerial());
		this.dtUserMapper.insertDtAcLink(user);
		this.dtUserMapper.insertWtPublic(user);
	
	}

	public Map<String, Object> synchronizeRepeatDtUser(String userSerial) {
		if (dtUser != null) {
			dtUser.setUserSerial(Long.valueOf(userSerial));
			this.dtUserMapper.updateByPrimaryKeySelective(dtUser);
			List<DtUser> list = new ArrayList<DtUser>();
			list.add(dtUser);
			this.midUserMapper.updateIsSynchronized(list);
			dtUser = null;
			return MapUtils.createSuccessMap("msg", "同步成功！");
		} else {
			return MapUtils.createFailedMap("msg", "同步失败，请联系管理员！");
		}
	}

	private void saveUsers(List<DtUser> list) {
		if (list != null && list.size() > 0) {
			for (DtUser user : list) {
				if (user.getUserNo() == null || user.getUserNo().equals("")) {
					user.setUserNo("00000000");
				}
				this.dtUserMapper.updateUserSerial();
				Integer serial = this.dtUserMapper.selectMaxUserSerial();
				// 序号
				user.setUserSerial(Long.parseLong(String.valueOf(serial)));
				// TODO 角色主键
				user.setRoleId(2);
				this.dtUserMapper.insertRoleUser(user);
				// 考勤密码
				user.setUserPassword("111111");
				// 业务无关
				user.setUserFinger("0000000000");
				user.setUserLevel(0);
				user.setUserPhoto(0);
				user.setKqTiaoxiu(0);
				user.setUserAc(0);
				this.dtUserMapper.insert(user);
				// TODO 账户编号
				Map<String, Object> map = MapUtils.createMap("userSerial",
						serial, "mj", 1, "st", 1);
				// if(user.getPrivilege1().indexOf("3")!=-1){
				user.setAcBh("0000000000000001");
				// }else{
				// user.setAcBh("2016072515403232");
				// map.put("st", 0);
				// }
				// if(user.getPrivilege1().indexOf("2")==-1){
				// map.put("mj", 0);
				// }
				// 将用户权限插入到cecep_user_privilege表中
				this.midUserMapper.insertUserPrivilege(map);
				DtAcType ac = this.dtUserMapper.selectDtAcTypeByPrimaryKey(user
						.getAcBh());
				Integer limit = ac.getAcLimit();
				Integer unit = ac.getAcUnit();
				Date sj = ac.getAcJssj();
				Calendar calendar = Calendar.getInstance();
				Calendar calendar2 = Calendar.getInstance();
				Date date = calendar.getTime();
				// 账户开始时间
				user.setAcBegin(date);
				// 账户结束时间
				if (limit == 0 && sj != null) {
					user.setAcEnd(sj);
				} else {
					if (unit == 0) {
						int year = calendar2.get(Calendar.YEAR);
						year = year + limit;
						calendar2.set(Calendar.YEAR, year);
						user.setAcEnd(calendar2.getTime());
					} else if (unit == 1) {
						int month = calendar2.get(Calendar.MONTH);
						month = month + limit;
						calendar2.set(Calendar.MONTH, month);
						user.setAcEnd(calendar2.getTime());
					} else if (unit == 2) {
						int day = calendar2.get(Calendar.DAY_OF_MONTH);
						day = day + limit;
						calendar2.set(Calendar.DAY_OF_MONTH, day);
						user.setAcEnd(calendar2.getTime());
					}
				}
				this.dtUserMapper.insertDtAcUser(user);
				this.dtUserMapper
						.updateUserAcByPrimaryKey(user.getUserSerial());
				this.dtUserMapper.insertDtAcLink(user);
				this.dtUserMapper.insertWtPublic(user);
				//
			}
			this.midUserMapper.updateIsSynchronized1(list);
		}
	}

	private void saveExternalUsers(List<DtUser> list) {
		if (list != null && list.size() > 0) {
			for (DtUser user : list) {
				user.setUserNo("00000000");
				this.dtUserMapper.updateUserSerial();
				Integer serial = this.dtUserMapper.selectMaxUserSerial();
				// 序号
				user.setUserSerial(Long.parseLong(String.valueOf(serial)));
				// 判断是否是总部,是则根据部门查找depSerial，并将其设置为userdep；不是则将其company和companySerial设置为userdep及userdepname
				if ("中国节能环保集团公司总部".equals(user.getCompany())) {
					List<Map<String, Object>> zbDep = this.midUserMapper
							.selectZbDep();
					Map<String, Object> deps = new HashMap<String, Object>();
					for (Map<String, Object> map : zbDep) {
						deps.put((String) map.get("depName"),
								map.get("depSerial"));
					}
					user.setUserDep(Integer.parseInt((Long) deps.get(user
							.getUserDepname()) + ""));
				} else {
					DtDep benbu = this.dtDepMapper.selectHasBenbu(user
							.getCompanySerial());
					if (benbu != null) {
						user.setUserDep(benbu.getDepSerial().intValue());
						user.setUserDepname(benbu.getDepName());
					} else {
						user.setUserDep(user.getCompanySerial());
						user.setUserDepname(user.getCompany());
					}
				}
				Map<String, Object> map = MapUtils.createMap("userSerial",
						serial, "mj", 1, "st", 1);
				// 判断是否是公卡，是则根据company创建公卡部门，不是则根据company创建外部人员部门
				if (user.getUserLname().indexOf("卡") != -1) {
					map.put("external", 2);
					String exist = this.dtDepMapper
							.selectDepByNameAndSerial(MapUtils.createMap(
									"parentId", user.getUserDep(), "name", "公卡"));
					if (exist == null) {
						List<String> acdepSerials = this.midUserMapper
								.selectAcDepSerials(user.getUserDep()
										.toString());
						DtDep dep = new DtDep();
						dep.setDepName("公卡");
						this.dtDepMapper.updateDepSerial();
						Integer newDepSerial = this.dtDepMapper
								.selectMaxDepSerial();
						// 序号
						dep.setDepSerial(Long.parseLong(newDepSerial + ""));
						dep.setDepNo("99999999");
						dep.setDepOrder(0);
						dep.setDepRule("0");
						dep.setDepParent(user.getUserDep());
						this.dtDepMapper.insert(dep);
						user.setUserDep(newDepSerial);
						if (acdepSerials != null && acdepSerials.size() > 0) {
							this.dtAcDepMapper.insertDtDev(MapUtils.createMap(
									"depSerial", newDepSerial, "ids",
									acdepSerials));
						}
					} else {
						user.setUserDep(Integer.parseInt(exist));
					}
					user.setUserDepname("公卡");
				} else {
					map.put("external", 1);
					String exist = this.dtDepMapper
							.selectDepByNameAndSerial(MapUtils.createMap(
									"parentId", user.getUserDep(), "name",
									"外部人员"));
					if (exist == null) {
						List<String> acdepSerials = this.midUserMapper
								.selectAcDepSerials(user.getUserDep()
										.toString());
						DtDep dep = new DtDep();
						dep.setDepName("外部人员");
						this.dtDepMapper.updateDepSerial();
						Integer newDepSerial = this.dtDepMapper
								.selectMaxDepSerial();
						// 序号
						dep.setDepSerial(Long.parseLong(newDepSerial + ""));
						dep.setDepNo("99999999");
						dep.setDepOrder(0);
						dep.setDepRule("0");
						dep.setDepParent(user.getUserDep());
						this.dtDepMapper.insert(dep);
						user.setUserDep(newDepSerial);
						if (acdepSerials != null && acdepSerials.size() > 0) {
							this.dtAcDepMapper.insertDtDev(MapUtils.createMap(
									"depSerial", newDepSerial, "ids",
									acdepSerials));
						}
					} else {
						user.setUserDep(Integer.parseInt(exist));
					}
					user.setUserDepname("外部人员");
				}
				// 业务无关
				user.setUserFinger("0000000000");
				user.setUserLevel(0);
				user.setUserPhoto(0);
				user.setKqTiaoxiu(0);
				user.setUserAc(0);
				this.dtUserMapper.insertSelective1(user);
				// TODO 账户编号
				if (user.getPrivilege1().indexOf("3") != -1) {
					user.setAcBh("0000000000000001");
				} else {
					user.setAcBh("2016072515403232");
					map.put("st", 0);
				}
				if (user.getPrivilege1().indexOf("2") == -1) {
					map.put("mj", 0);
				}
				// 将用户权限插入到cecep_user_privilege表中
				this.midUserMapper.insertUserPrivilege(map);
				DtAcType ac = this.dtUserMapper.selectDtAcTypeByPrimaryKey(user
						.getAcBh());
				Integer limit = ac.getAcLimit();
				Integer unit = ac.getAcUnit();
				Date sj = ac.getAcJssj();
				Calendar calendar = Calendar.getInstance();
				Calendar calendar2 = Calendar.getInstance();
				Date date = calendar.getTime();
				// 账户开始时间
				user.setAcBegin(date);
				// 账户结束时间
				if (limit == 0 && sj != null) {
					user.setAcEnd(sj);
				} else {
					if (unit == 0) {
						int year = calendar2.get(Calendar.YEAR);
						year = year + limit;
						calendar2.set(Calendar.YEAR, year);
						user.setAcEnd(calendar2.getTime());
					} else if (unit == 1) {
						int month = calendar2.get(Calendar.MONTH);
						month = month + limit;
						calendar2.set(Calendar.MONTH, month);
						user.setAcEnd(calendar2.getTime());
					} else if (unit == 2) {
						int day = calendar2.get(Calendar.DAY_OF_MONTH);
						day = day + limit;
						calendar2.set(Calendar.DAY_OF_MONTH, day);
						user.setAcEnd(calendar2.getTime());
					}
				}
				this.dtUserMapper.insertDtAcUser(user);
				this.dtUserMapper
						.updateUserAcByPrimaryKey(user.getUserSerial());
				this.dtUserMapper.insertDtAcLink(user);
				this.dtUserMapper.insertWtPublic(user);
				//
			}
			this.midUserMapper.updateIsSynchronized2(list);
		}
	}

	public Map<String, Object> saveInternalUser1() {
		List<DtUser> list = this.midUserMapper.selectInternalUsers1();
		this.saveInternalUsers1(list);
		return MapUtils.createSuccessMap();
	}

	private void saveInternalUsers1(List<DtUser> list) {
		if (list != null && list.size() > 0) {
			for (DtUser user : list) {
				user.setUserNo("00000000");
				this.dtUserMapper.updateUserSerial();
				Integer serial = this.dtUserMapper.selectMaxUserSerial();
				// 序号
				user.setUserSerial(Long.parseLong(String.valueOf(serial)));
				// 判断是否是总部,是则根据部门查找depSerial，并将其设置为userdep；不是则将其company和companySerial设置为userdep及userdepname
				if ("中国节能环保集团公司总部".equals(user.getCompany())) {
					List<Map<String, Object>> zbDep = this.midUserMapper
							.selectZbDep1();
					Map<String, Object> deps = new HashMap<String, Object>();
					for (Map<String, Object> map : zbDep) {
						deps.put((String) map.get("depName"),
								map.get("depSerial"));
					}
					user.setUserDep(Integer.parseInt((Long) deps.get(user
							.getUserDepname()) + ""));
					if ("总部退休员工".equals(user.getUserDepname())) {
						user.setUserType((short) 66);
					}
				} else {
					DtDep benbu = this.dtDepMapper.selectHasBenbu(user
							.getCompanySerial());
					if (benbu != null) {
						user.setUserDep(benbu.getDepSerial().intValue());
						user.setUserDepname(benbu.getDepName());
					} else {
						user.setUserDep(user.getCompanySerial());
						user.setUserDepname(user.getCompany());
					}
				}
				String name = "总部退休员工".equals(user.getUserDepname()) ? "总部退休员工"
						: "内部未同步员工";
				String exist = this.dtDepMapper
						.selectDepByNameAndSerial(MapUtils.createMap(
								"parentId", user.getUserDep(), "name", name));
				if (exist == null) {
					List<String> acdepSerials = this.midUserMapper
							.selectAcDepSerials(user.getUserDep().toString());
					DtDep dep = new DtDep();
					dep.setDepName(name);
					this.dtDepMapper.updateDepSerial();
					Integer newDepSerial = this.dtDepMapper
							.selectMaxDepSerial();
					// 序号
					dep.setDepSerial(Long.parseLong(newDepSerial + ""));
					dep.setDepNo("99999999");
					dep.setDepOrder(0);
					dep.setDepRule("0");
					dep.setDepParent(user.getUserDep());
					this.dtDepMapper.insert(dep);
					user.setUserDep(newDepSerial);
					if (acdepSerials != null && acdepSerials.size() > 0) {
						this.dtAcDepMapper
								.insertDtDev(MapUtils.createMap("depSerial",
										newDepSerial, "ids", acdepSerials));
					}
				} else {
					user.setUserDep(Integer.parseInt(exist));
				}
				user.setUserDepname(name);
				user.setDepNo("99999999");
				// TODO 角色主键
				user.setRoleId(2);
				this.dtUserMapper.insertRoleUser(user);
				// 业务无关
				user.setUserFinger("0000000000");
				user.setUserLevel(0);
				user.setUserPhoto(0);
				user.setKqTiaoxiu(0);
				user.setUserAc(0);
				Map<String, Object> paramMap = MapUtils.createMap("userSerial",
						serial, "mj", 1, "st", 1);
				if ("总部退休人员".equals(user.getUserDepname())) {
					paramMap.put("external", 4);
				} else {
					paramMap.put("external", 3);
				}
				this.dtUserMapper.insertSelective1(user);
				// TODO 账户编号
				if (user.getPrivilege1().indexOf("3") != -1) {
					user.setAcBh("0000000000000001");
				} else {
					user.setAcBh("2016072515403232");
					paramMap.put("st", 0);
				}
				if (user.getPrivilege1().indexOf("2") == -1) {
					paramMap.put("mj", 0);
				}
				// 将用户权限插入到cecep_user_privilege表中
				this.midUserMapper.insertUserPrivilege(paramMap);
				DtAcType ac = this.dtUserMapper.selectDtAcTypeByPrimaryKey(user
						.getAcBh());
				Integer limit = ac.getAcLimit();
				Integer unit = ac.getAcUnit();
				Date sj = ac.getAcJssj();
				Calendar calendar = Calendar.getInstance();
				Calendar calendar2 = Calendar.getInstance();
				Date date = calendar.getTime();
				// 账户开始时间
				user.setAcBegin(date);
				// 账户结束时间
				if (limit == 0 && sj != null) {
					user.setAcEnd(sj);
				} else {
					if (unit == 0) {
						int year = calendar2.get(Calendar.YEAR);
						year = year + limit;
						calendar2.set(Calendar.YEAR, year);
						user.setAcEnd(calendar2.getTime());
					} else if (unit == 1) {
						int month = calendar2.get(Calendar.MONTH);
						month = month + limit;
						calendar2.set(Calendar.MONTH, month);
						user.setAcEnd(calendar2.getTime());
					} else if (unit == 2) {
						int day = calendar2.get(Calendar.DAY_OF_MONTH);
						day = day + limit;
						calendar2.set(Calendar.DAY_OF_MONTH, day);
						user.setAcEnd(calendar2.getTime());
					}
				}
				this.dtUserMapper.insertDtAcUser(user);
				this.dtUserMapper
						.updateUserAcByPrimaryKey(user.getUserSerial());
				this.dtUserMapper.insertDtAcLink(user);
				this.dtUserMapper.insertWtPublic(user);
				//
			}
			this.midUserMapper.updateIsSynchronized3(list);
		}
	}

	public Map<String, Object> insertTestKqJl() {
		Random random = new Random();
		// 1.查询用户,user_serial,user_card
		List<DtUser> users = this.dtUserMapper.getAllUser();
		// 2.查询速通门编号
		String[] mbhs = { "2016072810514830", "2016072810560836",
				"2016072810583777", "2016072811073617" };
		// 3.定义方向
		// 设置时间sj和jl_sj
		int day = 21;
		int hrs[] = { 8, 9 };
		int[] hrs2 = { 16, 17 };
		Calendar calendar = Calendar.getInstance();
		Date date = null;
		Map<String, Object> paramMap = null;
		// 为每位员工每天插入4条门禁记录，两个开门两个关门
		// 门禁记录必须的列:
		// jl_sj,gate_bh,fx,dev_serial=0010006,user_serial,user_card=99999999,jl_type,sj,state=0
		while (day <= 31) {
			for (DtUser user : users) {
				calendar.set(2016, 7, day, hrs[random.nextInt(2)],
						random.nextInt(60), random.nextInt(60));
				date = calendar.getTime();
				paramMap = MapUtils.createMap("jl_sj", date, "gate_bh",
						mbhs[random.nextInt(4)], "fx", 0, "dev_serial",
						"0010006", "user_serial", user.getUserSerial(),
						"user_card", "99999999", "jl_type", 45, "sj", date,
						"state", 0);
				this.midUserMapper.insertMjJl(paramMap);
				calendar.set(2016, 7, day, hrs2[random.nextInt(2)],
						random.nextInt(60), random.nextInt(60));
				date = calendar.getTime();
				paramMap = MapUtils.createMap("jl_sj", date, "gate_bh",
						mbhs[random.nextInt(4)], "fx", 1, "dev_serial",
						"0010006", "user_serial", user.getUserSerial(),
						"user_card", "99999999", "jl_type", 45, "sj", date,
						"state", 0);
				this.midUserMapper.insertMjJl(paramMap);
				calendar.set(2016, 7, day, hrs[random.nextInt(2)],
						random.nextInt(60), random.nextInt(60));
				date = calendar.getTime();
				paramMap = MapUtils.createMap("jl_sj", date, "gate_bh",
						mbhs[random.nextInt(4)], "fx", 0, "dev_serial",
						"0010006", "user_serial", user.getUserSerial(),
						"user_card", "99999999", "jl_type", 45, "sj", date,
						"state", 0);
				this.midUserMapper.insertMjJl(paramMap);
				calendar.set(2016, 7, day, hrs2[random.nextInt(2)],
						random.nextInt(60), random.nextInt(60));
				date = calendar.getTime();
				paramMap = MapUtils.createMap("jl_sj", date, "gate_bh",
						mbhs[random.nextInt(4)], "fx", 1, "dev_serial",
						"0010006", "user_serial", user.getUserSerial(),
						"user_card", "99999999", "jl_type", 45, "sj", date,
						"state", 0);
				this.midUserMapper.insertMjJl(paramMap);
			}
			day++;
		}

		//

		// 根据门编号查询设备号

		// List<String> users =
		return null;
	}

	public Map<String, Object> midUserSynchronizeCount() {
		//判断是否有员工管理功能的权限
		Integer count = this.midUserMapper.midUserSynchronizeCount();
		return MapUtils.createSuccessMap("count",count);
	}

	public Map<String, Object> synchronizeUsers(List<DtUser> list) {
		// TODO Auto-generated method stub
		Integer depSerial = null;
		Short userType = null;
		if(list!=null&&list.size()>0){
			for(DtUser user : list){
				try {
					depSerial = Integer.valueOf(user.getUserDepname());
				} catch (Exception e) {
					depSerial = user.getUserDep();
				}
				try {
					userType = Short.valueOf(user.getUserTypeName());
				} catch (Exception e) {
					userType = user.getUserType();
				}
				user.setUserDep(depSerial);
				DtUser temp = this.dtUserMapper.selectByUserNo(user);
				temp.setUserSerial(user.getUserSerial());
				temp.setUserType(userType);
				this.dtUserMapper.updateByPrimaryKeySelective(temp);
			}
		}
		return MapUtils.createSuccessMap("msg","同步成功!");
	}
}

package com.cecep.cache;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.cecep.dao.DtDepMapper;
import com.cecep.util.MapUtils;

/**
 * 用于缓存部门序号，防止多次递归查询部门及其子部门序号，init方法在应用程序启动时调用一次，之后每次同步部门数据后调用一次
 * @author ll
 *
 */
public class DepCache {

	public static DepTree root;
	
	public static void init(DtDepMapper depMapper){
		Long depSerial = Long.valueOf(depMapper.getRootDepSerial(MapUtils.createMap("depNo", "10000000")));
		root = new DepTree(depSerial,depMapper);
	}
	
	/**
	 * 根据部门编号查找其所有下级公司及部门（包括自己）
	 * @param depSerial
	 * @return
	 */
	public static Set<Long> getChildren(Long depSerial){
		Set<Long> result = new HashSet<Long>();
		DepTree depTree = findByDepSerial(root,depSerial);
		if(depTree!=null){
			depTree.getAllChildren(result);
		}
		return result;
	}
	
	/**
	 * 根据部门编号集合查找其所有下级公司及部门（包括自己）
	 * @param depSerials
	 * @return
	 */
	public static Set<Long> getChildren(List<Long> depSerials){
		Set<Long> result = new HashSet<Long>();
		if(depSerials==null||depSerials.size()==0){
			return null;
		}
		for(Long depSerial : depSerials){
			result.addAll(getChildren(depSerial));
		}
		return result;
	}
	
	private static DepTree findByDepSerial(DepTree depTree,Long depSerial){
		if(depTree.getDepSerial().longValue()==depSerial.longValue()){
			return depTree;
		}else{
			if(depTree.getChildren()!=null&&depTree.getChildren().size()>0){
				for(DepTree tree : depTree.getChildren()){
					DepTree result = findByDepSerial(tree,depSerial);
					if(result!=null){
						return result;
					}
				}
			}
		}
		return null;
	}
	
}

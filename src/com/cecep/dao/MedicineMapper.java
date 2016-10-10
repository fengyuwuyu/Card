package com.cecep.dao;

import java.util.List;
import java.util.Map;

import com.cecep.model.Medicine;
import com.cecep.model.SysUser;

public interface MedicineMapper {
    int deleteByPrimaryKey(Integer medicineId);

    int insert(Medicine record);

    int insertSelective(Medicine record);

    Medicine selectByPrimaryKey(Integer medicineId);

    int updateByPrimaryKeySelective(Medicine record);

    int updateByPrimaryKey(Medicine record);
    int selectCouBarCode(Medicine record);
    
    int selectCou(Integer medicineId);
    //分页查询
    List<Medicine> selectByPage(Medicine record);
    Integer selectCount(Medicine record);
    //下拉查询
    List<Map<String,Object>> load(SysUser record);
    //查询药品分类信息
    List<Map<String,Object>> selectType(Medicine record);
}
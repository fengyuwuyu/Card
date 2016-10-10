package com.cecep.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Service;

import com.cecep.dao.CecepWordsMapper;
import com.cecep.model.CecepWords;
import com.cecep.model.DtUser;

@Service
public class ChangeWordToPinYin {
	
	/**
	 * 将未同步过且属于内部（根据cecep_user_privilege表的update_1字段判断）员工的名字转换为pinyin存储在cecep_user_privilege表中
	 * @param cecepWordsMapper
	 */
	public static void oprator(CecepWordsMapper cecepWordsMapper){
		List<DtUser> users = cecepWordsMapper.selectAllUsersBySync();
		List<CecepWords> words = cecepWordsMapper.selectAllPinYin();
		Map<String,String> map = new HashMap<String, String>();
		for (CecepWords word : words) {
			map.put(word.getWord(), word.getPinyin());
		}
		if(users!=null&&users.size()>0){
			for(int i=0;i<users.size();i++){
				String pinyin = "";
				String [] s = users.get(i).getUserLname().split("");
				String temp = null;
				for(int j=1;j<s.length;j++){
					temp = map.get(s[j]);
					if(temp==null||temp.length()==0){
						if(CommonsUtil.match("[1-9a-zA-Z]", s[j])){
							temp = s[j];
						}else{
							temp = "-";
//							CecepWords record = new CecepWords(pinyin, s[j]);
//							cecepWordsMapper.insertSelective(record);
						}
					}
					pinyin+=temp;
				}
				users.get(i).setPinyin(pinyin);
				updateUserPinYin(cecepWordsMapper,users.get(i));
			}
			//更新cecep_user_privilege表中的update_1字段为1
			cecepWordsMapper.updateSynchronized(MapUtils.createMap("users",users));
		}
	}
	
	public static void updateUserPinYin(CecepWordsMapper cecepWordsMapper,DtUser user){
		String pinyin = user.getPinyin();
		List<String> pinyins = cecepWordsMapper.selectDtUserByPinYin(MapUtils.createMap("pinyin",pinyin));
		int max = -1;
		if(pinyins!=null&&pinyins.size()>0){
			for (String string : pinyins) {
				try {
					String sub = string.substring(pinyin.length());
					Integer num = null;
					if(sub==null||sub.trim().length()==0){
						num = 0;
					}else{
						num = Integer.valueOf(sub);
					}
					if(num>max){
						max = num;
					}
				} catch (Exception e) {
					continue;
				}
			}
			String serial = max==-1?"":"00".substring(0,2-(max+"").length())+(max+1);
			user.setPinyin(pinyin+serial);
			cecepWordsMapper.updateCecepUserPrivilege(user);
		}else{
			//若不存在拼音相同的员工，则直接更新
			cecepWordsMapper.updateCecepUserPrivilege(user);
		}
	}
	
	public static void initCecepWords(CecepWordsMapper cecepWordsMapper){
		InputStream in = ChangeWordToPinYin.class.getResourceAsStream("/words.txt");
		try {
			String  content = IOUtils.toString(in,"UTF-8");
			String pinyins[] = content.split(",");
			if(pinyins!=null&&pinyins.length>0){
				for (String string : pinyins) {
					String ss[] = string.split(":");
					List<CecepWords> cecepWords = new ArrayList<CecepWords>();
					String words[] = ss[1].split("");
					if(words!=null&&words.length>0){
						for (int i=1;i<words.length;i++) {
							cecepWords.add(new CecepWords(ss[0], words[i]));
						}
					}
					System.out.println(cecepWords);
					cecepWordsMapper.insertList(MapUtils.createMap("words",cecepWords));
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		//初始化cecep_words表
		initCecepWords(null);
	}
}

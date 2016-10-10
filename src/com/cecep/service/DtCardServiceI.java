package com.cecep.service;

import java.util.Map;


import com.cecep.model.DtCard;

public interface DtCardServiceI {
	
	Map<String, Object> openCard(DtCard record);
	Map<String, Object> lockCard(DtCard record);
	Map<String, Object> readCard(String cardHao);
	Map<String, Object> unlockCard(DtCard record);
	Map<String, Object> returnCard(DtCard record);
	Map<String, Object> upCard(DtCard record,String physicsCard);

}

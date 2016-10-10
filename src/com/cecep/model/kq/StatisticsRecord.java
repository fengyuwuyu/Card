package com.cecep.model.kq;

import java.sql.Time;
import java.util.Date;
import java.util.List;

import com.cecep.util.KqStatisticsUtil;

/**
 * 考勤统计实体类，通过调用statistics(List<String> workday,Time amTime,Time
 * pmTime)方法自动统计迟到、早退、外出
 * 
 * @author lilei
 * 
 */
public class StatisticsRecord {

	/** 员工编号 */
	private int userSerial;
	/** 卡序列号 */
	private String cardSerial;
	/** 一段时间内的打卡记录 */
	private List<KqRecord> kqRecords;
	private String goOutTime;
	private String lateTime;
	private String leaveEarlyTime;
	private String jbTime;
	/** 是否是全勤 */
	private Integer allWork = 0;
	private Date amSj;
	private Date pmSj;
	private boolean needInsert = true;

	/**
	 * 统计迟到、早退、外出
	 * 
	 * @param isHoliday
	 * 
	 * @param amTime
	 *            上班时间
	 * @param pmTime
	 *            下班时间
	 * @param kssj 
	 */
	public void statistics(boolean isHoliday, Time amTime, Time pmTime, String kssj) {
		// 1.判断是否是节假日，若是将jbTime赋值后返回
		if (isHoliday) {
			if (kqRecords != null && kqRecords.size() > 0) {
				jbTime = kssj;
				amSj = kqRecords.get(0).getSj();
				pmSj = kqRecords.get(kqRecords.size()-1).getSj();
			} else {
				needInsert = false;
			}
			return;
		}
		if (kqRecords == null || kqRecords.size() == 0) { // 当天无打卡记录则视为外出
			goOutTime = kssj;
		} else {
			// 2.处理迟到早退及外出
			KqRecord firstRecord = null;
			KqRecord lastRecord = null;
			int length = kqRecords.size();
			for (int i = 0; i < length; i++) {
				if (firstRecord == null) {
					if (kqRecords.get(i).getFx() == 0) {
						firstRecord = kqRecords.get(i);
					}
				}
				if (lastRecord == null) {
					if (kqRecords.get(length - i - 1).getFx() == 1) {
						lastRecord = kqRecords.get(length - i - 1);
					}
				}
				if (firstRecord != null && lastRecord != null) {
					break;
				}
			}
			countAmRecord(firstRecord, lastRecord, amTime,kssj);
			countPmRecord(firstRecord, lastRecord, pmTime,kssj);
		}
		if (lateTime != null || leaveEarlyTime != null || goOutTime != null) {
			allWork = 1;
		}
	}

	/** 计算上午迟到次数及打卡时间 */
	private void countAmRecord(KqRecord firstRecord, KqRecord lastRecord,
			Time amTime,String kssj) {
		amSj = (firstRecord == null) ? null : firstRecord.getSj();
		if (amSj == null) {
			lateTime = kssj + " 未打卡";
			return;
		}
		// 如果刷卡时间大于amTime
		if (!KqStatisticsUtil.compareTime(amSj, amTime)) {
			lateTime = KqStatisticsUtil.formatDateToString3(amSj);
		}
	}

	/** 计算上午迟到次数及打卡时间 */
	private void countPmRecord(KqRecord firstRecord, KqRecord lastRecord,
			Time pmTime,String kssj) {
		pmSj = (lastRecord == null) ? null : lastRecord.getSj();
		if (pmSj == null) {
			leaveEarlyTime = kssj + " 未打卡";
			return;
		}
		if (KqStatisticsUtil.compareTime(pmSj, pmTime)) {
			leaveEarlyTime = KqStatisticsUtil.formatDateToString3(pmSj);
		}
	}

	public String getGoOutTime() {
		return goOutTime;
	}

	public String getLateTime() {
		return lateTime;
	}

	public String getLeaveEarlyTime() {
		return leaveEarlyTime;
	}

	public String getCardSerial() {
		return cardSerial;
	}

	public void setCardSerial(String cardSerial) {
		this.cardSerial = cardSerial;
	}

	public int getUserSerial() {
		return userSerial;
	}

	public void setUserSerial(int userSerial) {
		this.userSerial = userSerial;
	}

	public List<KqRecord> getKqRecords() {
		return kqRecords;
	}

	public void setKqRecords(List<KqRecord> kqRecords) {
		this.kqRecords = kqRecords;
	}

	public Integer getAllWork() {
		return allWork;
	}

	public Date getAmSj() {
		return amSj;
	}

	public Date getPmSj() {
		return pmSj;
	}

	public String getJbTime() {
		return jbTime;
	}

	public void setJbTime(String jbTime) {
		this.jbTime = jbTime;
	}

	public boolean isNeedInsert() {
		return needInsert;
	}

	@Override
	public String toString() {
		return "StatisticsRecord [userSerial=" + userSerial + ", cardSerial="
				+ cardSerial + ", kqRecords=" + kqRecords + ", goOutTime="
				+ goOutTime + ", lateTime=" + lateTime + ", leaveEarlyTime="
				+ leaveEarlyTime + ", jbTime=" + jbTime + ", allWork="
				+ allWork + ", amSj=" + amSj + ", pmSj=" + pmSj + "]";
	}

}

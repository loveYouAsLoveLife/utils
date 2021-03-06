package com.bw.wangtiandong.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 
 * @author wangtiandong
 *
 */
public class DateUtil {
	/**
	 * 
	 * @Title:         getRemainDays   
	 * @Description:   TODO
	 * @param:         @param futureDate
	 * @param:         @return      
	 * @return:        int     
	 * @date:          2019年9月9日 上午9:51:33   
	 * @throws
	 */
	public int getRemainDays(Date futureDate) {
		return (int)(futureDate.getTime()-new Date().getTime())/1000/3600/24;	
	}
	
	/***
	 * 
	 * @Title:         isToday   
	 * @Description:   TODO
	 * @param:         @param date
	 * @param:         @return      
	 * @return:        boolean     
	 * @date:          2019年9月9日 上午9:51:38   
	 * @throws
	 */
	public static boolean isToday(Date date) {
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
		String dateStr = simpleDateFormat.format(date);
		String todayStr = simpleDateFormat.format(new Date());
		return dateStr.equals(todayStr);
		
	}
	
	
	/**
	 * 
	 * @Title:         isCurrentMonth   
	 * @Description:   TODO
	 * @param:         @param date
	 * @param:         @return      
	 * @return:        boolean     
	 * @date:          2019年9月9日 上午9:51:42   
	 * @throws
	 */
	public static boolean isCurrentMonth(Date date) {
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMM");
		String dateStr = simpleDateFormat.format(date);
		String todayStr = simpleDateFormat.format(new Date());
		return dateStr.equals(todayStr);
		
	}
	
	/**
	 * 3.4.7����ʱ����󣬳�ʼ�������³���1��0ʱ0��0��0����
	 * @return
	 * @throws ParseException 
	 */
	public static Date getMonthStart(Date date) throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat("yyyyMM");
		String string = format.format(date);//199809
		String monthStart = string + "01 00:00:00";
		format = new SimpleDateFormat("yyyyMMdd HH:mm:ss");
		return format.parse(monthStart);
	}
	
	
	/**
	 * 
	 * @Title:         getMonthEnd   
	 * @Description:   TODO
	 * @param:         @param date
	 * @param:         @return
	 * @param:         @throws ParseException      
	 * @return:        Date     
	 * @date:          2019年9月9日 上午9:51:46   
	 * @throws
	 */
	public static Date getMonthEnd(Date date) throws ParseException {
		
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.MONTH, 1);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		calendar.set(Calendar.HOUR_OF_DAY,0);
		calendar.set(Calendar.MINUTE, 0);
		//calendar.set(Calendar.HOUR, 0);
		
		calendar.set(Calendar.SECOND, 0);
		calendar.add(Calendar.SECOND, -1);
		return calendar.getTime(); 
		
	}
	
	
	
	
	
	
	
	
	
	/**
	 * 
	 * @param birthday
	 * @return
	 */
	public int getAge(Date birthday) {
		
		Calendar instance = Calendar.getInstance();
		instance.setTime(birthday);
		
		//�õ���������
		int birthYear = instance.get(Calendar.YEAR);
		int birthMonth = instance.get(Calendar.MONTH);
		int birthDate = instance.get(Calendar.DAY_OF_MONTH);
		
		//��ȡ��ǰ��������
		instance.setTime(new Date());
		int currentYear = instance.get(Calendar.YEAR);
		int currentMonth = instance.get(Calendar.MONTH);
		int currentDate = instance.get(Calendar.DAY_OF_MONTH);
		
		int age = currentYear-birthYear;
		if(currentMonth<birthMonth) {
			age--;
		}else if(currentMonth==birthMonth && currentDate<birthDate){
			age --;
		}
		
		return age;
		
	}
	
	
}

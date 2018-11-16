package com.project.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;

public class IDCardNoValid {
    private static final int[] wi = { 7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2, 1 };
    private static final int[] vi = { 1, 0, 'X', 9, 8, 7, 6, 5, 4, 3, 2 };
    private static final String birthdayRegex="^((\\d{2}(([02468][048])|([13579][26]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])))))|(\\d{2}(([02468][1235679])|([13579][01345789]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|(1[0-9])|(2[0-8]))))))(\\s(((0?[0-9])|([1-2][0-3]))\\:([0-5]?[0-9])((\\s)|(\\:([0-5]?[0-9])))))?$";
    public static boolean validate(String idCardNo){
        String ai = "";
        if(idCardNo != null){
            if(idCardNo.length() == 15){
                ai = idCardNo.substring(0, 6)+ "19" + idCardNo.substring(6, 15);
            }else if(idCardNo.length() == 18){
                ai = idCardNo.substring(0, 17);
            }
            if(idCardNo.matches("[0-9]*")){//验证是否是数字
                String birthday = ai.substring(6, 10)+ "-" + ai.substring(10, 12)+ "-" + ai.substring(12, 14);
                if(validateBirthday(birthday)){
                    if(validateAreaCode(ai.substring(0,2 ))){
                        String remain = getRemaining(ai);
                        if(remain.equals(idCardNo.substring(17, 18))){
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
    private static String getRemaining(String idCardNo){
        if (idCardNo.length() == 18) {
            idCardNo = idCardNo.substring(0, 17);
        }
        int total = 0;
        for (int i = 0; i < 17; i++) {
            total = total + Integer.parseInt(idCardNo.substring(i, i+1)) * wi[i];
        }
        int remaining = total % 11;
        return remaining == 2 ? "X" : String.valueOf(vi[remaining]);
    }
     /**
     * 校验生日证格式
     * @param birthday
     * @return
     */
    private static boolean validateBirthday(String birthday){
        if(birthday.matches(birthdayRegex)){//验生日证格式
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            GregorianCalendar gc = new GregorianCalendar();
            try {
                //验证生日有效范围
                if(!((gc.get(Calendar.YEAR) - Integer.parseInt(birthday.substring(0, 4))) > 150 || (gc.getTime().getTime() - sdf.parse(birthday).getTime()) < 0)){
                    return true;
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return false;
    }
    /**
     *
     * @param str
     * @return
     */
    private static boolean validateAreaCode(String str){
        HashMap<String, String> map = getAreaCode();
        if(map.get(str) != null){
            return true;
        }
        return false;
    }
    /**
     * @return 地区编码 HashMap<String, String>
     */
    private static HashMap<String, String> getAreaCode() {
        HashMap<String, String> hashtable = new HashMap<String, String>();
        hashtable.put("11", "北京");
        hashtable.put("12", "天津");
        hashtable.put("13", "河北");
        hashtable.put("14", "山西");
        hashtable.put("15", "内蒙古");
        hashtable.put("21", "辽宁");
        hashtable.put("22", "吉林");
        hashtable.put("23", "黑龙江");
        hashtable.put("31", "上海");
        hashtable.put("32", "江苏");
        hashtable.put("33", "浙江");
        hashtable.put("34", "安徽");
        hashtable.put("35", "福建");
        hashtable.put("36", "江西");
        hashtable.put("37", "山东");
        hashtable.put("41", "河南");
        hashtable.put("42", "湖北");
        hashtable.put("43", "湖南");
        hashtable.put("44", "广东");
        hashtable.put("45", "广西");
        hashtable.put("46", "海南");
        hashtable.put("50", "重庆");
        hashtable.put("51", "四川");
        hashtable.put("52", "贵州");
        hashtable.put("53", "云南");
        hashtable.put("54", "西藏");
        hashtable.put("61", "陕西");
        hashtable.put("62", "甘肃");
        hashtable.put("63", "青海");
        hashtable.put("64", "宁夏");
        hashtable.put("65", "新疆");
        hashtable.put("71", "台湾");
        hashtable.put("81", "香港");
        hashtable.put("82", "澳门");
        hashtable.put("91", "国外");
        return hashtable;
    }
}

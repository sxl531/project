package com.project.util;

public class ToolsUtil {


    public static boolean isNull(String value){
        if(value != null && !"".equals(value)){
            return false;
        }else{
            return  true;
        }
    }

    public static boolean isNull(int value){
        if(value != 0 && !"".equals(value)){
            return false;
        }else{
            return true;
        }
    }
}

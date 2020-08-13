package com.taotas.selenideintro.common.helpers;

public class Xpath {
    public static String hasCssClass(String value){
        return "contains(concat(' ',normalize-space(@class),' '),' "+ value +" ')";
    }
}

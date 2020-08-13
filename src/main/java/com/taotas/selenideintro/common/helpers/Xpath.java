package com.taotas.selenideintro.common.helpers;

public class Xpath {
    public static String hasCssClass(String Value){
        return "contains(concat(' ',normalize-space(@class),' '),' "+ Value +" ')";
    }
}

package com.yang.fighting;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author yangtao
 * @date 2022/10/12 20:15
 * @description
 */
public class RegexUtil {

    private static final String regexOfScript = "<script[^>]*?>[\\\\s\\\\S]*?<\\\\/script>";
    private static final String regexOfStyle = "<style[^>]*?>[\\\\s\\\\S]*?<\\\\/style>";
    private static final String regexOfHtml = "<[^>]+>";

    private static final Pattern patternOfScript = Pattern.compile(regexOfScript, Pattern.CASE_INSENSITIVE);
    private static final Pattern patternOfStyle = Pattern.compile(regexOfStyle, Pattern.CASE_INSENSITIVE);
    private static final Pattern patternOfHtml = Pattern.compile(regexOfHtml, Pattern.CASE_INSENSITIVE);

    /**
     * 通过正则表达式 移除字符串的html标签
     *
     * @param originStr
     * @return
     */
    public static String removeStrHtmlScript(String originStr) {
        String targetStr;
        Matcher matcherOfScript = patternOfScript.matcher(originStr);
        targetStr = matcherOfScript.replaceAll("");
        Matcher matcherOfStyle = patternOfStyle.matcher(targetStr);
        targetStr = matcherOfStyle.replaceAll("");
        Matcher matcherOfHtml = patternOfHtml.matcher(targetStr);
        targetStr = matcherOfHtml.replaceAll("");

        return targetStr.trim();
    }
}


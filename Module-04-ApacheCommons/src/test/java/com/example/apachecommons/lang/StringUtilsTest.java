package com.example.apachecommons.lang;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;

/**
 * @author yukiloh
 * @version 0.1
 * @date 2020/7/6 13:42
 */
class StringUtilsTest {

    /**
     * StringUtilsTest
     */
    @Test
    void stringUtils() {

        //测试数据
        String str1 = "" ;
        String str2 = "" ;
        String str3 = "\t" ;
        String str4 = null ;
        String str5 = "123" ;
        String str6 = "ABCDEFG" ;
        String str7 = "Itfeels good to use JakartaCommons.\r\n" ;

        // 检查字符串是否为空(案例中都为空)
        System.out.println( "Is str1 blank? " + StringUtils.isBlank(str1));
        System.out.println( "Is str2 blank? " + StringUtils.isBlank(str2));
        System.out.println( "Is str3 blank? " + StringUtils.isBlank(str3));
        System.out.println( "Is str4 blank? " + StringUtils.isBlank(str4));

        // 检查是否为数字
        System.out.println( "Is str5 numeric? " + StringUtils.isNumeric(str5));
        System.out.println( "Is str6 numeric? " + StringUtils.isNumeric(str6));

        // 倒置字符串
        System.out.println( "str6: " + str6);
        System.out.println( "str6reversed: " + StringUtils.reverse(str6));

        // 去除尾部的换行符
        System.out.println( "str7: " + str7);
        String str8 = StringUtils.chomp(str7);

        // 倒置所有单词的顺序
        str8 = StringUtils.reverseDelimited(str8, ' ' );
        System.out.println( "str7 reversed whole words : \r\n" + str8);

        //重复字符串
        String padding = StringUtils.repeat( "=" , 50);

        //居中字符串,size:总长度,padStr:填充字符
        String msg = StringUtils.center( " Customised Header " , 50, "%" );

        //组合数组,separator:拼接字符
        Object[] raw = new Object[]{padding, msg,padding};
        String header = StringUtils.join(raw, "\r\n" );
        System.out.println(header);
    }


    @Test
    void stringUtils2() {
    }
}

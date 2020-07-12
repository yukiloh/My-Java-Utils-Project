package com.example.apachecommons.lang;

import org.apache.commons.lang3.ArrayUtils;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Map;

/**
 * @author yukiloh
 * @version 0.1
 * @date 2020/7/6 13:42
 */
class ArrayUtilsTest {

    /**
     * ArrayUtilsTest,关于数组相关的api
     */
    @Test
    void arrayUtils() {

        //创建一些数组
        int[] intArray1 = {2, 4, 8, 16};
        int[][] intArray2 = {{1, 2}, {2, 4}, {3, 8}, {4, 16}};
        Object[][] notAMap = {
                {"A", 100d},
                {"B", 80d},
                {"C", 60d},
                {"D", 40d},
                {"E", 20d}
        };

        // 将数组转换为string
        System.out.println("toString by java:" + Arrays.toString(intArray1));   //通过原生java的api来获取
        System.out.println("intArray1: " + ArrayUtils.toString(intArray1));
        System.out.println("intArray2: " + ArrayUtils.toString(intArray2));
        System.out.println("notAMap: " + ArrayUtils.toString(notAMap));

        // 查找数组
        // contains,是否包含
        System.out.println("intArray1 contains '8'? "
                + ArrayUtils.contains(intArray1, 8));

        //indexOf,返回下标(从0开始)
        System.out.println("intArray1 index of '8'? "
                + ArrayUtils.indexOf(intArray1, 8));

        //lastIndexOf,倒数位置(从1开始)
        System.out.println("intArray1 last index of '8'? "
                + ArrayUtils.lastIndexOf(intArray1, 8));

        // clone,克隆数组
        int[] intArray3 = ArrayUtils.clone(intArray1);
        System.out.println("intArray3: " + ArrayUtils.toString(intArray3));

        // reverse,倒置数组
        ArrayUtils.reverse(intArray3);
        System.out.println("intArray3 reversed: "
                + ArrayUtils.toString(intArray3));

        // toObject,转为包装类型(int[] → Integer[])
        Integer[] integerArray1 = ArrayUtils.toObject(intArray1);
        System.out.println("integerArray1: "
                + ArrayUtils.toString(integerArray1));

        // toMap,二维数组转换为map
        Map map = ArrayUtils.toMap(notAMap);
        Double res = (Double) map.get("C");
        System.out.println("get 'C' from map: " + res);
    }

}

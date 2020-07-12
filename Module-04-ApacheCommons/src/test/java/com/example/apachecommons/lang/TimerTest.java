package com.example.apachecommons.lang;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.StopWatch;
import org.junit.jupiter.api.Test;

import java.util.Date;

/**
 * @author yukiloh
 * @version 0.1
 * @date 2020/7/6 13:42
 */
class TimerTest {

    /**
     * timer,时间/日期格式化相关的工具
     */
    @Test
    void formatTest() {
        // 格式化日期,第一个参数也可以传入Calendar.getInstance()
        String yearAndMonth = DateFormatUtils.format(new Date(), "yyyy-MM");
        System.out.println(yearAndMonth);
    }

    @Test
    void stopWatchTest() throws InterruptedException {
        //秒表
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();      //开始计时

        //todo 模拟业务操作
        Thread.sleep(1000);

        stopWatch.stop();       //停止计 附带时
        System.out.println("cost time: "+stopWatch.getTime());
    }
}

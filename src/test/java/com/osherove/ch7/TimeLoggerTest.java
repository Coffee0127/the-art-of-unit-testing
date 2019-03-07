package com.osherove.ch7;

import java.time.LocalDateTime;

import org.hamcrest.core.StringContains;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

public class TimeLoggerTest {

    @Test
    public void SettingSystemTime_Always_ChangesTime() {
        // 設定一個假日期
        SystemTime.setLocalDateTime(LocalDateTime.of(2000, 1, 1, 0, 0));
        String output = TimeLogger.createMessage("a");

        Assert.assertThat(output, StringContains.containsString("2000-01-01"));
    }

    @After
    public void tearDown() {
        // 在每個測試結束時，重置日期與時間
        SystemTime.reset();
    }

}

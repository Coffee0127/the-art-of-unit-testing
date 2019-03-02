package com.osherove.ch2;

import org.junit.Assert;
import org.junit.Test;

public class MemCalculatorTest {

    @Test
    public void Sum_ByDefault_ReturnsZero() {
        MemCalculator calc = new MemCalculator();

        int lastSum = calc.sum();

        // 驗證預設回傳值
        Assert.assertEquals(0, lastSum);
    }

}

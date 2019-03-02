package com.osherove.ch2;

import org.junit.Assert;
import org.junit.Test;

public class MemCalculatorTest {

    @Test
    public void Sum_ByDefault_ReturnsZero() {
        MemCalculator calc = makeCalc();

        int lastSum = calc.sum();

        // 驗證預設回傳值
        Assert.assertEquals(0, lastSum);
    }

    @Test
    public void Add_WhenCalled_ChangesSum() {
        MemCalculator calc = makeCalc();

        calc.add(1);
        int sum = calc.sum();

        Assert.assertEquals(1, sum);
    }

    private MemCalculator makeCalc() {
        return new MemCalculator();
    }

}

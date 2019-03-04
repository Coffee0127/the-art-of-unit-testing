package com.osherove.ch5;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class MockitoBasics {

    @Test
    public void Returns_ByDefault_WorksForHardCodedArgument() {
        IFileNameRules fakeRules = Mockito.mock(IFileNameRules.class);

        // 強制方法被呼叫時要回傳假的值
        Mockito.when(fakeRules.isValidLogFileName("strict.txt"))
            .thenReturn(true);

        Assert.assertTrue(fakeRules.isValidLogFileName("strict.txt"));
    }

}

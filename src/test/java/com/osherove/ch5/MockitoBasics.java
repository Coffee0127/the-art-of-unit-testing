package com.osherove.ch5;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mockito;

public class MockitoBasics {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void Returns_ByDefault_WorksForHardCodedArgument() {
        IFileNameRules fakeRules = Mockito.mock(IFileNameRules.class);

        // 強制方法被呼叫時要回傳假的值
        Mockito.when(fakeRules.isValidLogFileName("strict.txt"))
            .thenReturn(true);

        Assert.assertTrue(fakeRules.isValidLogFileName("strict.txt"));
    }

    @Test
    public void Returns_ArgAny_IgnoresArgument() {
        IFileNameRules fakeRules = Mockito.mock(IFileNameRules.class);

        // 忽略參數內容，即任意字串
        Mockito.when(fakeRules.isValidLogFileName(Mockito.anyString()))
            .thenReturn(true);

        Assert.assertTrue(fakeRules.isValidLogFileName("anything.txt"));
    }

    @Test
    public void Returns_ArgAny_Throws() {
        IFileNameRules fakeRules = Mockito.mock(IFileNameRules.class);

        Mockito.when(fakeRules.isValidLogFileName(Mockito.anyString()))
            // 模擬拋出例外
            .thenThrow(new RuntimeException("fake exception"));

        // 驗證拋出例外
        thrown.expect(RuntimeException.class);
        // thrown.expectMessage("fake exception");

        fakeRules.isValidLogFileName("anything");
    }

}

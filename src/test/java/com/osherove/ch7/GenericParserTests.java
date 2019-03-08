package com.osherove.ch7;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;

import org.junit.Assert;
import org.junit.Test;

// 定義泛型約束條件
public abstract class GenericParserTests<T extends IStringParser> {

    protected abstract String getInputHeaderSingleDigit();

    // 取得泛型型別的實體，而非介面
    private T getParser(String input) {
        try {
            @SuppressWarnings("unchecked")
            Class<T> actualType = (Class<T>) ((ParameterizedType) getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0];
            Constructor<T> constructor =
                actualType.getDeclaredConstructor(String.class);
            // 回傳泛型型別的實體
            return constructor.newInstance(input);
        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void TestGetStringVersionFromHeader_SingleDigit_Found() {
        String input = getInputHeaderSingleDigit();
        T parser = getParser(input);
        boolean result = parser.hasCorrectHeader();

        Assert.assertFalse(result);
    }

    // 其他更多的測試...
}

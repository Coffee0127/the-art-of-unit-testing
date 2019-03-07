package com.osherove.ch5;

public class MyTestableComplicatedInterface implements IComplicatedInterface {

    // 手工實作複雜的介面
    private String meth1_a;
    private String meth1_b, meth2_b;
    private boolean meth1_c, meth2_c, meth3_c;
    private int meth1_x, meth2_x, meth3_x;
    private Object meth1_o, meth2_o, meth3_o;

    @Override
    public void method1(String a, String b, boolean c, int x, Object o) {
        meth1_a = a;
        meth1_b = b;
        meth1_c = c;
        meth1_x = x;
        meth1_o = o;
    }

    @Override
    public void method2(String b, boolean c, int x, Object o) {
        meth2_b = b;
        meth2_c = c;
        meth2_x = x;
        meth2_o = o;
    }

    @Override
    public void method3(boolean c, int x, Object o) {
        meth3_c = c;
        meth3_x = x;
        meth3_o = o;
    }

}

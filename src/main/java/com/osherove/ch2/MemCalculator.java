package com.osherove.ch2;

public class MemCalculator {

    private int sum = 0;

    public void add(int number) {
        sum += number;
    }

    public int sum() {
        int temp = sum;
        sum = 0;
        return temp;
    }

}

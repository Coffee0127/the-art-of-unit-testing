package com.osherove.ch1;

public class SimpleParser {

    public int parseAndSum(String numbers) {
        if (numbers.length() == 0) {
            return 0;
        }

        if (!numbers.contains(",")) {
            return Integer.parseInt(numbers);
        } else {
            throw new UnsupportedOperationException("I can only handle 0 or 1 numbers for now!");
        }
    }

}

package com.codewithme.stringcalculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringCalculator {

    public int add(String str) {
        int sum = 0;
        if (str == null || str.isEmpty() || str.isBlank()) {
            return 0;
        }
        else
        {
            sum=extractNumbers(str).stream().reduce(sum,Integer::sum);
        }

        return sum;
    }

    private List<Integer> extractNumbers(String str) {
        return Arrays.stream(str.split(",")).mapToInt(Integer::parseInt).boxed().toList();
    }
}

package com.codewithme.stringcalculator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringCalculator {

    public int add(String str) {
        int sum = 0;
        if (str == null || str.isEmpty() || str.isBlank()) {
            return 0;
        }
        else
        {
            List<Integer> extractedNumbers = extractNumbers(str);
            String negatives = extractedNumbers.stream().filter(num -> num < 0).map(String::valueOf).collect(Collectors.joining(", "));
            if (!negatives.isEmpty()) {
                throw new InvalidArgumentException("negatives not allowed: " + negatives);
            }
            sum= extractedNumbers.stream().reduce(sum,Integer::sum);
        }

        return sum;
    }

    private List<Integer> extractNumbers(String str) {
        String delimiter = str.startsWith("//") ? str.substring(2, str.indexOf("\n")) : ",";
        str = str.replaceAll("//" + delimiter + "\n", "").replaceAll("\n", delimiter);
        return Arrays.stream(str.split(delimiter)).mapToInt(Integer::parseInt).boxed().toList();
    }
}

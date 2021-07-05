package org.sidorov.type;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class ConverterRomanArab implements TypeConverter {

    List<String> romanBeforeTen = Arrays.asList("I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X");
    List<String> romanMoreThenTen = Arrays.asList("XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX");

    @Override
    public String getType(String num) {

        Pattern arabPattern = Pattern.compile("([1-9]{1}|10)");

        if (arabPattern.matcher(num).matches()) {
            return ARABIAN;
        }

        if (romanBeforeTen.contains(num)) {
            return "roman";
        }

        return INCORRECT_TYPE;
    }

    @Override
    public String turnToArabian(String num) {
        String arabianNum = String.valueOf(romanBeforeTen.indexOf(num) + 1);
        return arabianNum;
    }

    @Override
    public String turnToRevers(String num) {
        int index = Integer.parseInt(num) - 1;
        if(index > romanBeforeTen.size() - 1){
            return romanMoreThenTen.get(index - 10);
        }
        return romanBeforeTen.get(index);
    }
}

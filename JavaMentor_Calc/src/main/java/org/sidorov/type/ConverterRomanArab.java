package org.sidorov.type;

import java.util.*;
import java.util.regex.Pattern;

public class ConverterRomanArab implements TypeConverter {

    List<String> romanBeforeTen = Arrays.asList("I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X");
    final Map<Integer, String> romanMapChar = new LinkedHashMap<>();

    {
        romanMapChar.put(100, "C");
        romanMapChar.put(90, "XC");
        romanMapChar.put(50, "L");
        romanMapChar.put(40, "XL");
        romanMapChar.put(10, "X");
        romanMapChar.put(9, "IX");
        romanMapChar.put(5, "V");
        romanMapChar.put(4, "IV");
        romanMapChar.put(1, "I");
    }

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
    public String turnToArabian(String romanNum) {

        String arabianNum = String.valueOf(romanBeforeTen.indexOf(romanNum) + 1);
        return arabianNum;
    }

    @Override
    public String turnToRevers(String arabNum) {
        int num = Integer.parseInt(arabNum);

        StringBuilder romanNum = new StringBuilder();
        for (Map.Entry<Integer, String> entry : romanMapChar.entrySet()) {
            if (num == entry.getKey()) {
                romanNum.append(entry.getValue());
                return romanNum.toString();
            }

            while (num - entry.getKey() >= 0) {
                num -= entry.getKey();
                romanNum.append(entry.getValue());
            }
        }
        return romanNum.toString();
    }
}

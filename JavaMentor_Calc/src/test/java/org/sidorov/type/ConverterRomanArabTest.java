package org.sidorov.type;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConverterRomanArabTest {


    @Test
    public void checkFromItoX(){
        List<String> romanBeforeTen = Arrays.asList("I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X");
        String expect = "12345678910";
        ConverterRomanArab converter = new ConverterRomanArab();
        StringBuilder actual = new StringBuilder();
        for(String num : romanBeforeTen){
            actual.append(converter.turnToArabian(num));
        }
        Assert.assertEquals(expect, actual.toString());
    }

    @Test
    public void checkNumbers81and49and48(){
        List<String> romanNum = Arrays.asList("LXXXI", "XLIX", "XLVIII");
        List<String> arabianNum = Arrays.asList("81", "49", "48");

        ConverterRomanArab converter = new ConverterRomanArab();
        ArrayList<String> actual = new ArrayList<>();
        for(String num : arabianNum){
            actual.add(converter.turnToRevers(num));
        }
        Assert.assertEquals(romanNum, actual);
    }
}
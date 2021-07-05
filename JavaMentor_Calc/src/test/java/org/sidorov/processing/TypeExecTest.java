package org.sidorov.processing;

import org.junit.Test;
import org.sidorov.type.ConverterRomanArab;
import org.sidorov.type.TypeConverter;

import static org.junit.Assert.*;

public class TypeExecTest {

    TypeConverter typeExec = new ConverterRomanArab();

    @Test
    public void getTypeArab() {
        String actual = typeExec.getType("2");
        assertEquals(TypeConverter.ARABIAN, actual);
    }

    @Test
    public void getTypeArab10() {
        String actual = typeExec.getType("10");
        assertEquals(TypeConverter.ARABIAN, actual);
    }

    @Test
    public void getTypeRoman() {
        String actual = typeExec.getType("II");
        assertEquals("roman", actual);
    }

    @Test
    public void getTypeIncorrectArabRoman() {
        String actual = typeExec.getType("2I");
        assertEquals(TypeConverter.INCORRECT_TYPE, actual);
    }

    @Test
    public void getTypeIncorrectRomanArab() {
        String actual = typeExec.getType("I2");
        assertEquals(TypeConverter.INCORRECT_TYPE, actual);
    }

    @Test
    public void getTypeIncorrectMore10() {
        String actual = typeExec.getType("11");
        assertEquals(TypeConverter.INCORRECT_TYPE, actual);
    }

    @Test
    public void getTypeIncorrectZero() {
        String actual = typeExec.getType("0");
        assertEquals(TypeConverter.INCORRECT_TYPE, actual);
    }
}
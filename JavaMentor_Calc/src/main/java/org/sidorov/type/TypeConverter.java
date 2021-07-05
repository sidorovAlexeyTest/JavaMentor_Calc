package org.sidorov.type;

public interface TypeConverter {

    final static String INCORRECT_TYPE = "INCORRECT";
    final static String ARABIAN = "ARABIAN";

    String getType(String num);
    String turnToArabian(String num);
    String turnToRevers(String num);

}

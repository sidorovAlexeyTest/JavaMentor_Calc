package org.sidorov.processor;

public class ProcessorCalculate implements ProcessorInterface{

    public String processing(String[] operands) {
        int a = Integer.parseInt(operands[0]);
        int b = Integer.parseInt(operands[2]);
        String op = operands[1];
        int result = 0;
        switch (op) {
            case "+":
                result = a + b;
                break;
            case "-":
                result = a - b;
                break;
            case "/":
                result = a / b;
                break;
            case "*":
                result = a * b;
                break;
        }
        return String.valueOf(result);
    }
}

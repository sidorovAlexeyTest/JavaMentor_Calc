package org.sidorov.output;

public class OutputToConsole implements Output{

    @Override
    public void send(String data) {
        System.out.println(data);
    }
}

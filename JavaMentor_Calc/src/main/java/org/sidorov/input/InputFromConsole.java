package org.sidorov.input;

import java.util.Scanner;

public class InputFromConsole implements Input{

    private String line;
    private Scanner scanner;

    public InputFromConsole(){
        scanner = new Scanner(System.in);
    }

    @Override
    public String getInfo() {
        String line = scanner.nextLine();
        return line;
    }
}

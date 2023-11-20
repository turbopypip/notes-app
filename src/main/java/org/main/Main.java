package org.main;

import utils.Commands;
import utils.Utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("""
                Hello and welcome to Notes!
                Type /info to see see the supported commands.
                Type /stop to exit
                
                """);

        String input = reader.readLine();
        while (!Objects.equals(input, Commands.STOP.getCommand())) {
            //Checking input
            Utils.checkCommand(input);

            input = reader.readLine();
        }
    }
}
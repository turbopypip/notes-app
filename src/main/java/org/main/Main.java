package org.main;

import utils.Commands;
import utils.Utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Objects;

public class Main {
    public static void main(String[] args){
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("""
                Hello and welcome to Notes!
                Type /info to see see the supported commands.
                Type /stop to exit
                
                """);
        try {
            String input = reader.readLine();
            while (!Objects.equals(input, Commands.STOP.getCommand())) {
                //Handling a command
                Utils.checkCommand(input, reader);

                //Getting new command
                input = reader.readLine();
            }
        } catch (IOException e){
            System.out.println("Something went wrong...");
            System.out.println(Arrays.toString(e.getStackTrace()));
        }

    }
}
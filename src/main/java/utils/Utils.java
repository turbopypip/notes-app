package utils;

import Components.DateOfCreation;
import Components.Note;

import java.io.BufferedReader;
import java.io.IOException;

//This class contains all reusable methods
public class Utils {
    public static void viewCommands(){
        // This method returns a table with commands and their descriptions

        System.out.print("\n");
        for (Commands command : Commands.values()){
            System.out.printf("%-20s %s\n",
                    Colors.GREEN.getColor() + command.getCommand(),
                    Colors.BASE.getColor() + command.getDescription());
        }
        System.out.print("\n");
    }

    public static void addNote(BufferedReader reader) throws IOException {
        // This method creates new note and saves it

        //Getting title
        System.out.println("\nPlease enter the note title:");
        String title = reader.readLine();

        //Checking if title is empty ("")
        if (title.isEmpty()){
            System.out.println(
                    Colors.YELLOW.getColor()
                    + "The note title can't be empty. Please enter the title again."
                    + Colors.BASE.getColor());
            title = reader.readLine();
        }

        //Getting note content
        System.out.println("Please enter the note content:");
        String content = reader.readLine();

        //Creating new note instance
        Note newNote = new Note(
                Note.countNotes+1,
                new DateOfCreation(),
                title,
                content);

        System.out.println(
                Colors.GREEN.getColor()
                + "New note added successfully!"
                + Colors.BASE.getColor()
                + "\n");
    }

    public static void checkCommand(String input, BufferedReader reader){
        //This method checks the input and calls the needed function

        try {
            //This logic finds the following command in Commands.java
            final Commands command = Commands.valueOf(input.substring(1).toUpperCase());
            switch(command){
                case INFO -> viewCommands();
                case NEW_NOTE -> addNote(reader);
            }
        } catch (Exception e){
            System.out.println(
                    Colors.RED.getColor()
                    + "Please enter a command correctly. \""
                    + input
                    + "\" is not a command."
                    + Colors.BASE.getColor());
        }
    }
}

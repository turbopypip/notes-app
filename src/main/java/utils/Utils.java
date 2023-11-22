package utils;

import Components.DateOfCreation;
import Components.Note;
import Components.NotesManager;
import com.google.gson.Gson;

import java.io.*;
import java.util.*;

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
    public static String getOS(){
        // This method checks the users OS and returns its name

        String os = System.getProperty("os.name").toLowerCase();

        if (os.contains("win")) {
            return "Windows";
        } else if (os.contains("mac")) {
            return "macOS";
        } else {
            return "Undefined OS";
        }
    }
    public static HashMap<String, Note> getNotes(){
        //This method reads all notes from notes.json

        HashMap<String, Note> notes = new HashMap<>();
        switch (getOS()){
            case "Windows" : { }

            case "macOS" : {
                String userHome = System.getProperty("user.home");
                String notesDirectoryPath = userHome + "/Library/Application Support/Notes";
                String notesFilePath = notesDirectoryPath + "/notes.json";

                try{
                    BufferedReader reader = new BufferedReader(new FileReader(notesFilePath));
                    String line;
                    Gson gson = new Gson();

                    // reading json objects from notes.json
                    while ((line = reader.readLine()) != null) {
                        Note note = gson.fromJson(line, Note.class);
                        notes.put(note.getIndex(), note);
                    }

                } catch (Exception e){
                    System.out.println("It seems you don't have any notes.");
                    e.printStackTrace();
                }
            }
        }
        return notes;
    }

    public static void viewNotes(){
        HashMap<String, Note> notes = getNotes();
        for (Note note : notes.values()) {
            System.out.println(note.toString());
        }
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
        UUID noteID = UUID.randomUUID();
        Note newNote = new Note(
                noteID.toString(),
                new DateOfCreation(),
                title,
                content);

        switch(getOS()){
            case "Windows" : {
                // Need to check if it works
                String appDataDir = System.getenv("APPDATA");
                String filePath = appDataDir + "\\Notes\\notes.json";
                NotesManager.saveNotesToJson(newNote, filePath, true);
                return;
            }

            case "macOS" : {
                String userHome = System.getProperty("user.home");
                String notesDirectoryPath = userHome + "/Library/Application Support/Notes";
                String notesFilePath = notesDirectoryPath + "/notes.json";

                // Creating Notes directory, if it is not exists
                File notesDirectory = new File(notesDirectoryPath);
                if (!notesDirectory.exists()) {
                    if (notesDirectory.mkdirs()) {
                        System.out.println("Created Notes directory.");
                    } else {
                        System.out.println("Failed to create the Notes directory.");
                    }
                } else if (!notesDirectory.isDirectory()) {
                    System.out.println("Way " + notesDirectoryPath + " is not a directory.");
                }

                // Creating file notes.json in Notes directory
                File notesFile = new File(notesFilePath);
                try {
                    if (notesFile.createNewFile()) {
                        System.out.println("Created File notes.json.");
                    }
                } catch (IOException e) {
                    System.out.println("An error occurred during creating notes.json: " + e.getMessage());
                }

                // Uploading new note to notes file
                NotesManager.saveNotesToJson(newNote, notesFilePath, true);
            }
        }
    }

    public static void checkCommand(String input, BufferedReader reader){
        //This method checks the input and calls the needed function

        try {
            //This logic finds the following command in Commands.java
            final Commands command = Commands.valueOf(input.substring(1).toUpperCase());
            switch(command){
                case INFO -> viewCommands();
                case NEW_NOTE -> addNote(reader);
                case VIEW_NOTES -> viewNotes();
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

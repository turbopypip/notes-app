package utils;

import Components.DateOfCreation;
import Components.Note;
import Components.NotesManager;

import java.io.File;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.UUID;

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
                NotesManager.saveNotesToJson(newNote, filePath);
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
                        System.out.println("Директория Notes создана.");
                    } else {
                        System.out.println("Не удалось создать директорию Notes.");
                    }
                } else if (!notesDirectory.isDirectory()) {
                    System.out.println("Путь " + notesDirectoryPath + " не является директорией.");
                }

                // Creating file notes.json in Notes directory
                File notesFile = new File(notesFilePath);
                try {
                    if (notesFile.createNewFile()) {
                        System.out.println("Файл notes.json создан.");
                    } else {
                        System.out.println("Файл notes.json уже существует.");
                    }
                } catch (IOException e) {
                    System.out.println("Ошибка при создании файла notes.json: " + e.getMessage());
                    e.printStackTrace();
                }

                // Uploading new note to notes file
                NotesManager.saveNotesToJson(newNote, notesFilePath);
                return;
            }
            case "Unix" : {
                String userHome = System.getProperty("user.home");
                String filePath = userHome + "/.config/Notes/notes.json";
                NotesManager.saveNotesToJson(newNote, filePath);
            }
        }
    }

    public static String getOS(){
        // This method checks the users OS and returns its name

        String os = System.getProperty("os.name").toLowerCase();

        if (os.contains("win")) {
            return "Windows";
        } else if (os.contains("nix") || os.contains("nux") || os.contains("aix")) {
            return "Unix";
        } else if (os.contains("mac")) {
            return "macOS";
        } else {
            return "Undefined OS";
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

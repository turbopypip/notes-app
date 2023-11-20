//This class contains all reusable methods
package utils;

public class Utils {
    public static void viewCommands(){
        // This method returns a table with commands and their descriptions

        System.out.print("\n");
        for (Commands command : Commands.values()){
            System.out.printf("%-20s %s\n", command.getCommand(), command.getDescription());
        }
        System.out.print("\n");
    }
}
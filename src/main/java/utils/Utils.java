//This class contains all reusable methods
package utils;

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

    public static void checkCommand(String input){
        //This method checks the input and calls the needed function

        try {
            //This logic finds the following command in Commands.java
            final Commands command = Commands.valueOf(input.substring(1).toUpperCase());
            switch(command){
                case INFO -> viewCommands();
                //... other commands
            }
        } catch (Exception e){
            System.out.println(
                    Colors.RED.getColor()
                    + "Please enter the command correctly. \""
                    + input
                    + "\" is not a command."
                    + Colors.BASE.getColor());
        }
    }
}

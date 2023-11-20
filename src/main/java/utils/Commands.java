package utils;

public enum Commands {
    // This is list of commands
    INFO("/info", "Use this command to see the commands."),
    NEW_NOTE("/new_note", "Use this command to add a new note."),
    VIEW_NOTES("/view_notes", "Use this command to view your notes."),
    DELETE_NOTE("/delete_note", "Use this command to delete a note."),
    STOP("/stop", "Use this command to stop the app.");
    private final String command;
    private final String description;

    Commands(String value, String description) {
        this.command = value;
        this.description = description;
    }
    public String getCommand(){
        return command;
    }
    public String getDescription(){
        return description;
    }
}

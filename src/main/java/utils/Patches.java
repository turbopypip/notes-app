package utils;

public enum Patches {
    WINDOWS(System.getenv("APPDATA") + "\\Notes",
            System.getenv("APPDATA") + "\\Notes" + "\\notes.json"),
    MACOS(System.getProperty("user.home") + "/Library/Application Support/Notes",
            System.getProperty("user.home") + "/Library/Application Support/Notes" + "/notes.json");
    private final String notesDirectoryPath;
    private final String notesFilePath;

    Patches(String notesDirectoryPath, String notesFilePath){
        this.notesDirectoryPath = notesDirectoryPath;
        this.notesFilePath = notesFilePath;
    }

    public String getNotesDirectoryPath() {
        return notesDirectoryPath;
    }

    public String getNotesFilePath() {
        return notesFilePath;
    }
}

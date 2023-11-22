package Components;

import com.google.gson.Gson;
import utils.Colors;

import java.io.FileWriter;
import java.io.IOException;

//This class is used to add the notes to the notes.json
public class NotesManager {
    public static void saveNotesToJson(Note note, String fileName, boolean append) {
        Gson gson = new Gson();
        try (FileWriter writer = new FileWriter(fileName, append)) {
            String jsonNote = gson.toJson(note);
            writer.write(jsonNote+"\n");
            System.out.println(
                    Colors.GREEN.getColor()
                            + "New note added successfully!"
                            + Colors.BASE.getColor()
                            + "\n");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

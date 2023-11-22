package Components;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import utils.Colors;

import java.io.FileWriter;
import java.io.IOException;

//This class is used to add the notes to the notes.json
public class NotesManager {
    public static void saveNotesToJson(Note note, String fileName) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (FileWriter writer = new FileWriter(fileName, true)) {
            gson.toJson(note, writer);

            System.out.println(
                    Colors.GREEN.getColor()
                            + "New note added successfully!"
                            + Colors.BASE.getColor()
                            + "\n");

        } catch (IOException e) {
            e.printStackTrace();
            // Обработка ошибок записи в файл
        }
    }

}

package Components;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateOfCreation {
    private final String date;

    public DateOfCreation(){
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        this.date = currentDate.format(formatter);
    }

    public String getDate() {
        return date;
    }
}
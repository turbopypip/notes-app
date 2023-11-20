package Components;

public class Note {
    //Note index is used to get specific note or to delete specific note
    int index;
    Date dateOfCreation;
    String title;
    String content;

    Note(int index,
         Date dateOfCreation,
         String title,
         String content){
        this.index = index;
        this.dateOfCreation = dateOfCreation;
        this.title = title;
        this.content = content;
    }
}

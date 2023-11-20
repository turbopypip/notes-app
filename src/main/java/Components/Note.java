package Components;

public class Note {
    //Note index is used to get specific note or to delete specific note
    int index;
    DateOfCreation dateOfCreation;
    String title;
    String content;
    //countNodes is used to get the index for new node
    //Now this doesn't work correctly.
    // !!! Later switch counter to getter !!!
    public static int countNotes = 0;

    public Note(int index,
                DateOfCreation dateOfCreation,
                String title,
                String content){
        this.index = index;
        this.dateOfCreation = dateOfCreation;
        this.title = title;
        this.content = content;
        countNotes += 1;
    }
}

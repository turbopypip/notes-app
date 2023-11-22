package Components;

import utils.Colors;

public class Note {
    //Note index is used to get specific note or to delete specific note
    private final String index;
    private final DateOfCreation dateOfCreation;
    private final String title;
    private final String content;

    public String getIndex() {
        return index;
    }

    public Note(String index,
                DateOfCreation dateOfCreation,
                String title,
                String content){
        this.index = index;
        this.dateOfCreation = dateOfCreation;
        this.title = title;
        this.content = content;
    }
    @Override
    public String toString(){
        return "Note: "
                + this.title
                + " "
                + Colors.GREEN.getColor()
                + this.index
                + Colors.BASE.getColor()
                + "\n"
                + this.content
                + "\n"
                + dateOfCreation.getDate()
                + "\n";
    }
}

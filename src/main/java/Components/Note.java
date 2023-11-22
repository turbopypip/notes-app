package Components;

import utils.Colors;

public class Note {
    //Note index is used to get specific note or to delete specific note
    String index;
    DateOfCreation dateOfCreation;
    String title;
    String content;

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
                + Colors.GREEN.getColor()
                + this.index
                + Colors.BASE.getColor()
                + this.title
                + "\n"
                + this.content
                + "\n";
    }
}

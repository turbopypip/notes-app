package utils;

import java.awt.*;

public enum Colors {
    BASE("\u001B[0m"),
    RED("\u001B[31m"),
    YELLOW("\u001B[33m"),
    PURPLE("\u001B[35m"),
    GREEN("\u001B[32m");
    private final String color;
    Colors(final String color){
        this.color = color;
    }
    public String getColor(){
        return color;
    }
}

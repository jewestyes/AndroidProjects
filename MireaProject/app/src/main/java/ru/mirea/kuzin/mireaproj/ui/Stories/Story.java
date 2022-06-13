package ru.mirea.kuzin.mireaproj.ui.Stories;

public class Story {
    private final String title;
    private final String content;

    Story(String title, String content){
        this.title = title;
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public String getTitle() {
        return title;
    }
}

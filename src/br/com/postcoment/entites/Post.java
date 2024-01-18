package br.com.postcoment.entites;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Post {
    DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    private LocalDateTime date;
    private String title;
    private String content;
    private Integer likes;
    List<Comment> comments = new ArrayList<>();

    public Post(){

    }

    public Post(LocalDateTime date, String title, String content, Integer likes) {
        this.date = date;
        this.title = title;
        this.content = content;
        this.likes = likes;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void addComments(Comment comment) {
        comments.add(comment);
    }
    public void removeComments(Comment comment){
        comments.remove(comment);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(date.format(fmt) + "\n")
                .append(title + "\n")
                .append(content + "\n")
                .append(likes).append(" likes" + "\n")
                .append("Comments: " + "\n");

        for (Comment c : comments) {
            stringBuilder.append(c.getText() + "\n");
        }

        return stringBuilder.toString();
    }
}

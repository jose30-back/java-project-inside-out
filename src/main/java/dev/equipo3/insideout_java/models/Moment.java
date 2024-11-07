package dev.equipo3.insideout_java.models;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Moment {

    private static int idCounter = 1;
    private int id;
    private String title;
    private String description;
    private Emotions emotion;
    private LocalDate momentDate;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;

    private static final DateTimeFormatter MOMENT_DATE_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yy HH:mm");

    public Moment(int id, String title, String description, Emotions emotion, LocalDate momentDate) {
        this.id = idCounter++;
        this.title = title;
        this.description = description;
        this.emotion = emotion;
        this.momentDate = momentDate;
        this.createdDate = LocalDateTime.now();
        this.updatedDate = LocalDateTime.now();
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Emotions getEmotions() {
        return emotion;
    }

    public LocalDate getMomentDate() {
        return momentDate;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void updateUpdatedDate(){
        this.updatedDate = LocalDateTime.now();
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getUpdatedDate() {
        return updatedDate;
    }

    public void setEmotions(Emotions emotion) {
        this.emotion = emotion;
    }

    public void setMomentDate(LocalDate momentDate) {
        this.momentDate = momentDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public void setUpdatedDate(LocalDateTime updatedDate) {
        this.updatedDate = updatedDate;
    }

    public String getFormattedCreatedDate() {
        return createdDate.format(DATE_TIME_FORMATTER);
    }

    public String getFormattedUpdatedDate() {
        return updatedDate.format(DATE_TIME_FORMATTER);
    }

    @Override
    public String toString() {
        return "----------------------\n" +
                "Moment:\n" +
                "ID: " + id + "\n" +
                "Title: " + title + "\n" +
                "Description: " + description + "\n" +
                "Emotion: " + emotion + "\n" +
                "Date: " + momentDate.format(MOMENT_DATE_FORMATTER)
                + "\n" +
                "Created: " + getFormattedCreatedDate()
                + "\n" +
                "Updated: " + getFormattedUpdatedDate() + "\n";
    }

}

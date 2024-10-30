package dev.equipo3.insideout_java.models;

import java.time.LocalDateTime;


public class Moment {
    
    private int id; 
    private String tittle;
    private String description; 
    private Emotions emotions;
    private LocalDateTime momentDate; 
    private LocalDateTime createdDate; 
    private LocalDateTime updatedDate;


    public Moment(int id, String tittle, String description, Emotions emotions, LocalDateTime momentDate, LocalDateTime createdDate,
            LocalDateTime updatedDate) {
        this.id = id++;
        this.tittle = tittle;
        this.description = description;
        this.emotions = emotions;
        this.momentDate = momentDate;
        this.createdDate = LocalDateTime.now();
        this.updatedDate = LocalDateTime.now();
    }


    public int getId() {
        return id;
    }


    public String getTittle() {
        return tittle;
    }


    public String getDescription() {
        return description;
    }

    public Emotions getEmotions() {
        return emotions;
    }


    public LocalDateTime getMomentDate() {
        return momentDate;
    }


    public LocalDateTime getCreatedDate() {
        return createdDate;
    }


    public LocalDateTime getUpdatedDate() {
        return updatedDate;
    }


    public void setId(int id) {
        this.id = id;
    }


    public void setTittle(String tittle) {
        this.tittle = tittle;
    }


    public void setDescription(String description) {
        this.description = description;
    }

    public void setEmotions(Emotions emotions) {
        this.emotions = emotions;
    } 


    public void setMomentDate(LocalDateTime momentDate) {
        this.momentDate = momentDate;
    }


    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }


    public void setUpdatedDate(LocalDateTime updatedDate) {
        this.updatedDate = updatedDate;
    }

}


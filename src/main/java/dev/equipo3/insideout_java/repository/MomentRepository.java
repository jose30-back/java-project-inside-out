package dev.equipo3.insideout_java.repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import dev.equipo3.insideout_java.models.Emotions;
import dev.equipo3.insideout_java.models.Moment;

public class MomentRepository {
    private final List<Moment> moments = new ArrayList<>();

    public void addMoment(Moment moment) {
        if (moment == null) {
            return; 
        }
        moments.add(moment);
    }

    public List<Moment> getAllMoments() {
        return new ArrayList<>(moments);
    }

    public boolean deleteMomentById(int id) {
        return moments.removeIf(moment -> moment.getId() == id);
    }

    public List<Moment> filterMomentsByEmotion(Emotions emotion) {
        List<Moment> filtered = new ArrayList<>();
        for (Moment moment : moments) {
            if (moment.getEmotions() == emotion) {
                filtered.add(moment);
            }
        }
        return filtered;
    }

    public List<Moment> filterMomentsByDate(LocalDate date) {
        List<Moment> filtered = new ArrayList<>();
        for (Moment moment : moments) {
            if (moment.getMomentDate().equals(date)) {
                filtered.add(moment);
            }
        }
        return filtered;
    }

    public Moment getMomentById(int id) {
        for (Moment moment : moments) {
            if (moment.getId() == id) {
                return moment;
            }
        }
        return null; 
    }
}
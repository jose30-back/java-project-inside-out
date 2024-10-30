package dev.equipo3.insideout_java.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import dev.equipo3.insideout_java.models.Emotions;
import dev.equipo3.insideout_java.models.Moment;
import dev.equipo3.insideout_java.repository.MomentRepository;
import dev.equipo3.insideout_java.views.TerminalMenu;

public class MomentController {
    private final MomentRepository momentRepository = new MomentRepository();
    private final TerminalMenu terminalMenu = new TerminalMenu();

    public void displayMainMenu() {
        terminalMenu.displayMainMenu();
    }

    public void addMoment() {
        System.out.println("Enter title:");
        String title = terminalMenu.getInput();

        LocalDateTime momentDate = null;
        while (momentDate == null) {
            System.out.println("Enter date (dd/MM/yyyy):");
            String dateInput = terminalMenu.getInput();
            momentDate = parseDate(dateInput);
        }

        System.out.println("Enter description:");
        String description = terminalMenu.getInput();

        Emotions emotion = selectEmotion();
        if (emotion == null) {
            System.out.println("Emotion doesn't exist");
            return;
        }

        Moment moment = new Moment(0, title, description, emotion, momentDate);
        momentRepository.addMoment(moment);
        System.out.println("Moment successfully added!");
    }

    public void viewMoments() {
        terminalMenu.displayMomentList(momentRepository.getAllMoments());
    }

    public void deleteMoment() {
        System.out.println("Enter the moment ID:");
        int id = Integer.parseInt(terminalMenu.getInput());
        boolean deleted = momentRepository.deleteMomentById(id);
        if (deleted) {
            System.out.println("Moment deleted successfully.");
        } else {
            System.out.println("Moment not found.");
        }
    }

    private Emotions selectEmotion() {
        terminalMenu.displayEmotionOptions();
        int emotionsChoice = Integer.parseInt(terminalMenu.getInput());
        return Emotions.getByIndex(emotionsChoice);
    }

    public void filterMoments() {
        terminalMenu.displayFilterMenu();
        int filterChoice = Integer.parseInt(terminalMenu.getInput());

        if (filterChoice == 1) {
            filterMomentsByEmotion();
        } else if (filterChoice == 2) {
            filterMomentsByDate();
        } else {
            System.out.println("Invalid choice.");
        }
    }

    private void filterMomentsByEmotion() {
        Emotions emotion = selectEmotion();
        if (emotion != null) {
            terminalMenu.displayMomentList(momentRepository.filterMomentsByEmotion(emotion));
        } else {
            System.out.println("Invalid emotion choice.");
        }
    }

    private void filterMomentsByDate() {
        System.out.println("Enter date to filter by (dd/MM/yyyy):");
        String dateInput = terminalMenu.getInput();
        LocalDateTime date = parseDate(dateInput);
        if (date != null) {
            terminalMenu.displayMomentList(momentRepository.filterMomentsByDate(date));
        }
    }

    private LocalDateTime parseDate(String date) {
        try {
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            return LocalDate.parse(date, dateFormatter).atStartOfDay();
        } catch (DateTimeParseException e) {
            System.out.println("Invalid date format. Please enter date as dd/MM/yyyy.");
            return null;
        }
    }

}

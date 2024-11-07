package dev.equipo3.insideout_java.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import dev.equipo3.insideout_java.models.Emotions;
import dev.equipo3.insideout_java.models.Moment;
import dev.equipo3.insideout_java.repository.MomentRepository;
import dev.equipo3.insideout_java.views.TerminalMenu;

public class MomentCreateController {
    private final MomentRepository momentRepository;
    private final TerminalMenu terminalMenu;

    public MomentCreateController(MomentRepository momentRepository, TerminalMenu terminalMenu) {
        this.momentRepository = momentRepository;
        this.terminalMenu = terminalMenu;
    }

    public void addMoment() {
        System.out.println("Enter title:");
        String title = terminalMenu.getInput();

        LocalDate momentDate = null;
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

        Moment moment = new Moment(1, title, description, emotion, momentDate);
        momentRepository.addMoment(moment);
        System.out.println("Moment successfully added!");
    }

    private Emotions selectEmotion() {
        terminalMenu.displayEmotionOptions();
        int emotionsChoice = Integer.parseInt(terminalMenu.getInput());
        return Emotions.getByIndex(emotionsChoice);
    }

    LocalDate parseDate(String date) {
        try {
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            return LocalDate.parse(date, dateFormatter);
        } catch (DateTimeParseException e) {
            System.out.println("Invalid date format. Please enter date as dd/MM/yyyy.");
            return null;
        }
    }
}

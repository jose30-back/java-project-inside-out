package dev.equipo3.insideout_java.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import dev.equipo3.insideout_java.models.Emotions;
import dev.equipo3.insideout_java.repository.MomentRepository;
import dev.equipo3.insideout_java.views.TerminalMenu;

public class MomentFilterController {
    private final MomentRepository momentRepository;
    private final TerminalMenu terminalMenu;

    public MomentFilterController(MomentRepository momentRepository, TerminalMenu terminalMenu) {
        this.momentRepository = momentRepository;
        this.terminalMenu = terminalMenu;
    }

    public void filterMomentsByEmotion() {
        Emotions emotion = selectEmotion();
        if (emotion != null) {
            terminalMenu.displayMomentList(momentRepository.filterMomentsByEmotion(emotion));
        } else {
            System.out.println("Invalid emotion choice.");
        }
    }

    public void filterMomentsByDate() {
        System.out.println("Enter date to filter by (dd/MM/yyyy):");
        String dateInput = terminalMenu.getInput();
        LocalDate date = parseDate(dateInput);
        if (date != null) {
            terminalMenu.displayMomentList(momentRepository.filterMomentsByDate(date));
        }
    }

    private Emotions selectEmotion() {
        terminalMenu.displayEmotionOptions();
        int emotionsChoice = Integer.parseInt(terminalMenu.getInput());
        return Emotions.getByIndex(emotionsChoice);
    }

    private LocalDate parseDate(String date) {
        try {
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            return LocalDate.parse(date, dateFormatter);
        } catch (DateTimeParseException e) {
            System.out.println("Invalid date format. Please enter date as dd/MM/yyyy.");
            return null;
        }
    }
}

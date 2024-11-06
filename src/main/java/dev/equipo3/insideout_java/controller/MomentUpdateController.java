package dev.equipo3.insideout_java.controller;

import dev.equipo3.insideout_java.models.Emotions;
import dev.equipo3.insideout_java.models.Moment;
import dev.equipo3.insideout_java.repository.MomentRepository;
import dev.equipo3.insideout_java.views.TerminalMenu;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class MomentUpdateController {
    private final MomentRepository momentRepository;
    private final TerminalMenu terminalMenu;

    public MomentUpdateController(MomentRepository momentRepository, TerminalMenu terminalMenu) {
        this.momentRepository = momentRepository;
        this.terminalMenu = terminalMenu;
    }

    public void updateMoment() {
        System.out.println("Enter the moment ID to update:");
        int id = Integer.parseInt(terminalMenu.getInput());

        Moment moment = momentRepository.getMomentById(id);
        if (moment == null) {
            System.out.println("Moment not found.");
            return;
        }

        System.out.println("Current Moment details:");
        System.out.println(moment);

        boolean updating = true;
        while (updating) {
            System.out.println("Choose what you want to update:");
            System.out.println("1. Title");
            System.out.println("2. Description");
            System.out.println("3. Date");
            System.out.println("4. Emotion");
            System.out.println("5. Exit to Main Menu");

            int choice = getValidInput();

            switch (choice) {
                case 1 -> {
                    System.out.println("Enter new title:");
                    String newTitle = terminalMenu.getInput();
                    moment.setTitle(newTitle);
                }
                case 2 -> {
                    System.out.println("Enter new description:");
                    String newDescription = terminalMenu.getInput();
                    moment.setDescription(newDescription);
                }
                case 3 -> {
                    System.out.println("Enter new date (dd/MM/yyyy):");
                    LocalDate newDate = parseDate(terminalMenu.getInput());
                    if (newDate != null) {
                        moment.setMomentDate(newDate);
                    }
                }
                case 4 -> {
                    System.out.println("Select new emotion:");
                    Emotions newEmotion = selectEmotion();
                    if (newEmotion != null) {
                        moment.setEmotions(newEmotion);
                    } else {
                        System.out.println("Invalid emotion selection.");
                    }
                }
                case 5 -> {
                    System.out.println("Returning to main menu...");
                    updating = false;
                    return;
                }
                default -> System.out.println("Invalid choice.");
            }

            moment.setUpdatedDate(LocalDateTime.now());
            System.out.println("Field updated successfully!");

            int continueChoice = terminalMenu.displayYesNoMenu();
            if (continueChoice == 2) {
                System.out.println("Moment updated successfully.");
                updating = false;
            }
        }
    }

    private int getValidInput() {
        int choice = -1;
        boolean validInput = false;
        while (!validInput) {
            try {
                choice = Integer.parseInt(terminalMenu.getInput());
                validInput = true;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number between 1 and 5.");
            }
        }
        return choice;
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

    private Emotions selectEmotion() {
        terminalMenu.displayEmotionOptions();
        int emotionsChoice = Integer.parseInt(terminalMenu.getInput());
        return Emotions.getByIndex(emotionsChoice);
    }
}

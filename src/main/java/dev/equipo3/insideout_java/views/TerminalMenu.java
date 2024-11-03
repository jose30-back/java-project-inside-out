package dev.equipo3.insideout_java.views;

import java.util.List;
import java.util.Scanner;

import dev.equipo3.insideout_java.models.Emotions;
import dev.equipo3.insideout_java.models.Moment;

public class TerminalMenu {
    private final Scanner scanner = new Scanner(System.in);

    public void displayMainMenu() {
        System.out.println("\n--- My diary: ---");
        System.out.println("1. Add Moment");
        System.out.println("2. View all available moments");
        System.out.println("3. Delete Moment");
        System.out.println("4. Filter Moments");
        System.out.println("5. Exit");
        System.out.print("Select an option: ");
    }

    public void displayFilterMenu() {
        System.out.println("\n--- Filter Menu ---");
        System.out.println("1. Filter by Emotion");
        System.out.println("2. Filter by Date");
        System.out.print("Enter an option: ");
    }

    public void displayEmotionOptions() {
        System.out.println("Select an emotion:");
        Emotions[] emotion = Emotions.values();
        for (int i = 0; i < emotion.length; i++) {
            System.out.println((i + 1) + ". " + emotion[i]);
        }
        System.out.print("Select an emotion: ");
    }

    public void displayMomentList(List<Moment> moments) {
        if (moments.isEmpty()) {
            System.out.println("No moments found.");
        } else {
            for (Moment moment : moments) {
                System.out.println(moment);
            }
        }
    }

    public void displayMessage(String message) {
        System.out.println(message);
    }

    public String getInput() {
        return scanner.nextLine();
    }

}

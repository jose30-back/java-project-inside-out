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
        System.out.println("3. Update Moment");
        System.out.println("4. Delete Moment");
        System.out.println("5. Filter Moments");
        System.out.println("6. Exit");
        System.out.print("Select an option: ");
    }

    public void displayUpdateOptions() {
        System.out.println("\nChoose what you want to update:");
        System.out.println("1. Title");
        System.out.println("2. Description");
        System.out.println("3. Date");
        System.out.println("4. Emotion");
        System.out.print("Enter your choice: ");
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

    public int displayYesNoMenu() {
        System.out.println("Do you want to update another field?");
        System.out.println("1. Yes");
        System.out.println("2. No");
        System.out.print("Select an option: ");
        int choice;
        while (true) {
            try {
                choice = Integer.parseInt(getInput());
                if (choice == 1 || choice == 2) {
                    break;
                } else {
                    System.out.println("Invalid choice. Please enter 1 for Yes or 2 for No.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number (1 or 2).");
            }
        }
        return choice;
    }

}

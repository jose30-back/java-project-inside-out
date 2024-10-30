package dev.equipo3.insideout_java;

import dev.equipo3.insideout_java.controller.MomentController;

public class App {
    private final MomentController momentController = new MomentController();
    private boolean running = true;

    public void run() {
        while (running) {
            momentController.displayMainMenu();
            String input = momentController.getTerminalMenu().getInput();

            try {
                switch (Integer.parseInt(input)) {
                    case 1 -> momentController.addMoment();
                    case 2 -> momentController.viewMoments();
                    case 3 -> momentController.deleteMoment();
                    case 4 -> momentController.filterMoments();
                    case 5 -> exit();
                    default -> momentController.getTerminalMenu().displayMessage("Invalid choice.");
                }
            } catch (NumberFormatException e) {
                momentController.getTerminalMenu().displayMessage("Please enter a valid number.");
            }
        }
    }

    private void exit() {
        momentController.getTerminalMenu().displayMessage("See you next time!!!");
        running = false;
    }

    public static void main(String[] args) {
        new App().run();
    }
}

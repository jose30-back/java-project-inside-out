package dev.equipo3.insideout_java.controller;

import dev.equipo3.insideout_java.repository.MomentRepository;
import dev.equipo3.insideout_java.views.TerminalMenu;

public class MomentController {
    private final MomentRepository momentRepository = new MomentRepository();
    private final TerminalMenu terminalMenu = new TerminalMenu();
    private final MomentCreateController creationController = new MomentCreateController(momentRepository,
            terminalMenu);
    private final MomentViewController viewController = new MomentViewController(momentRepository, terminalMenu);
    private final MomentDeleteController deleteController = new MomentDeleteController(momentRepository, terminalMenu);
    private final MomentFilterController filterController = new MomentFilterController(momentRepository, terminalMenu);

    public void displayMainMenu() {
        terminalMenu.displayMainMenu();
    }

    public TerminalMenu getTerminalMenu() {
        return terminalMenu;
    }

    public void addMoment() {
        creationController.addMoment();
    }

    public void viewMoments() {
        viewController.viewMoments();
    }

    public void deleteMoment() {
        deleteController.deleteMoment();
    }

    public void filterMoments() {
        terminalMenu.displayFilterMenu();
        int filterChoice = Integer.parseInt(terminalMenu.getInput());

        if (filterChoice == 1) {
            filterController.filterMomentsByEmotion();
        } else if (filterChoice == 2) {
            filterController.filterMomentsByDate();
        } else {
            System.out.println("Invalid choice.");
        }
    }
}

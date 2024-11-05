package dev.equipo3.insideout_java.controller;

import dev.equipo3.insideout_java.repository.MomentRepository;
import dev.equipo3.insideout_java.views.TerminalMenu;

public class MomentDeleteController {
    private final MomentRepository momentRepository;
    private final TerminalMenu terminalMenu;

    public MomentDeleteController(MomentRepository momentRepository, TerminalMenu terminalMenu) {
        this.momentRepository = momentRepository;
        this.terminalMenu = terminalMenu;
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
}

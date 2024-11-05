package dev.equipo3.insideout_java.controller;

import dev.equipo3.insideout_java.repository.MomentRepository;
import dev.equipo3.insideout_java.views.TerminalMenu;

public class MomentViewController {
    private final MomentRepository momentRepository;
    private final TerminalMenu terminalMenu;

    public MomentViewController(MomentRepository momentRepository, TerminalMenu terminalMenu) {
        this.momentRepository = momentRepository;
        this.terminalMenu = terminalMenu;
    }

    public void viewMoments() {
        terminalMenu.displayMomentList(momentRepository.getAllMoments());
    }
}

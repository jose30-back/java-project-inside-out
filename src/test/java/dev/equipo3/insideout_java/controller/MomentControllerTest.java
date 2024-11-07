package dev.equipo3.insideout_java.controller;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import dev.equipo3.insideout_java.views.TerminalMenu;

public class MomentControllerTest {

    private MomentController momentController;

    @BeforeEach
    public void setUp() {
        momentController = new MomentController() {
            @Override
            public void displayMainMenu() {
            }

            @Override
            public void addMoment() {
            }

            @Override
            public void viewMoments() {
            }

            @Override
            public void deleteMoment() {
            }

            @Override
            public void updateMoment() {
            }

            @Override
            public void filterMoments() {
            }
        };
    }

    @Test
    public void testDisplayMainMenu() {
        momentController.displayMainMenu();
    }

    @Test
    public void testAddMoment() {
        momentController.addMoment();
    }

    @Test
    public void testViewMoments() {
        momentController.viewMoments();
    }

    @Test
    public void testDeleteMoment() {
        momentController.deleteMoment();
    }

    @Test
    public void testUpdateMoment() {
        momentController.updateMoment();
    }

    @Test
    public void testFilterMoments() {
        momentController.filterMoments();
    }

    @Test
    public void testTerminalMenuInteraction() {
        TerminalMenu terminalMenu = momentController.getTerminalMenu();
        assertNotNull(terminalMenu);
    }
}

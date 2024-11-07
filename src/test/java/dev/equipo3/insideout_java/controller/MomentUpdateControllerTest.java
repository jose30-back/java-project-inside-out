package dev.equipo3.insideout_java.controller;

import dev.equipo3.insideout_java.models.Emotions;
import dev.equipo3.insideout_java.views.TerminalMenu;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import java.time.LocalDate;

public class MomentUpdateControllerTest {

    private static class TestTerminalMenu extends TerminalMenu {
        private String input;

        public void setInput(String input) {
            this.input = input;
        }

        @Override
        public String getInput() {
            return input;
        }

        @Override
        public int displayYesNoMenu() {
            return 1;
        }

        @Override
        public void displayEmotionOptions() {

        }
    }

    private MomentUpdateController momentUpdateController;
    private TestTerminalMenu testTerminalMenu;

    @BeforeEach
    public void setUp() {
        testTerminalMenu = new TestTerminalMenu();
        momentUpdateController = new MomentUpdateController(null, testTerminalMenu);

    }

    @Test
    public void testGetValidInput_ValidInput() {
        testTerminalMenu.setInput("3");
        int result = momentUpdateController.getValidInput();
        assertThat(result, is(3));
    }

    @Test
    public void testParseDate_ValidDate() {
        String inputDate = "25/12/2024";
        LocalDate result = momentUpdateController.parseDate(inputDate);
        assertThat(result, is(LocalDate.of(2024, 12, 25)));
    }

    @Test
    public void testParseDate_InvalidDate() {
        String inputDate = "31-12-2024";
        LocalDate result = momentUpdateController.parseDate(inputDate);
        assertThat(result, is(nullValue()));
    }

    @Test
    public void testSelectEmotion_ValidInput() {
        testTerminalMenu.setInput("1");
        Emotions result = momentUpdateController.selectEmotion();
        assertThat(result, is(Emotions.Joy));
    }

    @Test
    public void testSelectEmotion_InvalidInput() {
        testTerminalMenu.setInput("99");
        Emotions result = momentUpdateController.selectEmotion();
        assertThat(result, is(nullValue()));
    }

}

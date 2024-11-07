package dev.equipo3.insideout_java.views;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import dev.equipo3.insideout_java.models.Emotions;
import dev.equipo3.insideout_java.models.Moment;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class TerminalMenuTest {
    private TerminalMenu terminalMenu;
    private ByteArrayOutputStream outputStream;

    @BeforeEach
    void setUp() {
        terminalMenu = new TerminalMenu();
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    void testDisplayMainMenu() {
        terminalMenu.displayMainMenu();

        assertThat(outputStream.toString(), containsString("--- My diary: ---"));
        assertThat(outputStream.toString(), containsString("1. Add Moment"));
        assertThat(outputStream.toString(), containsString("2. View all available moments"));
        assertThat(outputStream.toString(), containsString("6. Exit"));
    }

    @Test
    void testDisplayUpdateOptions() {
        terminalMenu.displayUpdateOptions();

        assertThat(outputStream.toString(), containsString("Choose what you want to update:"));
        assertThat(outputStream.toString(), containsString("1. Title"));
        assertThat(outputStream.toString(), containsString("4. Emotion"));
    }

    @Test
    void testDisplayFilterMenu() {
        terminalMenu.displayFilterMenu();

        assertThat(outputStream.toString(), containsString("--- Filter Menu ---"));
        assertThat(outputStream.toString(), containsString("1. Filter by Emotion"));
        assertThat(outputStream.toString(), containsString("2. Filter by Date"));
    }

    @Test
    void testDisplayEmotionOptions() {

        String simulatedInput = "1\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        terminalMenu.displayEmotionOptions();

        assertThat(outputStream.toString(), containsString("Select an emotion:"));
        assertThat(outputStream.toString(), containsString("1. Joy"));
        assertThat(outputStream.toString(), containsString("2. Sadness"));
        assertThat(outputStream.toString(), containsString("3. Anger"));
        assertThat(outputStream.toString(), containsString("4. Disgust"));
        assertThat(outputStream.toString(), containsString("Select an emotion:"));
    }

    @Test
    void testDisplayMomentList_emptyList() {
        List<Moment> emptyMoments = new ArrayList<>();
        terminalMenu.displayMomentList(emptyMoments);

        assertThat(outputStream.toString(), containsString("No moments found."));
    }

    @Test
    void testDisplayMomentList_withMoments() {

        List<Moment> moments = new ArrayList<>();
        Moment moment1 = new Moment(1, "Happy Day", "A joyful day with friends", Emotions.Joy,
                LocalDate.of(2024, 11, 7));
        Moment moment2 = new Moment(2, "Sad Evening", "A reflective evening alone", Emotions.Sadness,
                LocalDate.of(2024, 11, 8));
        moments.add(moment1);
        moments.add(moment2);
        terminalMenu.displayMomentList(moments);

        assertThat(outputStream.toString(), containsString("Happy Day"));
        assertThat(outputStream.toString(), containsString("A joyful day with friends"));
        assertThat(outputStream.toString(), containsString("Sad Evening"));
        assertThat(outputStream.toString(), containsString("A reflective evening alone"));
        assertThat(outputStream.toString(), not(containsString("No moments found.")));
    }

    @Test
    void testDisplayMessage() {
        String testMessage = "Test message output";
        terminalMenu.displayMessage(testMessage);

        assertThat(outputStream.toString(), containsString(testMessage));
    }

    @Test
    void testGetInput() {
        String input = "Hello";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());

        System.setIn(in);
        terminalMenu = new TerminalMenu();
        String result = terminalMenu.getInput();

        assertEquals("Hello", result);
    }

    @Test
    void testDisplayYesNoMenu_Yes() {
        String input = "1\n";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        TerminalMenu terminalMenu = new TerminalMenu();

        int result = terminalMenu.displayYesNoMenu();
        assertEquals(1, result);
    }

    @Test
    void testDisplayYesNoMenu_No() {

        String input = "2\n";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        TerminalMenu terminalMenu = new TerminalMenu();

        int result = terminalMenu.displayYesNoMenu();
        assertEquals(2, result);
    }

    @Test
    void testDisplayYesNoMenu_InvalidInput() {
        String input = "a\n1\n";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        TerminalMenu terminalMenu = new TerminalMenu();
        int result = terminalMenu.displayYesNoMenu();
        assertEquals(1, result);
    }

    @Test
    void testDisplayYesNoMenu_InvalidChoice() {
        String input = "3\n1\n";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        TerminalMenu terminalMenu = new TerminalMenu();

        int result = terminalMenu.displayYesNoMenu();
        assertEquals(1, result);
    }

}

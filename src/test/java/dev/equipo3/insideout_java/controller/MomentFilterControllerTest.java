package dev.equipo3.insideout_java.controller;

import dev.equipo3.insideout_java.models.Emotions;
import dev.equipo3.insideout_java.models.Moment;
import dev.equipo3.insideout_java.repository.MomentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class MomentFilterControllerTest {

    private MomentFilterController controller;
    private MomentRepository momentRepository;

    @BeforeEach
    public void setUp() {
        momentRepository = new MomentRepository();
        controller = new MomentFilterController(momentRepository, null);
    }

    @Test
    public void testSelectEmotion_ValidEmotion() {

        int emotionIndex = 1;
        Emotions selectedEmotion = Emotions.getByIndex(emotionIndex);

        assertThat(selectedEmotion, is(Emotions.Joy));
    }

    @Test
    public void testSelectEmotion_InvalidEmotion() {
        int emotionIndex = 99;
        Emotions selectedEmotion = Emotions.getByIndex(emotionIndex);

        assertThat(selectedEmotion, is(nullValue()));
    }

    @Test
    public void testParseDate_ValidDate() {
        String dateInput = "25/12/2023";
        LocalDate parsedDate = controller.parseDate(dateInput);

        assertThat(parsedDate, is(LocalDate.of(2023, 12, 25)));
    }

    @Test
    public void testParseDate_InvalidDate() {
        String dateInput = "2023-12-25";
        LocalDate parsedDate = controller.parseDate(dateInput);

        assertThat(parsedDate, is(nullValue()));
    }

    @Test
    public void testFilterMomentsByDate_ValidDate() {
        momentRepository
                .addMoment(new Moment(1, "Moment 1", "Description 1", Emotions.Joy, LocalDate.of(2023, 12, 25)));
        momentRepository
                .addMoment(new Moment(2, "Moment 2", "Description 2", Emotions.Sadness, LocalDate.of(2023, 12, 26)));

        String dateInput = "25/12/2023";
        LocalDate date = controller.parseDate(dateInput);

        momentRepository.filterMomentsByDate(date);

        assertThat(momentRepository.getAllMoments(), hasSize(2));
        assertThat(momentRepository.getAllMoments().get(0).getMomentDate(), is(LocalDate.of(2023, 12, 25)));
    }

    @Test
    public void testFilterMomentsByDate_InvalidDate() {
        momentRepository
                .addMoment(new Moment(1, "Moment 1", "Description 1", Emotions.Joy, LocalDate.of(2023, 12, 25)));
        momentRepository
                .addMoment(new Moment(2, "Moment 2", "Description 2", Emotions.Sadness, LocalDate.of(2023, 12, 26)));

        String dateInput = "invalid date";
        LocalDate date = controller.parseDate(dateInput);

        assertThat(date, is(nullValue()));
    }
}

package dev.equipo3.insideout_java.models;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.notNullValue;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.junit.jupiter.api.Test;

public class TestMoment {

    @Test
    void testConstructor() {

        // Datos de entrada
        LocalDate momentDate = LocalDate.of(2024, 5, 10);
        Emotions emotion = Emotions.Anxiety;

        // Crear un momento mediante el constructor
        Moment moment = new Moment(1, "test title", "description", emotion, momentDate);

        // Realizamos las pruebas pertinentes
        assertThat(moment.getId(), is(notNullValue()));
        assertThat(moment.getTitle(), is("test title"));
        assertThat(moment.getDescription(), is("description"));
        assertThat(moment.getEmotions(), is(emotion));
        assertThat(moment.getMomentDate(), is(momentDate));
        assertThat(moment.getCreatedDate(), is(notNullValue()));
        assertThat(moment.getFormattedCreatedDate(), is(notNullValue()));
    }

    @Test
    void testSettersAndGetters() {

        LocalDate momentDate = LocalDate.of(2025, 8, 15);
        Moment moment = new Moment(2, "test title", "description", Emotions.Fear, momentDate);

        moment.setTitle("update title");
        moment.setDescription("description update");
        moment.setEmotions(Emotions.Nostalgia);
        moment.setMomentDate(LocalDate.of(2025, 3, 20));

        assertThat(moment.getTitle(), is("update title"));
        assertThat(moment.getDescription(), is("description update"));
        assertThat(moment.getEmotions(), is(Emotions.Nostalgia));
        assertThat(moment.getMomentDate(), is(LocalDate.of(2025, 3, 20)));

    }

    @Test
    void testToStringFormat() {
        LocalDate momentDate = LocalDate.of(2025, 8, 15);
        Moment moment = new Moment(3, "test title", "description", Emotions.Fear, momentDate);

        String ExpectToString = "----------------------\n" +
                "Moment:\n" +
                "ID: " + moment.getId() + "\n" +
                "Title: " + moment.getTitle() + "\n" +
                "Description: " + moment.getDescription() + "\n" +
                "Emotion: " + Emotions.Fear + "\n" +
                "Date: " + momentDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
                + "\n" +
                "Created: " + moment.getFormattedCreatedDate()
                + "\n" +
                "Updated: " + moment.getFormattedUpdatedDate() + "\n";

        assertThat(moment.toString(), is(ExpectToString));

    }

    @Test
    void testDateFormatting() {
        // Datos de entrada
        LocalDate momentDate = LocalDate.of(2024, 5, 20);
        Moment moment = new Moment(1, "Test Title", "Test Description", Emotions.Joy, momentDate);

        // Verificar el formato de fecha de creación
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yy HH:mm");
        String expectedCreatedDate = moment.getCreatedDate().format(formatter);
        assertThat(moment.getFormattedCreatedDate(), is(expectedCreatedDate));

        // Verificar el formato de fecha de actualización (es el mismo que el de
        // creación al principio)
        String expectedUpdatedDate = moment.getFormattedUpdatedDate();
        assertThat(expectedUpdatedDate, is(expectedCreatedDate));
    }

    @Test 
    void updateUpdatedDate () {

        LocalDate momentDate = LocalDate.of(2023, 10, 18);
        Moment moment = new Moment(4, "Test Title", "Test Description", Emotions.Sadness, momentDate);

        LocalDateTime originalUpdateDate = moment.getCreatedDate();

        moment.updateUpdatedDate();

        assertThat(moment.getFormattedUpdatedDate(), is(not(equalTo(originalUpdateDate))));
    }

    @Test 
    void testSetCreatedDate () {

        LocalDateTime newCreatedDate = LocalDateTime.of(2023, 10, 18, 15, 12);
        Moment moment = new Moment(4, "Test Title", "Test Description", Emotions.Sadness, LocalDate.now());

        moment.setCreatedDate(newCreatedDate);
        assertThat(moment.getCreatedDate(), is(newCreatedDate));
    }

    @Test
    void testSetUpdatedDate () {
        LocalDateTime newUpdateDate = LocalDateTime.of(2023, 10, 18, 15, 12);
        Moment moment = new Moment(4, "Test Title", "Test Description", Emotions.Sadness, LocalDate.now());

        moment.setUpdatedDate(newUpdateDate);
        assertThat(moment.getUpdatedDate(), is(newUpdateDate));
    }

}

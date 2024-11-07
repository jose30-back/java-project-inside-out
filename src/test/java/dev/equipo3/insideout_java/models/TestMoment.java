package dev.equipo3.insideout_java.models;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

import java.time.LocalDate;

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
    void testSettersAndGetters(){   

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

}

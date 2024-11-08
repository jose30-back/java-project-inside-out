package dev.equipo3.insideout_java.models;

import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import java.util.Arrays;

public class EmotionsTest {

    @Test
    public void testGetByIndex_validIndex() {
        Emotions emotion = Emotions.getByIndex(2);
        assertThat(emotion, is(Emotions.Sadness));
    }

    @Test
    public void testGetByIndex_invalidIndexBelowRange() {
        Emotions emotion = Emotions.getByIndex(0);
        assertThat(emotion, is(nullValue()));
    }

    @Test
    public void testGetByIndex_invalidIndexAboveRange() {
        Emotions emotion = Emotions.getByIndex(11);
        assertThat(emotion, is(nullValue()));
    }

    @Test
    public void testValues() {
        Emotions[] emotions = Emotions.values();
        assertThat(emotions.length, is(10));
        assertThat(Arrays.asList(emotions), hasItem(Emotions.Joy));
        assertThat(Arrays.asList(emotions), hasItem(Emotions.Fear));
    }
}
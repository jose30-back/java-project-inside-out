package dev.equipo3.insideout_java.controller;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

public class MomentCreateControllerTest {

    @Test
    void testParseDate_validDate() {
        MomentCreateController controller = new MomentCreateController(null, null);

        String validDate = "25/12/2024";
        LocalDate result = controller.parseDate(validDate);

        assertThat(result, is(LocalDate.of(2024, 12, 25)));
    }

    @Test
    void testParseDate_invalidDate() {
        MomentCreateController controller = new MomentCreateController(null, null);

        String invalidDate = "2024/12/25";
        LocalDate result = controller.parseDate(invalidDate);

        assertThat(result, is((LocalDate) null));
    }
}

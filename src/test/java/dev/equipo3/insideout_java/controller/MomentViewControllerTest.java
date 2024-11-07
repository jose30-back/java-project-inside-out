package dev.equipo3.insideout_java.controller;

import dev.equipo3.insideout_java.views.TerminalMenu;
import dev.equipo3.insideout_java.repository.MomentRepository;
import dev.equipo3.insideout_java.models.Moment;
import dev.equipo3.insideout_java.models.Emotions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MomentViewControllerTest {

    private MomentViewController momentViewController;
    private TestMomentRepository testMomentRepository;
    private TestTerminalMenu testTerminalMenu;

    @BeforeEach
    public void setUp() {
        testMomentRepository = new TestMomentRepository();
        testTerminalMenu = new TestTerminalMenu();
        momentViewController = new MomentViewController(testMomentRepository, testTerminalMenu);
    }

    @Test
    public void testViewMoments() {
        List<Moment> moments = new ArrayList<>();
        moments.add(new Moment(1, "Moment 1", "Description 1", Emotions.Joy, LocalDate.now()));
        moments.add(new Moment(2, "Moment 2", "Description 2", Emotions.Sadness, LocalDate.now()));
        testMomentRepository.setMoments(moments);

        momentViewController.viewMoments();

        assertThat(testTerminalMenu.getDisplayedMoments(), hasSize(2));
        assertThat(testTerminalMenu.getDisplayedMoments(), containsInAnyOrder(
                hasProperty("title", is("Moment 1")),
                hasProperty("title", is("Moment 2"))));
    }

    private static class TestMomentRepository extends MomentRepository {
        private List<Moment> moments;

        public void setMoments(List<Moment> moments) {
            this.moments = moments;
        }

        @Override
        public List<Moment> getAllMoments() {
            return moments;
        }
    }

    private static class TestTerminalMenu extends TerminalMenu {
        private List<Moment> displayedMoments = new ArrayList<>();

        @Override
        public void displayMomentList(List<Moment> moments) {
            this.displayedMoments = moments;
        }

        public List<Moment> getDisplayedMoments() {
            return displayedMoments;
        }
    }
}

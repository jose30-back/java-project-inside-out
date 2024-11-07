package dev.equipo3.insideout_java.controller;

import dev.equipo3.insideout_java.repository.MomentRepository;
import dev.equipo3.insideout_java.views.TerminalMenu;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class TestMomentRepository extends MomentRepository {
    private boolean deleteResult = false;

    public void setDeleteResult(boolean deleteResult) {
        this.deleteResult = deleteResult;
    }

    @Override
    public boolean deleteMomentById(int id) {
        return deleteResult;
    }
}

class TestTerminalMenu extends TerminalMenu {
    private String input;

    public void setInput(String input) {
        this.input = input;
    }

    @Override
    public String getInput() {
        return input;
    }
}

public class MomentDeleteControllerTest {
    private TestMomentRepository testRepository;
    private TestTerminalMenu testMenu;
    private MomentDeleteController controller;

    @BeforeEach
    public void setUp() {
        testRepository = new TestMomentRepository();
        testMenu = new TestTerminalMenu();
        controller = new MomentDeleteController(testRepository, testMenu);
    }

    @Test
    public void testDeleteMomentSuccessfully() {
        testMenu.setInput("1");
        testRepository.setDeleteResult(true);

        controller.deleteMoment();

        assertThat("Moment should be deleted successfully", testRepository.deleteMomentById(1), is(true));
    }

    @Test
    public void testDeleteMomentNotFound() {
        testMenu.setInput("2");
        testRepository.setDeleteResult(false);

        controller.deleteMoment();
        assertThat("Moment should not be found and deleted", testRepository.deleteMomentById(2), is(false));
    }
}

package dev.equipo3.insideout_java.repository;

import dev.equipo3.insideout_java.models.Emotions;
import dev.equipo3.insideout_java.models.Moment;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class MomentRepositoryTest {
    private MomentRepository repository;

    @BeforeEach
    void setUp() {
        repository = new MomentRepository();
    }

    @Test
    void testAddMoment() {
        Moment moment = new Moment(1, "Test Title 1", "Test Description 1", Emotions.Joy, LocalDate.now());
        repository.addMoment(moment);

        List<Moment> allMoments = repository.getAllMoments();
        assertEquals(1, allMoments.size());
        assertEquals(moment, allMoments.get(0));
    }

    @Test
    void testGetAllMoments() {
        Moment moment1 = new Moment(1, "Test Title 1", "Test Description 1", Emotions.Joy, LocalDate.now());
        Moment moment2 = new Moment(2, "Test Title 2", "Test Description 2", Emotions.Sadness,
                LocalDate.now().plusDays(1));

        repository.addMoment(moment1);
        repository.addMoment(moment2);

        List<Moment> allMoments = repository.getAllMoments();
        assertEquals(2, allMoments.size());
    }

    @Test
    void testDeleteMomentById() {
        Moment moment = new Moment(1, "Test Title 1", "Test Description 1", Emotions.Anxiety, LocalDate.now());
        repository.addMoment(moment);

        assertTrue(repository.deleteMomentById(moment.getId()));
        assertFalse(repository.deleteMomentById(moment.getId())); // вже видаленo
        assertEquals(0, repository.getAllMoments().size());
    }

    @Test
    void testFilterMomentsByEmotion() {
        Moment happyMoment = new Moment(1, "Happy Moment", "Feeling great!", Emotions.Joy, LocalDate.now());
        Moment sadMoment = new Moment(2, "Sad Moment", "Feeling down.", Emotions.Sadness, LocalDate.now());

        repository.addMoment(happyMoment);
        repository.addMoment(sadMoment);

        List<Moment> happyMoments = repository.filterMomentsByEmotion(Emotions.Joy);
        assertEquals(1, happyMoments.size());
        assertEquals(happyMoment, happyMoments.get(0));
    }

    @Test
    void testFilterMomentsByDate() {

        LocalDate today = LocalDate.now();
        LocalDate tomorrow = today.plusDays(1);

        Moment happyMoment = new Moment(1, "Happy Moment", "Feeling great!", Emotions.Joy, today);
        Moment sadMoment = new Moment(2, "Sad Moment", "Feeling down.", Emotions.Sadness, tomorrow);

        repository.addMoment(happyMoment);
        repository.addMoment(sadMoment);

        List<Moment> filteredByDate = repository.filterMomentsByDate(today);
        assertEquals(1, filteredByDate.size());
        assertEquals(happyMoment, filteredByDate.get(0));

        List<Moment> filteredBytomorrow = repository.filterMomentsByDate(tomorrow);
        assertEquals(1, filteredBytomorrow.size());
        assertEquals(sadMoment, filteredBytomorrow.get(0));
    }

    @Test
    void testAddNullMomentDoesNothing() {
        repository.addMoment(null);
        assertEquals(0, repository.getAllMoments().size());
    }

    @Test
    public void testGetMomentById() {
        Moment moment = new Moment(1, "Test Title 1", "Test Description 1", Emotions.Joy, LocalDate.now());
        repository.addMoment(moment);

        Moment retrievedMoment = repository.getMomentById(moment.getId());
        assertNotNull(retrievedMoment, "Moment with ID should be found");
        assertEquals(moment.getId(), retrievedMoment.getId(), "The moment ID should match");
        assertEquals("Test Description 1", retrievedMoment.getDescription(), "The moment description should match");
    }

}
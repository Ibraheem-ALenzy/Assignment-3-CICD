import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StudentServiceTest {

    @Test
    void testAddStudentAndTopStudent() {
        StudentService service = new StudentService();
        Student s1 = new Student("Alice", 20, 3.5);
        Student s2 = new Student("Bob", 22, 3.9);

        service.addStudent(s1);
        service.addStudent(s2);

        // Test if top student is correctly identified
        Student top = service.getTopStudent();
        assertEquals("Bob", top.getName());
    }

    @Test
    void testCalculateAverageGpa() {
        StudentService service = new StudentService();
        service.addStudent(new Student("Alice", 20, 3.5));
        service.addStudent(new Student("Bob", 22, 3.5));

        double avg = service.calculateAverageGpa();
        assertEquals(3.5, avg, 0.001);
    }

    @Test
    void testRemoveStudentByName_success() {
        StudentService service = new StudentService();
        service.addStudent(new Student("Alice", 20, 3.5));

        boolean removed = service.removeStudentByName("Alice");

        assertTrue(removed);

        // After removing the only student, the list is empty.
        // getTopStudent() currently throws IndexOutOfBoundsException.
        assertThrows(IndexOutOfBoundsException.class, () -> service.getTopStudent());
    }

    @Test
    void testRemoveStudentByName_notFound() {
        StudentService service = new StudentService();
        service.addStudent(new Student("Bob", 22, 3.9));

        boolean removed = service.removeStudentByName("Alice");

        assertFalse(removed);
    }
}

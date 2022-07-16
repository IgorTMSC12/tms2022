package students;

import model.Sex;
import model.Student;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class StudentsTest {

    private static Student student1;
    private static Student student2;
    private static Student student3;

    private static List<Student> actual;
    private static List<Student> actualBySex;

    @BeforeAll
    public static void setUp() {
        student1 = new Student("Ivan", 17, Sex.MALE);
        student2 = new Student("Anna", 19, Sex.FEMALE);
        student3 = new Student("Polina", 18, Sex.FEMALE);

        actual = new ArrayList<>();
        actual.add(student1);
        actual.add(student2);
        actual.add(student3);

        actualBySex = new ArrayList<>();
        actualBySex.add(student2);
        actualBySex.add(student3);
    }

    @Test
    public void checkAllStudentsReturned() {
        List<Student> expected = Student.getAllStudents();
        assertEquals(expected, actual);
    }

    @Test
    public void checkAllStudentsReturned_NotNull() {
        List<Student> expected = Student.getAllStudents();
        assertNotNull(expected);
    }

    @Test
    public void checkAllStudentsBySex() {
        List<Student> expected = Student.getAllStudentsBySex(Sex.FEMALE);
        assertEquals(expected, actualBySex);
    }

    @Test
    public void checkStudentsCountWithSex() {
        int expected = Student.getStudentsCountWithSex(Sex.FEMALE);
        assertEquals(expected, 2);
    }

    @Test
    public void checkStudentsCount() {
        int expected = Student.getStudentsCount();
        assertEquals(expected, 3);
    }

    @Test
    public void checkSumOfAllStudentsAge() {
        int expected = Student.getSumOfAllStudentsAge();
        assertEquals(expected, 54);
    }

    @Test
    public void checkSumOfAllStudentsAgeBySex() {
        int expected = Student.getSumOfAllStudentsAgeBySex(Sex.FEMALE);
        assertEquals(expected, 37);
    }

    @Test
    public void checkAverageAgeOfAllStudents() {
        int expected = Student.getAverageAgeOfAllStudents();
        assertEquals(expected, 18);
    }

    @Test
    public void checkAverageOfAllStudentsBySex() {
        int expected = Student.getAverageOfAllStudentsBySex(Sex.FEMALE);
        assertEquals(expected, 18);
    }
}

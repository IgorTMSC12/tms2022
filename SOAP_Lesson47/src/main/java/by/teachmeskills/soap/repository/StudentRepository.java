package by.teachmeskills.soap.repository;

import by.teachmeskills.soap.model.Faculty;
import by.teachmeskills.soap.model.Sex;
import by.teachmeskills.soap.model.Student;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class StudentRepository {
    private static final List<Student> students = new ArrayList<>();

    @PostConstruct
    public void initData() {
        Student student1 = new Student();
        student1.setName("Igor");
        student1.setLastname("Mixaevich");
        student1.setAge(24);
        student1.setSex(Sex.MALE);
        student1.setFaculty(Faculty.FACULTY_OF_ENERGY);

        students.add(student1);

        Student student2 = new Student();
        student2.setName("Ivan");
        student2.setLastname("Ivanovich");
        student2.setAge(20);
        student2.setSex(Sex.MALE);
        student2.setFaculty(Faculty.MECHANICAL_ENGINEERING_FACULTY);

        students.add(student2);

        Student student3 = new Student();
        student1.setName("Anastasia");
        student1.setLastname("Ivanovna");
        student1.setAge(24);
        student1.setSex(Sex.FEMALE);
        student1.setFaculty(Faculty.BUILDING_FACULTY);

        students.add(student3);
    }

    public Student findStudent(String lastname) {
        Student result = null;
        for (Student student : students) {
            if (lastname.equals(student.getLastname())) {
                result = student;
            }
        }
        return result;
    }
}

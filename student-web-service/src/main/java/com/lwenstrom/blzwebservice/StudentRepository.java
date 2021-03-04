package com.lwenstrom.blzwebservice;

import javax.annotation.PostConstruct;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import net.lwenstrom.ws.students.Student;
import org.springframework.stereotype.Component;

@Component
public class StudentRepository {
    private static final Map<Integer, Student> students = new HashMap<>();

    @PostConstruct
    public void initData() throws DatatypeConfigurationException {
        Student maja = new Student();
        maja.setName("Maja");
        maja.setSurname("Biene");
        maja.setStudentID(34718);
        maja.setAvgScore(1.74);
        maja.setBirthday(
                DatatypeFactory.newInstance().newXMLGregorianCalendar(LocalDate.of(1996, 4, 25).toString())
);

        students.put(maja.getStudentID(), maja);


        Student willi = new Student();
        willi.setName("Willi");
        willi.setSurname("Biene");
        willi.setStudentID(38712);
        willi.setAvgScore(3.1);
        willi.setBirthday(
                DatatypeFactory.newInstance().newXMLGregorianCalendar(LocalDate.of(1995, 2, 5).toString())
        );

        students.put(willi.getStudentID(), willi);


        Student puck = new Student();
        puck.setName("Puck");
        puck.setSurname("die Fliege");
        puck.setStudentID(42382);
        puck.setAvgScore(1.0);
        puck.setBirthday(
                DatatypeFactory.newInstance().newXMLGregorianCalendar(LocalDate.of(1994, 1, 25).toString())
        );

        students.put(puck.getStudentID(), puck);

    }

    public Student findStudent(int studentID) {
        return students.get(studentID);
    }
}

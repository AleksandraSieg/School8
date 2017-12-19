package pl.madison.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.madison.domain.Scholarship;
import pl.madison.domain.Student;
import pl.madison.services.IScholarshipServices;
import pl.madison.services.IStudentServices;

import java.util.List;
import java.util.Map;

@Controller
public class SchoolController2 {

    @Autowired
    IStudentServices iStudentServices;

    @Autowired
    IScholarshipServices iScholarshipServices;

    @RequestMapping(value = "/showStudents2")
    public String showStudents2(Map<String, Object> model){
        List<Student> students = iStudentServices.findAll();
        model.put("students", students);
        return "showStudents";
    }

    @RequestMapping(value = "/scholarshipByValue2")
    public String scholarshipByValue2(Map<String, Object> model){
        List<Scholarship> scholarships = (List<Scholarship>)iScholarshipServices.findScholarshipByValue(400);
        model.put("scholarships", scholarships);
        return "scholarshipsByValue";
    }

    @RequestMapping(value = "/addStudent2")
    public String add(Map<String, Object> model){
        model.put("student", new Student());

        return "newStudent";
    }

    @RequestMapping(value = "/pageAfter", method = RequestMethod.POST)
    public String pa(Student student, Map<String, Object> model){
        Student saved = iStudentServices.save(student);
        model.put("savedStudent", saved);
        return "pageAfterAdding";
    }
}

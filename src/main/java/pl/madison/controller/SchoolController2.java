package pl.madison.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.madison.domain.Student;
import pl.madison.services.IStudentServices;

import java.util.List;
import java.util.Map;

@Controller
public class SchoolController2 {

    @Autowired
    IStudentServices iStudentServices;

    @RequestMapping(value = "/showStudents2")
    public String showStudents2(Map<String, Object> model){
        List<Student> students = iStudentServices.findAll();
        model.put("students", students);
        return "showStudents";
    }
}

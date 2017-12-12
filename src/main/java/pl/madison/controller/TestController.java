package pl.madison.controller;

import org.springframework.web.bind.annotation.RestController;
import pl.madison.dao.StudentDao;
import pl.madison.domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RestController
public class TestController {

    @Autowired
    private StudentDao studentDao;

    @RequestMapping(value = "/showStudents", method = RequestMethod.GET)
    public List<Student> show(){
        return (List<Student>)studentDao.findAll();
    }

    @RequestMapping(value = "/addStudent", method = RequestMethod.PUT)
    public String addStudent(@RequestParam("name") String name, @RequestParam("surname") String surname,
                             @RequestParam("scoreAverage") double scoreAverage){
        Student tempStudent = Student.builder().name(name).surname(surname).scoreAverage(scoreAverage).build();

        studentDao.save(tempStudent);

        return "jupi! You had already added student";
    }

    @RequestMapping(value = "/deleteStudent", method = RequestMethod.DELETE)
    public String deleteStudent(@RequestParam("id") Long id){
        studentDao.delete(id);

        return "You have successfully deleted student";
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public String update(@RequestParam("id") Long id, @RequestParam("name") String name,
                         @RequestParam("surname") String surname, @RequestParam("scoreAverage") double scoreAverage){
        Student tempStudent = studentDao.findOne(id);
        tempStudent.setName(name);
        tempStudent.setSurname(surname);
        tempStudent.setScoreAverage(scoreAverage);
        studentDao.save(tempStudent);

        return "You have successfully update student;)";
    }

    @RequestMapping(value = "/theHighestScore", method = RequestMethod.GET)
    public String theHighestScore(){

        double tempScore = 0;
        Student tempStudent = null;

        for (Student student : studentDao.findAll()) {
            if(tempScore < student.getScoreAverage()){
                tempScore = student.getScoreAverage();
                tempStudent = student;
            }
        }

        return ""+tempStudent.getScoreAverage();
    }

    @RequestMapping(value = "/theLowestScore", method = RequestMethod.GET)
    public String theLowestScore(){

        double tempScore = 100;
        Student tempStudent = null;

        for (Student student : studentDao.findAll()) {
            if(tempScore > student.getScoreAverage()){
                tempScore = student.getScoreAverage();
                tempStudent = student;
            }
        }

        return "" + tempStudent.getScoreAverage();
    }

}

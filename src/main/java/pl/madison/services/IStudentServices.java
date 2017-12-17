package pl.madison.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.madison.dao.StudentDao;
import pl.madison.domain.Student;

import java.util.List;


public interface IStudentServices {

    List<Student> findAll();
    Student save(Student student);
    void delete(Long id);
    Student findOne(Long id);

}

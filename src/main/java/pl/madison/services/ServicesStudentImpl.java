package pl.madison.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.madison.dao.StudentDao;
import pl.madison.domain.Student;

import java.util.List;

@Service
public class ServicesStudentImpl implements IStudentServices {
    @Autowired
    private StudentDao studentDao;

    public List<Student> findAll() {
        return (List<Student>)studentDao.findAll();
    }

    public Student save(Student student) {
        return studentDao.save(student);
    }

    public void delete(Long id) {
        studentDao.delete(id);
    }

    public Student findOne(Long id) {
        return studentDao.findOne(id);
    }

}

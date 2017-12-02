package pl.madison.dao;

import pl.madison.domain.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentDao extends CrudRepository<Student, Long> {
}

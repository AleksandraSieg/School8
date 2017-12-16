package pl.madison.dao;

import org.springframework.data.repository.CrudRepository;
import pl.madison.domain.Scholarship;

import java.util.List;

public interface ScholarshipDao extends CrudRepository<Scholarship, Long> {

    List<Scholarship> findScholarshipByType(String type) ;
}

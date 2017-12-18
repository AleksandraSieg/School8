package pl.madison.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.madison.dao.ScholarshipDao;
import pl.madison.domain.Scholarship;

import java.util.List;

@Service
public class ServicesScholarshipImpl implements IScholarshipServices {

    @Autowired
    private ScholarshipDao scholarshipDao;

    public List<Scholarship> findScholarshipByType(String type) {
        return (List<Scholarship>)scholarshipDao.findScholarshipByType(type);
    }

    public List<Scholarship> findScholarshipByValue(int value) {
        return (List<Scholarship>)scholarshipDao.findScholarshipByValue(value);
    }
}

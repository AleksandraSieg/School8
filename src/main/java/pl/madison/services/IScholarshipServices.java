package pl.madison.services;

import pl.madison.domain.Scholarship;

import java.util.List;

public interface IScholarshipServices {

    List<Scholarship> findScholarshipByType(String type);
    List<Scholarship> findScholarshipByValue(int value);
}

package pl.madison;

import pl.madison.dao.ScholarshipDao;
import pl.madison.dao.StudentDao;
import pl.madison.domain.Scholarship;
import pl.madison.domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//8. Stwórz klasę z uczniami. Przypisz uczniom oceny z 5 przedmiotów.
// Wyświetl imię ucznia, który ma największą średnią oraz wyświetl imię ucznia, który ma najmniejszą średnią.
//Troche zmienilam zadanie poniewaz jego pierwsza wersje trzeba by bylo zrobic na dwie klasy i by dwie tablice byly w bazie
//danych, wiec stwierdzilam ze w klasie Student bedzie tylko srednia ocen.

@SpringBootApplication
public class SchoolApplication implements CommandLineRunner{

    public static void main(String[] args) {
        SpringApplication.run(SchoolApplication.class, args);
    }

    @Autowired
    private StudentDao studentDao;

    @Autowired
    private ScholarshipDao scholarshipDao;

    public Student createStudent(String name, String surname, double scoreAverage){
        return Student.builder().name(name).surname(surname).scoreAverage(scoreAverage).build();

    }

    public Scholarship createScholarship(String type, int value, Student student){
        return Scholarship.builder().type(type).value(value).student(student).build();
    }



    public void run(String... strings) throws Exception {
        Student student1 = Student.builder().name("Andrzej").surname("Chmielewski").scoreAverage(4.5).build();
        Student student2 = Student.builder().name("Marysia").surname("Piwowarski").scoreAverage(3.8).build();
        Student student3 = Student.builder().name("Malina").surname("Ziobro").scoreAverage(4.2).build();
        Student student4 = Student.builder().name("Roman").surname("Romanski").scoreAverage(4.1).build();

        studentDao.save(student1);
        studentDao.save(student2);
        studentDao.save(student3);
        studentDao.save(student4);

        Scholarship sp1 = createScholarship("sportowy", 400, student1);
        scholarshipDao.save(sp1);
        Scholarship sp2 = createScholarship("socjalny", 400, student2);
        scholarshipDao.save(sp2);


    }
}

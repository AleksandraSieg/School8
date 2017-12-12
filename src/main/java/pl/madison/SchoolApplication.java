package pl.madison;

import pl.madison.dao.StudentDao;
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

    @Autowired
    private StudentDao studentDao;

    public static void main(String[] args) {
        SpringApplication.run(SchoolApplication.class, args);
    }

    public Student createStudent(String name, String surname, double scoreAverage){
        return Student.builder().name(name).surname(surname).scoreAverage(scoreAverage).build();

    }



    public void run(String... strings) throws Exception {
//        Student student1 = new Student();
//        Student student1 = Student.builder().name("Andrzej").surname("Andzej").scoreAverage(6.0).build();
//
//        Student student2 = new Student();
//        Student student3 = new Student();
//        Student student4 = new Student();
//
//        student1.setName("Andrzej");
//        student2.setName("Marysia");
//        student3.setName("Malina");
//        student4.setName("Roman");
//
//        student1.setSurname("Chmielewski");
//        student2.setSurname("Piwowarski");
//        student3.setSurname("Ziobro");
//        student4.setSurname("Romanski");
//
//        student1.setScoreAverage(4.5);
//        student2.setScoreAverage(3.8);
//        student3.setScoreAverage(4.2);
//        student4.setScoreAverage(4.1);
//
//        studentDao.save(student1);
//        studentDao.save(student2);
//        studentDao.save(student3);
//        studentDao.save(student4);

    }
}

package pl.madison.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import pl.madison.domain.Scholarship;
import pl.madison.domain.Student;
import pl.madison.services.IScholarshipServices;
import pl.madison.services.IStudentServices;

import java.util.Arrays;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(MockitoJUnitRunner.class) //istnieje zaleznosc miedzy injectmocks a mock
public class TestControllerSchool {
    @InjectMocks
    private SchoolController schoolController;

//    @Mock
//    private StudentDao studentDao;

    @Mock
    private IStudentServices iStudentServices;

//    @Mock
//    private ScholarshipDao scholarshipDao;

    @Mock
    private IScholarshipServices iScholarshipServices;

    private MockMvc mockMvc; //mvc = model viewer controler

    @Before
    public void init(){
        mockMvc = MockMvcBuilders.standaloneSetup(schoolController).build();
    } //testcontroller jest jednym z elementow mockowanych przez mvc

    //nie laczymy elelementow mockowanych do testu, kazdy testowany w osonej paczce
    @Test
    public void show() throws Exception {
        List<Student> students = Arrays.asList(Student.builder().name("x").build());

        Mockito.when(iStudentServices.findAll()).thenReturn(students);

        mockMvc.perform(get("/showStudents")).andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("x"));
    }

    @Test
    public void findScholarship() throws Exception {
        List<Scholarship> scholarships = Arrays.asList(Scholarship.builder().type("sportowy").build());

        Mockito.when(iScholarshipServices.findScholarshipByType("sportowy")).thenReturn(scholarships);

        mockMvc.perform(get("/scholarship")).andExpect(status().isOk())
                .andExpect(jsonPath("$[0].type").value("sportowy"));
    }

    @Test
    public void addStudent() throws Exception {
        Student s = Student.builder().name("x").surname("y").scoreAverage(6).build();
        Mockito.when(iStudentServices.save(s)).thenReturn(s);

        mockMvc.perform(MockMvcRequestBuilders.put("/addStudent").param("name", "x")
                .param("surname","y")
                .param("scoreAverage","6"))
                .andExpect(MockMvcResultMatchers.content()
                .string("jupi! You had already added student"));
    }

    @Test
    public void deleteStudent() throws Exception {
        Mockito.when(iStudentServices.findOne(1L)).thenReturn(Student.builder().id(1L).build());

        mockMvc.perform(MockMvcRequestBuilders.delete("/deleteStudent").param("id","1"))
                .andExpect(MockMvcResultMatchers.content().string("You have successfully deleted student"));

    }

    @Test
    public void update() throws Exception {

        Mockito.when(iStudentServices.findOne(1L)).thenReturn(Student.builder().id(1L) // builder jeden ze wzorcoe projektowych,
                // czytamy!! kiedy cos tam zwroc cos tam
                .name("aaa")
                .surname("yyy")
                .scoreAverage(67).build());

        mockMvc.perform(MockMvcRequestBuilders.put("/update").param("id","1")
                .param("name","hhh")
                .param("surname","jjj")
                .param("scoreAverage","89")).andExpect(MockMvcResultMatchers.content()
                .string("You have successfully update student;)"));
    }

    @Test
    public void theHighestScore() throws Exception {
        Student student1 = Student.builder().scoreAverage(6).build();
        Student student2 = Student.builder().scoreAverage(3).build();
        List<Student> students = Arrays.asList(student1, student2);

        Mockito.when(iStudentServices.findAll()).thenReturn(students);

        mockMvc.perform(get("/theHighestScore")).andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(""+"6.0"));
    }

    @Test
    public void theLowestScore() throws Exception {
        Student st1 = Student.builder().scoreAverage(5).build();
        Student st2 = Student.builder().scoreAverage(3).build();

        List<Student> st = Arrays.asList(st1, st2);

        Mockito.when(iStudentServices.findAll()).thenReturn(st);

        mockMvc.perform(get("/theLowestScore")).andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(""+"3.0"));
    }

}
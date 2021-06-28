package htw.berlin.WebtechProjekt.boottest;

import htw.berlin.WebtechProjekt.Models.ToDoListEntity;
import htw.berlin.WebtechProjekt.Repository.ToDoRepository;
import htw.berlin.WebtechProjekt.Services.ToDoListService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDate;
import java.util.List;

import static org.mockito.Mockito.doReturn;

// Von Herr Wider zum testen geklaut
@SpringBootTest
public class ToDoListServiceTest {

    @Autowired
    private ToDoListService systemUnderTest;

    @MockBean
    private ToDoRepository repository;

    @Test
    @DisplayName("Should find ToDo's by owner's email")
    void testFindToDoByOwnerEmail(){
        var td1 = new ToDoListEntity("Hausaufgabe", LocalDate.of(2021, 06, 24), "magdamnich@web.de");
        //td1.setOwner("magdamnich@web.de");
        var td2 = new ToDoListEntity("Abwasch",  LocalDate.of(2021, 06,23), "John@gmail.com");
        doReturn(List.of(td1, td2)).when(repository).findAll();

        List<ToDoListEntity> testToDos = systemUnderTest.findAll("magdamnich@web.de");

        Assertions.assertSame(testToDos.size(), 1, "The number of ToDo's returned was wrong");
        Assertions.assertSame(testToDos.get(0).getTask(), "Hausaufgabe", "The wrong ToDo was returned" );
    }

}

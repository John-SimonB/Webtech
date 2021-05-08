package htw.berlin.WebtechProjekt.Repository;

import htw.berlin.WebtechProjekt.Models.ToDoListEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToDoRepository extends JpaRepository<ToDoListEntity, Integer> {

}

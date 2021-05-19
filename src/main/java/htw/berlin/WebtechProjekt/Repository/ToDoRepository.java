package htw.berlin.WebtechProjekt.Repository;

import htw.berlin.WebtechProjekt.Models.ToDoListEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ToDoRepository extends JpaRepository<ToDoListEntity, Long> {

}
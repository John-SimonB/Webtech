package htw.berlin.WebtechProjekt.Repository;

import htw.berlin.WebtechProjekt.Models.ToDoUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<ToDoUser, Long> {

    @Query("SELECT u FROM ToDoUser u WHERE u.email = ?1")
    ToDoUser findByEmail(String email);
}

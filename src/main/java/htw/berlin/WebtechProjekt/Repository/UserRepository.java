package htw.berlin.WebtechProjekt.Repository;

import htw.berlin.WebtechProjekt.Models.ToDoUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional(readOnly = true)
public interface UserRepository extends JpaRepository<ToDoUser, Long> {
    Optional<ToDoUser> findByEmail(String email);
}

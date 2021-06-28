package htw.berlin.WebtechProjekt;

import static org.assertj.core.api.Assertions.assertThat;
import htw.berlin.WebtechProjekt.Models.ToDoUser;
import htw.berlin.WebtechProjekt.Repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class UserRepositoryTests {

    @Autowired
    private UserRepository repo;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void testCreateUser(){
        ToDoUser user = new ToDoUser();
        user.setFirstName("Magda");
        user.setLastName("Mnich");
        user.setEmail("magdamnich@web.de");
        user.setPassword("password");
        user.isAccountNonExpired();
        user.isAccountNonLocked();
        user.isCredentialsNonExpired();
        user.isEnabled();

       ToDoUser savedUser = repo.save(user);

      ToDoUser existUser = entityManager.find(ToDoUser.class, savedUser.getId());

      assertThat(existUser.getEmail()).isEqualTo(user.getEmail());
    }

    @Test
    public void testFindUserByEmail() {
        String email = "john@gmail.com";

        ToDoUser toDoUser = repo.findByEmail(email);

        assertThat(toDoUser).isNotNull();
    }
}

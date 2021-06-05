package htw.berlin.WebtechProjekt.Services;

import htw.berlin.WebtechProjekt.Models.CustomUserDetails;
import htw.berlin.WebtechProjekt.Models.ToDoUser;
import htw.berlin.WebtechProjekt.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository repo;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        ToDoUser toDoUser = repo.findByEmail(email);
        if (toDoUser == null){
            throw new
                    UsernameNotFoundException("User not found");
        }
        return new CustomUserDetails(toDoUser);
    }
}

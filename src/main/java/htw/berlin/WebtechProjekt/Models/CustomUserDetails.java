package htw.berlin.WebtechProjekt.Models;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class CustomUserDetails implements UserDetails {

    private ToDoUser toDoUser;
    public CustomUserDetails(ToDoUser toDoUser){
        super();
        this.toDoUser = toDoUser;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return toDoUser.getPassword();
    }

    @Override
    public String getUsername() {
        return toDoUser.getEmail();
    }

    public void setToDoUser(ToDoUser toDoUser) {
        this.toDoUser = toDoUser;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public String getFullName() {
        return toDoUser.getFirstName() + " " + toDoUser.getLastName();
    }
}

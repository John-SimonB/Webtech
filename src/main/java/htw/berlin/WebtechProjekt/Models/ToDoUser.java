package htw.berlin.WebtechProjekt.Models;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import javax.persistence.*;
import java.util.Collection;
import java.util.Collections;

@Entity
@Table
public class ToDoUser  {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String firstName;
    @Column
    private String lastName;
    @Column
    private String email;
    @Column
    private String password;
    private boolean isAccountNonExpired;
    private boolean isAccountNonLocked;
    private boolean isCredentialsNonExpired;
    private boolean isEnabled;

    public ToDoUser(String firstName,
                    String lastName,
                    String email,
                    String password,
                    boolean isAccountNonExpired,
                    boolean isAccountNonLocked,
                    boolean isCredentialsNonExpired,
                    boolean isEnabled
    ) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.isAccountNonExpired = isAccountNonExpired;
        this.isAccountNonLocked = isAccountNonLocked;
        this.isCredentialsNonExpired = isCredentialsNonExpired;
        this.isEnabled = isEnabled;
    }

    public ToDoUser() {

    }

    public void setId(Long id) { this.id = id; }

    public void setEmail(String email) { this.email = email; }

    public void setPassword(String password) { this.password = password; }

    public void setFirstName(String firstName) { this.firstName = firstName; }

    public void setLastName(String lastName) { this.lastName = lastName; }

    public Collection<? extends GrantedAuthority> getAuthorities() { return getAuthorities(); }

    public Long getId() { return id; }

    public String getEmail() { return email; }

    public String getPassword() { return password; }

    public String getFirstName() { return firstName; }

    public String getLastName() { return lastName; }

    public boolean isAccountNonExpired() { return isAccountNonExpired; }

    public boolean isAccountNonLocked() { return isAccountNonLocked; }

    public boolean isCredentialsNonExpired() { return isCredentialsNonExpired; }

    public boolean isEnabled() { return isEnabled; }
}

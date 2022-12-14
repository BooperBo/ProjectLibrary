package ru.naumen.ProjectLibrary.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import ru.naumen.ProjectLibrary.models.Person;

import java.util.Collection;
import java.util.Collections;

// класс обёртка над Person
public class PersonDetails implements UserDetails {

    private final Person person;

    @Autowired
    public PersonDetails(Person person) {
        this.person = person;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
//        или список действий
//        сделали на основании ролей
        return Collections.singletonList(new SimpleGrantedAuthority(person.getRole()));
    }

    @Override
    public String getPassword() {
        return this.person.getPassword();
    }

    @Override
    public String getUsername() {
        return this.person.getUsername();
    }

    public int getId() {
        return this.person.getId();
    }

    public int getYearOfBirth() {
        return this.person.getYearOfBirth();
    }

    public String getRole() {
        return this.person.getRole();
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

    // для получения данных аутен. пользователя
    public Person getPerson() {
        return this.person;
    }
}

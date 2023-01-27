package com.sdv.kit.RestSecurityTest.service;

import com.sdv.kit.RestSecurityTest.model.Person;
import com.sdv.kit.RestSecurityTest.model.PersonDetails;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class PersonDetailsService implements UserDetailsService {

    private static final List<Person> STORAGE = List.of(
            new Person("test1", "{noop}roottoor1"),
            new Person("test2", "{noop}roottoor2"),
            new Person("test3", "{noop}roottoor3")
    );

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return STORAGE.stream()
                .filter(person -> person.getLogin().equals(username))
                .findFirst()
                .map(PersonDetails::new)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
}

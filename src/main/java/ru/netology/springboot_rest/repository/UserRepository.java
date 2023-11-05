package ru.netology.springboot_rest.repository;

import org.springframework.stereotype.Repository;
import ru.netology.springboot_rest.service.Authorities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Repository
public class UserRepository {

    public List<Authorities> getUserAuthorities(String user, String password) {
        List<Authorities> autorities = new ArrayList<>();
        if (user.equals("admin") && password.equals("159")) {
            Collections.addAll(autorities, Authorities.READ, Authorities.WRITE, Authorities.DELETE);
        } else if (user.equals("user1") && password.equals("111")) {
            Collections.addAll(autorities, Authorities.READ, Authorities.WRITE);
        }
        return autorities;
    }
}
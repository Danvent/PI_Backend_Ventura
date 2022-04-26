package com.proyect.deparment.service;

import java.util.List;
import java.util.Optional;

import com.proyect.deparment.entity.User;

public interface UserService {
    
    public abstract List<User> listUsers();

    public abstract User miUser(User obj);

    public abstract void deleteUser(int IdUser);

    public abstract Optional<User> findUser(int IdUser);

    public abstract List<User> validateUser(String username, String password);
}

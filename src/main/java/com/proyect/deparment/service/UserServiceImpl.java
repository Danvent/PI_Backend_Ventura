package com.proyect.deparment.service;

import java.util.List;
import java.util.Optional;

import com.proyect.deparment.entity.User;
import com.proyect.deparment.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    
    @Autowired
    private UserRepository repository;

    @Override
    public List<User> listUsers() {
        return repository.findAll();
    }
    @Override
    public Optional<User> findUser(int IdUser) {
        return repository.findById(IdUser);
    }

    @Override
    public User miUser(User obj) {
        return repository.save(obj);
    }

    @Override
    public void deleteUser(int IdUser) {
        repository.deleteById(IdUser);
    }

    @Override
    public List<User> validateUser(String username,String password) {
        return repository.findUserByUsernameAndPassword(username,password);
    }
}

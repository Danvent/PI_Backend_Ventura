package com.proyect.deparment.repository;

import java.util.List;

import javax.transaction.Transactional;

import com.proyect.deparment.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<User,Integer> {
    
    @Query( "select u from User u where u.username = ?1 and u.password =?2")
    List<User> findUserByUsernameAndPassword(String username , String password);
}

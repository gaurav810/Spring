package com.jpa.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jpa.crud.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}

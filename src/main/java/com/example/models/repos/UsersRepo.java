package com.example.models.repos;

import java.util.List;

import com.example.models.entities.users;

import org.springframework.data.repository.CrudRepository;

public interface UsersRepo extends CrudRepository<users, Long> {

    List<users> findByNameContains(String name);
}

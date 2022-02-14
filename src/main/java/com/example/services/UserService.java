package com.example.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import com.example.models.entities.users;
import com.example.models.repos.UsersRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UserService {

    @Autowired
    private UsersRepo usersRepo;

    public users post(users users) {
        return usersRepo.save(users);
    }

    public users put(users users) {
        Optional<users> optionalUsers = usersRepo.findById(users.getId());
        if (optionalUsers.isPresent()) {
            return usersRepo.save(users);
        }
        return null;
    }

    public users findOne(Long id) {
        Optional<users> optionalUsers = usersRepo.findById(id);
        if (!optionalUsers.isPresent()) {
            return null;
        }
        return optionalUsers.get();
    }

    public Iterable<users> findAll() {
        return usersRepo.findAll();
    }

    public void removeOne(Long id) {
        Optional<users> optionalUsers = usersRepo.findById(id);
        if (optionalUsers.isPresent()) {
            usersRepo.delete(optionalUsers.get());
        } else {
            throw new RuntimeException("User not found");
        }
    }

    public List<users> findByName(String name) {
        return usersRepo.findByNameContains(name);
    }
}

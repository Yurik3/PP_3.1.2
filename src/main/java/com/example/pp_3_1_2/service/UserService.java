package com.example.pp_3_1_2.service;

import com.example.pp_3_1_2.models.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    public List<User> findAll();

    public Optional<User> findById(Long id);

    public void delete(User user);

    public void save(User user);
}

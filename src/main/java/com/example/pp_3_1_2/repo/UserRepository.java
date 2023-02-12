package com.example.pp_3_1_2.repo;

import com.example.pp_3_1_2.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Long> {
}

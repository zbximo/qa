package com.example.zuccqa.repository;

/**
 * @author: ximo
 * @date: 2022/3/20 12:10
 * @description:
 */


import com.example.zuccqa.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UserRepository extends MongoRepository<User, Integer> {

    User findById(String userId);
    void deleteById(String userId);
    List<User> findByName(String userName);

}


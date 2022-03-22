package com.example.zuccqa.repository;

import com.example.zuccqa.entity.Model;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author: ximo
 * @date: 2022/3/20 20:07
 * @description:
 */
public interface ModelRepository extends MongoRepository<Model,Integer> {
    Model findByModelName(String name);
}

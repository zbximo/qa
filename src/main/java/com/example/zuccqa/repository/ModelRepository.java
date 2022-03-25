package com.example.zuccqa.repository;

import com.example.zuccqa.entity.Model;
import com.example.zuccqa.entity.Question;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: ximo
 * @date: 2022/3/20 20:07
 * @description:
 */
@Repository
public interface ModelRepository extends MongoRepository<Model, Integer> {
    Model findByModelID(String modelId);
    List<Model> findByModelName(String modelName);
    void deleteByModelID(String modelId);
}

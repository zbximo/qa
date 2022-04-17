package com.example.zuccqa.service;

import com.example.zuccqa.entity.Model;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ModelService {
    String addModel(Model modelMap);

    String deleteModel(String id);

    String updateModel(Model modelMap);

    Model findById(String id);

    List<Model> findByName(String name);

    List<Model> getAll();
}

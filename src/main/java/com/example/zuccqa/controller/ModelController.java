package com.example.zuccqa.controller;

import com.example.zuccqa.entity.Course;
import com.example.zuccqa.entity.Model;
import com.example.zuccqa.entity.Student;
import com.example.zuccqa.repository.ModelRepository;
import com.example.zuccqa.repository.StudentRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author: ximo
 * @date: 2022/3/20 19:46
 * @description:
 */
@RestController
@RequestMapping("/model")
public class ModelController {
    @Autowired
    private ModelRepository modelRepository;
    @PostMapping("/add")
    public List<Model> add(@RequestBody Map<String, String> queryExample) {
        List<Model> list = new LinkedList<>();
        for (Integer count = 0; count < 3; count++) {
            ObjectId id = new ObjectId();
            Model model = new Model();
            model.setModelName("model"+count);
            model.setModelID(id.toString());
            modelRepository.save(model);
            list.add(model);
        }
        return list;
    }
    @PostMapping("/update")
    public Model update(@RequestBody Map<String, String> queryExample) {
        Model model  = modelRepository.findByModelName("model1");
        modelRepository.save(model);
        return model;
    }
    @PostMapping("/remove")
    public Model remove(@RequestBody Map<String, String> queryExample) {
        Model model  = modelRepository.findByModelName("model1");
        modelRepository.delete(model);
        return model;
    }
    @PostMapping("/findByName")
    public Model findByname(@RequestBody Map<String, String> queryExample) {
        Model model  = modelRepository.findByModelName("model1");
        return model;
    }
}

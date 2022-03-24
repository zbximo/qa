package com.example.zuccqa.controller;

import com.example.zuccqa.entity.Course;
import com.example.zuccqa.entity.Model;
import com.example.zuccqa.entity.Question;
import com.example.zuccqa.repository.ModelRepository;
import com.example.zuccqa.result.ExceptionMsg;
import com.example.zuccqa.result.Response;
import com.example.zuccqa.result.ResponseData;
import org.bson.types.ObjectId;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseData addModel(@RequestBody Model modelMap) throws Exception {
        if (modelMap == null) {
            return new ResponseData(ExceptionMsg.FAILED, "");
        }
        ObjectId id = new ObjectId();
        modelMap.setModelID(id.toString());
        Model model = new Model();
        BeanUtils.copyProperties(modelMap, model);
        modelRepository.save(model);
        return new ResponseData(ExceptionMsg.SUCCESS, model);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public Response deleteModel(@PathVariable("id") String id) {
        modelRepository.deleteByModelID(id);
        return new Response(ExceptionMsg.SUCCESS);
    }


    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ResponseData updateModel(@RequestBody Model modelMap) throws Exception {
        modelRepository.save(modelMap);
        return new ResponseData(ExceptionMsg.SUCCESS, modelMap);
    }

    @RequestMapping(value = "/find/{id}", method = RequestMethod.GET)
    public ResponseData findById(@PathVariable("id") String id) {
        Model model = modelRepository.findByModelID(id);
        if (model != null) {
            return new ResponseData(ExceptionMsg.SUCCESS, model);
        }
        return new ResponseData(ExceptionMsg.FAILED, model);
    }

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public ResponseData getAll() {
        List<Model> modelList = modelRepository.findAll();
        return new ResponseData(ExceptionMsg.SUCCESS, modelList);
    }
}

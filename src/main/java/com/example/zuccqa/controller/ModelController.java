package com.example.zuccqa.controller;

import com.example.zuccqa.entity.Course;
import com.example.zuccqa.entity.Model;
import com.example.zuccqa.repository.ModelRepository;
import com.example.zuccqa.result.ExceptionMsg;
import com.example.zuccqa.result.Response;
import com.example.zuccqa.result.ResponseData;
import org.bson.types.ObjectId;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

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

    /**
     * @param modelMap 模板信息
     * @return
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseData addModel(@RequestBody Model modelMap) {
        Model model = new Model();
        BeanUtils.copyProperties(modelMap, model);
        if (model == null) {
            return new ResponseData(ExceptionMsg.FAILED, "");
        }
        ObjectId id = new ObjectId();
        modelMap.setModelID(id.toString());

        modelRepository.save(model);
        return new ResponseData(ExceptionMsg.SUCCESS, model);
    }

    /**
     * @param id 模板ID
     * @return
     */
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public Response deleteModel(@RequestParam("id") String id) {
        modelRepository.deleteByModelID(id);
        return new Response(ExceptionMsg.SUCCESS);
    }


    /**
     * @param modelMap 模板信息
     * @return
     */
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ResponseData updateModel(@RequestBody Model modelMap) {
        if (modelMap.getModelID().equals("") || modelMap.getModelID()==null){
            return new ResponseData("100000","没有模板ID", "");
        }
        modelRepository.save(modelMap);
        return new ResponseData(ExceptionMsg.SUCCESS, modelMap);
    }

    /**
     * @param id 模板ID
     * @return
     */
    @RequestMapping(value = "/find", method = RequestMethod.GET)
    public ResponseData findById(@RequestParam("id") String id) {
        Model model = modelRepository.findByModelID(id);
        if (model != null) {
            return new ResponseData(ExceptionMsg.SUCCESS, model);
        }
        return new ResponseData(ExceptionMsg.QueryEmpty, "");
    }

    /**
     * @param name 模板名称
     * @return
     */
    @RequestMapping(value = "/findByName", method = RequestMethod.GET)
    public ResponseData findByName(@RequestParam("name") String name) {
        List<Model> modelList = modelRepository.findByModelName(name);
        if (modelList.size() > 0) {
            return new ResponseData(ExceptionMsg.SUCCESS, modelList);
        }
        return new ResponseData(ExceptionMsg.QueryEmpty, "");
    }

    /**
     * @return
     */
    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public ResponseData getAll() {
        List<Model> modelList = modelRepository.findAll();
        return new ResponseData(ExceptionMsg.SUCCESS, modelList);
    }
}

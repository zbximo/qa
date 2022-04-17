package com.example.zuccqa.controller;


import com.example.zuccqa.entity.Model;
import com.example.zuccqa.result.ExceptionMsg;
import com.example.zuccqa.result.Response;
import com.example.zuccqa.result.ResponseData;
import com.example.zuccqa.service.ModelService;
import org.slf4j.LoggerFactory;
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
    private final org.slf4j.Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private ModelService modelService;

    /**
     * @param modelMap 模板信息
     * @return
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseData addModel(@RequestBody Model modelMap) {

        String modelId = modelService.addModel(modelMap);
        logger.warn("create model id: {}", modelId);
        return new ResponseData(ExceptionMsg.SUCCESS, modelId);
    }

    /**
     * @param id 模板ID
     * @return
     */
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public Response deleteModel(@RequestParam("id") String id) {
        String modelId = modelService.deleteModel(id);
        logger.warn("delete model id: {}", modelId);

        return new Response(ExceptionMsg.SUCCESS);
    }


    /**
     * @param modelMap 模板信息
     * @return
     */
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ResponseData updateModel(@RequestBody Model modelMap) {
        String modelId = modelService.updateModel(modelMap);
        logger.warn("update model id: {}", modelId);

        return new ResponseData(ExceptionMsg.SUCCESS, modelMap);
    }

    /**
     * 通过模板ID获取模板信息
     *
     * @param id 模板ID
     * @return
     */
    @RequestMapping(value = "/findById", method = RequestMethod.GET)
    public ResponseData viewModelById(@RequestParam("id") String id) {
        Model model = modelService.findById(id);
        logger.warn("query model id: {}", id);

        return new ResponseData(ExceptionMsg.SUCCESS, model);
    }

    /**
     * 通过模板名称获取模板
     *
     * @param name 模板名称
     * @return
     */
    @RequestMapping(value = "/findByName", method = RequestMethod.GET)
    public ResponseData viewModelByName(@RequestParam("name") String name) {
        List<Model> modelList = modelService.findByName(name);
        logger.warn("query model id: {}", name);

        return new ResponseData(ExceptionMsg.SUCCESS, modelList);
    }

    /**
     * @return
     */
    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public ResponseData getAll() {
        List<Model> modelList = modelService.getAll();
        logger.warn("query all models");

        return new ResponseData(ExceptionMsg.SUCCESS, modelList);
    }
}

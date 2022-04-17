package com.example.zuccqa.impl;

import com.example.zuccqa.entity.Model;
import com.example.zuccqa.exception.BusinessException;
import com.example.zuccqa.repository.ModelRepository;

import com.example.zuccqa.service.ModelService;
import com.example.zuccqa.utils.Constant;
import org.bson.types.ObjectId;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @author: ximo
 * @date: 2022/4/17 14:20
 * @description:
 */
@Service
public class ModelServiceImpl implements ModelService {

    @Autowired
    private ModelRepository modelRepository;

    /**
     * @param modelMap 模板信息
     * @return
     */
    public String addModel(Model modelMap) {
        Model model = new Model();
        BeanUtils.copyProperties(modelMap, model);
        if (model.getModelName() == null || model.getModelName().equals("")) {
            throw new BusinessException(Constant.ParamError, "缺少模板名称");
        }
        ObjectId id = new ObjectId();
        modelMap.setModelID(id.toString());

        modelRepository.save(model);
        return model.getModelID();
    }

    /**
     * @param id 模板ID
     * @return
     */
    public String deleteModel(String id) {
        if (id.equals("")) {
            throw new BusinessException(Constant.ParamError, "模板ID不能为空");
        }
        Model model = modelRepository.findByModelID(id);
        if (model == null) {
            throw new BusinessException(Constant.ParamError, "未有找到该模板: 模板ID: " + id);
        }
        modelRepository.deleteByModelID(id);
        return id;
    }


    /**
     * @param modelMap 模板信息
     * @return
     */
    public String updateModel(Model modelMap) {
        if (modelMap.getModelID() == null || modelMap.getModelID().equals("")) {
            throw new BusinessException(Constant.ParamError, "缺少模板ID");
        }
        Model model = modelRepository.findByModelID(modelMap.getModelID());
        if (model == null) {
            throw new BusinessException(Constant.ParamError, "未有找到该模板: 模板ID: " + modelMap.getModelID());
        }
        modelRepository.save(modelMap);
        return modelMap.getModelID();
    }

    /**
     * @param id 模板ID
     * @return
     */
    public Model findById(String id) {
        Model model = modelRepository.findByModelID(id);
        if (model == null) {
            throw new BusinessException(Constant.ParamError, "未找到该模板: 模板ID: " + id);
        }
        return model;
    }

    /**
     * @param name 模板名称
     * @return
     */
    public List<Model> findByName(String name) {
        List<Model> modelList = modelRepository.findByModelName(name);
        if (modelList.size() == 0) {
            throw new BusinessException(Constant.ParamError, "未找到该模板: 模板名: " + name);
        }
        return modelList;
    }

    /**
     * @return
     */
    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public List<Model> getAll() {
        return modelRepository.findAll();
    }
}

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
    @Override
    public String addModel(Model modelMap) {
        Model model = new Model();
        BeanUtils.copyProperties(modelMap, model);
        if (model.getModelName() == null || model.getModelName().equals("")) {
            throw new BusinessException(Constant.PARAM_ERROR, "缺少模板名称");
        }
        checkQuestion(model);
        ObjectId id = new ObjectId();
        model.setModelID(id.toString());

        modelRepository.save(model);
        return model.getModelID();
    }


    /**
     * @param model 需要检查题目的模板
     */
    public void checkQuestion(Model model){
        if (model.getQuestionList() != null) {
            model.getQuestionList().stream().forEach(
                    question -> {
                        if (!Constant.Q_CATEGORY_SINGLE_CHOICE.equals(question.getQuestionType())
                                && !Constant.Q_CATEGORY_MULTI_CHOICE.equals(question.getQuestionType())
                                && !Constant.Q_CATEGORY_SUBJECTIVE.equals(question.getQuestionType())
                        ) {
                            throw new BusinessException(300000,question.getQuestionTitle() + "的类型不支持");
                        }
                        if (Constant.Q_CATEGORY_SINGLE_CHOICE.equals(question.getQuestionType())
                                || Constant.Q_CATEGORY_MULTI_CHOICE.equals(question.getQuestionType())) {
                            if (question.getOptions() == null || question.getOptions().size() == 0) {
                                throw new BusinessException(300000,question.getQuestionTitle() + "的选项不能为空");
                            }
                        }
                    }
            );
        }
    }
    /**
     * @param id 模板ID
     * @return
     */
    @Override
    public String deleteModel(String id) {
        if (id.equals("")) {
            throw new BusinessException(Constant.PARAM_ERROR, "模板ID不能为空");
        }
        Model model = modelRepository.findByModelID(id);
        if (model == null) {
            throw new BusinessException(Constant.PARAM_ERROR, "未有找到该模板: 模板ID: " + id);
        }
        modelRepository.deleteByModelID(id);
        return id;
    }


    /**
     * @param modelMap 模板信息
     * @return
     */
    @Override
    public String updateModel(Model modelMap) {
        Model model = new Model();
        BeanUtils.copyProperties(modelMap, model);
        if (model.getModelID() == null || model.getModelID().equals("")) {
            throw new BusinessException(Constant.PARAM_ERROR, "缺少模板ID");
        }
        Model queryModel = modelRepository.findByModelID(modelMap.getModelID());
        if (queryModel == null) {
            throw new BusinessException(Constant.PARAM_ERROR, "未有找到该模板: 模板ID: " + modelMap.getModelID());
        }
        checkQuestion(model);
        modelRepository.save(model);
        return model.getModelID();
    }

    /**
     * @param id 模板ID
     * @return
     */
    @Override
    public Model findById(String id) {
        Model model = modelRepository.findByModelID(id);
        if (model == null) {
            throw new BusinessException(Constant.PARAM_ERROR, "未找到该模板: 模板ID: " + id);
        }
        return model;
    }

    /**
     * @param name 模板名称
     * @return
     */
    @Override
    public List<Model> findByName(String name) {
        List<Model> modelList = modelRepository.findByModelName(name);
        if (modelList.size() == 0) {
            throw new BusinessException(Constant.PARAM_ERROR, "未找到该模板: 模板名: " + name);
        }
        return modelList;
    }

    /**
     * @return
     */
    @Override
    public List<Model> getAll() {
        return modelRepository.findAll();
    }
}

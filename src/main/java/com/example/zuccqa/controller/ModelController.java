package com.example.zuccqa.controller;

import com.example.zuccqa.entity.Model;
import com.example.zuccqa.entity.Question;
import com.example.zuccqa.repository.ModelRepository;
import com.example.zuccqa.result.ExceptionMsg;
import com.example.zuccqa.result.Response;
import com.example.zuccqa.result.ResponseData;
import org.bson.types.ObjectId;
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
    public ResponseData addModel() throws Exception {
        Model model1 = new Model();
        ObjectId id = new ObjectId();
        model1.setModelID(id.toString());
        Question q = new Question();
        q.setQuestionTitle("今天课程难度怎么样？");
        q.setQuestionType(2);
        List<Question> list = new ArrayList<>();
        list.add(q);
        model1.setQuestionList(list);
        modelRepository.save(model1);
        return new ResponseData(ExceptionMsg.SUCCESS,model1);
    }

    @RequestMapping(value = "/delete{id}", method = RequestMethod.DELETE)
    public Response deleteModel(@PathVariable("id") String id) {
        modelRepository.deleteByModelID(id);
        return new Response(ExceptionMsg.SUCCESS);
    }


    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public String updateModel() throws Exception {
        Model model = new Model();
        model.setModelID("623733f8e95bef13159e578a");
        Question q = new Question();
        q.setQuestionTitle("今天课程难度怎么样？");
        q.setQuestionType(0);
        List<String> l = new ArrayList<>();
        l.add("难");
        l.add("一般");
        l.add("简单");
        q.setOptions(l);
        List<Question> list = new ArrayList<>();
        list.add(q);
        model.setQuestionList(list);
        modelRepository.save(model);
        return "修改成功";
    }

    @RequestMapping(value = "/find{id}", method = RequestMethod.GET)
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

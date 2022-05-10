package com.example.zuccqa.controller;

import com.example.zuccqa.entity.FbES;
import com.example.zuccqa.entity.Feedback;
import com.example.zuccqa.repository.FbESRepository;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.sort.SortBuilders;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: ximo
 * @date: 2022/5/9 21:24
 * @description:
 */
@RestController
@RequestMapping("/fb")

public class FbESController {
    @Autowired
    private FbESRepository fbESRepository;

    @PostMapping("/add")
    public String add(@RequestBody FbES fbES) {
        fbESRepository.save(fbES);
        return "ok";
    }

    @PostMapping("search")
    public String searchByPageAndSort(Integer start, String key) {
        // 分页：
        if (start == null) {
            start = 0;
        }
        int size = 2;//每页文档数

        NativeSearchQueryBuilder nativeSearchQueryBuilderQueryBuilder = new NativeSearchQueryBuilder();
        // nativeSearchQueryBuilderQueryBuilder.withQuery(QueryBuilders.matchQuery("name", key));
        nativeSearchQueryBuilderQueryBuilder.withQuery(QueryBuilders.multiMatchQuery(key, "feedbackTitle","questionList.questionTitle"));
        //nativeSearchQueryBuilderQueryBuilder.withHighlightFields(new HighlightBuilder.Field("name").preTags("<span style='background-color: #FFFF00'>").postTags("</span>"));
         nativeSearchQueryBuilderQueryBuilder.withSort(SortBuilders.fieldSort("id").order(SortOrder.DESC));
//        nativeSearchQueryBuilderQueryBuilder.withPageable(PageRequest.of(start, size));
        Page<FbES> fbESPage = fbESRepository.search(nativeSearchQueryBuilderQueryBuilder.build());
        // 总条数
        for (FbES fbES : fbESPage) {
            System.out.println(fbES);
        }
        System.out.println(fbESPage.getTotalElements());
        System.out.println(fbESPage.getTotalPages());
        System.out.println(fbESPage.getNumberOfElements());
        return "ok";
    }

}

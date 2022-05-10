//package cn.edu.zucc.elastic.controller;
//
//import cn.edu.zucc.elastic.entity.Product;
//import cn.edu.zucc.elastic.repository.ProductRepository;
//import org.elasticsearch.index.query.QueryBuilders;
//import org.elasticsearch.search.sort.SortBuilders;
//import org.elasticsearch.search.sort.SortOrder;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.servlet.ModelAndView;
//
//import java.util.Random;
//
//
///**
// * Copyright (C), 2019-2019, XXX有限公司
// * FileName: TestController
// * Author:   longzhonghua
// * Date:     2019/5/5 13:52
// * Description:
// * History:
// * <author>          <time>          <version>          <desc>
// * 作者姓名           修改时间           版本号              描述
// */
//@RestController
//public class SearchController {
//    @Autowired
//    private ProductRepository productRepository;
//
//    @PostMapping("add")
//    public String add(){
//        for(long i=190;i<200;i++){
//            Product product = new Product(i,"xx","a",1.2,"sss","wode");
//
//            productRepository.save(product);
//            System.out.println(productRepository.findAll());
//        }
//
//        return "1";
//    }
//
//    @PostMapping("search")
//    public ModelAndView searchByPageAndSort(Integer start, String key) {
//        // 分页：
//        if (start == null) {
//            start = 0;
//        }
//        int size = 2;//每页文档数
//
//        // 构建查询条件
//        NativeSearchQueryBuilder nativeSearchQueryBuilderQueryBuilder = new NativeSearchQueryBuilder();
//
//        // nativeSearchQueryBuilderQueryBuilder.withQuery(QueryBuilders.matchQuery("name", key));
//        nativeSearchQueryBuilderQueryBuilder.withQuery(QueryBuilders.multiMatchQuery(key, "name", "body"));
//
//        //nativeSearchQueryBuilderQueryBuilder.withHighlightFields(new HighlightBuilder.Field("name").preTags("<span style='background-color: #FFFF00'>").postTags("</span>"));
//        // 搜索，获取结果
//         nativeSearchQueryBuilderQueryBuilder.withSort(SortBuilders.fieldSort("id").order(SortOrder.DESC));
////        nativeSearchQueryBuilderQueryBuilder.withPageable(PageRequest.of(start, size));
//        Page<Product> products = productRepository.search(nativeSearchQueryBuilderQueryBuilder.build());
//
//        // 总条数
//        for (Product product : products) {
//            System.out.println(product);
//        }
//        System.out.println(products.getTotalElements());
//        System.out.println(products.getTotalPages());
//        System.out.println(products.getNumberOfElements());
//        ModelAndView mav = new ModelAndView("search");
//        mav.addObject("page", products);
//        mav.addObject("keys", key);
//        return mav;
//    }
//
//}

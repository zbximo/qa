package com.example.zuccqa.repository;

import com.example.zuccqa.entity.FbES;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Component;

/**
 * @author: ximo
 * @date: 2022/5/9 21:26
 * @description:
 */
@Component
public interface FbESRepository extends ElasticsearchRepository<FbES,Long> {

}

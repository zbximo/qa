package com.example.zuccqa.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import com.example.zuccqa.entity.ASES;
import org.springframework.stereotype.Component;

/**
 * @author: ximo
 * @date: 2022/5/9 21:27
 * @description:
 */
@Component
public interface ASESRepository extends ElasticsearchRepository<ASES,Integer> {
}

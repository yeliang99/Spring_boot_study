package com.jxw.heihei1.repository;

import com.jxw.heihei1.domian.EsBlog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * EsBlog Repository 接口
 */
public interface EsBlogRepository extends ElasticsearchRepository<EsBlog,String> {
    /**
     * 分页查询博客 （去重）
     *  JPA不用自己写SQL
     * @param title
     * @param content
     * @param summary
     * @return
     */
    Page<EsBlog> findDistinctByTitleContainingOrContentContainingOrSummaryContaining(String title, String content,String summary,Pageable pageable);
}

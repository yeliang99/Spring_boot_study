package com.jxw.heihei1.repository;

import com.jxw.heihei1.domian.EsBlog;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Java6Assertions.assertThat;

/**
 * EsBlog Repository 接口测试
 */
@RunWith(SpringRunner.class)
@SpringBootTest     //引进上下文
public class EsBlogRepositoryTest{

    @Autowired
    private EsBlogRepository esBlogRepository;
    @Before     //在执行test前会执行
    public void  initRepositoryDate(){
        //清除所有数据
        esBlogRepository.deleteAll();

        esBlogRepository.save(new EsBlog("登鹳雀楼","白日依山尽","白日依山尽，黄河入海流。\n" +
                "欲穷千里目，更上一层楼。"));
        esBlogRepository.save(new EsBlog("问刘十九","绿蚁新醅酒","绿蚁新醅酒，红泥小火炉。\n" +
                "晚来天欲雪，能饮一杯无？"));
        esBlogRepository.save(new EsBlog("寻隐者不遇","松下问童子","松下问童子，言师采药去。\n" +
                "只在此山中，云深不知处。"));
    }
    @Test
    public void findDistinctByTitleContainingOrContentContainingOrSummaryContaining(){
        Pageable pageable =new PageRequest(0,20);
        Page<EsBlog> page = esBlogRepository.findDistinctByTitleContainingOrContentContainingOrSummaryContaining("问", "松下", "红泥",pageable);
        assertThat(page.getTotalElements()).isEqualTo(2);
        System.out.println("---------------------------start");
        for (EsBlog blog :page){
            System.out.println(blog.toString());
        }
        System.out.println("---------------------------end");
    }
}

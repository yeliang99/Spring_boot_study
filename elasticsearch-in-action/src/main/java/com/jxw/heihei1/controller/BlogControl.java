package com.jxw.heihei1.controller;

import com.jxw.heihei1.domian.EsBlog;
import com.jxw.heihei1.repository.EsBlogRepository;
import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/blogs")
public class BlogControl {


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
    @GetMapping
    public List<EsBlog> list(@RequestParam(value = "title") String title, @RequestParam(value = "summary") String summary,
                             @RequestParam(value = "content") String content,
                             @RequestParam(value = "pageIndex",defaultValue = "0") int pageIndex,
                             @RequestParam(value = "pageSize",defaultValue = "10") int pageSize){
        //数据在测试用例中
        Pageable pageable =new PageRequest(pageIndex,pageSize);
        Page<EsBlog> page = esBlogRepository.findDistinctByTitleContainingOrContentContainingOrSummaryContaining(title,content,summary,pageable);
        return page.getContent();
    }
}

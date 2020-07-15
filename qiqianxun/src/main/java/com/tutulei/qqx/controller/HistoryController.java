package com.tutulei.qqx.controller;

import com.tutulei.qqx.entity.HistoryEntity;
import com.tutulei.qqx.formbean.History;
import com.tutulei.qqx.repositories.HistoryRepository;
import com.tutulei.qqx.repositories.SearchHistoryRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/history")
public class HistoryController {
    private final HistoryRepository repository;
    //spring会自动依赖注入↓
    HistoryController(HistoryRepository repository){
        this.repository = repository;
    }


    //获取指定用户的穴位检索历史记录
    @GetMapping("/list")
    public List<Integer> getHistoryList(@Param("userId") int userId){
        List<HistoryEntity> l =  repository.findByHistoryUserOrderByHistoryCtimeDesc(userId);
        List<Integer> list = new ArrayList<>();
        for(HistoryEntity historyEntity : l){
            list.add(historyEntity.getHistoryKey());
        }
        return list;
    }
}

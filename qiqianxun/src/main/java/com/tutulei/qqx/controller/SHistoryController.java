package com.tutulei.qqx.controller;

import com.tutulei.qqx.entity.ShistoryEntity;
import com.tutulei.qqx.repositories.SearchHistoryRepository;
import com.tutulei.qqx.view.SHistoryMsg;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;

@RestController
@RequestMapping("/SHistory")
public class SHistoryController {

    private final SearchHistoryRepository repository;
    //spring会自动依赖注入↓
    SHistoryController(SearchHistoryRepository repository){
        this.repository = repository;
    }

    //保存搜索历史记录
    @PostMapping("/save")
    boolean saveSHistory(@RequestBody() SHistoryMsg sHistoryMsg){
        ShistoryEntity s = repository.findByShistoryContentAndShistoryUser(sHistoryMsg.getContent(),sHistoryMsg.getUserId());
        ShistoryEntity shistoryEntity = new ShistoryEntity();
        if(s!=null){
            repository.updateTimeById(new Timestamp(System.currentTimeMillis()),s.getShistoryId());
        }else{
            shistoryEntity.setShistoryContent(sHistoryMsg.getContent());
            shistoryEntity.setShistoryUser(sHistoryMsg.getUserId());
            shistoryEntity.setShistoryCtime(new Timestamp(System.currentTimeMillis()));
            repository.save(shistoryEntity);
        }
        return true;
    }
    //列出历史记录
    @GetMapping("/list")
    List<String> getSHistories(@Param("userId")int userId){
        List<String> list = repository.findContentBySHistoryId(userId);
        return list;
    }

}

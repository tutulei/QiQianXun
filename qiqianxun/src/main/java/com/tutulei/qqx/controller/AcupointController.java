package com.tutulei.qqx.controller;

import com.tutulei.qqx.entity.AcupointEntity;
import com.tutulei.qqx.entity.HistoryEntity;
import com.tutulei.qqx.formbean.Acupoint;
import com.tutulei.qqx.repositories.AcupointRepository;
import com.tutulei.qqx.repositories.HistoryRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@RestController
public class AcupointController {

    private final AcupointRepository repository;
    private final HistoryRepository historyRepository;
    //spring会自动依赖注入↓
    AcupointController(AcupointRepository repository,HistoryRepository historyRepository){
        this.repository = repository;
        this.historyRepository = historyRepository;
    }

    //查询通过name
    @GetMapping("/acupoint/select1")
    public Acupoint Select(@Param("name") String name) {
        name = name.replace("穴", "");
        AcupointEntity acupointEntity = repository.findByAcupointName(name);
        Acupoint acupoint = new Acupoint();
        if(acupointEntity!=null){
            BeanUtils.copyProperties(acupointEntity, acupoint);
            return acupoint;
        }
        return null;
    }
    //获取穴位详情信息通过id(每次更新穴位历史)
    @GetMapping("/acupoint")
    public Acupoint GetAcupointWithId(@Param("id") int id, @Param("userid") int userId){
        AcupointEntity acupointEntity = repository.findByAcupointId(id);
        Acupoint acupoint = new Acupoint();
        if(acupointEntity!=null){
            BeanUtils.copyProperties(acupointEntity, acupoint);
            return acupoint;
        }
        AddHistory(userId,id);
        return null;
    }

    public void AddHistory(int userId, int acupointId){
        HistoryEntity h = historyRepository.findByHistoryKeyAndHistoryUser(acupointId,userId);
        if(h!=null){
            historyRepository.updateTimeById(new Timestamp(System.currentTimeMillis()),h.getHistoryId());
        }else{
            HistoryEntity historyEntity = new HistoryEntity();
            historyEntity.setHistoryKey(acupointId);
            historyEntity.setHistoryUser(userId);
            historyEntity.setHistoryCtime(new Timestamp(System.currentTimeMillis()));
            historyRepository.save(historyEntity);
        }
    }

    //模糊查询通过name
    @GetMapping("/acupoint/likeName")
    public List<Acupoint> ListLikeName(@Param("key") String key){
        key = key.replace("穴","");
        List<AcupointEntity> l = repository.findByAcupointNameLike("%"+key+"%");
        return getAcupoints(l);
    }
    //模糊查询通过症状
    @GetMapping("/acupoint/symptom")
    public List<Acupoint> GetAcupointWithSymptom(@Param("symptom") String symptom){
        List<AcupointEntity> l = repository.fulltextWithSymptom(symptom);
        return getAcupoints(l);
    }
    //模糊查询通过筋络
    @GetMapping("/acupoint/meridian")
    public List<Acupoint> GetAcupointWithMeridian(@Param("meridian") String meridian){
        List<AcupointEntity> l = repository.findByAcupointMeridianLike("%"+meridian+"%");
        return getAcupoints(l);
    }



    //获取穴位名称列表
    @GetMapping("/acupoint/listName")
    @ResponseBody
    public List<String> ListName() {
        List<String> list;
        list = repository.listName();
        return list;
    }


    private List<Acupoint> getAcupoints(List<AcupointEntity> l) {
        List<Acupoint> list = new ArrayList<>();
        for(AcupointEntity a:l){
            Acupoint acupoint = new Acupoint();
            if(a!=null){
                BeanUtils.copyProperties(a, acupoint);
                list.add(acupoint);
            }
        }
        return list;
    }
}

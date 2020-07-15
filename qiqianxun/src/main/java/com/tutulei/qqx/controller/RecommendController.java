package com.tutulei.qqx.controller;

import com.tutulei.qqx.entity.AcupointEntity;
import com.tutulei.qqx.entity.HistoryEntity;
import com.tutulei.qqx.entity.RecommendEntity;
import com.tutulei.qqx.repositories.AcupointRepository;
import com.tutulei.qqx.repositories.HistoryRepository;
import com.tutulei.qqx.repositories.RecommendRepository;
import com.tutulei.qqx.repositories.SearchHistoryRepository;
import com.tutulei.qqx.service.Impl.RecommendServiceImpl;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class RecommendController {

    private final RecommendRepository repository;
    private final RecommendServiceImpl service;
    private final HistoryRepository historyRepository;
    private final AcupointRepository acupointRepository;
    //spring会自动依赖注入↓
    RecommendController(RecommendRepository repository,RecommendServiceImpl service,HistoryRepository historyRepository,AcupointRepository acupointRepository){
        this.repository = repository;
        this.service = service;
        this.historyRepository = historyRepository;
        this.acupointRepository = acupointRepository;
    }


    @GetMapping("/recommend")
    public Map<String,List<AcupointEntity>> getRecommendList(@Param("userId") int userId){
        Map<String,List<AcupointEntity>> result = new HashMap<>();
        List<HistoryEntity> l =  historyRepository.findByHistoryUserOrderByHistoryCtimeDesc(userId);
        List<Integer> list = new ArrayList<>();
        for(HistoryEntity historyEntity : l){
            list.add(historyEntity.getHistoryKey());
        }
        List<AcupointEntity> acupointEntities = acupointRepository.findByAcupointIdIn(list);
        List<String> sentences = new ArrayList<>();
        for(AcupointEntity acupointEntity : acupointEntities){
            sentences.add(acupointEntity.getAcupointFunction());
        }
//        System.out.println(sentences);
        List<String> wordsList = service.getWord(sentences);
        //不大于3个word

        for(String word:wordsList){
            List<AcupointEntity> aList = acupointRepository.fulltextWithSymptom(word);
            if(aList.size()<=2){
                result.put(word,aList);
            }else{
                result.put(word,aList.subList(0,1));
            }
        }
        return result;
    }

}

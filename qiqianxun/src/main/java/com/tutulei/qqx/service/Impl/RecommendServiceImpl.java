package com.tutulei.qqx.service.Impl;

import com.tutulei.qqx.service.RecommendService;
import org.ansj.domain.Result;
import org.ansj.domain.Term;
import org.ansj.splitWord.analysis.ToAnalysis;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service("RecommendService")
public class RecommendServiceImpl implements RecommendService {
    private String[] codes =new String[]{"vn","z","a","x","n","v","ng","ag","g","vg"};

    public List<String> getWord(List<String> sentences){
        List<String> words = new ArrayList<>();
        List<String> natures = new ArrayList<>();
        for(String sentence : sentences){
            Result result = ToAnalysis.parse(sentence); //封装的分词结果对象，包含一个terms列表
//		 System.out.println(result);
            List<Term> terms = result.getTerms();
            for(Term term:terms){
                for(String c : codes){
                    if(c.equals(term.getNatureStr())){
                        words.add(term.getName());
                        natures.add(term.getNatureStr());
                    }
                }
            }
        }
        //词频统计
        Map<String, Long> map = words.stream().collect(Collectors.groupingBy(p -> p,Collectors.counting()));
        //根据value排序
        Map<String,Integer> r = sortMapByValue(map);
        List<String> resultList = new ArrayList<>();
        if(r.size()>3){
            int i = 0;
            for (Map.Entry<String, Integer> entry : r.entrySet()) {
                i++;
                resultList.add(entry.getKey());
                if(i==3) break;
            }
        }else{
            for (Map.Entry<String, Integer> entry : r.entrySet()) {
                resultList.add(entry.getKey());
            }
        }

        return resultList;
    }

    private static Map<String,Integer> sortMapByValue(Map<String, Long> oriMap) {
        if (oriMap == null || oriMap.isEmpty()) {
            return null;
        }
        Map<String, Integer> sortedMap = new LinkedHashMap<>();
        List<Map.Entry<String, Long>> entryList = new ArrayList<>(oriMap.entrySet());
        entryList.sort(Comparator.comparing(Map.Entry::getValue));

        Iterator<Map.Entry<String, Long>> iter = entryList.iterator();
        Map.Entry<String, Long> tmpEntry = null;
        while (iter.hasNext()) {
            tmpEntry = iter.next();
            sortedMap.put(tmpEntry.getKey(), tmpEntry.getValue().intValue());
        }
        return sortedMap;
    }


}

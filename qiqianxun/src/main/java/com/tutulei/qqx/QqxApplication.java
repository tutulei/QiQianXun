package com.tutulei.qqx;

import org.ansj.domain.Result;
import org.ansj.domain.Term;
import org.ansj.splitWord.analysis.ToAnalysis;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class QqxApplication {

    public static void main(String[] args) {
        SpringApplication.run(QqxApplication.class, args);

//        String str = "欢迎使用ansj_seg,(ansj中文分词)在这里如果你遇到什么问题都可以联系我.我一定尽我所能.帮助大家.ansj_seg更快,更准,更自由!" ;
//        Result result = ToAnalysis.parse(str); //封装的分词结果对象，包含一个terms列表
////		 System.out.println(result);
//        List<Term> terms = result.getTerms(); //term列表，元素就是拆分出来的词以及词性
////		 System.out.println(terms);
//        for(Term term:terms){
//            System.out.println(term.getName());		//分词的内容
//            System.out.println(term.getNatureStr());	//分词的词性
//            //值得注意的是当分词词性不在分词表范围内时，返回结果是一个null字符串而非null
//            System.out.println(term.getOffe());		//分词在原文本中的起始位置
//        }

    }

}

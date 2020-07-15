package com.tutulei.qqx.repositories;

import com.tutulei.qqx.entity.RecommendEntity;
import com.tutulei.qqx.formbean.Recommend;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecommendRepository extends JpaRepository<RecommendEntity, Integer> {
    List<RecommendEntity> findByRecommendUser(int userId);
}

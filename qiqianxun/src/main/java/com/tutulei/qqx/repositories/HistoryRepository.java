package com.tutulei.qqx.repositories;

import com.tutulei.qqx.entity.HistoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;

public interface HistoryRepository extends JpaRepository<HistoryEntity, Integer> {
    HistoryEntity findByHistoryKeyAndHistoryUser(int key,int userId);

    @Transactional
    @Modifying
    @Query(value = "update history set history_ctime = :d where history_id = :id",nativeQuery = true)
    void updateTimeById(@Param("d") Timestamp time, @Param("id")int id);


    List<HistoryEntity> findByHistoryUserOrderByHistoryCtimeDesc(int userId);
}

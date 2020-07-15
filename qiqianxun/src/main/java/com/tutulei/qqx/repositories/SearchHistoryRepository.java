package com.tutulei.qqx.repositories;

import com.tutulei.qqx.entity.ShistoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;

public interface SearchHistoryRepository extends JpaRepository<ShistoryEntity, Integer> {

    @Query(value = "select shistory_content from shistory where shistory_user = :userId order by shistory_ctime DESC",nativeQuery = true)
    List<String> findContentBySHistoryId(@Param("userId") int userId);

    ShistoryEntity findByShistoryContentAndShistoryUser(String content,int id);
    @Transactional
    @Modifying
    @Query(value = "update shistory set shistory_ctime = :d where shistory_id = :id",nativeQuery = true)
    void updateTimeById(@Param("d")Timestamp time,@Param("id")int id);
}

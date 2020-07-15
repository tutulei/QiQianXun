package com.tutulei.qqx.repositories;

import com.tutulei.qqx.entity.AcupointEntity;
import com.tutulei.qqx.entity.UserEntity;
import com.tutulei.qqx.formbean.Acupoint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AcupointRepository extends JpaRepository<AcupointEntity, Integer> {
    AcupointEntity findByAcupointName(String name);
    @Query(value = "select acupoint_name from acupoint",nativeQuery=true)
    List<String> listName();
    List<AcupointEntity> findByAcupointNameLike(String key);
    AcupointEntity findByAcupointId(int id);
    List<AcupointEntity> findByAcupointMeridianLike(String meridian);
    List<AcupointEntity> findByAcupointIdIn(List<Integer> ids);
    @Query(value = "select * from acupoint where MATCH acupoint_function AGAINST (:symptom IN NATURAL LANGUAGE MODE)",nativeQuery=true)
    List<AcupointEntity> fulltextWithSymptom(@Param("symptom") String symptom);

}

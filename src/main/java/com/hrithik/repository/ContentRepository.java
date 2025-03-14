package com.hrithik.repository;

import com.hrithik.dataObjects.ContentDO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContentRepository extends JpaRepository<ContentDO,Long> {

    ContentDO findByGuid(String guid);
    List<ContentDO> findBySubjectCd(String subjectCd);
}

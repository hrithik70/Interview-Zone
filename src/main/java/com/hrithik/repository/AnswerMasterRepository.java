package com.hrithik.repository;

import com.hrithik.dataObjects.AnswerMasterDO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswerMasterRepository extends JpaRepository<AnswerMasterDO,Long> {
}

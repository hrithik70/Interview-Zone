package com.hrithik.repository;

import com.hrithik.dataObjects.TopicDO;
import org.springframework.data.repository.CrudRepository;

public interface TopicRepository extends CrudRepository<TopicDO,Long> {
}

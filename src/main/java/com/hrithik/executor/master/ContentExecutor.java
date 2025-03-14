package com.hrithik.executor.master;

import com.hrithik.base.BaseMasterExecutor;
import com.hrithik.base.BaseTransactionIO;
import com.hrithik.dataObjects.ContentDO;
import com.hrithik.interfaceObjects.ContentIO;
import com.hrithik.repository.ContentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContentExecutor extends BaseMasterExecutor {
    private static final Logger LOGGER = LoggerFactory.getLogger(ContentExecutor.class);
    @Autowired
    private ContentRepository contentRepository;
    @Override
    public void persistMainTx(BaseTransactionIO io) {
        io.setBaseMasterDO(contentRepository.save((ContentDO)io.getBaseMasterDO()));
    }
    @Override
    public void coreSystemNum(BaseTransactionIO io) {
    }
    @Override
    public BaseTransactionIO fetchByGuid(String guid) {
        ContentIO io = new ContentIO();
        ContentDO content = contentRepository.findByGuid(guid);
        io.setContent(content);
        return io;
    }
    public List<ContentDO> fetchBySubjectCd(String subjectCd) {
        List<ContentDO> contentList = contentRepository.findBySubjectCd(subjectCd);
        LOGGER.info("*** Found Content-List of SubjectCd : [{}] is [{}] *** " ,subjectCd,contentList.size());
        return contentList;
    }
    public List<String> fetchSubject() {
        List<String> uniqueSubjects = contentRepository
                                                .findAll()
                                                .stream()
                                                .map(ContentDO::getSubjectCd)
                                                .distinct()
                                                .toList();
        LOGGER.info("*** Unique Count : [{}] *** " ,uniqueSubjects.size());
        return uniqueSubjects;
    }
}

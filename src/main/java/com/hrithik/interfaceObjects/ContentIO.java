package com.hrithik.interfaceObjects;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hrithik.base.BaseMasterDO;
import com.hrithik.base.BaseTransactionIO;
import com.hrithik.dataObjects.ContentDO;

public class ContentIO extends BaseTransactionIO {
    private ContentDO content;

    public ContentDO getContent() {
        return content;
    }

    public void setContent(ContentDO content) {
        this.content = content;
    }

    @JsonIgnore
    @Override
    public BaseMasterDO getBaseMasterDO() {
        return getContent();
    }

    @JsonIgnore
    @Override
    public BaseMasterDO setBaseMasterDO(BaseMasterDO baseMasterDO) {
         this.content = (ContentDO) baseMasterDO;
         return content;
    }
}

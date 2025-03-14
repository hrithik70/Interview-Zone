package com.hrithik.dataObjects;

import com.hrithik.base.BaseMasterDO;
import jakarta.persistence.*;

@Entity
@Table(name = "CONTENT")
public class ContentDO extends BaseMasterDO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "contentCd")
    private String contentCd;
    @Column(name = "contentName")
    private String contentName;
    @Column(name = "displayName")
    private String displayName;

    @Column(name = "subjectCd")
    private String subjectCd;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContentCd() {
        return contentCd;
    }

    public void setContentCd(String contentCd) {
        this.contentCd = contentCd;
    }

    public String getContentName() {
        return contentName;
    }

    public void setContentName(String contentName) {
        this.contentName = contentName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getSubjectCd() {
        return subjectCd;
    }

    public void setSubjectCd(String subjectCd) {
        this.subjectCd = subjectCd;
    }

    @Override
    public String getObjectName() {
        return ContentDO.class.getSimpleName();
    }
}

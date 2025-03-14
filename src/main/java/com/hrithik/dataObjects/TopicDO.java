package com.hrithik.dataObjects;

import com.hrithik.base.BaseMasterDO;
import jakarta.persistence.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.List;

@Entity
@Table(name = "TOPIC")
public class TopicDO extends BaseMasterDO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "topicCd")
    private String topicCd;
    @Column(name = "topicName")
    private String topicName;
    @Column(name = "displayName")
    private String displayName;

    @JoinColumn(name = "parentObjectID")
    @OneToMany(orphanRemoval = true,fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @Fetch(FetchMode.SUBSELECT)
    private List<ContentDO> contentList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTopicCd() {
        return topicCd;
    }

    public void setTopicCd(String topicCd) {
        this.topicCd = topicCd;
    }

    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public List<ContentDO> getContentList() {
        return contentList;
    }

    public void setContentList(List<ContentDO> contentList) {
        this.contentList = contentList;
    }

    @Override
    public String getObjectName() {
        return TopicDO.class.getSimpleName();
    }
}

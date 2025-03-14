package com.hrithik.dataObjects;

import com.hrithik.base.BaseMasterDO;
import jakarta.persistence.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.List;

@Entity
@Table(name = "QUESTION_MASTER")
public class QuestionMasterDO extends BaseMasterDO {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "questionCd")
    private String questionCd;
    @Column(name = "questionName")
    private String questionName;
    @Column(name = "displayName")
    private String displayName;

    @Column(name = "contentCd")
    private String contentCd;
    @JoinColumn(name = "parentObjectID")
    @OneToMany(orphanRemoval = true,fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @Fetch(FetchMode.SUBSELECT)
    private List<AnswerMasterDO> answerList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuestionCd() {
        return questionCd;
    }

    public void setQuestionCd(String questionCd) {
        this.questionCd = questionCd;
    }

    public String getQuestionName() {
        return questionName;
    }

    public void setQuestionName(String questionName) {
        this.questionName = questionName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public List<AnswerMasterDO> getAnswerList() {
        return answerList;
    }

    public void setAnswerList(List<AnswerMasterDO> answerList) {
        this.answerList = answerList;
    }

    @Override
    public String getObjectName() {
        return QuestionMasterDO.class.getSimpleName();
    }
}

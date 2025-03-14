package com.hrithik.dataObjects;

import com.hrithik.base.BaseMasterDO;
import jakarta.persistence.*;

@Entity
@Table(name = "ANSWER_MASTER")
public class AnswerMasterDO extends BaseMasterDO {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Lob
    @Column(name = "answer")
    private String answer;
    @Column(name = "languageCd")
    private String languageCd;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getLanguageCd() {
        return languageCd;
    }

    public void setLanguageCd(String languageCd) {
        this.languageCd = languageCd;
    }

    @Override
    public String getObjectName() {
        return AnswerMasterDO.class.getSimpleName();
    }
}

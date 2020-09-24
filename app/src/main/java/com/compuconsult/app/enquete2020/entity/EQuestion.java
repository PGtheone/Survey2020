package com.compuconsult.app.enquete2020.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Objects;

@Entity(tableName = "questionnaire")
public class EQuestion {
    @PrimaryKey(autoGenerate = true)
    private Long id;
    private String question;

    public EQuestion(String question) {
        this.id = id;
        this.question = question;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EQuestion eQuestion = (EQuestion) o;
        return Objects.equals(id, eQuestion.id) &&
                Objects.equals(question, eQuestion.question);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, question);
    }
}

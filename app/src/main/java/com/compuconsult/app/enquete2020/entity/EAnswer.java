package com.compuconsult.app.enquete2020.entity;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import java.util.Objects;

import static androidx.room.ForeignKey.CASCADE;


@Entity(tableName = "person_answer",
        foreignKeys = @ForeignKey(entity = EQuestion.class,
        parentColumns = "id",
        childColumns = "id_question",
        onDelete = CASCADE))
public class EAnswer {
    @PrimaryKey(autoGenerate = true)
    private Long id;

    private Long key;
    private Long id_question;
    private String reponse;

    public EAnswer(Long key, Long id_question, String reponse) {
        this.key = key;
        this.id_question = id_question;
        this.reponse = reponse;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId_question() {
        return id_question;
    }

    public void setId_question(Long id_question) {
        this.id_question = id_question;
    }

    public String getReponse() {
        return reponse;
    }

    public void setReponse(String reponse) {
        this.reponse = reponse;
    }

    public Long getKey() {
        return key;
    }

    public void setKey(Long key) {
        this.key = key;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EAnswer eAnswer = (EAnswer) o;
        return Objects.equals(id, eAnswer.id) &&
                Objects.equals(id_question, eAnswer.id_question) &&
                Objects.equals(reponse, eAnswer.reponse);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, id_question, reponse);
    }
}

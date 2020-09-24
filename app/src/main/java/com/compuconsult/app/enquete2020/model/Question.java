package com.compuconsult.app.enquete2020.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Question implements Parcelable {

    private Long id;
    private String question;
    private boolean multiple_choix;
    private List<Answer> answerList;

    public Question(String question, boolean multiple_choix) {
        this.question = question;
        this.multiple_choix = multiple_choix;
    }


    public Question(Long id, String question, boolean multiple_choix, List<Answer> answerList) {
        this.id = id;
        this.question = question;
        this.multiple_choix = multiple_choix;
        this.answerList = answerList;
    }

    public Question(Long id, String question, boolean multiple_choix) {
        this.id = id;
        this.question = question;
        this.multiple_choix = multiple_choix;
        answerList = new ArrayList<>();
    }

    public boolean isMultiple_choix() {
        return multiple_choix;
    }

    public void setMultiple_choix(boolean multiple_choix) {
        this.multiple_choix = multiple_choix;
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

    public List<Answer> getAnswerList() {
        return answerList;
    }

    public void setAnswerList(List<Answer> answerList) {
        this.answerList = answerList;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(this.id);
        dest.writeString(this.question);
        dest.writeTypedList(this.answerList);
    }

    protected Question(Parcel in) {
        this.id = (Long) in.readValue(Long.class.getClassLoader());
        this.question = in.readString();
        this.answerList = in.createTypedArrayList(Answer.CREATOR);
    }

    public static final Parcelable.Creator<Question> CREATOR = new Parcelable.Creator<Question>() {
        @Override
        public Question createFromParcel(Parcel source) {
            return new Question(source);
        }

        @Override
        public Question[] newArray(int size) {
            return new Question[size];
        }
    };

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Question question1 = (Question) o;
        return multiple_choix == question1.multiple_choix &&
                Objects.equals(id, question1.id) &&
                Objects.equals(question, question1.question) &&
                Objects.equals(answerList, question1.answerList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, question, multiple_choix, answerList);
    }
}

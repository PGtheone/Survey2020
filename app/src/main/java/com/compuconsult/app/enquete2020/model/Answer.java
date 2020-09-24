package com.compuconsult.app.enquete2020.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Objects;

public class Answer implements Parcelable {
    private Long id;
    private String reponse;

    public Answer(Long id, String reponse) {
        this.id = id;
        this.reponse = reponse;
    }

    public Answer(String reponse) {
        this.reponse = reponse;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReponse() {
        return reponse;
    }

    public void setReponse(String reponse) {
        this.reponse = reponse;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(this.id);
        dest.writeString(this.reponse);
    }

    public Answer() {
    }

    protected Answer(Parcel in) {
        this.id = (Long) in.readValue(Long.class.getClassLoader());
        this.reponse = in.readString();
    }

    public static final Parcelable.Creator<Answer> CREATOR = new Parcelable.Creator<Answer>() {
        @Override
        public Answer createFromParcel(Parcel source) {
            return new Answer(source);
        }

        @Override
        public Answer[] newArray(int size) {
            return new Answer[size];
        }
    };

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Answer answer = (Answer) o;
        return Objects.equals(id, answer.id) &&
                Objects.equals(reponse, answer.reponse);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, reponse);
    }
}

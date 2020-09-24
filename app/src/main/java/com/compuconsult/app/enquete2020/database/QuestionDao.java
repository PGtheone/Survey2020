package com.compuconsult.app.enquete2020.database;

import android.database.Cursor;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.compuconsult.app.enquete2020.entity.EQuestion;
import com.compuconsult.app.enquete2020.entity.User;

import java.util.List;

@Dao
public interface QuestionDao {

    @Query("SELECT * FROM questionnaire ORDER BY ID")
    Cursor loadQuestion();

    @Insert
    long insertQuestion(EQuestion eQuestion);

    @Update
    void updateQuestion(EQuestion eQuestion);

    @Delete
    void delete(EQuestion question);

    @Query("SELECT * FROM questionnaire WHERE id = :id")
    EQuestion loadQuestionById(int id);

}

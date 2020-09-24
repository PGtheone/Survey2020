package com.compuconsult.app.enquete2020.database;

import android.database.Cursor;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.compuconsult.app.enquete2020.entity.EAnswer;
import com.compuconsult.app.enquete2020.entity.User;

import java.util.List;

@Dao
public interface AnswerDao {
    @Query("SELECT * FROM person_answer ORDER BY ID")
    Cursor loadAnswer();

    @Insert
    void insertAnswer(EAnswer EAnswer);

    @Update
    void updatEAnswer(EAnswer EAnswer);

    @Delete
    void delete(EAnswer Answer);

    @Query("SELECT * FROM person_answer WHERE id = :id")
    EAnswer loadAnswerById(int id);

    @Query("SELECT * FROM person_answer WHERE id_question = :id")
    List<EAnswer> loadAnswerByIdQuestion(int id);
}

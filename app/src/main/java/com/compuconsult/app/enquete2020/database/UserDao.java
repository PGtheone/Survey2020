package com.compuconsult.app.enquete2020.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.compuconsult.app.enquete2020.entity.User;

import java.util.List;

@Dao
public interface UserDao {

    @Query("SELECT * FROM User ORDER BY ID")
    List<User> loadAlluser();

    @Insert
    void insertUser(User user);

    @Update
    void updateUser(User user);

    @Delete
    void delete(User user);

    @Query("SELECT * FROM User WHERE id = :id")
    User loadUserById(int id);
}

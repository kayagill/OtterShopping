package com.example.ottershopping;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.ottershopping.User;

import java.util.List;

@Dao
public interface OtterDao {
    @Insert
    void insert(User...users);
    @Update
    void update(User...users);
    @Delete
    void delete(User user);
    @Query("SELECT * FROM "+ AppDataBase.USER_TABLE)
    List<User> getUsers();
    @Query("SELECT * FROM " + AppDataBase.USER_TABLE + " WHERE username = :username")
    User getUserByUsername(String username);
}

package com.example.standard;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface PersonDao {


    @Query("SELECT * FROM PERSON ORDER BY ID")
    List<Person> loadAllPersons();  //select * from person

    @Insert  //Insert into table Person values(name="abdul")
    void insertPerson(Person person);
    @Update
    void updatePerson(Person person);
    @Delete
    void delete(Person person);

    @Query("SELECT * FROM PERSON WHERE id = :id")//id = :id is column_name = value
    Person loadPersonById(int id);
}
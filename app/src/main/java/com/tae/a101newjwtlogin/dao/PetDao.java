package com.tae.a101newjwtlogin.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;
import android.provider.ContactsContract;

import java.util.List;

@Dao
public interface PetDao {


        @Insert
        Long insertPet(Pet pet);

        @Insert (onConflict = OnConflictStrategy.REPLACE)
        void updateAllPets(List <Pet> listPet);

        @Query("SELECT * FROM Pet ORDER BY Id desc")
        List<Pet> fetchAllPets();

        @Query("SELECT * FROM Pet WHERE id =:taskId")
        LiveData<Pet> getPet(int taskId);

        @Update
        void updatePet(Pet pet);

        @Delete
        void deletePet(Pet pet);
    }
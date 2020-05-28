package com.example.assingment.db;


import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.assingment.model.Product;

@Database(entities = {Product.class}, version = 1)
public abstract  class ProductDataBase extends RoomDatabase {

    public abstract ProductDao productDao();

}

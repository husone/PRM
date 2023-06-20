package com.example.project2;

import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import java.util.List;

@androidx.room.Dao
public interface Dao {
    // below method is use to add data to database.
    @Insert
    void insert(Product model);
    // below method is use to update the data in our database.
    @Update
    void update(Product model);
    // below line is use to delete a specific course in our database.
    @Delete 
    void delete(Product model);
    // on below line we are making query to delete all coursesfrom our database.
    @Query("DELETE FROM Product")
    void
    deleteAllProducts();
    // below line is to read all the courses from our database.
    // in this we are ordering our courses in ascending order with our course name.
    @Query("SELECT * FROM Product ORDER BY productName ASC")
    List<Product> getAllProducts();
}

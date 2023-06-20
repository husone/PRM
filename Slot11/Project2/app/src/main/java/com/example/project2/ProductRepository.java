package com.example.project2;

import android.app.Application;
import java.util.List;

public class ProductRepository {
    // below line is the create a variable
    // for dao and list for all courses.
    public static Dao dao;
    public ProductRepository(Application application) {
        ProductDatabase database =
                ProductDatabase.getInstance(application);
        dao = database.Dao();
    }
    // creating a method to insert the data to our database.
    public void insert(Product product) {
        dao.insert(product);
    }
    // creating a method to update data in database.
    public void update(Product product) {
        dao.update(product);
    }
    // creating a method to delete the data in our database.
    public void delete(Product product) {
        dao.delete(product);
    }
    // below is the method to delete all the courses.
    public void deleteAll() {
        dao.deleteAllProducts();
    }
    // below method is to read all the courses.
    public List<Product> getAll() {
        return dao.getAllProducts();
    }

}
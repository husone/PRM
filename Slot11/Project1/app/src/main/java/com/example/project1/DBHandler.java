package com.example.project1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;
public class DBHandler extends SQLiteOpenHelper {
    private static final String DB_NAME = "goods.db";
    private static final int DB_VERSION = 2;
    private static final String TABLE_NAME = "myproducts";
    private static final String ID_COL = "id";
    private static final String NAME_COL = "name";
    private static final String DESCRIPTION_COL = "description";
    private static final String PRICE_COL = "price";

    // creating a constructor for our database handler.
    public DBHandler(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }
    // below method is for creating a database by running a sqlite query
    @Override
    public void onCreate(SQLiteDatabase db) {
        // on below line we are creating
        // an sqlite query and we are
        // setting our column names
        // along with their data types.
        String query = "CREATE TABLE " + TABLE_NAME + " ("
                + ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + NAME_COL + " TEXT,"
                + DESCRIPTION_COL + " TEXT, "
                + PRICE_COL + " INTEGER)";
        db.execSQL(query);
    }
    public void addNewProduct(String name, String description, int price) {
        // on below line we are creating a variable for
        // our sqlite database and calling writable method
        // as we are writing data in our database.
        SQLiteDatabase db = this.getWritableDatabase();
        // on below line we are creating a
        // variable for content values.
        ContentValues values = new ContentValues();
        // on below line we are passing all values
        // along with its key and value pair.
        values.put(NAME_COL, name);
        values.put(DESCRIPTION_COL, description);
        values.put(PRICE_COL, price);
        // after adding all values we are passing
        // content values to our table.
        db.insert(TABLE_NAME, null, values);
        // at last we are closing our
        // database after adding database.
        db.close();
    }

    public ArrayList<ProductModal> getAllProducts() {
        // creating a variable for our database.
        SQLiteDatabase db = this.getWritableDatabase();
        // creating a new array list
        ArrayList<ProductModal> productList = new ArrayList<>();
        // creating a variable for our query.
        String query = "SELECT * FROM " + TABLE_NAME;
        // running a select query and getting the cursor
        Cursor cursor = db.rawQuery(query, null);
        // moving our cursor to first position.
        if (cursor.moveToFirst()) {
            do {
                // on below line we are adding the data from cursor to our array list.
                productList.add(new ProductModal(cursor.getString(1), cursor.getString(2), cursor.getInt(3)));
                // moving our cursor to next.
            } while (cursor.moveToNext());
            // at last closing our cursor
            // and returning our array list.
            cursor.close();
            return productList;
        } else {
            return null;
        }

    }
    // below is the method for updating our courses
    public void updateProduct(String originalProductName, String productName, String productDescription,  Integer productPrice) {
        // calling a method to get writable database.
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        // on below line we are passing all values
        // along with its key and value pair.
        values.put(NAME_COL, productName);
        values.put(DESCRIPTION_COL, productDescription);
        values.put(PRICE_COL, productPrice);
        // on below line we are calling a update method to update our database and passing our values.
        // and we are comparing it with name of our course which is stored in original name variable.
        db.update(TABLE_NAME, values, "name=?", new
                String[]{originalProductName});
        db.close();
    }
    // below is the method for deleting our course.
    public void deleteProduct(String productName) {
        // on below line we are creating
        // a variable to write our database.
        SQLiteDatabase db = this.getWritableDatabase();
        // on below line we are calling a method to delete our
        // course and we are comparing it with our course name.
        db.delete(TABLE_NAME, "name=?", new
                String[]{productName});
        db.close();
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int
            newVersion) {
        // this method is called to check if the table exists already.
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}
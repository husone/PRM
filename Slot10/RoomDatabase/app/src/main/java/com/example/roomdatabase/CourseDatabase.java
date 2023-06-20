package com.example.roomdatabase;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

// adding annotation for our database entities and db version.
@Database(entities = {Course.class}, version = 1)
public abstract class CourseDatabase extends RoomDatabase {
    // below line is to create instance for our database class.
    private static CourseDatabase instance;

    public abstract Dao Dao();

    // on below line we are getting instance for our database.
    public static synchronized CourseDatabase getInstance(Context context) {
        if (instance == null) {
            // if the instance is null we are creating a new
            instance = Room.databaseBuilder(context.getApplicationContext(),
                            CourseDatabase.class,
                            "course_database").fallbackToDestructiveMigration()
                    .addCallback(roomCallback)
                    .allowMainThreadQueries()
                    .build();
        }
        return instance;
    }

    private static RoomDatabase.Callback roomCallback = new
            RoomDatabase.Callback() {
                @Override
                public void onCreate(@NonNull SupportSQLiteDatabase db) {
                    super.onCreate(db);
                    // this method is called when database is created
                    // and below line is to populate our data.
                    new PopulateDbAsyncTask(instance).execute();
                }
            };

    private static class PopulateDbAsyncTask extends
            AsyncTask<Void, Void, Void> {
        PopulateDbAsyncTask(CourseDatabase instance) {
            Dao dao = instance.Dao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            return null;
        }
    }

}



package android.eservices.webrequests.data.db;

import android.eservices.webrequests.data.api.model.Book;
import android.eservices.webrequests.data.api.model.BookDao;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;

@Database(entities = {Book.class}, version = 1)
public abstract  class BookDatabase extends RoomDatabase {
    public abstract BookDao bookDao();
}

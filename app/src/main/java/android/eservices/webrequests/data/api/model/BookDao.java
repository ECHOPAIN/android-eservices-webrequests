package android.eservices.webrequests.data.api.model;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import io.reactivex.Completable;

@Dao
public interface BookDao {
    @Query("SELECT * FROM bookEntity")
    List<BookEntity> getAll();

    @Query("SELECT * FROM bookEntity WHERE id IN (:bookIds)")
    List<BookEntity> loadAllByIds(int[] bookIds);

    @Insert
    Completable insertAll(BookEntity... books);

    @Delete
    Completable delete(BookEntity book);
}

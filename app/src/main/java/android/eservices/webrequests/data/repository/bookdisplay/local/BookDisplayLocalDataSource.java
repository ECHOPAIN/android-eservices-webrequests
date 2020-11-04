package android.eservices.webrequests.data.repository.bookdisplay.local;

import android.eservices.webrequests.data.api.model.Book;
import android.eservices.webrequests.data.api.model.BookDao;
import android.eservices.webrequests.data.api.model.BookEntity;
import android.eservices.webrequests.data.db.BookDatabase;

import java.util.List;

import io.reactivex.Completable;

public class BookDisplayLocalDataSource {

    private BookDatabase bookDatabase;
    public BookDisplayLocalDataSource(BookDatabase bookDatabase) {
        this.bookDatabase = bookDatabase;
    }


    public List<BookEntity> getAllFavorite(){
        //lui communique avec dao
        BookDao bookDao = bookDatabase.bookDao();
        return bookDao.getAll();
    }
    //supprimer du bdd
    public Completable deleteFavorite(BookEntity book){
        //lui communique avec dao
        BookDao bookDao = bookDatabase.bookDao();
        return bookDao.delete(book);
    }

    //ajouter
    public Completable addFavorite(BookEntity book){
        //lui communique avec dao
        BookDao bookDao = bookDatabase.bookDao();
        return bookDao.insertAll(book);
    }
}

package android.eservices.webrequests.data.repository.bookdisplay.local;

import android.eservices.webrequests.data.db.BookDatabase;

public class BookDisplayLocalDataSource {

    private BookDatabase bookDatabase;
    public BookDisplayLocalDataSource(BookDatabase bookDatabase) {
        this.bookDatabase = bookDatabase;
    }
}

package android.eservices.webrequests.data.repository.bookdisplay;

import android.eservices.webrequests.data.api.model.Book;
import android.eservices.webrequests.data.api.model.BookSearchResponse;
import android.eservices.webrequests.data.repository.bookdisplay.local.BookDisplayLocalDataSource;
import android.eservices.webrequests.data.repository.bookdisplay.mapper.BookToBookEntityMapper;
import android.eservices.webrequests.data.repository.bookdisplay.remote.BookDisplayRemoteDataSource;

import java.util.List;

import io.reactivex.Single;
import retrofit2.Call;
import retrofit2.http.Path;

public class BookDisplayDataRepository{

    private BookDisplayLocalDataSource bookDisplayLocalDataSource;
    private BookDisplayRemoteDataSource bookDisplayRemoteDataSource;
    private BookToBookEntityMapper bookToBookEntityMapper;

    public BookDisplayDataRepository(BookDisplayLocalDataSource bookDisplayLocalDataSource, BookDisplayRemoteDataSource bookDisplayRemoteDataSource, BookToBookEntityMapper bookToBookEntityMapper) {
        this.bookDisplayLocalDataSource = bookDisplayLocalDataSource;
        this.bookDisplayRemoteDataSource = bookDisplayRemoteDataSource;
        this.bookToBookEntityMapper = bookToBookEntityMapper;
    }

    public Single<BookSearchResponse> searchBooks(@Path("search-terms") String searchTerms){
        return bookDisplayRemoteDataSource.searchBooks(searchTerms);
    }
}

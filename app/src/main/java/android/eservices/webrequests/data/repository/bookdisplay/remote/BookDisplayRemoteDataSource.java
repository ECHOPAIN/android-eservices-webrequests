package android.eservices.webrequests.data.repository.bookdisplay.remote;

import android.eservices.webrequests.data.api.BookDisplayService;
import android.eservices.webrequests.data.api.model.Book;
import android.eservices.webrequests.data.api.model.BookSearchResponse;

import java.util.List;

import io.reactivex.Single;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.http.Path;

public class BookDisplayRemoteDataSource {
    private BookDisplayService bookDisplayService;
    public BookDisplayRemoteDataSource(BookDisplayService bookDisplayService) {
        this.bookDisplayService = bookDisplayService;
    }

    public Single<BookSearchResponse> searchBooks(@Path("search-terms") String searchTerms){
        return bookDisplayService.searchBooks(searchTerms);
    }

    public Single<Book> getBookDetails(@Path("search-terms") String searchTerms){
        return bookDisplayService.getBook(searchTerms);
    }
}

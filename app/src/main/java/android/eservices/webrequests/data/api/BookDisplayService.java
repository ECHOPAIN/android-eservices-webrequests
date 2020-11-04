package android.eservices.webrequests.data.api;

import android.app.Application;
import android.eservices.webrequests.BookApplication;
import android.eservices.webrequests.data.api.model.Book;
import android.eservices.webrequests.data.api.model.BookSearchResponse;

import java.util.List;

import io.reactivex.Single;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface BookDisplayService {
    @GET("https://www.googleapis.com/books/v1/volumes?key="+ BookApplication.API_KEY)
    Single<BookSearchResponse> searchBooks(@Query("q") String searchTerms);

    @GET("https://www.googleapis.com/books/v1/volume/{bookId}?key="+ BookApplication.API_KEY)
    Single<Book> getBook(@Path("bookId") String bookId);
}

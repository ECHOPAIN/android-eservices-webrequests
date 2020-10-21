package android.eservices.webrequests.data.api;

import android.eservices.webrequests.data.api.model.Book;
import android.eservices.webrequests.data.api.model.BookSearchResponse;

import java.util.List;

import io.reactivex.Single;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface BookDisplayService {
    @GET("https://www.googleapis.com/books/v1/volumes?q={search-terms}&key=AIzaSyDd5JRbMCES04pFjIKqu4s21EjN9Qop_OE")
    Single<BookSearchResponse> searchBooks(@Path("search-terms") String searchTerms);
}

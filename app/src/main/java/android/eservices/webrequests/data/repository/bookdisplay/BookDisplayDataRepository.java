package android.eservices.webrequests.data.repository.bookdisplay;

import android.eservices.webrequests.data.api.model.Book;
import android.eservices.webrequests.data.api.model.BookEntity;
import android.eservices.webrequests.data.api.model.BookSearchResponse;
import android.eservices.webrequests.data.repository.bookdisplay.local.BookDisplayLocalDataSource;
import android.eservices.webrequests.data.repository.bookdisplay.mapper.BookToBookEntityMapper;
import android.eservices.webrequests.data.repository.bookdisplay.remote.BookDisplayRemoteDataSource;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.CompletableSource;
import io.reactivex.Single;
import io.reactivex.functions.Function;
import retrofit2.Call;
import retrofit2.http.Path;



//aiguilleur des donées, il connait le remote et le local
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




    //en local

    //recuperer les favoris
    public List<BookEntity> getAllFavorite(){
        return bookDisplayLocalDataSource.getAllFavorite();
    }
    //supprimer du bdd
    public Completable deleteFavorite(String bookId){Single<Book> book = bookDisplayRemoteDataSource.getBookDetails(bookId);
        Single<BookEntity> book2 = book.map(new Function<Book, BookEntity>() {
            @Override
            public BookEntity apply(Book book) throws Exception {
                BookEntity bookEntity = new BookEntity();
                bookEntity.setId(book.getId());
                bookEntity.setTitle(book.getVolumeInfo().getTitle());
                //bookEntity.setAuthors(book.getVolumeInfo().getAuthorList());
                bookEntity.setDescription(book.getVolumeInfo().getDescription());
                bookEntity.setLanguage(book.getVolumeInfo().getLanguage());
                bookEntity.setThumbUrl(book.getVolumeInfo().getImageLinks().getThumbnail());
                return bookEntity;
            }
        });
        return book2.flatMapCompletable(new Function<BookEntity, CompletableSource>() {
            @Override
            public CompletableSource apply(BookEntity bookEntity) throws Exception {
                return bookDisplayLocalDataSource.deleteFavorite(bookEntity);
            }
        });
    }

    //ajouter
    public Completable addFavorite(String bookId){
        Single<Book> book = bookDisplayRemoteDataSource.getBookDetails(bookId);
        Single<BookEntity> book2 = book.map(new Function<Book, BookEntity>() {
            @Override
            public BookEntity apply(Book book) throws Exception {
                BookEntity bookEntity = new BookEntity();
                bookEntity.setId(book.getId());
                bookEntity.setTitle(book.getVolumeInfo().getTitle());
                //bookEntity.setAuthors((String[])book.getVolumeInfo().getAuthorList().toArray());
                bookEntity.setDescription(book.getVolumeInfo().getDescription());
                bookEntity.setLanguage(book.getVolumeInfo().getLanguage());
                bookEntity.setThumbUrl(book.getVolumeInfo().getImageLinks().getThumbnail());
                return bookEntity;
            }
        });
        return book2.flatMapCompletable(new Function<BookEntity, CompletableSource>() {
            @Override
            public CompletableSource apply(BookEntity bookEntity) throws Exception {
                return bookDisplayLocalDataSource.addFavorite(bookEntity);
            }
        });
    }

}

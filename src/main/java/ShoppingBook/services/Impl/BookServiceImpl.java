package ShoppingBook.services.Impl;


import ShoppingBook.domain.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ShoppingBook.repository.BookRepository;
import ShoppingBook.services.BookService;

/**
 * Created by AbelN on 08/05/2016.
 */
@Service
public class BookServiceImpl implements BookService {



    //
    @Autowired
    BookRepository repo;
    private static BookServiceImpl service = null;




    public boolean duplicateCheck(String title) {
        Iterable<Book> books;
        books =   repo.findAll();

        for (Book book : books)
        {
            if (book.getTitle().trim().equalsIgnoreCase(title))
                return true;

        }
        return false;
    }





}

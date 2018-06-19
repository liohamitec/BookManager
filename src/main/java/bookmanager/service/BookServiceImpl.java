package bookmanager.service;

import bookmanager.dao.BookDao;
import bookmanager.model.Book;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private BookDao bookDao;

    public void setBookDao(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    @Override
    @Transactional
    public void addBook(Book book) {
        bookDao.addBook(book);
    }

    @Override
    @Transactional
    public void updateBook(Book book) {
        bookDao.updateBook(book);
    }

    @Override
    @Transactional
    public void removeBook(int id) {
        bookDao.removeBook(id);
    }

    @Override
    @Transactional
    public Book getBookById(int id) {
        return bookDao.getBookById(id);
    }

    @Override
    @Transactional
    public List<Book> getAllBooks() {
        return bookDao.getAllBooks();
    }
}

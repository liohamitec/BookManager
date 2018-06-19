package bookmanager.dao;

import bookmanager.model.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookDaoImpl implements BookDao {
    private static final Logger logger = LoggerFactory.getLogger(BookDaoImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addBook(Book book) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(book);
        logger.info("Book was successfully saved. Details: " + book);
    }

    @Override
    public void updateBook(Book book) {
        Session session = sessionFactory.getCurrentSession();
        session.update(book);
        logger.info("Book was successfully updated. Details: " + book);
    }

    @Override
    public void removeBook(int id) {
        Session session = sessionFactory.getCurrentSession();
        Book book = (Book) session.load(Book.class,id);

        if (book != null) {
            session.delete(book);
            logger.info("Book was successfully deleted! Details: " + book);
        } else {
            logger.error("There is no book with such id in the database!");
        }
    }

    @Override
    public Book getBookById(int id) {
        Session session = sessionFactory.getCurrentSession();
        Book book = (Book) session.load(Book.class,id);

        if (book != null) {
            logger.info("Book is successfully loaded! Details: " + book);
        } else {
            logger.error("There is no book with such id in the database!");
        }

        return book;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Book> getAllBooks() {
        Session session = sessionFactory.getCurrentSession();
        List<Book> bookList = session.createQuery("from Book").list();

        logger.info("List of books is loaded!");
        return bookList;
    }
}

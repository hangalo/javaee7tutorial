/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaeetutorial.duksbookstore.ejb;

import java.util.List;
import java.util.logging.Level;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.logging.Logger;
import javaeetutorial.duksbookstore.entity.Book;
import javaeetutorial.duksbookstore.exception.BookNotFoundException;
import javaeetutorial.duksbookstore.exception.BooksNotFoundException;
import javax.ejb.EJBException;

/**
 *
 * @author desenvolvimento
 */
@Stateful
public class BookRequestBean {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @PersistenceContext
    private EntityManager em;
    private static final Logger looger = Logger.getLogger("javaeetutorial.duksbookstore.ejb.BookRequestBean");

    public BookRequestBean() throws Exception {
    }

    public void createBook(String bookId, String surname, String firstname, String title, Double price, Boolean onsale, Integer calendarYear, String description, Integer inventory) {

        try {
            Book book = new Book(bookId, surname, firstname, title, price, onsale, calendarYear, description, inventory);
            looger.log(Level.INFO, "Created book {0}", bookId);
            em.persist(book);
            looger.log(Level.INFO, "Created book {0}", bookId);
        } catch (Exception ex) {
            throw new EJBException(ex.getMessage());
        }
    }

    public List<Book> getBooks() throws BooksNotFoundException {
        try {

            return (List<Book>) em.createNamedQuery("findBooks").getResultList();
        } catch (Exception ex) {
            throw new BooksNotFoundException("Could not get books: "+ ex.getMessage());
        }
    }
    
    
    public Book getBook(String bookId) throws BookNotFoundException{
    
    Book requestedBook = em.find(Book.class, bookId);
    if(requestedBook == null){
    
    throw new BookNotFoundException("Couldn't find book: " +bookId);
    }
    return requestedBook;
    }

}

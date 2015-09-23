package edu.starterkit.dao.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.enterprise.event.Event;
import javax.enterprise.inject.Any;
import javax.inject.Inject;

import edu.starterkit.aop.NullableId;
import edu.starterkit.common.Sequence;
import edu.starterkit.dao.BookDao;
import edu.starterkit.to.BookTo;

@DaoHibernateImpl
public class BookDaoHibernateImpl implements BookDao {
	
	private final Set<BookTo> ALL_BOOKS = new HashSet<>();

	@Inject
    private Sequence sequence;
    
    @Inject @Any
    private Event<BookTo> bookEvent;
    
    @Override
    public List<BookTo> findAll() {
//    	System.out.println("findAll");
        return new ArrayList<>(ALL_BOOKS);
    }

    @Override
    public List<BookTo> findBookByTitle(String title) {
        return null;
    }

    @Override
    public List<BookTo> findBooksByAuthor(String author) {
        return null;
    }

    @Override
    @NullableId
    public BookTo save(BookTo book) {
        if (book.getId() == null) {
            book.setId(sequence.nextValue(ALL_BOOKS));
        }
        ALL_BOOKS.add(book);
        bookEvent.fire(book);
        return book;
    }

    public void setSequence(Sequence sequence) {
        this.sequence = sequence;
    }

    @PostConstruct
    private void addTestBooks() {
        ALL_BOOKS.add(new BookTo(1L, "Romeo i Julia", "Wiliam Szekspir"));
        ALL_BOOKS.add(new BookTo(2L, "Opium w rosole", "Hanna Ożogowska"));
        ALL_BOOKS.add(new BookTo(3L, "Przygody Odyseusza", "Jan Parandowski"));
        ALL_BOOKS.add(new BookTo(4L, "Awantura w Niekłaju", "Edmund Niziurski"));
        ALL_BOOKS.add(new BookTo(5L, "Pan Samochodzik i Fantomas", "Zbigniew Nienacki"));
        ALL_BOOKS.add(new BookTo(6L, "Zemsta", "Aleksander Fredro"));
    }

}

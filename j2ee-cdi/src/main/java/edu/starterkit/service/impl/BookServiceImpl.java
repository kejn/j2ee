package edu.starterkit.service.impl;

import java.util.List;

import javax.inject.Inject;

import edu.starterkit.dao.BookDao;
import edu.starterkit.dao.impl.DaoHibernateImpl;
import edu.starterkit.logger.LogDetails;
import edu.starterkit.service.BookService;
import edu.starterkit.to.BookTo;

public class BookServiceImpl implements BookService {

	@Inject @DaoHibernateImpl
	private BookDao bookDao;

	@LogDetails
	@Override
	public List<BookTo> findAllBooks() {
		return bookDao.findAll();
	}

	@LogDetails
	@Override
	public List<BookTo> findBooksByTitle(String title) {
		return bookDao.findBookByTitle(title);
	}

	@LogDetails
	@Override
	public List<BookTo> findBooksByAuthor(String author) {
		return bookDao.findBooksByAuthor(author);
	}

	@LogDetails
	@Override
	public BookTo saveBook(BookTo book) {
		return bookDao.save(book);
	}

	@LogDetails
	public void setBookDao(BookDao bookDao) {
		this.bookDao = bookDao;
	}
}

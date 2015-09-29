package edu.starterkit.web.rest;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.jglue.cdiunit.CdiRunner;
import org.json.JSONArray;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import edu.starterkit.service.BookService;
import edu.starterkit.to.BookTo;

@RunWith(CdiRunner.class)
public class BookRestServiceTest {
	
	@Mock
	private BookService bookService;
	
	@InjectMocks
	private BookRestService bookRestService;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testShouldFindAllBooks() {
		// given
		final BookTo book1 = new BookTo(1L, "Pierwsza ksi¹¿ka", "Jan Kowalski");
		final BookTo book2 = new BookTo(2L, "Druga ksi¹¿ka", "Adam Nowak");
		final List<BookTo> mockList = Arrays.asList(book1,book2);
		final JSONArray expected = new JSONArray(mockList);
		// when
		Mockito.doReturn(mockList).when(bookService).findAllBooks();
		final String responseString = bookRestService.findAllBooks().getEntity().toString();
		// then
		Mockito.verify(bookService).findAllBooks();
		assertEquals(expected.toString(), responseString);
	}

}

package edu.starterkit.observer;

import javax.enterprise.event.Observes;

import edu.starterkit.to.BookTo;

public class BooksObserver {
	
	public void afterBookSaved(@Observes BookTo book) {
		System.out.println("Book " + book.toString() + " was saved.");
	}
}

package com.customlists;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class TestCustomList {
	
	@Test
	public void testAdd() {
		
		CustomList<Book> actual = new CustomList<Book>();
		
		actual.add(new Book(2432, "DLD", "Moris"));
		assertTrue(actual.size()==1 && actual.get(0).equals(new Book(2432, "DLD", "Moris")));
		
		actual.add(new Book(4535, "LetC", "Balaguru"));
		assertTrue(actual.size()==2 && actual.get(1).equals(new Book(4535, "LetC", "Balaguru")));
		
		actual.add(new Book(4536, "Geometry", "Uclid"));
		assertTrue(actual.size()==3 && actual.get(2).equals(new Book(4536, "Geometry", "Uclid")));
		
	}
	
	@Test
	public void testGet() {
		CustomList<Book> actual = getPreloadedBookList();

		assertEquals(new Book(4536, "Geometry", "Uclid"), actual.get(2));
		assertEquals(new Book(4535, "LetC", "Balaguru"), actual.get(1));
		assertEquals(new Book(2432, "DLD", "Moris"), actual.get(0));
	}

	
	@Test
	public void testAddAt() {
		CustomList<Book> actual = getPreloadedBookList();
		
		actual.addAt(1, new Book(2342, "Chemistry", "Kabir"));
		assertEquals(new Book(2342, "Chemistry", "Kabir"), actual.get(1));
		
		actual.addAt(3, new Book(4535, "Physics", "Shahajan"));
		assertEquals(new Book(4535, "Physics", "Shahajan"), actual.get(3));
	}
	
	@Test
	public void testAddAll() {

		CustomList<Book> actual = new CustomList<Book>();
		actual.add( new Book(2342, "Chemistry", "Kabir") );
		actual.add( new Book(4535, "Physics", "Shahajan") );
		
		CustomList<Book> expected = getPreloadedBookList();
		expected.addAt(0, new Book(2342, "Chemistry", "Kabir") );
		expected.addAt(1, new Book(4535, "Physics", "Shahajan") );
		
		
		assertEquals(expected, actual.addAll(getPreloadedBookList()));
	}
	
	@Test
	public void testRemoveAt() {
		CustomList<Book> actual = getPreloadedBookList();
		
		Book book = actual.get(2);
		assertTrue(actual.removeAt(2) && actual.find(book) == -1);
		
		book = actual.get(1);
		assertTrue(actual.removeAt(1) && !actual.get(1).equals(book) );
	}
	
	@Test
	public void testRemove() {
		CustomList<Book> actual = getPreloadedBookList();
		
		Book book2 = new Book(4535, "LetC", "Balaguru");
		
		actual.remove(book2);
		assertEquals(-1, actual.find(book2));
		
	}
	
	@Test
	public void testRemoveAll() {
		
		CustomList<Book> removeList = new CustomList<Book>();
		removeList.add(new Book(4536, "Geometry", "Uclid"));
		removeList.add(new Book(2432, "DLD", "Moris"));
		
		CustomList<Book> actual = getPreloadedBookList();
		
		CustomList<Book> expected = getPreloadedBookList();
		expected.remove(new Book(4536, "Geometry", "Uclid"));
		expected.remove(new Book(2432, "DLD", "Moris"));

		assertEquals(expected, actual.removeAll(removeList));
	}
	
	@Test
	public void testReplace() {
		CustomList<Book> actual = getPreloadedBookList();
		Book toBeReplaced = new Book(4535, "LetC", "Balaguru");
		Book replaceWith = new Book(2342, "Chemistry", "Kabir");
		
		int position = actual.find(toBeReplaced);
		actual.replace(toBeReplaced, replaceWith);
		assertEquals(replaceWith, actual.get(position));

	}
	
	@Test
	public void testContains() {
		CustomList<Book> actual = getPreloadedBookList();
		
		Book book1 = new Book(2432, "DLD", "Moris");
		Book book2 = new Book(4345, "LetC", "Balaguru");
		
		assertTrue(actual.contains(book1));
		assertFalse(actual.contains(book2));
		
	}
	/*
	@Test
	public void testToArray() {
		CustomList<Book> customList = getPreloadedBookList();
		
		Book[] bookArray = (Book[]) customList.toArray();
		System.out.println(bookArray[1]);
		for(int i=0; i<customList.size(); i++) {
			assertEquals(customList.get(i), bookArray[i]);
		}
		
	}
	*/
	
	public CustomList<Book> getPreloadedBookList() {
		CustomList<Book> list = new CustomList<Book>();
		Book book1 = new Book(2432, "DLD", "Moris");
		Book book2 = new Book(4535, "LetC", "Balaguru");
		Book book3 = new Book(4536, "Geometry", "Uclid");
		Book book4 = new Book(4346, "Tukunjil", "Zafar");
		
		list.add(book1);
		list.add(book2);
		list.add(book3);
		list.add(book4);
		
		return list;
		
	}
	
	
	public void display(CustomList<Book> cs) {
		for(int i=0; i<cs.size();i++)
		{
			System.out.println(cs.get(i).getName());
		}
		System.out.println("\n\n");
	}
	

}

package com.customlists;

public class Book{
	
	

	private int isbn;
	private String name;
	private String writer;
	
	Book(){
		this.isbn = 0;
		this.name = "";
		this.writer = "";
	}
	Book(int isbn, String name, String writer){
		this.isbn = isbn;
		this.name = name;
		this.writer = writer;
	}

	public int getIsbn() {
		return isbn;
	}

	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	@Override
	public boolean equals(Object obj) {
		Book book = (Book)obj;
		if(this.isbn == book.isbn && this.name.equals(book.name) && this.writer.equals(book.writer))
			return true;
		return false;
	}
	
	@Override
	public String toString() {
		return isbn+" "+name+" "+writer;
	}

}

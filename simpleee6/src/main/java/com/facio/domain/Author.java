package com.facio.domain;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table (name = "Autor")
public class Author {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="idAutor", nullable=false)
	private Long id;
	
	@Column(name="Nome")
	private String name;
	
	@Column(name="Tel")
	private String phone;
	
	@Column(name="Idade")
	private Integer age;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="author")
	private Set<Book> books;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Set<Book> getBooks() {
		return books;
	}

	public void setBooks(Set<Book> books) {
		this.books = books;
	}

	public void addBook(Book b) {
		checkNotNull(b, "Book cannot be null");
		
		if (books == null) {
			books = new HashSet<Book>();
		}
		
		books.add(b);
		b.setAuthor(this);
	}
}

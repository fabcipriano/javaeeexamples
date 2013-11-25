package com.facio.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table (name = "Livros")
public class Book {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column (name="idLivros", nullable=false)
	private Long id;
	
	@Column(name="Titulo", nullable=false)
	private String title;
	
	@Column(name="SubTitulo")
	private String subTitle;
	
	@Column(name="Categoria")
	private String category;
	
	@Column(name="Descricao")
	private String description;
	
	@Column(name="Preco", nullable=false)
	private Integer price;
	
	@ManyToOne( cascade=CascadeType.ALL)
	@JoinColumn(name="Autor_idAutor", nullable=false)
	private Author author;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSubTitle() {
		return subTitle;
	}

	public void setSubTitle(String subTitle) {
		this.subTitle = subTitle;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}
	
}

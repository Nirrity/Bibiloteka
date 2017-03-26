package wijatkowska;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="Books")
public class Book {

	public int getId() {
		return id;
	}
	public void setId( int id ) {
		this.id = id;
	}
    public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getRentById() {
		return rentById;
	}
	public void setRentById(int rentById) {
		this.rentById = rentById;
	}
	public String getAuthors() {
		return authors;
	}
	public void setAuthors(String authors) {
		this.authors = authors;
	}
    
	@Id
    @GeneratedValue
    @Column(name="Id")
	@NotNull
	   private int id;
    
    @Column(name="title")
    @NotNull
	   private String title;
    
    @Column(name="rentById")
    @NotNull
	   private int rentById;
    
    @Column(name="authors")
	   private String authors;
    

	   public Book() {
		  
	   }
	   
	   public Book(String title, int rentById, String authors) {
	      this.title = title;
	      this.rentById = rentById;
	      this.authors = authors;
	     
	   }
	   
	   
	}


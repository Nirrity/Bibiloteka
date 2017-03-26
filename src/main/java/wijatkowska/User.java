package wijatkowska;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="Users")
public class User {

	public int getId() {
		return id;
	}
	public void setId( int id ) {
		this.id = id;
	}
    public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
    
	@Id
    @GeneratedValue
    @Column(name="Id")
	@NotNull
	   private int id;
    
    @Column(name="UserName")
    @NotNull
	   private String userName;
    
    @Column(name="Password")
    @NotNull
	   private String password;
    
    @Column(name="Email")
	   private String email;
    

	   public User() {
		  
	   }
	   
	   public User(String uName, String pwd, String mail) {
	      this.userName = uName;
	      this.password = pwd;
	      this.email = mail;
	     
	   }
	   
	   
	}


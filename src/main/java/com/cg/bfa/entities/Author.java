package com.cg.bfa.entities;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name="AuthorTable")
public class Author {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int authorId;
	
	@NotEmpty(message = "Enter your name")
	private String authorName;

	@Pattern(regexp = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$", message = "Enter Valid Mail Id")
	private String email;

	@Size(min = 4, max = 16, message = "Enter valid password")
	private String password;

	@Pattern(regexp = "^\\d{10}$", message = "Enter Your Mobile Number")
	private String mobileNumber;

	public Author() {
		super();
	}

	public Author(@NotEmpty(message = "Enter your name") String authorName,
			@Pattern(regexp = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$", message = "Enter Valid Mail Id") String email,
			@Size(min = 4, max = 16, message = "Enter valid password") String password,
			@Pattern(regexp = "^\\d{10}$", message = "Enter Your Mobile Number") String mobileNumber) {
		super();
		this.authorName = authorName;
		this.email = email;
		this.password = password;
		this.mobileNumber = mobileNumber;
	}

	public String getAuthorName() {
		return authorName;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	@Override
	public String toString() {
		return "Author [authorName=" + authorName + ", email=" + email + ", password=" + password + ", mobileNumber="
				+ mobileNumber + "]";
	}
	
	
	
	

}

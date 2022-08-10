package com.cg.bfa.entities;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name="ReaderTable")
public class Reader {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int readerId;
	
	@NotEmpty(message = "Enter your name")
	private String readerName;

	@Pattern(regexp = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$", message = "Enter Valid Mail Id")
	private String email;

	@Size(min = 4, max = 16, message = "Enter valid password")
	private String password;

	@Pattern(regexp = "^\\d{10}$", message = "Enter Your Mobile Number")
	private String mobileNumber;
	
	public Reader() {
		super();

	}

	public Reader(@NotEmpty(message = "Enter your name") String readerName,
			@Pattern(regexp = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$", message = "Enter Valid Mail Id") String email,
			@Size(min = 4, max = 16, message = "Enter valid password") String password,
			@Pattern(regexp = "^\\d{10}$", message = "Enter Your Mobile Number") String mobileNumber) {
		super();
		this.readerName = readerName;
		this.email = email;
		this.password = password;
		this.mobileNumber = mobileNumber;
	}

	public String getReaderName() {
		return readerName;
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
		return "Reader [readerName=" + readerName + ", email=" + email + ", password=" + password + ", mobileNumber="
				+ mobileNumber + "]";
	}


}

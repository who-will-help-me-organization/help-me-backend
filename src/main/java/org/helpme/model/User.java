package org.helpme.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Document(collection = "users")
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode(of = {"id"})
public class User {
	@Id
	private String id;
	
	@Indexed(unique = true)
	private String code;
	@JsonIgnore
	private String password;
	
	private String courseCode;
	private String email;
	private String name;
	private String phoneNumber;
	
	public User(String code, String password, String courseCode, String email, String name,
			String phoneNumber) {
		this.code = code;
		this.password = password;
		this.courseCode = courseCode;
		this.email = email;
		this.name = name;
		this.phoneNumber = phoneNumber;
	}
}

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
@EqualsAndHashCode(of = {"usercode"})
public class User {
	@Id
	private String id;
	
	@Indexed(unique = true)
	private String usercode;
	@JsonIgnore
	private String password;
	
	private String courseCode;
	private String email;
	private String name;
	private String phoneNumber;
	
	public User(String usercode, String password, String courseCode, String email, String name,
			String phoneNumber) {
		this.usercode = usercode;
		this.password = password;
		this.courseCode = courseCode;
		this.email = email;
		this.name = name;
		this.phoneNumber = phoneNumber;
	}
}

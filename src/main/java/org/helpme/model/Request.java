package org.helpme.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Document(collection = "requests")
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode(of = {"id"})
public class Request {
	@Id
	private String id;
	
	@DBRef
	@NotNull
	private User requester;
	
	@NotEmpty
	private String subject;
	private String day;
	private String location;
	
	public Request(String subject, String day, String location, User requester) {
		this.subject = subject;
		this.day = day;
		this.location = location;
		this.requester = requester;
	}
}

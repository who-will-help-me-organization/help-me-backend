package org.helpme.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Document(collection = "ratings")
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode(of = {"id"})
public class Rating {
	@Id
	private String id;
	
	private double grade;
	
	@DBRef
	private User ratingUser;
	@DBRef
	private Tutor ratedTutor;
	@DBRef
	private Request ratedRequest;	
	
	public Rating(double grade, User ratingUser, Tutor ratedTutor, Request ratedRequest) {
		this.grade = grade;
		this.ratingUser = ratingUser;
		this.ratedTutor = ratedTutor;
		this.ratedRequest = ratedRequest;
	}
}

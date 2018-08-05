package org.helpme.model;

import java.util.HashSet;
import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Document(collection = "tutors")
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode(of = {"usercode"})
public class Tutor {
	@Id
	private String id;
	
	@Indexed(unique = true)
	private String usercode;
	
	private String subject;
	private int knowhow;
	
	private double rating = 4;
	private double money = 0;
	
	private Set<String> locations = new HashSet<>();
	private Set<String> days = new HashSet<>();
	
	public Tutor(String usercode, String subject, int knowhow) {
		this.usercode = usercode;
		this.subject = subject;
		this.knowhow = knowhow;
	}
	
	@JsonProperty("ratingLevel")
	public String getRatingLevel() {
		if (rating > 4.5) {
			return "TOP";
		} else if (rating > 3 && rating <= 4.5) {
			return "Tutor";
		} else {
			return "Aprendiz";
		}
	}
}

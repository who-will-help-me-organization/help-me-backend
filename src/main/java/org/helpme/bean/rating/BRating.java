package org.helpme.bean.rating;

import org.helpme.exception.annotation.ValidGrade;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BRating {
	@ValidGrade private double grade;
	private String requesterId;
	private String tutorId;
	private String requestId;
}

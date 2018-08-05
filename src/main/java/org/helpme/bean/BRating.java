package org.helpme.bean;

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
	private String requestId;
	private String requestingUserId;
	private String tutorId;
	@ValidGrade private double grade;
}

package org.helpme.bean;

import javax.validation.constraints.NotNull;

import org.helpme.exception.annotation.ValidDay;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BPresentialRequest {
	private String userId;
	@NotNull private String subject;
	@ValidDay private String day;
	@NotNull private String location;
}

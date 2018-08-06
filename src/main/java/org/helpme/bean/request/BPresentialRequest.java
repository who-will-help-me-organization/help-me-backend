package org.helpme.bean.request;

import javax.validation.constraints.NotBlank;

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
	@NotBlank private String subject;
	@ValidDay private String day;
	@NotBlank private String location;
}

package org.helpme.bean.tutor;

import javax.validation.constraints.NotEmpty;

import org.helpme.exception.annotation.ValidLevel;
import org.helpme.exception.annotation.ValidUserCode;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BSignTutor {
	@ValidUserCode private String usercode;
	@NotEmpty private String subject;
	@ValidLevel private int knowhow;
}

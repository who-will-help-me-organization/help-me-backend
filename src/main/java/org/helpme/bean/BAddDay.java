package org.helpme.bean;

import org.helpme.exception.annotation.ValidDay;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BAddDay {
	@ValidDay private String day;
}

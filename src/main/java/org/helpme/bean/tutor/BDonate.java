package org.helpme.bean.tutor;

import org.helpme.exception.annotation.ValidDonation;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BDonate {
	@ValidDonation private double amount;
}

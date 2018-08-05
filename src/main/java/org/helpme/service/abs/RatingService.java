package org.helpme.service.abs;

import org.helpme.bean.BRating;
import org.helpme.model.Rating;

public interface RatingService {
	public Rating create(BRating body);
	public Rating findById(String id);
}

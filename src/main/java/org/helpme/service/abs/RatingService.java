package org.helpme.service.abs;

import org.helpme.bean.rating.BRating;
import org.helpme.model.Rating;

public interface RatingService {
	public Rating findById(String id);
	public Rating create(BRating body);
}

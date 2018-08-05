package org.helpme.service.abs;

import java.util.Collection;

import org.helpme.bean.BRating;
import org.helpme.bean.tutor.BAddDay;
import org.helpme.bean.tutor.BAddLocation;
import org.helpme.bean.tutor.BDonate;
import org.helpme.bean.tutor.BSignTutor;
import org.helpme.model.Tutor;

public interface TutorService {
	public Tutor create(BSignTutor body);
	public Tutor addLocation(String id, BAddLocation body);
	public Tutor addDay(String id, BAddDay body);
	public Tutor rate(String id, BRating body);
	public Tutor donate(String id, BDonate body);
	public Tutor findById(String id);
	public Tutor findByUsercode(String usercode);
	public Collection<Tutor> findAll();
}

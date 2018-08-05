package org.helpme.service.abs;

import org.helpme.bean.BOnlineRequest;
import org.helpme.bean.BPresentialRequest;
import org.helpme.model.Request;
import org.helpme.model.Tutor;

public interface RequestService {
	public Request createOnline(BOnlineRequest body);
	public Request createPresential(BPresentialRequest body);
	public Tutor getTutor(String requestId);
	public Request findById(String id);
}

package com.voter.service;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.voter.Req.Voters;
import com.voter.entity.Voter;
import com.voter.exception.DuplicateDataException;
import com.voter.repo.VoterRepo;

@Service
public class VoterService {

	@Autowired
	private VoterRepo vr;
	
	public String addVoter(@RequestBody Voters v) throws DuplicateDataException
	{
		if(vr.existsByAadhar(v.getAadhar()))
		{
			throw new DuplicateDataException("Duplicate Data");
		}
		Voter vt=new Voter();
		vt.setAadhar(v.getAadhar());
		vt.setDob(v.getDob());
		vt.setFn(v.getFn());
		vt.setLn(v.getLn());
		vt.setGender(v.getGender());
		vt.setMn(v.getMn());
		Calendar dob = Calendar.getInstance();
        dob.setTime(v.getDob());
        Calendar today = Calendar.getInstance();
        int age = today.get(Calendar.YEAR) - dob.get(Calendar.YEAR);
		if(age>=18)
		{
			vr.save(vt);
			return "Vote";
		}
		return "Not vote";
	}
	
	public Voter getDetails(@RequestParam String aadhar)
	{
		Voter v=vr.findByAadhar(aadhar);
		return v;
	}
	
	public boolean updateDetails(@RequestBody Voter v)
	{
		Voter vd=vr.findByAadhar(v.getAadhar());
		if(vd!=null)
		{
			vd.setDob(v.getDob());
			vd.setFn(v.getFn());
			vd.setGender(v.getGender());
			vd.setLn(v.getLn());
			vd.setMn(v.getMn());
			vr.save(vd);
			return true;
		}
		return false;
	}
}

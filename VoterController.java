package com.voter.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.voter.Req.Voters;
import com.voter.api.VoterApi;
import com.voter.entity.Voter;
import com.voter.exception.DuplicateDataException;
import com.voter.service.VoterService;

@RestController
public class VoterController implements VoterApi{

	@Autowired
	private VoterService vs;
	
	@Override
	public String addVoter(@RequestBody Voters v)
	{
		try {
		String b=vs.addVoter(v);
		return b;
		}
		catch(DuplicateDataException e)
		{
			return e.getMessage();
		}
	}
	
	@Override
	public Voter getDetails(@RequestParam String aadhar)
	{
		Voter v=vs.getDetails(aadhar);
		return v;
	}
	
	@Override
	public boolean updateDetails(@RequestBody Voter v)
	{
		boolean b=vs.updateDetails(v);
		return b;
	}
}

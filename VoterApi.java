package com.voter.api;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.voter.Req.Voters;
import com.voter.entity.Voter;

public interface VoterApi {

	@PostMapping("/api/voter/addVoter")
	public String addVoter(@RequestBody Voters v);
	
	@GetMapping("/api/voter/getDetails")
	public Voter getDetails(@RequestParam String aadhar);
	
	@PutMapping("/api/voter/updateDetails")
	public boolean updateDetails(@RequestBody Voter v);
}


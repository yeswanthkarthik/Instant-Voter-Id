package com.voter.repo;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.voter.entity.Voter;

@Repository
public interface VoterRepo extends JpaRepository<Voter, Integer> {
	
	@Query("select count(aadhar)>0 from voter_t where aadhar=:ad")
	public boolean existsByAadhar(String ad);
	
	@Query("SELECT v FROM Voter v WHERE v.aadhar = :aa")
	public Voter findByAadhar(String aa);
}

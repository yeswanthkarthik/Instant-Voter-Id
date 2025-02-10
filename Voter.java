package com.voter.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="Voter_T")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Voter {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Sno.")
	private int id;
	
	@Column(name="First_Name")
	private String fn;
	
	@Column(name="Last_Name")
	private String ln;
	
	@Column(name="Aadhar")
	private String aadhar;
	
	@Column(name="DOB")
	private Date dob;
	
	@Column(name="Mobie_No.")
	private String mn;
	
	@Column(name="Gender")
	private String gender;
}

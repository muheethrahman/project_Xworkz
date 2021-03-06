package com.xworkz.vacccine.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

@Entity
@Table(name = "vaccine_dosage")
@NamedQueries({
	@NamedQuery(name = "GetRecordByMail", query = "select name from VaccineEntity name where name.email=:em and name.password=:e ")})
public class VaccineEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "VACCINE_ID")
	private int vaccineId;

	//@Size(min=3,message="required")  
	@Column(name = "VACCINE_NAME")
	private String name;
	//@Size(min=8,message="required")  
	@Column(name = "VACCINE_EMAIL")
	private String email;
	
	//@Size(min=8,message="required")  
	@Column(name = "VACCINE_PASSWORD")
	private String password;
	
	//@Size(min=4,message="required")  
	@Column(name = "VACCINE_OPT")
	private int otp;
	
	//@Size(min=10,message="required")  
	@Column(name="VACCINE_ADDRESS")
	private String address;
	
	//@Size(min=10,max=10,message="required")  
	@Column(name="VACCINE_CONTACT")
	private long contact;
	
	//@Size(min=10,max=10,message="required")
	@Column(name="VACCINE_AL_CONTACT")
	private long alt_contact;
	
	//@Size(min=4,max=12,message="required")
	@Column(name="VACCINE_GENDER")
	private String gender;
	
	//@Size(message="required")
	@Column(name="VACCINE_BDATE")
	private String bdate;
	
	//@Size(message="required")
	@Column(name="VACCINE_PROOF")
	private String proof;
	

	public int getVaccineId() {
		return vaccineId;
	}


	public void setVaccineId(int vaccineId) {
		this.vaccineId = vaccineId;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public int getOtp() {
		return otp;
	}


	public void setOtp(int otp) {
		this.otp = otp;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public long getContact() {
		return contact;
	}


	public void setContact(long contact) {
		this.contact = contact;
	}


	public long getAlt_contact() {
		return alt_contact;
	}


	public void setAlt_contact(long alt_contact) {
		this.alt_contact = alt_contact;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public String getBdate() {
		return bdate;
	}


	public void setBdate(String bdate) {
		this.bdate = bdate;
	}


	public String getProof() {
		return proof;
	}


	public void setProof(String proof) {
		this.proof = proof;
	}


	public VaccineEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

}
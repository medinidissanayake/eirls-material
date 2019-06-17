package com.example.projectm;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class salesitem {


    @Id
    @JsonAlias("id")
    private int id;

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@JsonAlias("name")
	private String name;

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

    @OneToOne
    @JoinColumn
    @MapsId
    @JsonIgnoreProperties("item")
	private enquiryItems enquiryitem;

	public enquiryItems getEnquiryitem() {
		return this.enquiryitem;
	}

	public void setEnquiryitem(enquiryItems enquiryitem) {
		this.enquiryitem = enquiryitem;
	}





}
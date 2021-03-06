package com.example.projectm;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "supplier", schema ="1fQc5ZhkUX")
public class supplier{

	public supplier(){}


@Id
@GeneratedValue(strategy=GenerationType.AUTO)
@Column(name = "supplier_id")
    private int supplier_id;

	public int getSupplier_id() {
		return this.supplier_id;
	}

	public void setSupplier_id(int supplier_id) {
		this.supplier_id = supplier_id;
	}

	@Column(name="email_address")
	private String email_address;

	public String getEmail_address() {
		return this.email_address;
	}

	public void setEmail_address(String email_address) {
		this.email_address = email_address;
	}

	@Column(name="contact_number")
	private String contact_number;

	public String getContact_number() {
		return this.contact_number;
	}

	public void setContact_number(String contact_number) {
		this.contact_number = contact_number;
	}




	@Column(name="brand_name")
	private String brand_name;

	public String getBrand_name() {
		return this.brand_name;
	}

	public void setBrand_name(String brand_name) {
		this.brand_name = brand_name;
	}


	@Column(name="main_location")
	private String main_location;

	public String getMain_location() {
		return this.main_location;
	}

	public void setMain_location(String main_location) {
		this.main_location = main_location;
	}


	@Column(name="delivery_location")
	private String delivery_location;

	public String getDelivery_location() {
		return this.delivery_location;
	}

	public void setDelivery_location(String delivery_location) {
		this.delivery_location = delivery_location;
	}

	

	@Column(name="collection_location")
	private String collection_location;

	public String getCollection_location() {
		return this.collection_location;
	}

	public void setCollection_location(String collection_location) {
		this.collection_location = collection_location;
	}


	@Column(name="supplier_status")
	private String supplier_status;

	public String getSupplier_status() {
		return this.supplier_status;
	}

	public void setSupplier_status(String supplier_status) {
		this.supplier_status = supplier_status;
	}

	@OneToMany(mappedBy = "sup")
	@JsonIgnoreProperties("sup")
  private Set<items> ord;

	public Set<items> getOrd() {
		return this.ord;
	}

	public void setOrd(Set<items> ord) {
		this.ord = ord;
	}


	@Column(name="delivery_performance")
	private String delivery_performance;

	public String getDelivery_performance() {
		return this.delivery_performance;
	}

	public void setDelivery_performance(String delivery_performance) {
		this.delivery_performance = delivery_performance;
	}


	

	
	@Column(name="quality_performance")
	private String quality_performance;


	public String getQuality_performance() {
		return this.quality_performance;
	}

	public void setQuality_performance(String quality_performance) {
		this.quality_performance = quality_performance;
	}

	
	
}
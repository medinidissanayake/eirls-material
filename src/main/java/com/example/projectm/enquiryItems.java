package com.example.projectm;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class enquiryItems {

    @Id
    @JsonAlias("id")
    private int id;

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @JsonAlias("quantity")
    private int quantity;

    public int getQuantity() {
        return this.quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @JsonAlias("item")
    @OneToOne(mappedBy = "enquiryItems", cascade = CascadeType.ALL)
    private salesitem item;

	public salesitem getItem() {
		return this.item;
	}

	public void setItem(salesitem item) {
		this.item = item;
	}


	


   
    // @JoinColumn(name = "ord", nullable = true)
    @ManyToOne
    @JsonIgnore
    private salesorder salesOrder;


	public salesorder getSalesOrder() {
		return this.salesOrder;
	}

	public void setSalesOrder(salesorder salesOrder) {
		this.salesOrder = salesOrder;
	}





}
package com.example.projectm;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "order_items", schema ="1fQc5ZhkUX")
public class order_items{

	public order_items(){}


@Id
@Column(name = "item_id")
    private int item_id;

	public int getItem_id() {
		return this.item_id;
	}

	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}

	@Column(name="sales_order_id")
	private int sales_order_id;

	public int getSales_order_id() {
		return this.sales_order_id;
	}

	public void setSales_order_id(int sales_order_id) {
		this.sales_order_id = sales_order_id;
	}


	




@Column(name = "item_name")    
private String item_name;

	public String getItem_name() {
		return this.item_name;
	}

	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}



@Column(name = "item_quantity")
private int item_quantity;

	public int getItem_quantity() {
		return this.item_quantity;
	}

	public void setItem_quantity(int item_quantity) {
		this.item_quantity = item_quantity;
	}

	@Column(name="product_status")
	private String product_status;

	public String getProduct_status() {
		return this.product_status;
	}

	public void setProduct_status(String product_status) {
		this.product_status = product_status;
	}



	
}
package com.example.projectm;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "stock_items", schema ="1fQc5ZhkUX")
public class items{

	public items(){}


@Id
@GeneratedValue(strategy=GenerationType.AUTO)
@Column(name = "item_id")
    private int item_id;

	public int getItem_id() {
		return this.item_id;
	}

	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}


@Column(name = "item_name")    
private String item_name;

	public String getItem_name() {
		return this.item_name;
	}

	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}


@Column(name = "item_type")
private String item_type;

	public String getItem_type() {
		return this.item_type;
	}

	public void setItem_type(String item_type) {
		this.item_type = item_type;
	}


@Column(name = "item_description")
private String item_description;

	public String getItem_description() {
		return this.item_description;
	}

	public void setItem_description(String item_description) {
		this.item_description = item_description;
	}


@Column(name = "item_quantity")
private int item_quantity;

	public int getItem_quantity() {
		return this.item_quantity;
	}

	public void setItem_quantity(int item_quantity) {
		this.item_quantity = item_quantity;
	}


@Column(name = "item_price")
private Double item_price;

	public Double getItem_price() {
		return this.item_price;
	}

	public void setItem_price(Double item_price) {
		this.item_price = item_price;
	}


@Column(name = "reorder_level")
private int reorder_level;

	public int getReorder_level() {
		return this.reorder_level;
	}

	public void setReorder_level(int reorder_level) {
		this.reorder_level = reorder_level;
	}


@Column(name = "reorder_quantity")
private int reorder_quantity;

	public int getReorder_quantity() {
		return this.reorder_quantity;
	}

	public void setReorder_quantity(int reorder_quantity) {
		this.reorder_quantity = reorder_quantity;
	}


}
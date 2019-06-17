package com.example.projectm;

import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class warehouseItems {

@Id
private String received_item_id;

private int item_qty;

private String rec_note_id;

private int item_id;

	public String getReceived_item_id() {
		return this.received_item_id;
	}

	public void setReceived_item_id(String received_item_id) {
		this.received_item_id = received_item_id;
	}

	public int getItem_qty() {
		return this.item_qty;
	}

	public void setItem_qty(int item_qty) {
		this.item_qty = item_qty;
	}

	public String getRec_note_id() {
		return this.rec_note_id;
	}

	public void setRec_note_id(String rec_note_id) {
		this.rec_note_id = rec_note_id;
	}

	public int getItem_id() {
		return this.item_id;
	}

	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}


	



}
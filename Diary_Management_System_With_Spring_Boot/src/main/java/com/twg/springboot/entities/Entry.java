package com.twg.springboot.entities;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="entry")
public class Entry {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name="entryDate")
	private Date entryDate;
	private String description;
	private long userid;
	public Entry() {}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public Date getEntryDate() {
		return entryDate;
	}
	public void setEntryDate(Date entryDate) {
		this.entryDate = entryDate;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public long getUserid() {
		return userid;
	}
	public void setUserid(long userid) {
		this.userid = userid;
	}
	public Entry(long id, Date entryDate, String description, long userid) {
		super();
		this.id = id;
		this.entryDate = entryDate;
		this.description = description;
		this.userid = userid;
	}
	

}

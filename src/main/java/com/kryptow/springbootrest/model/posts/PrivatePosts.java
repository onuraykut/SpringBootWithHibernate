package com.kryptow.springbootrest.model.posts;


import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.JoinFormula;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.kryptow.springbootrest.model.User;
import com.kryptow.springbootrest.model.User.UserBuilder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity 
@Table(name = "Posts")
public class PrivatePosts implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
//	@OneToOne(targetEntity = User.class,cascade=CascadeType.ALL,fetch= FetchType.LAZY)
//	@JoinColumn(name = "fromID",referencedColumnName = "uid")
	//@JsonIgnore
	//private User user;
	@Column(nullable = false)
	private String fromID;
	@Column(nullable = false)
	private String toID;
	private String message;
	@Column(nullable = false)
	private String photoName;
	private String comment;
	private int rating;
	
	public PrivatePosts() {
		
	}
	public PrivatePosts(String fromID, String toID, String message, String photoName, String comment, int rating) {
		super();
		this.fromID = fromID;
		this.toID = toID;
		this.message = message;
		this.photoName = photoName;
		this.comment = comment;
		this.rating = rating;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFromID() {
		return fromID;
	}
	public void setFromID(String fromID) {
		this.fromID = fromID;
	}
	public String getToID() {
		return toID;
	}
	public void setToID(String toID) {
		this.toID = toID;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getPhotoName() {
		return photoName;
	}
	public void setPhotoName(String photoName) {
		this.photoName = photoName;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public String getToIdPhoto() {
		return toID+".jpg";
	}
	public String getFromIdPhoto() {
		return fromID+".jpg";
	}
	public String getPhotoNameMin() {
		return photoName+"_min.jpg";
	}
	
	}

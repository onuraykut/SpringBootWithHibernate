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
@Data  
@Builder
@NoArgsConstructor 
@AllArgsConstructor
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
	}

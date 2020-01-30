package com.kryptow.springbootrest.model;


import java.util.List;

import javax.persistence.CascadeType;
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
public class PrivatePosts {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@ManyToOne(targetEntity = com.kryptow.springbootrest.model.User.class,cascade=CascadeType.ALL)
	@JoinColumn(name = "fromID",referencedColumnName = "uid")
	private String fromID;
	private String toID;
	private String message;
	private String photoName;
	private String comment;
	private int rating;

	}

package com.kryptow.springbootrest.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity 
@Data 
@Builder 
@NoArgsConstructor 
@AllArgsConstructor
@Table(name="Users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	//@OneToMany(mappedBy = "fromID",targetEntity = com.kryptow.springbootrest.model.PrivatePosts.class)
	//@Column(name="uid",unique = true)
	
	private String uid;
	private String username;
	private String mailAdress;
	private String createDate;
	private int coin;
	@OneToMany(mappedBy = "fromID")
	private List<PrivatePosts> privatePosts;
	//private Posts posts;
}

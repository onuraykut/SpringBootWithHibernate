package com.kryptow.springbootrest.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.kryptow.springbootrest.model.posts.PrivatePosts;

import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity 
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name="Users")
public class User implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int id;
	//@OneToMany(mappedBy = "fromID",targetEntity = com.kryptow.springbootrest.model.PrivatePosts.class)
	//@Column(name="uid",unique = true)
	//@OneToMany(mappedBy="fromID")
	private String uid;
	private String username;
	private String name;
	private String mailAddress;
	//// profil fotoğrafı uid bağlantılı şekilde olacak. uid.jpg / uid_min.jpg
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	//@JsonIgnore
	private Date createDate;
	private int coin;
	private int ratingSum;
	private int ratingCount;
//	@Transient
	//@OneToMany(mappedBy = "fromID",cascade = CascadeType.ALL)
	//private List<PrivatePosts> privatePosts;
	//private Posts posts;
	
	public User(String uid,String mailAddress) {
		this.uid = uid;
		this.mailAddress = mailAddress;
	}
	
}


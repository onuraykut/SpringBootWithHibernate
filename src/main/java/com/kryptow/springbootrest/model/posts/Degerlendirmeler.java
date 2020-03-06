package com.kryptow.springbootrest.model.posts;

import java.util.Date;

import com.kryptow.springbootrest.model.User;
import com.kryptow.springbootrest.model.User.UserBuilder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Degerlendirmeler {
	int post_id;
	String username;
	String photo_to;
	String photo_from;
	String photoName;
}

package com.kryptow.springbootrest.model.posts;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@Builder 
@NoArgsConstructor 
@AllArgsConstructor
public class Posts {
	private List<Integer> myPostID;
	private List<Integer> otherPostID;
	private List<Integer> publicPostID;
	
}

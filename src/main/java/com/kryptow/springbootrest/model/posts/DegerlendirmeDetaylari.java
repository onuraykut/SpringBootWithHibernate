package com.kryptow.springbootrest.model.posts;


import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DegerlendirmeDetaylari {
	private String toName;
	private String fromName;
	//private Date fromDate;
	private String photoName;
	private String photoTo;
	private String comment;
}

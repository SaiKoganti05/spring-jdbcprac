package com.practice.hibernate.jdbc;

import java.math.BigDecimal;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Item {
	
	private Integer itemId;
	
	private String name;
	
	private BigDecimal price;
	
	private Integer quantity;
	
	private Date updated_time;
	

}

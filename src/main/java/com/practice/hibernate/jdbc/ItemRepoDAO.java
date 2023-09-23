package com.practice.hibernate.jdbc;

import java.security.Timestamp;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class ItemRepoDAO {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	
	class ItemRowMapper implements RowMapper<Item>{

		@Override
		public Item mapRow(ResultSet rs, int rowNum) throws SQLException {
			Item item = new Item();
			item.setItemId(rs.getInt("itemId"));
			item.setName(rs.getString("name"));
			item.setPrice(rs.getBigDecimal("price"));
			item.setQuantity(rs.getInt("quantity"));
			item.setUpdated_time(rs.getDate("updated_time"));
			return item;
		}
		
	}
	
	public List<Item> findAll() {
		return jdbcTemplate.query("select * from items", new BeanPropertyRowMapper<Item>(Item.class));
	}
	
	@SuppressWarnings("deprecation")
	public Item findById(int itemId) {
		return jdbcTemplate.queryForObject("select * from items where itemId=?", new Object[] {itemId}, new ItemRowMapper());
	}
	
	public int deleteById(int itemId, String itemName) {
		return jdbcTemplate.update("delete from items where itemId=? and name=?",new Object[] {itemId, itemName});
	}
	
	public int insertItem(Item item) {
		return jdbcTemplate.update("insert into items (itemId,name,price,quantity,updated_time) values(?,?,?,?,?)", 
				new Object[] {item.getItemId(),item.getName(),item.getPrice(),item.getQuantity(),new Date()});
	}
	
	public int updateItem(Item item) {
		return jdbcTemplate.update("update items set price= ?  where itemId=? ", new Object[] {item.getPrice(),item.getItemId()});
	}

}

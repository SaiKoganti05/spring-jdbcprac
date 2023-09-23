package com.practice.hibernate;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.practice.hibernate.jdbc.Item;
import com.practice.hibernate.jdbc.ItemRepoDAO;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class HibernateApplication implements ApplicationRunner {
	
	@Autowired
	ItemRepoDAO itemRepoDAO;

	public static void main(String[] args) {
		SpringApplication.run(HibernateApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		log.info("Items are : {}",itemRepoDAO.findAll());
		log.info("Item for id 10001 is :{}",itemRepoDAO.findById(10001));
		log.info("Deleting the id 10003 and affected rows are: {}",itemRepoDAO.deleteById(10003,"lehanga"));
		log.info("Inserting new row with itemId 10003 and affected rows are: {}",itemRepoDAO.insertItem(new Item(10003,"Dhoti",new BigDecimal(9000),3,new Date())));
		log.info("Updating row with itemId 10003 and affected rows are: {}",itemRepoDAO.updateItem(new Item(10003,"Dhoti",new BigDecimal(7500),3,new Date())));
	}

}

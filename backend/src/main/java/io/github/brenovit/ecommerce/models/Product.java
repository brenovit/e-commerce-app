package io.github.brenovit.ecommerce.models;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Entity
@Data
@Table(	name = "product")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String sku;
	private String name;
	private String description;
	private BigDecimal unitPrice;
	private String imageUrl;
	private boolean active;
	private int unitsInStock;
	
	@CreationTimestamp
	private Date createdAt;	
	@UpdateTimestamp
	private Date updatedAt;
}


package com.dg3.forum.forum.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "medicine")
public class Medicine {
	private Long dealer_pk;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long medicine_pk;
	private String name_medicine;
	private String where_production;
	private String price;
	private String effect;
	private String details_medicine;
	private boolean enable_medicine;
}

package com.codicefiscale.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.*;


@Entity
@Table(name = "DEPARTMENT")
@AllArgsConstructor
@NoArgsConstructor
public class Department {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter @Setter
	private Long id;

	@Column
	@Getter @Setter
	private String name;

}

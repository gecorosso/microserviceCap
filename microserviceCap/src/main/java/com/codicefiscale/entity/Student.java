package com.codicefiscale.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "STUDENT")
@AllArgsConstructor
@NoArgsConstructor
public class Student {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter @Setter
    private Long id;

    @Column
    @Getter @Setter
    private String name;

    @Column
    @Getter @Setter
    private int mobile;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "DEPT_ID")
    @Getter @Setter
    private Department department;

}

package com.proyect.deparment.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "Type_Departments")
public class Category {

    @Id
    @Column(name = "IdCategory")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int IdCategory;

    @Column(name = "rooms_department")
    private String cuartos;

    @Column(name = "kitchens_department")
    private String cocinas;

    @Column(name = "toilets_department")
    private String baños;

    @Column(name = "parkinglots_department")
    private String estacionamientos;

    @Column(name = "antiquity_department")
    private String antiguedad;

    @Column(name = "price_department")
    private double precio;

}

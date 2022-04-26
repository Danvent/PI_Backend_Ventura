package com.proyect.deparment.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "Type_departments")
public class Category {

    @Id
    @Column(name = "IdCategory")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCategory;

    @Column(name = "area_department")
    private String area;

    @Column(name = "rooms_department")
    private String cuartos;

    @Column(name = "kitchens_department")
    private String cocinas;

    @Column(name = "toilets_department")
    private String banios;

    @Column(name = "parkinglots_department")
    private String estacionamientos;

    @Column(name = "antiquity_department")
    private String antiguedad;

    @Column(name = "price_department")
    private double precio;

    @Column(name = "des_department")
    private String descripcion;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createdAt;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date updatedAt;

    @Column(name = "createdUser")
    private String usuario;
}

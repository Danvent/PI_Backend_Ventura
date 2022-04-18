package com.proyect.deparment.entity;

import java.sql.Date;

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
@Table(name = "Pets")
public class Pet {
    
    @Id
    @Column(name = "IdPet")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int IdPet;

    @Column(name = "IdCustomer")
    private int ip_pk;

    @Column(name = "des_pet")
    private String descripcion;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createdAt;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date updatedAt;

    @Column(name = "gender_pet")
    private String sexo;

    @Column(name = "color_pet")
    private String color;

    @Column(name = "breed_pet")
    private String raza;


    @Column(name = "name_pet")
    private String nombre;
}

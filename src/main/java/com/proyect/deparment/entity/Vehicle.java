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

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Vehicles")
public class Vehicle {
    
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private int IdVehicle;

    @Column(name = "IdCustomer")
    private int iv_pk;

    @Column(name = "brand_vehicle")
    private String marca;

    @Column(name = "type_vehicle")
    private String tipovehiculo;

    @Column(name = "plate_vehicle")
    private String placa;

    @Column(name = "color_vehicle")
    private String color;


}

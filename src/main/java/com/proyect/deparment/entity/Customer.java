package com.proyect.deparment.entity;


import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Table(name="Customers")
@Getter
@Setter
@Entity
public class Customer {
    
    @Id
    @Column(name = "IdCustomer")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idcustomer;
 
    @Column(name = "des_customer")
    private String descripcion;

    @Column(name = "document_customer")
    private String documento;

    @Column(name = "ruc_customer")
    private String ruc;

    @Column(name = "retainer_customer")
    private String retainer;

    @Enumerated(EnumType.STRING)
    @Column(name = "type_customer")
    private Type tipo;
    
    @Column(name = "firstname_customer")
    private String nombre;

    @Column(name="middlename_customer")
    private String nombre2;

    @Column(name = "lastname_customer")
    private String apellidoP;

    @Column(name = "slastname_customer")
    private String apellidoM;

    @Column(name = "cellphone_customer")
    private String celular;

    @Column(name = "email_customer")
    private String correo;

    @Column(name = "birthdate_customer")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private String fechaNac;

    @Column(name = "department_customer")
    private String departamento;

    @Column(name = "province_customer")
    private String provincia;

    @Column(name = "district_customer")
    private String distrito;
    
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createdAt;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date updatedAt;

    //Todo: Creando el One to Many -> Un (CLiente) - muchas (Mascotas)
    @OneToMany(targetEntity = Pet.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "IdCustomer",referencedColumnName = "IdCustomer")
    private List<Pet> pets;


    //Todo: Creando el One to Many -> Un (Cliente) - muchos(Vehiculos)
    @OneToMany(targetEntity = Vehicle.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "IdCustomer", referencedColumnName = "IdCustomer")
    private List<Vehicle> vehicles;
}

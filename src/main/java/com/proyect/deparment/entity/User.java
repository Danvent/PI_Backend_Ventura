package com.proyect.deparment.entity;

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
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "Users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer IdUser;

    @Column(name="document_user")
    private String documemto;

    @Column(name = "firstname_user")
    private String Pnombre;

    @Column(name = "middlename_user")
    private String Snombre;

    @Column(name = "lastname_user")
    private String apellidoP;

    @Column(name = "slastname_user")
    private String apellidoM;

    @Column(name = "cellphone_user")
    private String celular;

    @Column(name = "email_user")
    private String correo;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;
    
    @ManyToOne
    @JoinColumn(name = "IdRol")
    private Rol rol;

}

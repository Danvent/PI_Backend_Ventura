package com.proyect.deparment.service;

import java.util.List;
import java.util.Optional;

import com.proyect.deparment.entity.Rol;

public interface RolService {
    
    public abstract List<Rol> listRols();

    public abstract Rol miRol(Rol obj);

    public abstract void deleteRol(int IdRol);

    public abstract Optional<Rol> findRol(int IdRol);
}

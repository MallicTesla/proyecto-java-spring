package com.mallictesla.apirest.java_apirest.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mallictesla.apirest.java_apirest.Entities.Producto;

// Entre los <> va primero el modelo y después el tipo de identificador (el ID) 
public interface ProductoRepository extends JpaRepository <Producto, Long>{

}

package com.foliaco.reto_mongo.service;

import com.foliaco.reto_mongo.entity.Producto;

import java.util.List;
import java.util.Optional;

public interface IProductoService {

    // CRUD methods for Producto entity

    Producto guardar(Producto producto);

    Optional<Producto> buscarPorId(String id);

    List<Producto> listar();

    boolean eliminar(String id);

}

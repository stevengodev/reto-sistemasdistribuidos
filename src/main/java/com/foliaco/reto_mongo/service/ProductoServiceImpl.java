package com.foliaco.reto_mongo.service;

import com.foliaco.reto_mongo.entity.Producto;
import com.foliaco.reto_mongo.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoServiceImpl implements IProductoService {

    private final ProductoRepository productoRepository;

    @Autowired
    public ProductoServiceImpl(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    @Override
    public Producto guardar(Producto producto) {
        return productoRepository.save(producto);
    }

    @Override
    public Optional<Producto> buscarPorId(String id) {
        return productoRepository.findById(id);
    }

    @Override
    public List<Producto> listar() {
        return productoRepository.findAll();
    }

    @Override
    public boolean eliminar(String id) {

        // Verificamos que el producto exista en la base de datos
        if (buscarPorId(id).isEmpty()){
            return false;
        }

        productoRepository.deleteById(id);
        return true;
    }
}

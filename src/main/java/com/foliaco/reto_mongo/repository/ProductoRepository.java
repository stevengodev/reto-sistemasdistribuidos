package com.foliaco.reto_mongo.repository;

import com.foliaco.reto_mongo.entity.Producto;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductoRepository extends MongoRepository<Producto, String> {



}

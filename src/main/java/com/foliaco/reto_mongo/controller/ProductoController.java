package com.foliaco.reto_mongo.controller;

import com.foliaco.reto_mongo.entity.Producto;
import com.foliaco.reto_mongo.service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/productos")
public class ProductoController {

    private final IProductoService productoService;

    @Autowired
    public ProductoController(IProductoService productoService) {
        this.productoService = productoService;
    }

    @GetMapping("/")
    public ResponseEntity<List<Producto>> listarProductos() {
        return ResponseEntity.ok(productoService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Producto> buscarProductoPorId(@PathVariable("id") String id) {

        Optional<Producto> producto = productoService.buscarPorId(id);

        return producto.isPresent() ? ResponseEntity.ok(producto.get())
                                    : ResponseEntity.status(HttpStatus.NOT_FOUND).build();

    }

    @PostMapping("/")
    public ResponseEntity<Producto> guardarProducto(@RequestBody Producto producto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(productoService.guardar(producto));
    }

    @PutMapping("/")
    public ResponseEntity<Producto> actualizarProducto(@RequestBody Producto producto) {
            return ResponseEntity.status(HttpStatus.OK)
                .body(productoService.guardar(producto));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> eliminarProducto(@PathVariable String id){
        boolean esProductoEliminado = productoService.eliminar(id);

        return esProductoEliminado ? ResponseEntity.ok(true)
                                    : ResponseEntity.status(HttpStatus.NOT_FOUND).body(false);

    }
}

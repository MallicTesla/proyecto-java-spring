// en este archivo van las rutas
package com.mallictesla.apirest.java_apirest.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mallictesla.apirest.java_apirest.Entities.Producto;
import com.mallictesla.apirest.java_apirest.Repositories.ProductoRepository;

// este decorador es para indicar que se va a hacer una api rest
@RestController
// aca se agrega la ruta de para ingresar
@RequestMapping 
public class ProductoController {
    // con este decorador se inyecta directamente una instancia de ProductoRepository y no es necesario tener que crear un objeto de ese clase
    @Autowired
    private ProductoRepository productoRepository;

    // Decorador para el método get para traer todo
    @GetMapping
    public List <Producto> obtenerProductos(){
        // gracias el decorador Autowired es así de simple  
        return productoRepository.findAll();
    }

    // método post
    @PostMapping
    public Producto crearProducto (@RequestBody Producto producto){
        // la información se recibe en producto
        return productoRepository.save(producto);
    }

    // así continuas la URL para acceder a este método
    @GetMapping ("/{id}")
    public Producto obteneProductoID(@PathVariable Long id){
        return  productoRepository.findById(id)
        // esto es un especie de if por si no encuentra ningún resultado
        // esto () -> es una función flecha que activa un evento de error y mande ese mensaje
        .orElseThrow (() -> new RuntimeException ("No se encontró el producto con el ID " + id));
    }

    // método put
    @PutMapping ("/{id}")
    // primero recibe el id de la URL y después el cuerpo de la actualización
    public Producto actualizarProducto (@PathVariable Long id, @RequestBody Producto detallesProducto){
        // se guarda el producto en una variable de tipo Producto para después modificarla
        Producto producto = productoRepository.findById (id)
        // esto es un especie de if por si no encuentra ningún resultado
        // esto () -> es una función flecha que activa un evento de error y mande ese mensaje
        .orElseThrow (() -> new RuntimeException ("No se encontró el producto con el ID " + id));

        // así se modifican los distintos campos
        producto.setNombre(detallesProducto.getNombre());
        producto.setPrecio(detallesProducto.getPrecio());

        // y después se guarda el producto modificado 
        return productoRepository.save(producto);
    }

    @DeleteMapping ("/{id}")
    public String borrarProducto(@PathVariable Long id){
        // se guarda el producto en una variable de tipo Producto para después modificarla
        Producto producto = productoRepository.findById (id)
        // esto es un especie de if por si no encuentra ningún resultado
        // esto () -> es una función flecha que activa un evento de error y mande ese mensaje
        .orElseThrow (() -> new RuntimeException ("No se encontró el producto con el ID " + id));

        productoRepository.delete(producto);
        return "El producto con el ID: " + id + "fue eliminado correctamente";
    }
}

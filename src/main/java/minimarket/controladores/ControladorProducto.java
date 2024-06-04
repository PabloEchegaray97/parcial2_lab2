package minimarket.controladores;

import minimarket.entidades.Cliente;
import minimarket.entidades.Producto;
import minimarket.modelos.ProductoModelo;

public class ControladorProducto {
    public ProductoModelo productoModelo= new ProductoModelo();

    public void ingresarProducto(String nombre, double precio, int stock) {
        try {
            Producto producto=new Producto();
            producto.setNombre(nombre);
            producto.setPrecio(precio);
            producto.setStock(stock);
            productoModelo.ingresarProducto(producto);
            System.out.println("Cliente ingresado exitosamente.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void modificarProducto(int id, String nombre, double precio, int stock) {
        try {
           Producto producto = productoModelo.buscarProductoPorId(id);
            if (producto != null) {
                producto.setNombre(nombre);
                producto.setPrecio(precio);
                producto.setStock(stock);
                productoModelo.modificarProducto(producto);
                System.out.println("Cliente modificado exitosamente.");
            } else {
                System.out.println("Cliente no encontrado.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

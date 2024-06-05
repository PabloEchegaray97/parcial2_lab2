package minimarket.controladores;

import minimarket.entidades.Cliente;
import minimarket.entidades.Producto;
import minimarket.modelos.ProductoModelo;
import javax.swing.JOptionPane;

public class ControladorProducto {
    public ProductoModelo productoModelo= new ProductoModelo();

    public void ingresarProducto(String nombre, double precio, int stock) {
        try {
            Producto producto=new Producto();
            producto.setNombre(nombre);
            producto.setPrecio(precio);
            producto.setStock(stock);
            productoModelo.ingresarProducto(producto);
            System.out.println("Producto ingresado exitosamente.");

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
                System.out.println("Producto modificado exitosamente.");
            } else {
                System.out.println("Producto no encontrado.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void buscarProductoPorId(int id) {
        try {
            Producto producto = productoModelo.buscarProductoPorId(id);
            if (producto != null) {
                JOptionPane.showMessageDialog(null,"PRODUCTO:\nNombre: " + producto.getNombre() + "\n"
                        + "Precio: $" + producto.getPrecio() + "\n"
                        + "Stock: " + producto.getStock());

            } else {
                System.out.println("Producto no encontrado.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void eliminarProducto(int id) {
        try {
            Producto producto = productoModelo.buscarProductoPorId(id);
            if (producto != null) {
                productoModelo.eliminarProducto(producto);
                System.out.println("Producto eliminado exitosamente.");
            } else {
                System.out.println("Producto no encontrado.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

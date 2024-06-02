package minimarket.modelos;

import java.util.ArrayList;
import minimarket.entidades.Producto;
import minimarket.persistencia.ProductoDAO;

public class ProductoModelo {
    private ProductoDAO productoDAO = new ProductoDAO(this);

    public void ingresarProducto(Producto producto) throws Exception {
        productoDAO.ingresarProducto(producto);
    }

    public void modificarProducto(Producto producto) throws Exception {
        productoDAO.modificarProducto(producto);
    }

    public void eliminarProducto(Producto producto) throws Exception {
        productoDAO.eliminarProducto(producto);
    }

    public Producto buscarProductoPorId(int id) throws Exception {
        return productoDAO.buscarProductoPorId(id);
    }

    public ArrayList<Producto> buscarProductos() throws Exception {
        return productoDAO.buscarProductos();
    }
}

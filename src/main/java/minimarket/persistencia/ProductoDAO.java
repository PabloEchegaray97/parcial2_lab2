package minimarket.persistencia;

import java.util.ArrayList;
import minimarket.entidades.Producto;
import minimarket.modelos.ProductoModelo;

public class ProductoDAO extends DAO {
    ProductoModelo productoModelo;

    public ProductoDAO(ProductoModelo productoModelo) {
        this.productoModelo = productoModelo;
    }

    public void ingresarProducto(Producto producto) throws Exception {
        String sql = "INSERT INTO productos(nombre, precio, stock) VALUES('" + producto.getNombre() + "', " + producto.getPrecio() + ", " + producto.getStock() + ")";
        insertarModificarEliminar(sql);
    }

    public void modificarProducto(Producto producto) throws Exception {
        String sql = "UPDATE productos SET nombre = '" + producto.getNombre() + "', precio = " + producto.getPrecio() + ", stock = " + producto.getStock() + " WHERE id_producto = " + producto.getId();
        insertarModificarEliminar(sql);
    }

    public void eliminarProducto(Producto producto) throws Exception {
        String sql = "DELETE FROM productos WHERE id_producto = " + producto.getId();
        insertarModificarEliminar(sql);
    }

    public Producto buscarProductoPorId(int id) throws Exception {
        String sql = "SELECT * FROM productos WHERE id_producto = " + id;
        consultarBase(sql);
        if (resultado.next()) {
            Producto producto = new Producto();
            producto.setId(id);
            producto.setNombre(resultado.getString(2));
            producto.setPrecio(resultado.getDouble(3));
            producto.setStock(resultado.getInt(4));
            return producto;
        }
        return null;
    }

    public ArrayList<Producto> buscarProductos() throws Exception {
        String sql = "SELECT * FROM productos";
        consultarBase(sql);
        ArrayList<Producto> productos = new ArrayList<>();
        while (resultado.next()) {
            Producto producto = new Producto();
            producto.setId(resultado.getInt(1));
            producto.setNombre(resultado.getString(2));
            producto.setPrecio(resultado.getDouble(3));
            producto.setStock(resultado.getInt(4));
            productos.add(producto);
        }
        return productos;
    }
}

package minimarket.persistencia;

import minimarket.entidades.Comanda;
import minimarket.entidades.Producto;

import java.util.ArrayList;
import java.util.List;

public class ComandaDAO extends DAO {

    public void ingresarComanda(Comanda comanda) throws Exception {
        try {
            conectarBase();
            String sql = "INSERT INTO Comanda (id, idEmpleado) VALUES (" + comanda.getId() + ", " + comanda.getIdEmpleado() + ")";
            insertarModificarEliminar(sql);

            for (Producto producto : comanda.getProductos()) {
                sql = "INSERT INTO ComandaProducto (idComanda, idProducto) VALUES (" + comanda.getId() + ", " + producto.getId() + ")";
                insertarModificarEliminar(sql);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            desconectarBase();
        }
    }

    public List<Comanda> buscarComandas() throws Exception {
        List<Comanda> comandas = new ArrayList<>();
        try {
            conectarBase();
            String sql = "SELECT * FROM Comanda";
            consultarBase(sql);

            while (resultado.next()) {
                Comanda comanda = new Comanda();
                comanda.setId(resultado.getInt("id"));
                comanda.setIdEmpleado(resultado.getInt("idEmpleado"));
                comandas.add(comanda);

                sql = "SELECT p.* FROM Producto p INNER JOIN ComandaProducto cp ON p.id = cp.idProducto WHERE cp.idComanda = " + comanda.getId();
                consultarBase(sql);

                List<Producto> productos = new ArrayList<>();
                while (resultado.next()) {
                    Producto producto = new Producto();
                    producto.setId(resultado.getInt("id"));
                    producto.setNombre(resultado.getString("nombre"));
                    producto.setPrecio(resultado.getDouble("precio"));
                    producto.setStock(resultado.getInt("stock"));
                    productos.add(producto);
                }
                comanda.setProductos(productos);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            desconectarBase();
        }
        return comandas;
    }

    public Comanda buscarComandaPorId(int id) throws Exception {
        Comanda comanda = null;
        try {
            conectarBase();
            String sql = "SELECT * FROM Comanda WHERE id = " + id;
            consultarBase(sql);

            if (resultado.next()) {
                comanda = new Comanda();
                comanda.setId(resultado.getInt("id"));
                comanda.setIdEmpleado(resultado.getInt("idEmpleado"));

                sql = "SELECT p.* FROM Producto p INNER JOIN ComandaProducto cp ON p.id = cp.idProducto WHERE cp.idComanda = " + comanda.getId();
                consultarBase(sql);

                List<Producto> productos = new ArrayList<>();
                while (resultado.next()) {
                    Producto producto = new Producto();
                    producto.setId(resultado.getInt("id"));
                    producto.setNombre(resultado.getString("nombre"));
                    producto.setPrecio(resultado.getDouble("precio"));
                    producto.setStock(resultado.getInt("stock"));
                    productos.add(producto);
                }
                comanda.setProductos(productos);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            desconectarBase();
        }
        return comanda;
    }

    public void modificarComanda(Comanda comanda) throws Exception {
        try {
            conectarBase();
            String sql = "UPDATE Comanda SET idEmpleado = " + comanda.getIdEmpleado() + " WHERE id = " + comanda.getId();
            insertarModificarEliminar(sql);

            sql = "DELETE FROM ComandaProducto WHERE idComanda = " + comanda.getId();
            insertarModificarEliminar(sql);

            for (Producto producto : comanda.getProductos()) {
                sql = "INSERT INTO ComandaProducto (idComanda, idProducto) VALUES (" + comanda.getId() + ", " + producto.getId() + ")";
                insertarModificarEliminar(sql);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            desconectarBase();
        }
    }

    public void eliminarComanda(int id) throws Exception {
        try {
            conectarBase();
            String sql = "DELETE FROM ComandaProducto WHERE idComanda = " + id;
            insertarModificarEliminar(sql);

            sql = "DELETE FROM Comanda WHERE id = " + id;
            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        } finally {
            desconectarBase();
        }
    }
}

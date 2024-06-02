package minimarket.persistencia;

import java.util.ArrayList;
import minimarket.entidades.Proveedor;
import minimarket.modelos.ProveedorModelo;

public class ProveedorDAO extends DAO {
    ProveedorModelo proveedorModelo;

    public ProveedorDAO(ProveedorModelo proveedorModelo) {
        this.proveedorModelo = proveedorModelo;
    }

    public void ingresarProveedor(Proveedor proveedor) throws Exception {
        String sql = "INSERT INTO proveedores(nombre, contacto) VALUES('" + proveedor.getNombre() + "', '" + proveedor.getContacto() + "')";
        insertarModificarEliminar(sql);
    }

    public void modificarProveedor(Proveedor proveedor) throws Exception {
        String sql = "UPDATE proveedores SET nombre = '" + proveedor.getNombre() + "', contacto = '" + proveedor.getContacto() + "' WHERE id_proveedor = " + proveedor.getId();
        insertarModificarEliminar(sql);
    }

    public void eliminarProveedor(Proveedor proveedor) throws Exception {
        String sql = "DELETE FROM proveedores WHERE id_proveedor = " + proveedor.getId();
        insertarModificarEliminar(sql);
    }

    public Proveedor buscarProveedorPorId(int id) throws Exception {
        String sql = "SELECT * FROM proveedores WHERE id_proveedor = " + id;
        consultarBase(sql);
        if (resultado.next()) {
            Proveedor proveedor = new Proveedor();
            proveedor.setId(id);
            proveedor.setNombre(resultado.getString(2));
            proveedor.setContacto(resultado.getString(3));
            return proveedor;
        }
        return null;
    }

    public ArrayList<Proveedor> buscarProveedores() throws Exception {
        String sql = "SELECT * FROM proveedores";
        consultarBase(sql);
        ArrayList<Proveedor> proveedores = new ArrayList<>();
        while (resultado.next()) {
            Proveedor proveedor = new Proveedor();
            proveedor.setId(resultado.getInt(1));
            proveedor.setNombre(resultado.getString(2));
            proveedor.setContacto(resultado.getString(3));
            proveedores.add(proveedor);
        }
        return proveedores;
    }
}

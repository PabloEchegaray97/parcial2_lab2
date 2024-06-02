package minimarket.modelos;

import java.util.ArrayList;
import minimarket.entidades.Proveedor;
import minimarket.persistencia.ProveedorDAO;

public class ProveedorModelo {
    private ProveedorDAO proveedorDAO = new ProveedorDAO(this);

    public void ingresarProveedor(Proveedor proveedor) throws Exception {
        proveedorDAO.ingresarProveedor(proveedor);
    }

    public void modificarProveedor(Proveedor proveedor) throws Exception {
        proveedorDAO.modificarProveedor(proveedor);
    }

    public void eliminarProveedor(Proveedor proveedor) throws Exception {
        proveedorDAO.eliminarProveedor(proveedor);
    }

    public Proveedor buscarProveedorPorId(int id) throws Exception {
        return proveedorDAO.buscarProveedorPorId(id);
    }

    public ArrayList<Proveedor> buscarProveedores() throws Exception {
        return proveedorDAO.buscarProveedores();
    }
}

package minimarket.persistencia;

import minimarket.entidades.Cliente;
import minimarket.modelos.ClienteModelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class ClienteDAO extends DAO {
    ClienteModelo clienteModelo;

    public ClienteDAO(ClienteModelo clienteModelo) {
        this.clienteModelo = clienteModelo;
    }

    public void ingresarCliente(Cliente cliente) throws Exception {
        String sql = "INSERT INTO clientes(nombre, direccion) VALUES('" + cliente.getNombre() + "', '" + cliente.getDireccion() + "')";
        insertarModificarEliminar(sql);
    }

    public void modificarCliente(Cliente cliente) throws Exception {
        String sql = "UPDATE clientes SET nombre = '" + cliente.getNombre() + "', direccion = '" + cliente.getDireccion() + "' WHERE id_cliente = " + cliente.getId();
        insertarModificarEliminar(sql);
    }

    public void eliminarCliente(Cliente cliente) throws Exception {
        String sql = "DELETE FROM clientes WHERE id_cliente = " + cliente.getId();
        insertarModificarEliminar(sql);
    }

    public Cliente buscarClientePorId(int id) throws Exception {
        String sql = "SELECT * FROM clientes WHERE id_cliente = " + id;
        consultarBase(sql);
        if (resultado.next()) {
            Cliente cliente = new Cliente();
            cliente.setId(id);
            cliente.setNombre(resultado.getString(2));
            cliente.setDireccion(resultado.getString(3));
            return cliente;
        }
        return null;
    }

    public ArrayList<Cliente> buscarClientes() throws Exception {
        String sql = "SELECT * FROM clientes";
        consultarBase(sql);
        ArrayList<Cliente> clientes = new ArrayList<>();
        while (resultado.next()) {
            Cliente cliente = new Cliente();
            cliente.setId(resultado.getInt(1));
            cliente.setNombre(resultado.getString(2));
            cliente.setDireccion(resultado.getString(3));
            clientes.add(cliente);
        }
        return clientes;
    }
}

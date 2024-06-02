package minimarket.persistencia;

import java.util.ArrayList;
import minimarket.entidades.Cliente;
import minimarket.modelos.ClienteModelo;

public class ClienteDAO extends DAO {
    ClienteModelo clienteModelo;

    public ClienteDAO(ClienteModelo clienteModelo) {
        this.clienteModelo = clienteModelo;
    }

    public void ingresarCliente(Cliente cliente) throws Exception {
        String sql = "INSERT INTO clientes(codigo, razon_social) VALUES(" + cliente.getCodigo() + ", '" + cliente.getRazonSocial() + "')";
        insertarModificarEliminar(sql);
    }

    public void modificarCliente(Cliente cliente) throws Exception {
        String sql = "UPDATE clientes SET razon_social = '" + cliente.getRazonSocial() + "' WHERE codigo = " + cliente.getCodigo();
        insertarModificarEliminar(sql);
    }

    public void eliminarCliente(Cliente cliente) throws Exception {
        String sql = "DELETE FROM clientes WHERE codigo = " + cliente.getCodigo();
        insertarModificarEliminar(sql);
    }

    public Cliente buscarClientePorCodigo(int codigo) throws Exception {
        String sql = "SELECT * FROM clientes WHERE codigo = " + codigo;
        consultarBase(sql);
        if (resultado.next()) {
            Cliente cliente = new Cliente();
            cliente.setCodigo(codigo);
            cliente.setRazonSocial(resultado.getString("razon_social"));
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
            cliente.setCodigo(resultado.getInt("codigo"));
            cliente.setRazonSocial(resultado.getString("razon_social"));
            clientes.add(cliente);
        }
        return clientes;
    }
}

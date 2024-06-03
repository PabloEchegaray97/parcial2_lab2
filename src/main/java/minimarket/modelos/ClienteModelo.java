package minimarket.modelos;

import minimarket.entidades.Cliente;
import minimarket.persistencia.ClienteDAO;

import java.util.ArrayList;

public class ClienteModelo {
    private ClienteDAO clienteDAO = new ClienteDAO(this);

    public void ingresarCliente(Cliente cliente) throws Exception {
        clienteDAO.ingresarCliente(cliente);
    }

    public void modificarCliente(Cliente cliente) throws Exception {
        clienteDAO.modificarCliente(cliente);
    }

    public void eliminarCliente(Cliente cliente) throws Exception {
        clienteDAO.eliminarCliente(cliente);
    }

    public Cliente buscarClientePorId(int id) throws Exception {
        return clienteDAO.buscarClientePorId(id);
    }

    public ArrayList<Cliente> buscarClientes() throws Exception {
        return clienteDAO.buscarClientes();
    }
}

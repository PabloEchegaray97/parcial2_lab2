package minimarket.modelos;

import java.util.ArrayList;
import minimarket.entidades.Cliente;
import minimarket.persistencia.ClienteDAO;

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

    public Cliente buscarClientePorCodigo(int codigo) throws Exception {
        return clienteDAO.buscarClientePorCodigo(codigo);
    }

    public ArrayList<Cliente> buscarClientes() throws Exception {
        return clienteDAO.buscarClientes();
    }
}

package minimarket.controladores;

import minimarket.entidades.Cliente;
import minimarket.modelos.ClienteModelo;

import java.util.List;

public class ClienteControlador {
    private ClienteModelo clienteModelo = new ClienteModelo();

    public void ingresarCliente(String nombre, String direccion) {
        try {
            Cliente cliente = new Cliente();
            cliente.setNombre(nombre);
            cliente.setDireccion(direccion);
            clienteModelo.ingresarCliente(cliente);
            System.out.println("Cliente ingresado exitosamente.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void modificarCliente(int id, String nombre, String direccion) {
        try {
            Cliente cliente = clienteModelo.buscarClientePorId(id);
            if (cliente != null) {
                cliente.setNombre(nombre);
                cliente.setDireccion(direccion);
                clienteModelo.modificarCliente(cliente);
                System.out.println("Cliente modificado exitosamente.");
            } else {
                System.out.println("Cliente no encontrado.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void eliminarCliente(int id) {
        try {
            Cliente cliente = clienteModelo.buscarClientePorId(id);
            if (cliente != null) {
                clienteModelo.eliminarCliente(cliente);
                System.out.println("Cliente eliminado exitosamente.");
            } else {
                System.out.println("Cliente no encontrado.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void mostrarClientePorId(int id) {
        try {
            Cliente cliente = clienteModelo.buscarClientePorId(id);
            if (cliente != null) {
                System.out.println("Cliente encontrado: ");
                System.out.println("ID: " + cliente.getId());
                System.out.println("Nombre: " + cliente.getNombre());
                System.out.println("Dirección: " + cliente.getDireccion());
            } else {
                System.out.println("Cliente no encontrado.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void mostrarTodosLosClientes() {
        try {
            List<Cliente> clientes = clienteModelo.buscarClientes();
            if (clientes != null && !clientes.isEmpty()) {
                System.out.println("Lista de clientes: ");
                for (Cliente cliente : clientes) {
                    System.out.println("ID: " + cliente.getId());
                    System.out.println("Nombre: " + cliente.getNombre());
                    System.out.println("Dirección: " + cliente.getDireccion());
                    System.out.println("---------------------------");
                }
            } else {
                System.out.println("No hay clientes registrados.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

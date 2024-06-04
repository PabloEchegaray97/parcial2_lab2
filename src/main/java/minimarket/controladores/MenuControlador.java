package minimarket.controladores;

import java.util.Scanner;
import javax.swing.JOptionPane;

public class MenuControlador {
    private ClienteControlador clienteControlador = new ClienteControlador();
    private ControladorProducto productoControlador=new ControladorProducto();

    public void mostrarMenuPrincipal() {
        Scanner scanner = new Scanner(System.in);
        int opcion;
        do {
            String eleccion = JOptionPane.showInputDialog("----MENU GENERAL----\n1- Menu Clientes\n2- Menu comanda\n3- Menu Empleado\n4- Menu Producto\n5- Menu Proveedor\n0- Salir");
            opcion = Integer.parseInt(eleccion);
            switch (opcion) {
                case 1:
                    mostrarMenuClientes(scanner);
                    break;
                case 2:
                    mostrarMenuComanda(scanner);
                    break;
                case 3:
                    mostrarMenuEmpleado(scanner);
                    break;
                case 4:
                    mostrarMenuProducto(scanner);
                    break;
                case 5:
                    mostrarMenuProveedor(scanner);
                    break;
                case 0:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
                    break;
            }
        } while (opcion != 0);

        scanner.close();
    }

    private void mostrarMenuClientes(Scanner scanner) {
        int opcion;

        do {
            String eleccion= JOptionPane.showInputDialog("----MENU CLIENTES----\n1. Ingresar Cliente\n2. Modificar Cliente\n3. Eliminar Cliente\n4. Mostrar Cliente por ID\n5. Mostrar Todos los Clientes\n0. Volver al Menú Principal ");
            opcion = Integer.parseInt(eleccion);
            scanner.nextLine();  // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    String nombre = JOptionPane.showInputDialog("Ingrese nombre del cliente: ");
                    String direccion = JOptionPane.showInputDialog("Ingrese direccion del cliente");
                    clienteControlador.ingresarCliente(nombre,direccion);
                    break;
                case 2:

                    String idModificar = JOptionPane.showInputDialog("Ingrese ID del cliente a modificar: ");
                    int id_modificar=Integer.parseInt(idModificar);
                    String nuevoNombre = JOptionPane.showInputDialog("Ingrese nuevo nombre del cliente: ");
                    String nuevaDireccion = JOptionPane.showInputDialog("Ingrese nueva direccion del cliente: ");
                    clienteControlador.modificarCliente(id_modificar, nuevoNombre, nuevaDireccion);
                    break;
                case 3:
                    System.out.print("Ingrese ID del cliente a eliminar: ");
                    String id_eliminar = JOptionPane.showInputDialog("Ingrese ID del cliente a eliminar: ");
                    int idEliminar=Integer.parseInt(id_eliminar);
                    clienteControlador.eliminarCliente(idEliminar);
                    break;
                case 4:
                    System.out.print("Ingrese ID del cliente a mostrar: ");
                    String id_mostrar=JOptionPane.showInputDialog("Ingrese ID del cliente a mostrar: ");
                    int idMostrar = Integer.parseInt(id_mostrar);
                    clienteControlador.mostrarClientePorId(idMostrar);
                    break;
                case 5:
                    clienteControlador.mostrarTodosLosClientes();
                    break;
                case 0:
                    System.out.println("Volviendo al Menú Principal...");
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
                    break;
            }
        } while (opcion != 0);
    }

    private void mostrarMenuComanda(Scanner scanner){
        int opcion;

        do {
            String eleccion= JOptionPane.showInputDialog("----MENU COMANDA----\n1. Ingresar Comanda\n2. Modificar comanda\n3. Buscar comanda\n4. Eliminar comanda\n0. Volver al Menú Principal ");
            opcion = Integer.parseInt(eleccion);
            scanner.nextLine();  // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    break;
                case 2:
                    String idModificar = JOptionPane.showInputDialog("Ingrese ID de la comanda a modificar: ");
                    int id_modificar=Integer.parseInt(idModificar);
                    break;
                case 3:
                    String id_buscar = JOptionPane.showInputDialog("Ingrese ID de la comanda a buscar: ");
                    int idBuscar=Integer.parseInt(id_buscar);
                    break;
                case 4:
                    String id_eliminar=JOptionPane.showInputDialog("Ingrese ID de la comanda a eliminar: ");
                    int idEliminar = Integer.parseInt(id_eliminar);
                    break;
                case 0:
                    System.out.println("Volviendo al Menú Principal...");
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
                    break;
            }
        } while (opcion != 0);
    }

    private void mostrarMenuEmpleado(Scanner scanner){
        int opcion;

        do {
            String eleccion= JOptionPane.showInputDialog("----MENU EMPLEADOS----\n1. Ingresar Empleado\n2. Modificar empleado por ID\n3. Mostrar Todos los empleados\n4. Eliminar empleado\n0. Volver al Menú Principal ");
            opcion = Integer.parseInt(eleccion);
            scanner.nextLine();  // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    String nombre = JOptionPane.showInputDialog("Ingrese nombre del empleado: ");
                    String puesto = JOptionPane.showInputDialog("Ingrese puesto del empleado: ");
                    break;
                case 2:

                    String idModificar = JOptionPane.showInputDialog("Ingrese ID del empleado a modificar: ");
                    int id_modificar=Integer.parseInt(idModificar);
                    String nuevoNombre = JOptionPane.showInputDialog("Ingrese nuevo nombre del empleado: ");
                    String nuevoPuesto = JOptionPane.showInputDialog("Ingrese nuevo puesto del empleado: ");
                    break;
                case 3:
                    break;
                case 4:
                    String id_eliminar=JOptionPane.showInputDialog("Ingrese ID del empleado a eliminar: ");
                    int idEliminar= Integer.parseInt(id_eliminar);
                    break;
                case 0:
                    System.out.println("Volviendo al Menú Principal...");
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
                    break;
            }
        } while (opcion != 0);
    }

    private void mostrarMenuProducto(Scanner scanner){
        int opcion;

        do {
            String eleccion= JOptionPane.showInputDialog("----MENU PRODUCTOS----\n1. Ingresar Producto\n2. Modificar Producto\n3. Buscar producto\n4. Eliminar producto\n0. Volver al Menú Principal ");
            opcion = Integer.parseInt(eleccion);
            scanner.nextLine();  // Consumir el salto de línea

            switch (opcion) {
                case 1:

                    String nombre = JOptionPane.showInputDialog("Ingrese nombre del producto: ");
                    String price = JOptionPane.showInputDialog("Ingrese precio del producto: ");
                    double precio=Integer.parseInt(price);
                    String cant = JOptionPane.showInputDialog("Ingrese stock del producto: ");
                    int stock=Integer.parseInt(cant);
                    productoControlador.ingresarProducto(nombre,precio,stock);

                    break;
                case 2:
                    String idModificar = JOptionPane.showInputDialog("Ingrese ID del producto a modificar: ");
                    int id_modificar=Integer.parseInt(idModificar);
                    String nombrem = JOptionPane.showInputDialog("Ingrese nombre del producto: ");
                    String pricem = JOptionPane.showInputDialog("Ingrese precio del producto: ");
                    double preciom=Integer.parseInt(pricem);
                    String cantm = JOptionPane.showInputDialog("Ingrese stock del producto: ");
                    int stockm=Integer.parseInt(cantm);
                    break;
                case 3:
                    String id_buscar = JOptionPane.showInputDialog("Ingrese ID del producto a buscar: ");
                    int idBuscar=Integer.parseInt(id_buscar);
                    break;
                case 4:
                    String id_eliminar=JOptionPane.showInputDialog("Ingrese ID del producto a eliminar: ");
                    int idEliminar = Integer.parseInt(id_eliminar);
                    break;
                case 0:
                    System.out.println("Volviendo al Menú Principal...");
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
                    break;
            }
        } while (opcion != 0);
    }

    private void mostrarMenuProveedor(Scanner scanner){
        int opcion;

        do {
            String eleccion= JOptionPane.showInputDialog("----MENU PROVEEDOR----\n1. Ingresar Proveerdor\n2. Modificar Proveedor\n3. Buscar proveedor\n4. Eliminar proveedor\n0. Volver al Menú Principal ");
            opcion = Integer.parseInt(eleccion);
            scanner.nextLine();  // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    String nombre = JOptionPane.showInputDialog("Ingrese nombre del proveedor: ");
                    break;
                case 2:
                    String idModificar = JOptionPane.showInputDialog("Ingrese ID del proveedor a modificar: ");
                    int id_modificar=Integer.parseInt(idModificar);
                    String nombrem = JOptionPane.showInputDialog("Ingrese nombre del producto: ");
                    break;
                case 3:
                    String id_buscar = JOptionPane.showInputDialog("Ingrese ID del proveedor a buscar: ");
                    int idBuscar=Integer.parseInt(id_buscar);
                    break;
                case 4:
                    String id_eliminar=JOptionPane.showInputDialog("Ingrese ID del proveedor a eliminar: ");
                    int idEliminar = Integer.parseInt(id_eliminar);
                    break;
                case 0:
                    System.out.println("Volviendo al Menú Principal...");
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
                    break;
            }
        } while (opcion != 0);
    }

}

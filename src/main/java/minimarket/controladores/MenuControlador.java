package minimarket.controladores;

import java.util.Scanner;

public class MenuControlador {
    private ClienteControlador clienteControlador = new ClienteControlador();

    public void mostrarMenuPrincipal() {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("------ Menú Principal ------");
            System.out.println("1. Menú Clientes");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();  // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    mostrarMenuClientes(scanner);
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
            System.out.println("------ Menú Clientes ------");
            System.out.println("1. Ingresar Cliente");
            System.out.println("2. Modificar Cliente");
            System.out.println("3. Eliminar Cliente");
            System.out.println("4. Mostrar Cliente por ID");
            System.out.println("5. Mostrar Todos los Clientes");
            System.out.println("0. Volver al Menú Principal");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();  // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese nombre del cliente: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Ingrese dirección del cliente: ");
                    String direccion = scanner.nextLine();
                    clienteControlador.ingresarCliente(nombre, direccion);
                    break;
                case 2:
                    System.out.print("Ingrese ID del cliente a modificar: ");
                    int idModificar = scanner.nextInt();
                    scanner.nextLine();  // Consumir el salto de línea
                    System.out.print("Ingrese nuevo nombre del cliente: ");
                    String nuevoNombre = scanner.nextLine();
                    System.out.print("Ingrese nueva dirección del cliente: ");
                    String nuevaDireccion = scanner.nextLine();
                    clienteControlador.modificarCliente(idModificar, nuevoNombre, nuevaDireccion);
                    break;
                case 3:
                    System.out.print("Ingrese ID del cliente a eliminar: ");
                    int idEliminar = scanner.nextInt();
                    clienteControlador.eliminarCliente(idEliminar);
                    break;
                case 4:
                    System.out.print("Ingrese ID del cliente a mostrar: ");
                    int idMostrar = scanner.nextInt();
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
}

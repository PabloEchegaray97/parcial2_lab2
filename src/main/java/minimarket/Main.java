package minimarket;

import minimarket.persistencia.DAO;
import minimarket.modelos.ClienteModelo;
import java.util.Scanner;

public class Main {

    public static void crearTablas() throws Exception {
        DAO dao = new DAO() {};  // Instancia anónima de DAO para usar sus métodos

        String sqlClientes = "CREATE TABLE IF NOT EXISTS clientes (" +
                "codigo INT PRIMARY KEY," +
                "razon_social VARCHAR(255) NOT NULL" +
                ")";

        String sqlProductos = "CREATE TABLE IF NOT EXISTS productos (" +
                "id INT PRIMARY KEY," +
                "nombre VARCHAR(255) NOT NULL," +
                "precio DECIMAL(10, 2) NOT NULL," +
                "stock INT NOT NULL" +
                ")";

        String sqlProveedores = "CREATE TABLE IF NOT EXISTS proveedores (" +
                "id INT PRIMARY KEY," +
                "nombre VARCHAR(255) NOT NULL" +
                ")";

        String sqlEmpleados = "CREATE TABLE IF NOT EXISTS empleados (" +
                "id INT PRIMARY KEY," +
                "nombre VARCHAR(255) NOT NULL," +
                "puesto VARCHAR(255) NOT NULL" +
                ")";

        String sqlComandas = "CREATE TABLE IF NOT EXISTS comandas (" +
                "id INT PRIMARY KEY," +
                "id_producto INT NOT NULL," +
                "cantidad INT NOT NULL" +
                ")";

        dao.insertarModificarEliminar(sqlClientes);
        dao.insertarModificarEliminar(sqlProductos);
        dao.insertarModificarEliminar(sqlProveedores);
        dao.insertarModificarEliminar(sqlEmpleados);
        dao.insertarModificarEliminar(sqlComandas);
    }

    public static void main(String[] args) {
        try {
            crearTablas();
        } catch (Exception e) {
            System.out.println("Error al crear las tablas: " + e.getMessage());
        }

        Scanner scanner = new Scanner(System.in);
        ClienteModelo clienteModelo = new ClienteModelo();

        while (true) {
            System.out.println("Menú principal:");
            System.out.println("1. Vender/Cobrar un producto");
            System.out.println("2. Ingreso de mercadería");
            System.out.println("3. Pago a proveedor");
            System.out.println("4. Consulta de ventas");
            System.out.println("    a. Diaria");
            System.out.println("    b. Mensual");
            System.out.println("5. Balance (mostrar ganancias y pérdidas)");
            System.out.println("6. Solicitar una comanda a la cocina");
            System.out.println("7. Pagar cuenta");
            System.out.println("8. Información estadística de platos más pedidos");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine();  // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    // Lógica para vender/cobrar un producto
                    break;
                case 2:
                    // Lógica para ingreso de mercadería
                    break;
                case 3:
                    // Lógica para pago a proveedor
                    break;
                case 4:
                    // Lógica para consulta de ventas
                    break;
                case 5:
                    // Lógica para balance
                    break;
                case 6:
                    // Lógica para solicitar una comanda a la cocina
                    break;
                case 7:
                    // Lógica para pagar cuenta
                    break;
                case 8:
                    // Lógica para información estadística de platos más pedidos
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
                    break;
            }
        }
    }
}

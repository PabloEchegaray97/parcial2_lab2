package minimarket;
import minimarket.controladores.MenuControlador;

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
            MenuControlador menu = new MenuControlador();
            menu.mostrarMenuPrincipal();
        }
    }
}

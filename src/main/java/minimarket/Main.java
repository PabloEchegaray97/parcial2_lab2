package minimarket;
import minimarket.controladores.Funciones;
import minimarket.controladores.MenuControlador;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {
        Connection conexion = null;
        try {
            try {
                boolean crear_Tabla=Funciones.CuadroDialogoVoF("Desea crear la DB:","Base de datos");
                if(crear_Tabla){
                    MenuControlador.crearTablas();
                }
            } catch (Exception e) {
                System.out.println("Error al crear las tablas: " + e.getMessage());
            }
            while (true) {
                MenuControlador menu = new MenuControlador();
                menu.mostrarMenuPrincipal();
            }
        } finally { // Se cierra la conexión con la base de datos.
            System.out.println("Finalizado");
            try {
                if (conexion != null) {
                    conexion.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }

    }

}

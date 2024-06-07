package minimarket;
import minimarket.controladores.Funciones;
import minimarket.controladores.MenuControlador;
import minimarket.controladores.Menu_Usuario;

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

            try {
                int opcion = -2; //Opcion a elegir
                String[] Botones = new String[] {"Usuario", "Aministrador"};
                String mensaje = "Ingresar como:";
                String titulo ="LOGIN";

                //------------------------------------OPCIONES-------------------------------------------
                do{
                    opcion = Funciones.OpcionesMenu(Botones, mensaje, titulo)+1;
                    switch (opcion) {
                        case 1:
                            Menu_Usuario menu_Usuario = new Menu_Usuario();
                            menu_Usuario.mostrarMenuPrincipal();
                            break;
                        case 2:
                            MenuControlador menu = new MenuControlador();
                            menu.mostrarMenuPrincipal();
                            break;
                        default:
                            System.out.println("Cerrando la sistema...");
                            System.exit(0);
                            break;
                    }
                }while(opcion != -1);//V
            } catch (Exception e) {
                System.out.println("Error al crear las tablas: " + e.getMessage());
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

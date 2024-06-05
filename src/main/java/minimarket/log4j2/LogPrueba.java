package minimarket.log4j2;

import minimarket.entidades.Comanda;
import minimarket.entidades.Empleado;
import minimarket.entidades.Producto;
import java.util.ArrayList;
import java.util.Scanner;
import static minimarket.log4j2.log4j2.*;
public class LogPrueba {

        public void mostrarMenuLogs() {
            Scanner scanner = new Scanner(System.in);
            int opcion;

            do {
                System.out.println("\nMenú de Logs");
                System.out.println("1. Balance Diario");
                System.out.println("2. Error en Transacción");
                System.out.println("3. Comanda Solicitada");
                System.out.println("4. Salir");
                System.out.print("Ingrese una opción: ");
                opcion = scanner.nextInt();

                switch (opcion) {
                    case 1:
                        generarLogBalanceDiario();
                        break;
                    case 2:
                        generarLogErrorTransaccion();
                        break;
                    case 3:
                        generarLogComandaSolicitada();
                        break;
                    case 4:
                        System.out.println("Saliendo del menú de logs...");
                        break;
                    default:
                        System.out.println("Opción inválida. Por favor, intente de nuevo.");
                }

            } while (opcion!= 4);
        }

        private void generarLogBalanceDiario() {
            double ingresos = 112696.50;
            double egresos = 356900;

            try {
                logBalanceDiario(ingresos, egresos);
                System.out.println("Log de balance diario generado con éxito.");
            } catch (Exception e) {
                System.out.println("Error al generar el log de balance diario: " + e.getMessage());
            }
        }

        private void generarLogErrorTransaccion() {
            try {
                logErrorTransaccion();
                System.out.println("Log de error en transacción generado con éxito.");
            } catch (Exception e) {
                System.out.println("Error al generar el log de error en transacción: " + e.getMessage());
            }
        }

        private void generarLogComandaSolicitada() {
            ArrayList<Producto> listaProducto = new ArrayList<>();
            listaProducto.add(new Producto("Coca-Cola"));
            listaProducto.add(new Producto("Arroz"));
            listaProducto.add(new Producto("Arvegas"));
            listaProducto.add(new Producto("Leche"));
            listaProducto.add(new Producto("Cafe"));
            Comanda comandaIngresada = new Comanda(1, 1025, listaProducto, new Empleado("Emanuel"));

            try {
                logComandaSolicitada(comandaIngresada);
                System.out.println("Log de comanda solicitada generado con éxito.");
            } catch (Exception e) {
                System.out.println("Error al generar el log de comanda solicitada: " + e.getMessage());
            }
        }
    }


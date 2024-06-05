package minimarket.log4j2;

import minimarket.entidades.Comanda;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class log4j2 {
    private static final Logger loggerComanda = LogManager.getLogger("EmailLogger");
    private static final Logger loggerBalance = LogManager.getLogger("FileLogger");
    private static final Logger loggerError = LogManager.getLogger("ConsoleLogger");

    //Logger balance diaria salida por archivo
        public static void logBalanceDiario(double perdidas, double ganancia){
            loggerBalance.info("Perdida: " + perdidas+ " Ganancia " + ganancia + " Total: " + (ganancia - perdidas));
        }
    //Logger error al generara transaccion salida por consola
        public static void logErrorTransaccion(){
            loggerError.error("Error al procesar la transacción");
    }
    //logger comanda solicitada salida por mail
    public static void logComandaSolicitada(Comanda comanSolicitada) {
            String ProductosComanda = "";
            for (int i = 0; i < comanSolicitada.getProductos().size(); i++) {
                ProductosComanda += comanSolicitada.getProductos().get(i).getNombre() + "\n";
            }
            loggerComanda.debug("Comanda Procesada con Exito.\nDetalle Comanda\n"+  "Nro: " +comanSolicitada.getId()+ "\n"+
                               "Empleado : "+ comanSolicitada.getEmpleado().getNombre()+ "\n"+
                              "Productos:\n"+ ProductosComanda);
    }
}

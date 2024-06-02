package minimarket.modelos;

import java.util.ArrayList;
import minimarket.entidades.Comanda;
import minimarket.persistencia.ComandaDAO;

public class ComandaModelo {
    private ComandaDAO comandaDAO = new ComandaDAO(this);

    public void ingresarComanda(Comanda comanda) throws Exception {
        comandaDAO.ingresarComanda(comanda);
    }

    public void modificarComanda(Comanda comanda) throws Exception {
        comandaDAO.modificarComanda(comanda);
    }

    public void eliminarComanda(Comanda comanda) throws Exception {
        comandaDAO.eliminarComanda(comanda);
    }

    public Comanda buscarComandaPorId(int id) throws Exception {
        return comandaDAO.buscarComandaPorId(id);
    }

    public ArrayList<Comanda> buscarComandas() throws Exception {
        return comandaDAO.buscarComandas();
    }
}

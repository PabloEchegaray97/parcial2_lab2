package minimarket.modelos;

import minimarket.entidades.Comanda;
import minimarket.persistencia.ComandaDAO;

import java.util.List;

public class ComandaModelo {
    private ComandaDAO comandaDAO = new ComandaDAO();

    public void ingresarComanda(Comanda comanda) throws Exception {
        comandaDAO.ingresarComanda(comanda);
    }

    public List<Comanda> buscarComandas() throws Exception {
        return comandaDAO.buscarComandas();
    }

    public Comanda buscarComandaPorId(int id) throws Exception {
        return comandaDAO.buscarComandaPorId(id);
    }

    public void modificarComanda(Comanda comanda) throws Exception {
        comandaDAO.modificarComanda(comanda);
    }

    public void eliminarComanda(int id) throws Exception {
        comandaDAO.eliminarComanda(id);
    }
}

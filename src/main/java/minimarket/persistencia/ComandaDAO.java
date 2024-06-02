package minimarket.persistencia;

import java.util.ArrayList;
import minimarket.entidades.Comanda;
import minimarket.modelos.ComandaModelo;

public class ComandaDAO extends DAO {
    ComandaModelo comandaModelo;

    public ComandaDAO(ComandaModelo comandaModelo) {
        this.comandaModelo = comandaModelo;
    }

    public void ingresarComanda(Comanda comanda) throws Exception {
        String sql = "INSERT INTO comandas(id_producto, cantidad) VALUES(" + comanda.getIdProducto() + ", " + comanda.getCantidad() + ")";
        insertarModificarEliminar(sql);
    }

    public void modificarComanda(Comanda comanda) throws Exception {
        String sql = "UPDATE comandas SET id_producto = " + comanda.getIdProducto() + ", cantidad = " + comanda.getCantidad() + " WHERE id_comanda = " + comanda.getId();
        insertarModificarEliminar(sql);
    }

    public void eliminarComanda(Comanda comanda) throws Exception {
        String sql = "DELETE FROM comandas WHERE id_comanda = " + comanda.getId();
        insertarModificarEliminar(sql);
    }

    public Comanda buscarComandaPorId(int id) throws Exception {
        String sql = "SELECT * FROM comandas WHERE id_comanda = " + id;
        consultarBase(sql);
        if (resultado.next()) {
            Comanda comanda = new Comanda();
            comanda.setId(id);
            comanda.setIdProducto(resultado.getInt(2));
            comanda.setCantidad(resultado.getInt(3));
            return comanda;
        }
        return null;
    }

    public ArrayList<Comanda> buscarComandas() throws Exception {
        String sql = "SELECT * FROM comandas";
        consultarBase(sql);
        ArrayList<Comanda> comandas = new ArrayList<>();
        while (resultado.next()) {
            Comanda comanda = new Comanda();
            comanda.setId(resultado.getInt(1));
            comanda.setIdProducto(resultado.getInt(2));
            comanda.setCantidad(resultado.getInt(3));
            comandas.add(comanda);
        }
        return comandas;
    }
}

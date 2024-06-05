package minimarket.entidades;

import java.util.List;

public class Empleado {
    private int id;
    private String nombre;
    private String puesto;
    private List<Comanda> comandas;

    public Empleado(String nombre) {
        this.nombre = nombre;
    }
    public Empleado() {
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public List<Comanda> getComandas() {
        return comandas;
    }

    public void setComandas(List<Comanda> comandas) {
        this.comandas = comandas;
    }
}

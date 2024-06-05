package minimarket.entidades;

import java.util.List;

public class Comanda {
    private int id;
    private int idEmpleado;
    private List<Producto> productos;

    private Empleado empleado;

    public Comanda(int id, int idEmpleado, List<Producto> productos, Empleado empleado) {
        this.id = id;
        this.idEmpleado = idEmpleado;
        this.productos = productos;
        this.empleado = empleado;
    }

    public Comanda() {
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }
}

package minimarket.persistencia;

import java.util.ArrayList;
import minimarket.entidades.Empleado;
import minimarket.modelos.EmpleadoModelo;

public class EmpleadoDAO extends DAO {
    EmpleadoModelo empleadoModelo;

    public EmpleadoDAO(EmpleadoModelo empleadoModelo) {
        this.empleadoModelo = empleadoModelo;
    }

    public void ingresarEmpleado(Empleado empleado) throws Exception {
        String sql = "INSERT INTO empleados(nombre, puesto) VALUES('" + empleado.getNombre() + "', '" + empleado.getPuesto() + "')";
        insertarModificarEliminar(sql);
    }

    public void modificarEmpleado(Empleado empleado) throws Exception {
        String sql = "UPDATE empleados SET nombre = '" + empleado.getNombre() + "', puesto = '" + empleado.getPuesto() + "' WHERE id_empleado = " + empleado.getId();
        insertarModificarEliminar(sql);
    }

    public void eliminarEmpleado(Empleado empleado) throws Exception {
        String sql = "DELETE FROM empleados WHERE id_empleado = " + empleado.getId();
        insertarModificarEliminar(sql);
    }

    public Empleado buscarEmpleadoPorId(int id) throws Exception {
        String sql = "SELECT * FROM empleados WHERE id_empleado = " + id;
        consultarBase(sql);
        if (resultado.next()) {
            Empleado empleado = new Empleado();
            empleado.setId(id);
            empleado.setNombre(resultado.getString(2));
            empleado.setPuesto(resultado.getString(3));
            return empleado;
        }
        return null;
    }

    public ArrayList<Empleado> buscarEmpleados() throws Exception {
        String sql = "SELECT * FROM empleados";
        consultarBase(sql);
        ArrayList<Empleado> empleados = new ArrayList<>();
        while (resultado.next()) {
            Empleado empleado = new Empleado();
            empleado.setId(resultado.getInt(1));
            empleado.setNombre(resultado.getString(2));
            empleado.setPuesto(resultado.getString(3));
            empleados.add(empleado);
        }
        return empleados;
    }
}

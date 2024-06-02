package minimarket.modelos;

import java.util.ArrayList;
import minimarket.entidades.Empleado;
import minimarket.persistencia.EmpleadoDAO;

public class EmpleadoModelo {
    private EmpleadoDAO empleadoDAO = new EmpleadoDAO(this);

    public void ingresarEmpleado(Empleado empleado) throws Exception {
        empleadoDAO.ingresarEmpleado(empleado);
    }

    public void modificarEmpleado(Empleado empleado) throws Exception {
        empleadoDAO.modificarEmpleado(empleado);
    }

    public void eliminarEmpleado(Empleado empleado) throws Exception {
        empleadoDAO.eliminarEmpleado(empleado);
    }

    public Empleado buscarEmpleadoPorId(int id) throws Exception {
        return empleadoDAO.buscarEmpleadoPorId(id);
    }

    public ArrayList<Empleado> buscarEmpleados() throws Exception {
        return empleadoDAO.buscarEmpleados();
    }
}

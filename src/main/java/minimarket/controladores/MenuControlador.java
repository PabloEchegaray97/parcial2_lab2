package minimarket.controladores;
import minimarket.persistencia.DAO;
import javax.swing.JOptionPane;

public class MenuControlador {
    private ClienteControlador clienteControlador = new ClienteControlador();
    private ControladorProducto productoControlador=new ControladorProducto();
    private ComandaControlador comandaControlador=new ComandaControlador();
    private proveedorControlador proveedorControlador=new proveedorControlador();

    public static void crearTablas() throws Exception {
        DAO dao = new DAO() {};  // Instancia anónima de DAO para usar sus métodos

        String sqlClientes = "CREATE TABLE IF NOT EXISTS clientes (" +
                "id_cliente INT PRIMARY KEY," +
                "nombre VARCHAR(255) NOT NULL," +
                "direccion VARCHAR(255) NOT NULL" +
                ")";

        String sqlProductos = "CREATE TABLE IF NOT EXISTS productos (" +
                "id_producto INT PRIMARY KEY," +
                "nombre VARCHAR(255) NOT NULL," +
                "precio DECIMAL(10, 2) NOT NULL," +
                "stock INT NOT NULL" +
                ")";

        String sqlProveedores = "CREATE TABLE IF NOT EXISTS proveedores (" +
                "id_proveedor INT PRIMARY KEY," +
                "nombre VARCHAR(255) NOT NULL," +
                "contacto VARCHAR(255) NOT NULL" +
                ")";

        String sqlEmpleados = "CREATE TABLE IF NOT EXISTS empleados (" +
                "id_empleado INT PRIMARY KEY," +
                "nombre VARCHAR(255) NOT NULL," +
                "puesto VARCHAR(255) NOT NULL" +
                ")";

        String sqlComandas = "CREATE TABLE IF NOT EXISTS comandas (" +
                "id_Comanda INT PRIMARY KEY," +
                "id_producto INT NOT NULL," +
                "cantidad INT NOT NULL" +
                ")";

        dao.insertarModificarEliminar(sqlClientes);
        dao.insertarModificarEliminar(sqlProductos);
        dao.insertarModificarEliminar(sqlProveedores);
        dao.insertarModificarEliminar(sqlEmpleados);
        dao.insertarModificarEliminar(sqlComandas);
    }

    public void mostrarMenuPrincipal() {

        int opcion = -2; //Opcion a elegir
        String[] Botones = new String[] {"Clientes", "Comanda", "Empleado", "Producto", "Proveedor"};
        String mensaje = "Clientes: Menu Clientes\nComanda: Menu Comanda\nEmpleado: Menu Empleado\nProducto: Menu Producto\nProveedor: Menu Proveedor";
        String titulo ="MENU GENERAL";

        //------------------------------------OPCIONES-------------------------------------------
        do{
            opcion = Funciones.OpcionesMenu(Botones, mensaje, titulo)+1;
            switch (opcion) {
                case 1:
                    mostrarMenuClientes();
                    break;
                case 2:
                    mostrarMenuComanda();
                    break;
                case 3:
                    mostrarMenuEmpleado();
                    break;
                case 4:
                    mostrarMenuProducto();
                    break;
                case 5:
                    mostrarMenuProveedor();
                    break;
                default:
                    System.out.println("Cerrando la sistema...");
                    System.exit(0);
                    break;
            }
        }while(opcion != -1);//V

    }

    private void mostrarMenuClientes() {

        int opcion = -2; //Opcion a elegir
        String[] Botones = new String[] {"Ingresar", "Modificar", "Eliminar", "Mostrar C", "Mostrar T", "Volver"};
        String mensaje = "Ingresar: Ingresar Cliente\nModificar: Modificar Cliente\nEliminar: Eliminar Cliente\nMostrar C: Mostrar Cliente por ID\nMostrar T: Mostrar Todos los Clientes\nVolver: Volver al Menú Principal";
        String titulo ="MENU CLIENTES";

        //------------------------------------OPCIONES-------------------------------------------
        do{
            opcion = Funciones.OpcionesMenu(Botones, mensaje, titulo)+1;
            switch (opcion) {
                case 1:
                    String nombre = Funciones.InputDialogNoVacio("Ingrese nombre del cliente: ");
                    String direccion = Funciones.InputDialogNoVacio("Ingrese direccion del cliente: ");
                    clienteControlador.ingresarCliente(nombre,direccion);
                    break;
                case 2:

                    String idModificar = Funciones.InputDialogNoVacio("Ingrese ID del cliente a modificar: ");
                    int id_modificar=Integer.parseInt(idModificar);
                    String nuevoNombre = Funciones.InputDialogNoVacio("Ingrese nuevo nombre del cliente: ");
                    String nuevaDireccion = Funciones.InputDialogNoVacio("Ingrese nueva direccion del cliente: ");
                    clienteControlador.modificarCliente(id_modificar, nuevoNombre, nuevaDireccion);
                    break;
                case 3:
                    System.out.print("Ingrese ID del cliente a eliminar: ");
                    String id_eliminar = Funciones.InputDialogNoVacio("Ingrese ID del cliente a eliminar: ");
                    int idEliminar=Integer.parseInt(id_eliminar);
                    clienteControlador.eliminarCliente(idEliminar);
                    break;
                case 4:
                    System.out.print("Ingrese ID del cliente a mostrar: ");
                    String id_mostrar=Funciones.InputDialogNoVacio("Ingrese ID del cliente a mostrar: ");
                    int idMostrar = Integer.parseInt(id_mostrar);
                    clienteControlador.mostrarClientePorId(idMostrar);
                    break;
                case 5:
                    clienteControlador.mostrarTodosLosClientes();
                    break;
                case 6:
                    System.out.println("Volviendo al Menú Principal...");
                    mostrarMenuPrincipal();
                    break;
                default:
                    System.out.println("Cerrando la sistema...");
                    System.exit(0);
                    break;
            }
        }while(opcion != -1);//V
    }

    private void mostrarMenuComanda(){

        int opcion = -2; //Opcion a elegir
        String[] Botones = new String[] {"Ingresar", "Modificar", "Mostrar", "Eliminar", "Volver"};
        String mensaje = "Ingresar: Ingresar Comanda\\Modificar: Modificar comanda\\Mostrar C: Buscar comanda\\Eliminar: Eliminar comanda\\Volver: Volver al Menú Principal";
        String titulo ="MENU COMANDA";

        //------------------------------------OPCIONES-------------------------------------------
        do{
            opcion = Funciones.OpcionesMenu(Botones, mensaje, titulo)+1;
            switch (opcion) {
                case 1:
                    comandaControlador.crearComanda();
                    break;
                case 2:
                    String idModificar = Funciones.InputDialogNoVacio("Ingrese ID de la comanda a modificar: ");
                    int id_modificar=Integer.parseInt(idModificar);
                    comandaControlador.modificarLista(id_modificar);
                    break;
                case 3:
                    String id_buscar = Funciones.InputDialogNoVacio("Ingrese ID de la comanda a buscar: ");
                    int idBuscar=Integer.parseInt(id_buscar);
                    comandaControlador.mostrarComanda(idBuscar);
                    break;
                case 4:
                    String id_eliminar=Funciones.InputDialogNoVacio("Ingrese ID de la comanda a eliminar: ");
                    int idEliminar = Integer.parseInt(id_eliminar);
                    comandaControlador.eliminarComanda(idEliminar);
                    break;
                case 5:
                    System.out.println("Volviendo al Menú Principal...");
                    mostrarMenuPrincipal();
                    break;
                default:
                    System.out.println("Cerrando la sistema...");
                    System.exit(0);
                    break;
            }
        }while(opcion != -1);//V
    }

    private void mostrarMenuEmpleado(){
        int opcion = -2; //Opcion a elegir
        String[] Botones = new String[] {"Ingresar", "Mod por ID", "Mostrar", "Eliminar", "Volver"};
        String mensaje = "Ingresar: Ingresar Empleado\\Mod por ID: Modificar empleado por ID\\Mostrar: Mostrar Todos los empleados\\Eliminar Eliminar empleado\\Volver: Volver al Menú Principal";
        String titulo ="MENU EMPLEADOS";

        //------------------------------------OPCIONES-------------------------------------------
        do{
            opcion = Funciones.OpcionesMenu(Botones, mensaje, titulo)+1;

            switch (opcion) {
                case 1:
                    String nombre = Funciones.InputDialogNoVacio("Ingrese nombre del empleado: ");
                    String puesto = Funciones.InputDialogNoVacio("Ingrese puesto del empleado: ");
                    break;
                case 2:

                    String idModificar = Funciones.InputDialogNoVacio("Ingrese ID del empleado a modificar: ");
                    int id_modificar=Integer.parseInt(idModificar);
                    String nuevoNombre = Funciones.InputDialogNoVacio("Ingrese nuevo nombre del empleado: ");
                    String nuevoPuesto = Funciones.InputDialogNoVacio("Ingrese nuevo puesto del empleado: ");
                    break;
                case 3:
                    break;
                case 4:
                    String id_eliminar=Funciones.InputDialogNoVacio("Ingrese ID del empleado a eliminar: ");
                    int idEliminar= Integer.parseInt(id_eliminar);
                    break;
                case 5:
                    System.out.println("Volviendo al Menú Principal...");
                    mostrarMenuPrincipal();
                    break;
                default:
                    System.out.println("Cerrando la sistema...");
                    System.exit(0);
                    break;
            }
        }while(opcion != -1);//V
    }

    private void mostrarMenuProducto(){
        int opcion = -2; //Opcion a elegir
        String[] Botones = new String[] {"Ingresar", "Modificar", "Mostrar", "Eliminar", "Volver"};
        String mensaje = "Ingresar: Ingresar Producto\\Modificar: Modificar Producto\\Mostrar: Buscar producto\\Eliminar: Eliminar producto\\Volver: Volver al Menú Principal";
        String titulo ="MENU PRODUCTOS";

        //------------------------------------OPCIONES-------------------------------------------
        do{
            opcion = Funciones.OpcionesMenu(Botones, mensaje, titulo)+1;
            switch (opcion) {
                case 1:

                    String nombre = Funciones.InputDialogNoVacio("Ingrese nombre del producto: ");
                    String price = Funciones.InputDialogNoVacio("Ingrese precio del producto: ");
                    double precio=Integer.parseInt(price);
                    String cant = Funciones.InputDialogNoVacio("Ingrese stock del producto: ");
                    int stock=Integer.parseInt(cant);

                    productoControlador.ingresarProducto(nombre,precio,stock);

                    break;
                case 2:
                    String idModificar = Funciones.InputDialogNoVacio("Ingrese ID del producto a modificar: ");
                    int id_modificar=Integer.parseInt(idModificar);
                    String nombrem = Funciones.InputDialogNoVacio("Ingrese nombre del producto: ");
                    String pricem = Funciones.InputDialogNoVacio("Ingrese precio del producto: ");
                    double preciom=Integer.parseInt(pricem);
                    String cantm = Funciones.InputDialogNoVacio("Ingrese stock del producto: ");
                    int stockm=Integer.parseInt(cantm);

                    productoControlador.modificarProducto(id_modificar,nombrem,preciom,stockm);
                    break;
                case 3:
                    String id_buscar = Funciones.InputDialogNoVacio("Ingrese ID del producto a buscar: ");
                    int idBuscar=Integer.parseInt(id_buscar);

                    productoControlador.buscarProductoPorId(idBuscar);
                    break;
                case 4:
                    String id_eliminar=Funciones.InputDialogNoVacio("Ingrese ID del producto a eliminar: ");
                    int idEliminar = Integer.parseInt(id_eliminar);

                    productoControlador.eliminarProducto(idEliminar);
                    break;
                case 5:
                    System.out.println("Volviendo al Menú Principal...");
                    mostrarMenuPrincipal();
                    break;
                default:
                    System.out.println("Cerrando la sistema...");
                    System.exit(0);
                    break;
            }
        }while(opcion != -1);//V
    }

    private void mostrarMenuProveedor(){
        int opcion = -2; //Opcion a elegir
        String[] Botones = new String[] {"Ingresar", "Modificar", "Mostrar", "Eliminar", "Volver"};
        String mensaje = "Ingresar: Ingresar Proveerdor\\Modificar: Modificar Proveedor\\Mostrar: Buscar proveedor\\Eliminar: Eliminar proveedor\\Volver: Volver al Menú Principal";
        String titulo ="MENU PROVEEDOR";

        //------------------------------------OPCIONES-------------------------------------------
        do{
            opcion = Funciones.OpcionesMenu(Botones, mensaje, titulo)+1;
            // Ingresar Proveerdor\n2. Modificar Proveedor\n3. mostrar proveedor\n4. Eliminar proveedor\n0. Volver al Menú Principal ");
            switch (opcion) {
                case 1:
                    String nombre = JOptionPane.showInputDialog("Ingrese nombre del proveedor: ");
                    proveedorControlador.crearProveedor(nombre);
                    break;
                case 2:
                    String idModificar = JOptionPane.showInputDialog("Ingrese ID del proveedor a modificar: ");
                    int id_modificar=Integer.parseInt(idModificar);
                    String nombrem = JOptionPane.showInputDialog("Ingrese nombre del producto: ");
                    proveedorControlador.modificarLista(id_modificar,nombrem);
                    break;
                case 3:
                    String id_buscar = JOptionPane.showInputDialog("Ingrese ID del proveedor a mostrar: ");
                    int idBuscar=Integer.parseInt(id_buscar);
                    proveedorControlador.mostrarProveedor(idBuscar);
                    break;
                case 4:
                    String id_eliminar=JOptionPane.showInputDialog("Ingrese ID del proveedor a eliminar: ");
                    int idEliminar = Integer.parseInt(id_eliminar);
                    break;
                case 5:
                    System.out.println("Volviendo al Menú Principal...");
                    mostrarMenuPrincipal();
                    break;
                default:
                    System.out.println("Cerrando la sistema...");
                    System.exit(0);
                    break;
            }
        }while(opcion != -1);//V
    }

}

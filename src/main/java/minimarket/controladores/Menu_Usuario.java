package minimarket.controladores;

public class Menu_Usuario {

    public void mostrarMenuPrincipal() {

        int opcion = -2; //Opcion a elegir
        String[] Botones = new String[] {"cobrar", "Ingresar", "Pago", "ventas", "balance", "comanda", "pagar", "platos" };
        String mensaje = "Clientes: Menu Principal\nVender:cobrar\nIngreso:mercaderia\nPago a proveedor\nConsulta:ventas\nBalance:ventas\nEnviar comanda:cocina\nPagar cuenta\n TOP: platos";
        String titulo ="MENU GENERAL";

        //------------------------------------OPCIONES-------------------------------------------
        do{
            opcion = Funciones.OpcionesMenu(Botones, mensaje, titulo)+1;
            switch (opcion) {
                case 1:
                    ventaCobro();
                    break;
                case 2:
                    ingresarMercaderia();
                    break;
                case 3:
                    pagoProveedor();
                    break;
                case 4:
                    consultarVentas();
                    break;
                case 5:
                    balanceVentas();
                    break;
                case 6:
                    comandarCocina();
                    break;
                case 7:
                    realizarPago();
                    break;
                case 8:
                    topPlatos();
                    break;
                default:
                    System.out.println("Cerrando la sistema...");
                    System.exit(0);
                    break;
            }
        }while(opcion != -1);//V

    }

    private void ventaCobro() {

        int opcion = -2; //Opcion a elegir
        String[] Botones = new String[] {"Ingresar", "Modificar", "Eliminar", "Mostrar C", "Mostrar T", "Volver"};
        String mensaje = "Ingresar: Ingresar Cliente\nModificar: Modificar Cliente\nEliminar: Eliminar Cliente\nMostrar C: Mostrar Cliente por ID\nMostrar T: Mostrar Todos los Clientes\nVolver: Volver al Menú Principal";
        String titulo ="MENU CLIENTES";

        //------------------------------------OPCIONES-------------------------------------------
        do{
            opcion = Funciones.OpcionesMenu(Botones, mensaje, titulo)+1;
            switch (opcion) {
                case 1:

                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:
                    break;
                case 5:
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

    private void ingresarMercaderia(){

        int opcion = -2; //Opcion a elegir
        String[] Botones = new String[] {"Ingresar", "Modificar", "Mostrar", "Eliminar", "Volver"};
        String mensaje = "Ingresar: Ingresar Comanda\\Modificar: Modificar comanda\\Mostrar C: Buscar comanda\\Eliminar: Eliminar comanda\\Volver: Volver al Menú Principal";
        String titulo ="MENU COMANDA";

        //------------------------------------OPCIONES-------------------------------------------
        do{
            opcion = Funciones.OpcionesMenu(Botones, mensaje, titulo)+1;
            switch (opcion) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
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

    private void pagoProveedor(){
        int opcion = -2; //Opcion a elegir
        String[] Botones = new String[] {"Ingresar", "Mod por ID", "Mostrar", "Eliminar", "Volver"};
        String mensaje = "Ingresar: Ingresar Empleado\\Mod por ID: Modificar empleado por ID\\Mostrar: Mostrar Todos los empleados\\Eliminar Eliminar empleado\\Volver: Volver al Menú Principal";
        String titulo ="MENU EMPLEADOS";

        //------------------------------------OPCIONES-------------------------------------------
        do{
            opcion = Funciones.OpcionesMenu(Botones, mensaje, titulo)+1;

            switch (opcion) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
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

    private void consultarVentas(){
        int opcion = -2; //Opcion a elegir
        String[] Botones = new String[] {"Diaria", "Mensual"};
        String mensaje = "Ventas :Diaria\nventas: Mensual";
        String titulo ="Consultar Ventas";

        //------------------------------------OPCIONES-------------------------------------------
        do{
            opcion = Funciones.OpcionesMenu(Botones, mensaje, titulo)+1;
            switch (opcion) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
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

    private void balanceVentas(){
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
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
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

    private void comandarCocina() {

        int opcion = -2; //Opcion a elegir
        String[] Botones = new String[] {"Ingresar", "Modificar", "Eliminar", "Mostrar C", "Mostrar T", "Volver"};
        String mensaje = "Ingresar: Ingresar Cliente\nModificar: Modificar Cliente\nEliminar: Eliminar Cliente\nMostrar C: Mostrar Cliente por ID\nMostrar T: Mostrar Todos los Clientes\nVolver: Volver al Menú Principal";
        String titulo ="MENU CLIENTES";

        //------------------------------------OPCIONES-------------------------------------------
        do{
            opcion = Funciones.OpcionesMenu(Botones, mensaje, titulo)+1;
            switch (opcion) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
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

    private void realizarPago(){

        int opcion = -2; //Opcion a elegir
        String[] Botones = new String[] {"Ingresar", "Modificar", "Mostrar", "Eliminar", "Volver"};
        String mensaje = "Ingresar: Ingresar Comanda\\Modificar: Modificar comanda\\Mostrar C: Buscar comanda\\Eliminar: Eliminar comanda\\Volver: Volver al Menú Principal";
        String titulo ="MENU COMANDA";

        //------------------------------------OPCIONES-------------------------------------------
        do{
            opcion = Funciones.OpcionesMenu(Botones, mensaje, titulo)+1;
            switch (opcion) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
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

    private void topPlatos(){

        int opcion = -2; //Opcion a elegir
        String[] Botones = new String[] {"Ingresar", "Modificar", "Mostrar", "Eliminar", "Volver"};
        String mensaje = "Ingresar: Ingresar Comanda\\Modificar: Modificar comanda\\Mostrar C: Buscar comanda\\Eliminar: Eliminar comanda\\Volver: Volver al Menú Principal";
        String titulo ="MENU COMANDA";

        //------------------------------------OPCIONES-------------------------------------------
        do{
            opcion = Funciones.OpcionesMenu(Botones, mensaje, titulo)+1;
            switch (opcion) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
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

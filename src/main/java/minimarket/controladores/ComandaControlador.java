package minimarket.controladores;
import minimarket.entidades.Producto;
import minimarket.entidades.Comanda;
import minimarket.modelos.ComandaModelo;

import javax.swing.JOptionPane;
import java.util.ArrayList;

public class ComandaControlador {

    private ComandaModelo comandaModelo = new ComandaModelo();
    //-------------------------------------------------------------------------------------------------------------------------------------------------
    //Se crea una comanda para poder agregar productos, estos son enviados al metodo  "ingresarComanda" para asi llamar a ComandaModelo.ingresarComanda
    public void crearComanda() {
        ArrayList<Producto> productos = new ArrayList<>();
        boolean agregarOtro = true;

        while (agregarOtro) {
            try {
                String nombre = JOptionPane.showInputDialog("Ingrese el nombre del producto:");
                double precio = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el precio del producto:"));
                int stock = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el stock del producto:"));

                Producto producto = new Producto();
                producto.setNombre(nombre);
                producto.setPrecio(precio);
                producto.setStock(stock);

                productos.add(producto);

                int respuesta = JOptionPane.showConfirmDialog(null, "¿Desea agregar otro producto?", "Agregar Producto", JOptionPane.YES_NO_OPTION);
                if (respuesta != JOptionPane.YES_OPTION) {
                    agregarOtro = false;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Error: Entrada no válida. Por favor, ingrese un número válido para el precio y el stock.", "Error de Formato", JOptionPane.ERROR_MESSAGE);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error: Ocurrió un problema inesperado. " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        ingresarComanda(productos);
    }
    public void ingresarComanda(ArrayList<Producto> producto) {
        try {
            Comanda comanda = new Comanda();
            comanda.setProductos(producto);
            comandaModelo.ingresarComanda(comanda);

            System.out.println("Comanda ingresada exitosamente.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //-------------------------------------------------------------------------------------------------------------------------------------------------

    //-------------------------------------------------------------------------------------------------------------------------------------------------
    public void modificarLista(int id) {
        ArrayList<Producto> productos = new ArrayList<>();
        boolean agregarOtro = true;
        int idm=id;
        while (agregarOtro) {
            String nombre = JOptionPane.showInputDialog("Ingrese el nombre del producto:");
            double precio = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el precio del producto:"));
            int stock = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el stock del producto:"));

            Producto producto = new Producto();
            producto.setNombre(nombre);
            producto.setPrecio(precio);
            producto.setStock(stock);

            productos.add(producto);

            int respuesta = JOptionPane.showConfirmDialog(null, "¿Desea agregar otro producto?", "Agregar Producto", JOptionPane.YES_NO_OPTION);
            if (respuesta != JOptionPane.YES_OPTION) {
                agregarOtro = false;
            }
        }
        modificarComanda(idm,productos);

    }
    public void modificarComanda(int id, ArrayList<Producto>Modificacion_productos) {
        try {
            Comanda comanda = comandaModelo.buscarComandaPorId(id);
            if (comanda != null) {
               comanda.setProductos(Modificacion_productos);
               comandaModelo.modificarComanda(comanda);
                System.out.println("Cliente modificado exitosamente.");
            } else {
                System.out.println("Cliente no encontrado.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //------------------------------------------------------------------------------------------------------------------------------------------------

    //------------------------------------------------------------------------------------------------------------------------------------------------
    public void mostrarComanda(int id){
        try {
            Comanda comanda = comandaModelo.buscarComandaPorId(id);
            if (comanda != null) {
                System.out.println("--------------------------------------");
                System.out.println("Comanda completa: ");
                System.out.println(" ");
                for (int i=0;i<comanda.getProductos().size();i++) {

                    System.out.println("-------------------Producto N° " +i+ "-------------------");
                    System.out.println("Nombre producto: " + comanda.getProductos().get(i).getNombre());
                    System.out.println("Precio del producto: $" + comanda.getProductos().get(i).getPrecio());
                    System.out.println("Stock del producto: " + comanda.getProductos().get(i).getStock());
                    System.out.println("---------------------------------------------------------");
                }
            } else {
                System.out.println("Cliente no encontrado.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //------------------------------------------------------------------------------------------------------------------------------------------------
    public void eliminarComanda(int id){
        try {
            comandaModelo.eliminarComanda(id);
            System.out.println("Cliente eliminado exitosamente.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    }



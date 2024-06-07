package minimarket.controladores;
import minimarket.entidades.Comanda;
import minimarket.entidades.Producto;
import minimarket.entidades.Proveedor;
import minimarket.modelos.ProveedorModelo;
import javax.swing.JOptionPane;
import java.util.ArrayList;
public class proveedorControlador {

    private ProveedorModelo proveedorModelo = new ProveedorModelo();

    public void crearProveedor(String Nombre) {
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

        ingresarProveedor(Nombre, productos);
    }
    public void ingresarProveedor(String nombre,ArrayList<Producto> producto) {
        try {
            Proveedor proveedor = new Proveedor();
            proveedor.setNombre(nombre);
            proveedor.setProductos(producto);
            proveedorModelo.ingresarProveedor(proveedor);

            System.out.println("Proveedor ingresada exitosamente.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //------------------------------------------------------------------------------------

    public void modificarLista(int id, String Nombre) {
        ArrayList<Producto> productos = new ArrayList<>();
        boolean agregarOtro = true;

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
        modificarProveedor(id,Nombre,productos);

    }
    public void modificarProveedor(int id,String nombre, ArrayList<Producto>Modificacion_productos) {
        try {
            Proveedor proveedor= proveedorModelo.buscarProveedorPorId(id);
            if (proveedor != null) {
                proveedor.setProductos(Modificacion_productos);
                proveedor.setNombre(nombre);
                proveedorModelo.modificarProveedor(proveedor);

                System.out.println("Proveedor modificado exitosamente.");
            } else {
                System.out.println("Proveedor no encontrado.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //------------------------------------------------------------------------------------

    public void mostrarProveedor(int id){
        try {
            Proveedor proveedor=proveedorModelo.buscarProveedorPorId(id);

            if (proveedor != null) {
                System.out.println("--------------------------------------");
                System.out.println("Productos de este proveedor: ");
                System.out.println(" ");
                for (int i=0;i<proveedor.getProductos().size();i++) {

                    System.out.println("-------------------Producto N° " +i+ "-------------------");
                    System.out.println("Nombre producto: " + proveedor.getProductos().get(i).getNombre());
                    System.out.println("Precio del producto: $" + proveedor.getProductos().get(i).getPrecio());
                    System.out.println("Stock del producto: " + proveedor.getProductos().get(i).getStock());
                    System.out.println("---------------------------------------------------------");
                }
            } else {
                System.out.println("Proveedor no encontrado.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //------------------------------------------------------------------------------------

}

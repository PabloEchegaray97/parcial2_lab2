import javax.xml.transform.Result;
import java.sql.*;

public class H2jdbcCreateDemo {
    // driver JDBC y URL de la BD
    static final String JDBC_DRIVER = "org.h2.Driver";
    //static final String DB_URL = "jdbc:h2:~/testdb";
    //static final String DB_URL = "jdbc:h2:~/h2/testdb";
    //static final String DB_URL = "jdbc:h2:mem:test";
    //static final String DB_URL = "jdbc:h2:tcp://localhost/~/h2/test";

    static final String DB_URL = "jdbc:h2:tcp://localhost/~/minimarket";

    //  Credenciales
    static final String USER = "sa";
    static final String PASS = "";

    static Connection conn = null;
    static Statement stmt = null;

    public static void crearTabla(){
        //Paso 3: Ejecutar una consulta
        try {
            System.out.println("Creando tabla en la base de datos...");
            stmt = conn.createStatement();
            String sql = "CREATE TABLE REGISTRACION1 " +
                    "(id INTEGER not NULL, " +
                    " primero VARCHAR(255), " +
                    " ultimo VARCHAR(255), " +
                    " edad INTEGER, " +
                    " PRIMARY KEY ( id ))";
            stmt.executeUpdate(sql);
            System.out.println("Se creó la tabla...");
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    public static void guardarDatos(){
        //Paso 3: Ejecutar una consulta
        try {
            System.out.println("Insertando datos en la base de datos...");
            stmt = conn.createStatement();
            String sql = "insert into REGISTRACION1 " +
                    "(id, primero, ultimo, edad) values (1,'primero','ultimo',20)";
            stmt.executeUpdate(sql);
            System.out.println("Se insertaron los datos...");
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static void leerDatos(){
        //Paso 3: Ejecutar una consulta
        try {
            ResultSet rs;
            System.out.println("Leyendo datos desde la base de datos...");
            stmt = conn.createStatement();
            String sql = "select * from REGISTRACION1";
            rs = stmt.executeQuery(sql);
            while (rs.next()) {               // Position the cursor                 3
                System.out.println("Dato leido: " + rs.getString(2));
            }
            System.out.println("Se leyeron los datos...");
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }


    public static void main(String[] args) {

        try {
            // Paso 1: Registrar el driver jdbc
            Class.forName(JDBC_DRIVER);

            //Paso 2: Abrir una conexión
            System.out.println("Conectándose a la base de datos...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            //Paso 3: Trabajar con la tabla
            crearTabla();
            guardarDatos();
            leerDatos();

            // Paso 4: limpiar el ambiente
            stmt.close();
            conn.close();
        } catch(SQLException se) {
            //administrar errores para JDBC
            se.printStackTrace();
        } catch(Exception e) {
            //administrar errores para Class.forName
            e.printStackTrace();
        } finally {
            try{
                if(stmt!=null) stmt.close();
            } catch(SQLException se2) {
            }
            try {
                if(conn!=null) conn.close();
            } catch(SQLException se){
                se.printStackTrace();
            }
        }
        System.out.println("Goodbye!");
    }
}
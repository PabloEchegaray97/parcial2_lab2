package minimarket.controladores;

import java.awt.GridLayout;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class Funciones {

    public static void main(String[] args) {

    }

    //Condiciones de ingreso de datos:
    public static boolean VerificacionDeLetras(String texto) { //Verfica que el texto ingresado sea igual a ciertos string, devuelve bool
        boolean letrasCorrectas = false;
        String[] TEXTO = SepararLetras(texto);
        for (int i = 0; i < TEXTO.length; i++) {
            //System.out.println("LETRA: " + TEXTO[i]);
            //Usando switch
            switch (TEXTO[i]) {
                case "A":
                    letrasCorrectas = true;
                    break;
                case "T":
                    letrasCorrectas = true;
                    break;
                case "C":
                    letrasCorrectas = true;
                    break;
                case "G":
                    letrasCorrectas = true;
                    break;
                default:
                    letrasCorrectas = false;
                    break;
            }
            if (letrasCorrectas == false) {
                break;
            }
            //Usando IF
//            if(TEXTO[i].equals("A") == true){
//                letrasCorrectas = true;
//            }else if(TEXTO[i].equals("T") == true){
//                letrasCorrectas = true;
//            }else if(TEXTO[i].equals("C") == true){
//                letrasCorrectas = true;
//            }else if(TEXTO[i].equals("G") == true){
//                letrasCorrectas = true;
//            }else{
//                letrasCorrectas = false;
//                break;
//            }
        }
        //System.out.println("VERIFICA: " + letrasCorrectas);
        if (letrasCorrectas == false) {
            JOptionPane.showMessageDialog(null, "Hay por lo menos una letra que no corresponde");
        }

        return letrasCorrectas;
    }

    public static String VerificacionDeLargoCadena(String texto, int tamano) { //Para que no incerten la cantidad de caracteres justos;
        String text = "";
        do {
            text = InputDialogNoVacio(texto);
            if (tamano != text.length()) {
                JOptionPane.showMessageDialog(null, "El tamaño debe ser de: " + tamano);
            }
        } while (tamano != text.length());

        return text;
    }

    public static String InputDialogNoVacio(String texto) { //Para que no incerten un espacio en blanco en los datos
        String Input = "";
        do {
            Input = JOptionPane.showInputDialog(texto);
            if (Input == null || Input.equals("") == true) {
                JOptionPane.showMessageDialog(null, "DEBE INGRESAR UN DATO");
                Input = "";
            }
        } while (Input.equals("") == true); //V
        return Input;
    } //Nos devuelve obligatoriamente un Sring, No acepta que el usuario no cargue datos

    public static String[] SepararLetras(String texto) {//Separa las letras de un String y crear un array con las letras.

        char[] DNA = texto.toCharArray();
        String Mayuscula = "";//CONVERTIR EN MAYUSCULA
        String[] arregloDeCadenas = new String[DNA.length];

        for (int i = 0; i < DNA.length; i++) {
            Mayuscula = Character.toString(DNA[i]); //en caso que no se quiera convertir en mayuscula: arregloDeCadenas[i] = Character.toString(DNA[i]);
            arregloDeCadenas[i] = Mayuscula.toUpperCase(); //CONVERTIR EN MAYUSCULA
        }
        return arregloDeCadenas;
    }

    public static String RevertirString(String Frase) {
        System.out.println(Frase + "|"); //Compruebo el funcionamiento
        if (Frase.isEmpty()) { //Frase.isEmpty que es lo mismo que Frase.length() == 0: Verifica que sea una cadena vacia
            return Frase;
        } else {
            return RevertirString(Frase.substring(1)) + Frase.charAt(0);
            //Frase.substring: Trocea un String desde una posición a otra. + Frase.charAtDevuelve el carácter indicado por parámetro
        }
    }

    public static int LimitacionNumericaInt(String texto, String dato, int max, int min) { //Limita los parametros a ingresar
        int Numero = 0;
        String Input = "";
        do {
            Input = JOptionPane.showInputDialog(texto);
            Numero = Integer.parseInt(Input);
            if (Numero > max) {
                JOptionPane.showMessageDialog(null, "EL DATO NO CUMPLE CON EL LIMITE MAXIMO DE " + dato);
                Input = "";
            } else if (Numero < min) {
                JOptionPane.showMessageDialog(null, "EL DATO NO CUMPLE CON EL LIMITE MINIMO DE " + dato);
                Input = "";
            }
        } while (Numero > max || Numero < min); //V

        return Numero;
    } //Toma los valores del extremo

    public static double LimitacionNumericaDouble(String texto, String dato, double max, double min) { //Limita los parametros a ingresar
        double Numero = 0;
        String Input = "";
        do {
            Input = InputDialogNoVacio(texto); //ES NECESARIO IMPORTAR LA FUNCION ESTA
            Numero = Integer.parseInt(Input);
            if (Numero > max) {
                JOptionPane.showMessageDialog(null, "EL DATO NO CUMPLE CON EL LIMITE MAXIMO DE " + dato);
                Input = "";
            } else if (Numero < min) {
                JOptionPane.showMessageDialog(null, "EL DATO NO CUMPLE CON EL LIMITE MINIMO DE " + dato);
                Input = "";
            }
        } while (Numero > max || Numero < min); //V

        return Numero;
    } //Toma los valores del extremo

    //Calcular:
    public static int SumatoriaFila(int arreglo[]) {
        int total = 0;
        for (int i = 0; i < arreglo.length; i++) {   //Filas
            total = total + arreglo[i]; //Sumatoria
        }
        return total;
    }

    public static void SumaDiagonalPrincipal(int arreglo[][]) { //Suma los elementos de la diagonal principal
        //-----------------------------------------------Realizacion de la suma------------------------------------
        int sumadiagonalp = 0;

        //x = i = arreglo.length | y = j = arreglo[0].length
        for (int i = 0; i < arreglo.length; i++) {    //Filas
            sumadiagonalp = sumadiagonalp + arreglo[i][i];
        }
        System.out.println("Suma Diagonal PRINCIPAL: " + sumadiagonalp);
    }

    public static void SumaDiagonalInversa(int arreglo[][]) { // Suma los elementos de la diagonal inversa
        //-----------------------------------------------Realizacion de la suma------------------------------------
        int sumadiagonali = 0;

        //x = i = arreglo.length | y = j = arreglo[0].length
        for (int i = 0; i < arreglo.length; i++) {    //Filas
            sumadiagonali = sumadiagonali + arreglo[(arreglo.length - 1) - i][i];
        }
        System.out.println("Suma Diagonal INVERSA: " + sumadiagonali);
    }

    public static String[][] RellenarMatriz(String arreglo[][], int posicionX, int PosicionY, int modificacion) {
        //------------------------------------Rellenar los valores------------------------------
        int diferencia = Integer.parseInt(arreglo[posicionX][PosicionY]); // Conversion a entero

        diferencia = diferencia + modificacion; //Agrega cantidad

        arreglo[posicionX][PosicionY] = Integer.toString(diferencia); // Conversion a String

        return arreglo;
    }

    public static int CalcularResto(int numero) { //cuidado con el retornom, ya que hay que avisar que es un array con int[]
        numero = numero % 23;
        System.out.println("RESTO: " + numero);
        return numero;
    }

    //Array
    public static int[] CrearArray() { //cuidado con el retornom, ya que hay que avisar que es un array con int[]
        //Varibles
        int tamano = -1;
        String lector = "";

        //Condicion de tamaño
        do {
            lector = JOptionPane.showInputDialog("Ingrese tamaño de fila");
            tamano = Integer.parseInt(lector);
        } while (tamano < 0); //V

        //Tamaño
        int arreglo[] = new int[tamano];
        //-----------------------Asigno los valores----------------------------------------------
        for (int i = 0; i < tamano; i++) { //Podemos ver el tamano del array de esta forma
            lector = JOptionPane.showInputDialog("Ingrese " + (i + 1) + " elemento:");
            arreglo[i] = Integer.parseInt(lector);
        }
        return arreglo;
    }

    public static int[] RevertirArray(int arreglo[]) {
        int revertido[] = new int[arreglo.length];

        //-----------------------Asigno los valores----------------------------------------------
        for (int i = 0; i < arreglo.length; i++) { //Podemos ver el tamano del array de esta forma
            revertido[arreglo.length - (i + 1)] = arreglo[i];
        }
        return revertido;
    }

    public static void MostrarValoresArray(String arreglo[]) {
        //-----------------------Mostramos los valores----------------------------------------------
        System.out.print("[");
        for (int i = 0; i < arreglo.length; i++) {
            System.out.print(arreglo[i]);
            if (i < (arreglo.length - 1)) {
                System.out.print(" , ");
            }
        }
        System.out.println("]");
    }

    //Ordenar y buscar
    public static int[] OrdenamientoB(int Arreglo[], String opcion) { //ASC ->Acendente | DESC -> Decendentes

        //Varibles
        boolean intercambiado = false;
        int aux = 0;

        do {
            intercambiado = false;
            for (int i = 1; i < Arreglo.length; i++) {
                //Si este par no esta ordenado
                if (Arreglo[i - 1] > Arreglo[i]) {
                    //Los intercambiamos y recordamos que algo ha cambiado
                    aux = Arreglo[i - 1];
                    Arreglo[i - 1] = Arreglo[i];
                    Arreglo[i] = aux;
                    intercambiado = true;
                }
            }
        } while (intercambiado == true);

        //ACENDENTE
        if (opcion.compareTo("ASC") == 0) {
            Arreglo = Arreglo;
        }
        //DESCENDENTE
        if (opcion.compareTo("DESC") == 0) {
            int[] ArregloRevertido = new int[Arreglo.length];
            for (int i = 0; i < Arreglo.length; i++) {
                ArregloRevertido[i] = Arreglo[Arreglo.length - i - 1];
            }
            Arreglo = ArregloRevertido;
        }
        return Arreglo;
    }

    public static int[] OrdenamientoI(int Arreglo[], String opcion) { //ASC ->Acendente | DESC -> Decendentes
        for (int i = 0; i < Arreglo.length; i++) {
            //Variables
            int valor = Arreglo[i];
            int j = i - 1;
            //Ordenar
            while (j >= 0 && Arreglo[j] > valor) {
                Arreglo[j + 1] = Arreglo[j];
                j--;
            }
            Arreglo[j + 1] = valor;
        }

        //ACENDENTE
        if (opcion.compareTo("ASC") == 0) {
            Arreglo = Arreglo;
        }
        //DESCENDENTE
        if (opcion.compareTo("DESC") == 0) {
            int[] ArregloRevertido = new int[Arreglo.length];
            for (int i = 0; i < Arreglo.length; i++) {
                ArregloRevertido[i] = Arreglo[Arreglo.length - i - 1];
            }
            Arreglo = ArregloRevertido;
        }
        return Arreglo;
    }

    public static int[] OrdenamientoS(int Arreglo[], String opcion) { //ASC ->Acendente | DESC -> Decendentes

        for (int i = 0; i < Arreglo.length; i++) {
            int minimo = i;
            for (int j = i; j < Arreglo.length; j++) {
                //Si este par no esta ordenado
                if (Arreglo[j] < Arreglo[minimo]) {
                    //Encontramos un nuevo minimo
                    minimo = j;
                }
                //Intercambiamos el actual con el mínimo encontrado
                int aux = Arreglo[minimo];
                Arreglo[minimo] = Arreglo[j];
                Arreglo[j] = aux;
            }
        }

        //DESCENDENTE
        if (opcion.compareTo("DESC") == 0) {
            Arreglo = Arreglo;
        }
        //ACENDENTE
        if (opcion.compareTo("ASC") == 0) {
            int[] ArregloRevertido = new int[Arreglo.length];
            for (int i = 0; i < Arreglo.length; i++) {
                ArregloRevertido[i] = Arreglo[Arreglo.length - i - 1];
            }
            Arreglo = ArregloRevertido;
        }

        return Arreglo;
    }

    public static void BusquedaS(String Arreglo[]) {

        //Oracion a buscar
        String a = JOptionPane.showInputDialog("Buscar:");

        //Varibles
        boolean seEncontro = false;

        // recorremos la lista, revisando cada elemento de la misma, para ver
        // si es el alumno a.
        for (int i = 1; i < Arreglo.length - 1; i++) {
            // comparamos el alumno de la posición actual con el alumno buscado: a
            if (Arreglo[i].compareTo(a) == 0) {
                // encontramos el alumno buscado
                seEncontro = true;
                JOptionPane.showMessageDialog(null, "Se encontro: [" + a + "] en la posicion: " + (i + 1));
                break;
            }
            // si nunca se cumple L[i] == a, entonces la variable que indica si se
            // encontró o no el alumno: seEncontró, quedará valiendo falso.
        }
        if (seEncontro = false) {
            JOptionPane.showMessageDialog(null, "No se encontro: " + a);
        }
    }

    public static int BusquedaDeElementoArray(String Arreglo[], String buscar) { //Devuelve la posicion en la que se encuentra el elemento, En caso de no encontrarse devuelve "-1"

        int busqueda = 0;

        //Varibles
        boolean seEncontro = false;

        // recorremos la lista, revisando cada elemento de la misma, para ver
        // si es el alumno a.
        for (int i = 0; i < Arreglo.length; i++) {
            // comparamos el alumno de la posición actual con el alumno buscado: a
            if (Arreglo[i].compareTo(buscar) == 0) {
                // encontramos el alumno buscado
                seEncontro = true;
                busqueda = i;
                JOptionPane.showMessageDialog(null, "Se encontro: [" + buscar + "]");
                break;
            }
            // si nunca se cumple L[i] == a, entonces la variable que indica si se
            // encontró o no el alumno: seEncontró, quedará valiendo falso.
        }
        if (seEncontro == false) {
            busqueda = -1;
            JOptionPane.showMessageDialog(null, "No se encontro: " + buscar);
        }

        return busqueda;
    }

    //Matrices
    public static void MostrarValoresMatriz(String arreglo[][]) {
        //-----------------------Mostramos los valores----------------------------------------------
        for (int j = 0; j < arreglo[0].length; j++) { //Filas (invertido)
            System.out.print("[");
            for (int i = 0; i < arreglo.length; i++) { //Columnas (invertido)
                System.out.print(arreglo[i][j]); //(invertido)
                if (i < (arreglo.length - 1)) {
                    System.out.print(" , ");
                }
            }
            System.out.println("]");
        }
    }

    public static int[][] InvertimosFilasPorColumnas(int arreglo[][]) {
        int[][] arregloInvertir = new int[arreglo[0].length][arreglo.length];

        //x = i | y = j
        for (int j = 0; j < arreglo[0].length; j++) {   //Columnas
            for (int i = 0; i < arreglo.length; i++) {    //Filas
                arregloInvertir[j][i] = arreglo[i][j];
            }
        }
        return arregloInvertir;
    }

    public static int[][] AsignacionDeValores(int arreglo[][]) {
        //-----------------------Asigno los valores----------------------------------------------
        //x = i | y = j
        for (int i = 0; i < arreglo.length; i++) {   //Columnas
            for (int j = 0; j < arreglo[0].length; j++) {    //Filas
                String lector = JOptionPane.showInputDialog("Valor X" + (i + 1) + " | " + "Valor Y" + (j + 1) + ":");
                arreglo[i][j] = Integer.parseInt(lector);
            }
        }
        return arreglo;
    }

    public static void MostrarComoTabla(String[] titulos, String arreglo[][]) {
        for (int i = 0; i < titulos.length; i++) {
            System.out.print(titulos[i] + "\t");
        }
        System.out.println("");
        for (int j = 0; j < arreglo[0].length; j++) {
            for (int i = 0; i < arreglo.length; i++) {
                System.out.print(arreglo[i][j] + "\t\t\t");
            }
            System.out.println("");
        }
    }

    //Recorrido de matriz: (Recorren la matrices guardando los string formados por recorrido y devuelven una lista con todos los strings)
    public static ArrayList RecorrerHorizontal(String arreglo[][]) {
        //Variables
        ArrayList<String> Registro = new ArrayList<String>();
        String secuencia = "";

        //OPERACION
        for (int j = 0; j < arreglo.length; j++) {
            for (int i = 0; i < arreglo[j].length; i++) {
                secuencia = secuencia + arreglo[i][j];
            }
            Registro.add(secuencia);
            secuencia = "";
        }

        //RETORNO
        return Registro;
    }

    public static ArrayList RecorrerVertical(String arreglo[][]) {
        //Variables
        ArrayList<String> Registro = new ArrayList<String>();
        String secuencia = "";

        //OPERACION
        for (int j = 0; j < arreglo.length; j++) {
            for (int i = 0; i < arreglo[j].length; i++) {
                secuencia = secuencia + arreglo[j][i];
            }
            Registro.add(secuencia);
            secuencia = "";
        }

        //RETORNO
        return Registro;
    }

    public static ArrayList RecorrerOblicuamentesIDI(String arreglo[][]) { //Recorre la matriz de forma oblicua de izquierda a derecha desde el extremo INFERIOR
        int cont = -(arreglo.length + 1);
        ArrayList<String> Registro = new ArrayList<String>();
        String secuencia = "";
        do {
            for (int i = arreglo.length - 1; i >= 0; i--) {
                for (int j = arreglo[i].length - 1; j >= 0; j--) {
                    if (i + j == arreglo.length + cont) {
                        secuencia = secuencia + arreglo[i][j];
                    }
                }
            }
            Registro.add(secuencia);
            secuencia = "";
            cont++;
        } while (cont != arreglo.length - 1);

        return Registro;
    }

    public static ArrayList RecorrerOblicuamentesDII(String arreglo[][]) { //Recorre la matriz de forma oblicua de izquierda a derecha desde el extremo INFERIOR
        int cont = -(arreglo.length);
        ArrayList<String> Registro = new ArrayList<String>();
        String secuencia = "";
        do {
            for (int i = arreglo.length - 1; i >= 0; i--) {
                for (int j = arreglo[i].length - 1; j >= 0; j--) {
                    if (j + cont == i) {
                        secuencia = secuencia + arreglo[i][j];
                    }
                }
            }
            Registro.add(secuencia);
            secuencia = "";
            cont++;
        } while (cont != arreglo.length);

        return Registro;
    }

    //Listas / Colecciones
    public static int ContadorPalabrasContenidasListas(ArrayList<String> Registro, String[] Palabras) { //Devuelve el total de veces que har repetida una/unas palabras en una lista
        int contador = 0;
        for (int j = 0; j < Palabras.length; j++) {
            for (int i = 0; i < Registro.size(); i++) {
                if (Registro.get(i).contains(Palabras[j])) {
                    contador++;
                }
            }
        }

        return contador;
    }

    public static ArrayList CrearColeccion() {
        //Variables
        ArrayList<Integer> NUMEROS = new ArrayList<Integer>();
        String lector = "";

        //Leemos
        do {
            lector = JOptionPane.showInputDialog("Ingrese elemento:");
            if (lector != null) {
                NUMEROS.add(Integer.parseInt(lector));
            }
        } while (lector != null); //V

        //Retornamos
        return NUMEROS;
    }

    public static void MostrarColeccion(ArrayList<Integer> COLECCION) {
        //Modo alternativo a utilizar co con el for
        for (Integer n : COLECCION) {
            System.out.println("N*: " + n);
        }

//        for(int i=0;i<COLECCION.size();i++){
//            System.out.println("N*: " + COLECCION.get(i));
//        }
    }

    public static List<String> BuscarEnListaYAgregar(List<String> LISTA, String TextoDeIngreso, String TextoEncontrada, String TextoNoEncontrado) { //Se seguira ejecutando mientras el texto ingresado se encuentra dentro de la lista
        String buscar = JOptionPane.showInputDialog(TextoDeIngreso);
        boolean Encontro = false;
        do {
            for (int i = 0; i < LISTA.size(); i++) {
                if (LISTA.get(i).equals(buscar) == true) {
                    JOptionPane.showMessageDialog(null, TextoEncontrada);
                    Encontro = true;
                    break;
                }
            }
            if (Encontro == false) {
                JOptionPane.showMessageDialog(null, TextoNoEncontrado);
                LISTA.add(buscar);
            }
        } while (Encontro == true);

        return LISTA;
    }

    public static void MostrarHashMap(HashMap<String, String> hashmap) {
        // Mostrar el HashMap usando el método toString()
        System.out.println(hashmap.toString());
    }

    //Objetos

    //Opciones de menu:
    public static void Menu() {
        //----------------------------------Diferentes OPCIONES----------------------------------
        //VARIABLES PROYECTO
        //Agenda AGENDA = new Agenda();
        //VARIABLES OPCIONES
        int opcion = -2; //Opcion a elegir

        //------------------------------------OPCIONES-------------------------------------------
        do {
            switch (opcion) {
                case 0:
                    //Cargar_Datos(AGENDA);
                    break;
                case 1:
                    //Buscar_Telefono(AGENDA);
                    break;
                case 2:
                    //Listar_Agenda(AGENDA);
                    break;
                default:
                    break;
            }
            //Volvemos a mostrar las opciones
            //opcion = OpcionesMenu("","","");

            //Condicion para cerrar el programa
            if (opcion == -1) { //
                System.out.println("Finalizado");
            }
        } while (opcion != -1);//V
    }

    public static int OpcionesMenu(String[] Botones, String mensaje, String titulo) {
        int seleccion = JOptionPane.showOptionDialog(null, mensaje, titulo, JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, Botones, Botones[0]);

        return seleccion;
    }

    public static String[] CrearMultipleInputs() {
        //Creamos MATRIZ con los valores de retorno
        String[] MATRIZ = new String[4];

        // Crear un panel personalizado con varios componentes de entrada
        JPanel inputPanel = new JPanel(); //Instancia del PANEL
        inputPanel.setLayout(new GridLayout(6, 1)); // Cambia el número de columnas primero y filas segundo

        //Creo los constructores
        JLabel valorLabel = new JLabel("Valor de celda:");
        JTextField valorField = new JTextField(1);
        JLabel xLabel = new JLabel("X:");
        JTextField xField = new JTextField(1);
        JLabel yLabel = new JLabel("Y:");
        JTextField yField = new JTextField(1);

        //Agrego al panel
        inputPanel.add(valorLabel);
        inputPanel.add(valorField);
        inputPanel.add(xLabel);
        inputPanel.add(xField);
        inputPanel.add(yLabel);
        inputPanel.add(yField);

        // Crear un cuadro de diálogo de JOptionPane y mostrar el panel personalizado
        int result = JOptionPane.showConfirmDialog( //result: ACEPTAR = 0  |  CANCELAR = 2 | CERRAR = -1
                null,
                inputPanel,
                "MATRIZ",
                JOptionPane.OK_CANCEL_OPTION
        );

        //Asignamos los valores colocados a la MATRIZ
        MATRIZ[0] = Integer.toString(result); //Botones del Imput
        MATRIZ[1] = xField.getText(); //Posicion en X
        MATRIZ[2] = yField.getText(); //Posicion en Y
        MATRIZ[3] = valorField.getText(); //Valor de celda

        return MATRIZ;
    }

    public static boolean CuadroDialogoVoF(String texto, String titulo) { //Nos deja responder SI: true // NO/cerrar: false
        boolean respuesta = false;

        int x = JOptionPane.showConfirmDialog(null, texto, titulo, JOptionPane.YES_NO_OPTION); //SI = 0 || NO = 1 || CERRAR = -1

        if (x == 0) {
            respuesta = true;
        } else {
            respuesta = false;
        }

        return respuesta;
    }

    public static void TablaSimple(String[] columnNames, Object[][] data) { //Crear una tabla, se crea un objeto con todos los valores de la tabla y un String con todos los titulos
//        String[] columnNames = {"First Name", "Last Name", "Sport", "# of Years", "Vegetarian"};

//        Object[][] data = {{"Kathy", "Smith", "Snowboarding", new Integer(5), new Boolean(false)},
//                            {"John", "Doe" , "Rowing", new Integer(3), new Boolean(true)},
//                            {"Sue", "Black", "Knitting", new Integer(2), new Boolean(false)},
//                            {"Jane", "White", "Speed reading", new Integer(20), new Boolean(true)},
//                            {"Joe", "Brown", "Pool", new Integer(10), new Boolean(false)}
//                            };

        JTable table = new JTable(data, columnNames);

        JScrollPane scroll = new JScrollPane(table);
        scroll.setBounds(40, 40, 400, 200);

        JFrame ventana = new JFrame();

        ventana.setLayout(null);
        ventana.setSize(500, 300); //Tamaño de tabla
        ventana.setLocationRelativeTo(null);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.add(scroll);

        ventana.setVisible(true);
    }

    public static String AsignacionFecha() { //Necesito de la funcion LimitacionNumericaInt()
        int dia = LimitacionNumericaInt("Ingrese día:", "día", 31, 1);
        int mes = LimitacionNumericaInt("Ingrese mes:", "mes", 12, 1);
        int anio = LimitacionNumericaInt("Ingrese año:", "año", 2023, 1);
        SimpleDateFormat formato = new SimpleDateFormat("yyyy/MM/dd"); //Formato de fecha
        Calendar calendar = Calendar.getInstance();
        calendar.set(anio, mes - 1, dia);
        String fecha = formato.format(calendar.getTime());

        return fecha;
    }
}

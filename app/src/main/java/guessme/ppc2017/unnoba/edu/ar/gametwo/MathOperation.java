package guessme.ppc2017.unnoba.edu.ar.gametwo;

import android.util.Log;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Esta clase dispone de lo necesario para la creacion de los elementos matematicos de la
 * aplicacion, asi como tambien, una vez instanciado, tendra todos los elementos generados
 * por la misma, mas las 2 caras de dados pasadas como parametro al momento de instanciarlo.
 */
public class MathOperation {

    // Constantes de suma y resta
    public static final String ADD = "+";
    public static final String SUBTRACT = "-";

    private int random1;
    private int random2;
    private ArrayList<Integer> results= new ArrayList<Integer>();
    private ArrayList<Integer> row=new ArrayList<Integer>();
    private ArrayList<Integer> column= new ArrayList<Integer>();
    private ArrayList<Integer> operandos= new ArrayList<Integer>();
    private String operator;
    private int result;
    private List options;

    /**
     * El constructor recibe dos caras de dados, que seran utilizadas para calcular opciones validas
     *
     */
    public MathOperation(ArrayList<Integer> table) {
        this.operandos= table;

        // Generamos un operador, acorde a la configuracion y luego al azar
        this.operator = generateOperator();

        // Guardamos el resultado de la operacion
        this.results = calculateOperation();

        // Generamos las opciones, asegurandonos de que esten las 3 correctas (los numeros
        // de las caras de los dados y elresultado de la operacion
        this.options = generateOptions(this.getResults());
    }

    /**
     * Calcula la operacion
     */
    private ArrayList<Integer> calculateOperation() {
        // Verifica que el orden de los operadores sea el correcto si es resta (primero el mas grande)
        //verifyOrderOfOperators();
        for (int i=0; i<=2; i++){
            row.add(operandos.get(i));
        }
        for (int i=3; i<=5; i++){
            column.add(operandos.get(i));
        }

        // Si es una resta, resta los numeros de las caras de los dados, sino los suma
        if ( operator.equals(SUBTRACT) ) {
            for (int i=0; i<=2; i++){
                for (int j=0; j<=2; j++) {
                    results.add(row.get(i) - column.get(j));
                }
            }
            return results;
        } else {
            for (int i=0; i<=2; i++){
                for (int j=0; j<=2; j++) {
                    results.add(row.get(i) + column.get(j));
                }
            }
            return results;
        }


    }

    /**
     * En caso de ser una resta, nos aseguramos de que el resultado sera mayor o igual que cero,
     * cambiando el orden de los operandos si es necesario, para que el primero sea el mayor
     */
    /** private void verifyOrderOfOperators() {
        if ( operator.equals(SUBTRACT) ) {
            if ( random1 < random2 ) {
                // Intercambiamos la cara de dado 1 por la 2
                int aux = random1;
                random1 = random2;
                random2 = aux;
            }
        }
    }
     */

    /**
     * Si la configuracion indica que solo estan permitidas las sumas, entonces devolvera
     * el String almacenado en la constante ADD, en cambio, si sumas y restas estan permitidas,
     * se devolvera cualquiera de los dos, con una probabilidad de 0.5
     */
    private String generateOperator() {
        // Obtenemos la unica instancia de configuracion
        Configuration config = Configuration.getConfig();

        // Si solo estan permitidas las sumas, entonces devolvemos el String asociado a la suma
        if ( config.isOnlyAddition() ) {
            return ADD;
        }

        // Si llegamos hasta aca, es porque isOnlyAddition() es falso, por lo cual generamos un numero
        // random (que sera entre 0 y 1)
        double randomNumber = Math.random();

        // Si dicho numero es menor que 0.5 entonces es suma, de lo contrario, resta
        if ( randomNumber < 0.5 ) {
            return ADD;
        } else {
            return SUBTRACT;
        }
    }

    /**
     * Genera una lista de opciones, asegurandose de que esten las deseadas, y luego la desordena
     */
    private List generateOptions(ArrayList<Integer> results) {

        // Agregamos las opciones correctas a la lista
        List<Integer> options = new ArrayList<>();
        options= results;


        // Desordenamos la lista
        long seed = System.nanoTime();
        Collections.shuffle(options, new Random(seed));

        return options;
    }

    /**
     * Getters
     */

    public String getOperator() {
        return operator;
    }

    public List getOptions() {
        return options;
    }

    public int getRandom1() {
        return random1;
    }

    public int getRandom2() {
        return random2;
    }

    public int getResult() {
        return result;
    }

    public ArrayList<Integer> getResults() {
        return results;
    }

    public ArrayList<Integer> getRow() {
        return row;
    }

    public ArrayList<Integer> getColumn() {
        return column;
    }

    public ArrayList<Integer> getOperandos() {
        return operandos;
    }
}

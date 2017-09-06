package guessme.ppc2017.unnoba.edu.ar.gametwo;

import android.app.Activity;
import android.graphics.Typeface;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Julieta Terzano on 05/09/2017.
 */

public class Renderer {
    // Tendremos dos operandos, un operador y un resultado (Textos)

    private TextView operator;
    private TextView[] terms= new TextView[6];
    private TextView[] results= new TextView[9];

    // 9 opciones (texto)
    private TextView[] options = new TextView[9];

    // Fuente custom
    private Typeface font;

    /**
     * Dada una operacion matematica (MathOperation) y un activity (GameActivity), tenemos la
     * informacion necesaria para renderizar en dicho activity, los datos proporcionados por
     * mathOperation
     *
     * @param mathOperation este objeto dispone de toda la info necesaria de la operacion matematica
     * @param activity      GameActivity (donde vamos a renderizar los datos)
     */


    public void render(final MathOperation mathOperation, Activity activity) {
        // Primero asociamos los elemntos de la vista con las variables de este objeto
        linkElementsWithView(activity);

        // Creamos la fuente custom para settearla luego a los numeros
        // El archivo de la fuente esta guardado en app/src/main/assets
        font = Typeface.createFromAsset(activity.getAssets(), "adam handwriting test.ttf");

        // Ya con los pasos previos, podemos hacer el renderizado real con los datos de mathOperation
        realRender(mathOperation);
    }

    /**
     * Asociamos los elementos de la vista con las variables de este objeto
     *
     * @param activity Aca buscamos los elementos
     */
    private void linkElementsWithView(Activity activity) {

        operator = (TextView) activity.findViewById(R.id.operator);


        terms[0] = (TextView) activity.findViewById(R.id.term1);
        terms[1] = (TextView) activity.findViewById(R.id.term2);
        terms[2] = (TextView) activity.findViewById(R.id.term3);
        terms[3]= (TextView) activity.findViewById(R.id.term4);
        terms[4]= (TextView) activity.findViewById(R.id.term5);
        terms[5]= (TextView) activity.findViewById(R.id.term6);

        results[0] = (TextView) activity.findViewById(R.id.result1);
        results[1] = (TextView) activity.findViewById(R.id.result2);
        results[2]= (TextView) activity.findViewById(R.id.result3);
        results[3]= (TextView) activity.findViewById(R.id.result4);
        results[4]= (TextView) activity.findViewById(R.id.result5);
        results[5]= (TextView) activity.findViewById(R.id.result6);
        results[6]= (TextView) activity.findViewById(R.id.result7);
        results[7]= (TextView) activity.findViewById(R.id.result8);
        results[8]= (TextView) activity.findViewById(R.id.result9);

        options[0] = (TextView) activity.findViewById(R.id.option0);
        options[1] = (TextView) activity.findViewById(R.id.option1);
        options[2] = (TextView) activity.findViewById(R.id.option2);
        options[3] = (TextView) activity.findViewById(R.id.option3);
        options[4] = (TextView) activity.findViewById(R.id.option4);
        options[5] = (TextView) activity.findViewById(R.id.option5);
        options[6] = (TextView) activity.findViewById(R.id.option6);
        options[7] = (TextView) activity.findViewById(R.id.option7);
        options[8] = (TextView) activity.findViewById(R.id.option8);


    }

    /**
     * Metemos los datos de mathOperation en la vista
     *
     * @param mathOperation Contiene los datos a mostrar en la vista
     */
    private void realRender(MathOperation mathOperation) {

        // Setteamos la fuente custom a los operandos y el resultado
        for (int i = 0; i < terms.length; i++){
            terms[i].setTypeface(font);

        }
        for (int i = 0; i < results.length; i++){
            results[i].setTypeface(font);
        }




        // Mostramos el operador generado por mathOperation en la vista
        operator.setText(mathOperation.getOperator());
        terms[0].setText(String.valueOf(mathOperation.getColumn().get(0)));
        terms[1].setText(String.valueOf(mathOperation.getColumn().get(1)));
        terms[2].setText(String.valueOf(mathOperation.getColumn().get(2)));
        terms[3].setText(String.valueOf(mathOperation.getRow().get(0)));
        terms[4].setText(String.valueOf(mathOperation.getRow().get(1)));
        terms[5].setText(String.valueOf(mathOperation.getRow().get(2)));

        for (int i=0; i < options.length; i++) {
            // Settearle la fuente custom
            options[i].setTypeface(font);
            // Settearle el numero a mostrar, que se encuentra dentro de mathOperation
            options[i].setText(mathOperation.getOptions().get(i).toString());
            // Settearle nuestro OnTouchListener custom, el cual recibe la posicion i como parametro
            options[i].setOnTouchListener(new OptionsOnTouchListener(i));
        }


    }

    public TextView[] getOptions() {
        return options;
    }

    public TextView[] getTerms() {
        return terms;
    }

    public TextView[] getResults() {
        return results;
    }
}
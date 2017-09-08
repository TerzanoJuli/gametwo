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
    // Tendremos 6 operandos, un operador y 9 resultados (Textos)

    private TextView operator;
    //private TextView[] terms= new TextView[6];
    //private TextView[] results= new TextView[9];
    private TextView term1;
    private TextView term2;
    private TextView term3;
    private TextView term4;
    private TextView term5;
    private TextView term6;
    private TextView result1;
    private TextView result2;
    private TextView result3;
    private TextView result4;
    private TextView result5;
    private TextView result6;
    private TextView result7;
    private TextView result8;
    private TextView result9;


    // 9 opciones (texto)
    private TextView[] options = new TextView[9];

    // Fuente custom
    private Typeface font;

    /**
     * Dada una operacion matematica (MathOperation) y un activity (MainActivity), tenemos la
     * informacion necesaria para renderizar en dicho activity, los datos proporcionados por
     * mathOperation
     *
     * @param mathOperation este objeto dispone de toda la info necesaria de la operacion matematica
     * @param activity      MainActivity (donde vamos a renderizar los datos)
     */


    public void render(final MathOperation mathOperation,  Activity activity) {
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


        term1 = (TextView) activity.findViewById(R.id.term1);
        term2 = (TextView) activity.findViewById(R.id.term2);
        term3 = (TextView) activity.findViewById(R.id.term3);
        term4= (TextView) activity.findViewById(R.id.term4);
        term5= (TextView) activity.findViewById(R.id.term5);
        term6= (TextView) activity.findViewById(R.id.term6);

        result1 = (TextView) activity.findViewById(R.id.result1);
        result2= (TextView) activity.findViewById(R.id.result2);
        result3= (TextView) activity.findViewById(R.id.result3);
        result4= (TextView) activity.findViewById(R.id.result4);
        result5= (TextView) activity.findViewById(R.id.result5);
        result6= (TextView) activity.findViewById(R.id.result6);
        result7= (TextView) activity.findViewById(R.id.result7);
        result8= (TextView) activity.findViewById(R.id.result8);
        result9= (TextView) activity.findViewById(R.id.result9);

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

        // Setteamos la fuente custom a los operandos y a los resultados
        term1.setTypeface(font);
        term2.setTypeface(font);
        term3.setTypeface(font);
        term4.setTypeface(font);
        term5.setTypeface(font);
        term6.setTypeface(font);
/**
        result1.setTypeface(font);
        result2.setTypeface(font);
        result3.setTypeface(font);
        result4.setTypeface(font);
        result5.setTypeface(font);
        result6.setTypeface(font);
        result7.setTypeface(font);
        result8.setTypeface(font);
        result9.setTypeface(font);

        result1.setText(String.valueOf(mathOperation.getResults().get(0)));
        result2.setText(String.valueOf(mathOperation.getResults().get(1)));
        result3.setText(String.valueOf(mathOperation.getResults().get(2)));
        result4.setText(String.valueOf(mathOperation.getResults().get(3)));
        result5.setText(String.valueOf(mathOperation.getResults().get(4)));
        result6.setText(String.valueOf(mathOperation.getResults().get(5)));
        result7.setText(String.valueOf(mathOperation.getResults().get(6)));
        result8.setText(String.valueOf(mathOperation.getResults().get(7)));
        result9.setText(String.valueOf(mathOperation.getResults().get(8)));
**/




        // Mostramos el operador generado por mathOperation en la vista
        operator.setText(mathOperation.getOperator());
        //Mostramos los operandos (random)
        term1.setText(String.valueOf(mathOperation.getColumn().get(0)));
        term2.setText(String.valueOf(mathOperation.getColumn().get(1)));
        term3.setText(String.valueOf(mathOperation.getColumn().get(2)));
        term4.setText(String.valueOf(mathOperation.getRow().get(0)));
        term5.setText(String.valueOf(mathOperation.getRow().get(1)));
        term6.setText(String.valueOf(mathOperation.getRow().get(2)));

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



    public TextView getTerm1() {
        return term1;
    }

    public TextView getTerm2() {
        return term2;
    }

    public TextView getTerm3() {
        return term3;
    }

    public TextView getTerm4() {
        return term4;
    }

    public TextView getTerm5() {
        return term5;
    }

    public TextView getTerm6() {
        return term6;
    }

    public TextView getResult1() {
        return result1;
    }

    public TextView getResult2() {
        return result2;
    }

    public TextView getResult3() {
        return result3;
    }

    public TextView getResult4() {
        return result4;
    }

    public TextView getResult5() {
        return result5;
    }

    public TextView getResult6() {
        return result6;
    }

    public TextView getResult7() {
        return result7;
    }

    public TextView getResult8() {
        return result8;
    }

    public TextView getResult9() {
        return result9;
    }
}
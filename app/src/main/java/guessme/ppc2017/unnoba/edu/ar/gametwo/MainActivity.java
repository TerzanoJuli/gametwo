package guessme.ppc2017.unnoba.edu.ar.gametwo;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private int random1;
    private int random2;
    private int random3;
    private int random4;
    private int random5;
    private int random6;
    //table = new ArrayList<Integer>();

    private MathOperation mathOperation;
    private ArrayList<Integer> table = new ArrayList<Integer>();


    private int numberOfHits = 0;
    private Sounds sounds;

    private Renderer renderer = new Renderer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Random random = new Random();
        // Creamos los sonidos del sistema (success y error) para este (this) context
        sounds = new Sounds(this);

        // Creamos numeros aleatorios y los insertamos en un array "table"

        for (int i = 0; i <= 6; i++) {
            table.add((int) (Math.random() * 9));
        }


        // Generamos una nueva operacion matematica
        mathOperation = new MathOperation(this.getTable());


        // Renderizamos dicha operacion matematica en este activity

        renderer.render(mathOperation, this);


        // Creamos la primer respuesta

        new Answer(this,renderer.getResults()[0],mathOperation.getResults().get(0) , renderer, sounds);


    }

    public void evaluateAllAnswers() {
        // Incrementamos el numero de aciertos
        numberOfHits += 1;

        switch (numberOfHits) {
            case 1:
                // Dado que la primer casilla fue bien respondida, creamos la segunda
                new Answer(this, renderer.getResults()[1], mathOperation.getResults().get(1), renderer, sounds);
                break;
            case 2:
                // Dado que la segunda casilla fue bien respondida, creamos la tercera
                new Answer(this, renderer.getResults()[2], mathOperation.getResults().get(2), renderer, sounds);
                break;
            case 3:
                new Answer(this, renderer.getResults()[3], mathOperation.getResults().get(3), renderer, sounds);
                // Si estamos aqui, es porque ya fueron bien respondidas las 3 casillas

                // Dentro del metodo run de nuestro runnable guardamos el codigo que queremos
                // ejecutar (pero aun no lo hacemos)
                Runnable runnable = new Runnable() {
                    @Override
                    public void run() {
                        // Crea un nuevo intent
                        Intent intent = getIntent();
                        // Finaliza el activity actual
                        finish();
                        // Abre el nuevo activity
                        startActivity(intent);
                    }
                };
                Handler handler = new Handler();
                // Ejecuta el codigo que esta en run() dentro de runnable luego de 3000 milisegundos
                handler.postDelayed(runnable, 3000);


        }
    }
        public ArrayList<Integer> getTable () {
            return table;
        }

}








    /**
     * Cada vez que una respuesta (Answer) haya sido bien respondida, se llamara a este metodo,
     * el cual verifica si fue llamado por primera, segunda o tercera vez. Si fue llamado por
     * tercera vez, significa que ya fueron bien respondidas las 3 casillas, por lo cual
     * espera 3 segundos, cierra el activity actual y abre uno nuevo
     */



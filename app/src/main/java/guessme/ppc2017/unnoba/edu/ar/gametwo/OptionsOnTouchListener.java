package guessme.ppc2017.unnoba.edu.ar.gametwo;

import android.content.ClipData;
import android.view.MotionEvent;
import android.view.View;

/**
 * OnTouchListener que puede ser setteado dentro de un bucle, donde se le puede pasar la posicion
 * de la opcion, y luego, cuando es tocada dicha opcion, se puede hacer uso de dicho dato
 */
public class OptionsOnTouchListener implements View.OnTouchListener {

    int optionIndex;

    /**
     * Constructor
     * @param optionIndex indice de la posision del array de opciones
     */
    public OptionsOnTouchListener(int optionIndex) {
        this.optionIndex = optionIndex;
    }

    /**
     * Cuando la opcion es tocada, se dispara este metodo, guarda la posicion de la opcion en
     * un ClipData, data que termina recibiendo alguno de los operandos o el resultado, si lo arrastramos
     * hasta ahi.
     */
    @Override
    public boolean onTouch(View view, MotionEvent event) {
        // Guardamos la posicion de la opcion en el ClipData
        ClipData data = ClipData.newPlainText("optionIndex", String.valueOf(optionIndex));
        // Creamos una sombra del elemento, la cual se va a ver mientras es arrastrado
        View.DragShadowBuilder dragShadow = new View.DragShadowBuilder(view);
        // Comenzamos el drag con los datos arriba explicados.
        view.startDrag(data, dragShadow, view, 0);
        return true;
    }
}

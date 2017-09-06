package guessme.ppc2017.unnoba.edu.ar.gametwo;

import android.app.Activity;
import android.media.MediaPlayer;

/**
 * Esta clase se encarga del manejo de los sonidos, para ello, crea en el activity pasado
 * como parametro en el contructor (GameActivity), dos MediaPlayer, uno que tendra el sonido
 * de success y otro el de error. Entonces, despues de instanciarla, se podra emitir cualquiera
 * de esos sonidos llamando al metodo que corresponda, sin la necesidad de observar su
 * logica de implementacion.
 */
public class Sounds {

    private static MediaPlayer success;
    private static MediaPlayer error;
    private Activity activity;

    /**
     * Constructor, donde setteamos el activity para que quede almacenado en el objeto.
     *
     * @param activity
     */
    public Sounds(Activity activity){
        this.activity = activity;
    }

    /**
     * Este metodo emite el sonido de error
     */
    public void emitErrorSound(){
        /*  En la primera ejecucion de este metodo, error sera igual a null, por lo cual no entrara
            al if, pero el resto de las veces, entrara y va a liberar dicha variable, para luego
            asociar nuevamente el sonido a dicha variable. Esto fue necesario porque el sonido
            se reproducia solo un par de veces y luego dejaba de funcionar.
        */
        if ( error != null ) {
            error.release();
        }
        // Creamos el sonido error.wav que esta en la carpeta /res/raw/
        error = MediaPlayer.create(activity, R.raw.error);
        // y lo ejecutamos
        error.start();
    }

    /**
     * Este metodo emite el sonido de exito
     */
    public void emitSuccessSound() {
        /*  En la primera ejecucion de este metodo, success sera igual a null, por lo cual no entrara
            al if, pero el resto de las veces, entrara y va a liberar dicha variable, para luego
            asociar nuevamente el sonido a dicha variable. Esto fue necesario porque el sonido
            se reproducia solo un par de veces y luego dejaba de funcionar.
        */
        if ( success != null ) {
            success.release();
        }
        // Creamos el sonido success.wav que esta en la carpeta /res/raw/
        success = MediaPlayer.create(activity, R.raw.success);
        // y lo ejecutamos
        success.start();
    }

}

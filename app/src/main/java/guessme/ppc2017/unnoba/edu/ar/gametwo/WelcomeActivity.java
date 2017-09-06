package guessme.ppc2017.unnoba.edu.ar.gametwo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Activity de bienvenida
 */
public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
    }

    /**
     * Este metodo inicia el juego, creando un Intent del GameActivity.
     * Es llamado mediante el onClick del boton "iniciar" declarado en activity_welcome.xml
     *
     * @param view
     */
    public void initiateGame(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    /**
     * En la configuracion tenemos un boolean llamado onlyAddition, que justamente estara en
     * true si queremos que no haya restas. Este metodo obtiene la unica instancia de la clase
     * Configuration y settea dicha configuracion en true.
     * Este metodo es llamado desde el onClick del radioButton declarado en activity_welcome.xml
     *
     * @param view
     */
    public void putOnlyAdditionOnTrue(View view) {
        Configuration config = Configuration.getConfig();
        config.setOnlyAddition(true);
    }

    /**
     * En la configuracion tenemos un boolean llamado onlyAddition, que justamente estara en
     * false si queremos que haya restas. Este metodo obtiene la unica instancia de la clase
     * Configuration y settea dicha configuracion en false.
     * Este metodo es llamado desde el onClick del radioButton declarado en activity_welcome.xml
     *
     * @param view
     */
    public void putOnlyAdditionOnFalse(View view) {
        Configuration config = Configuration.getConfig();
        config.setOnlyAddition(false);
    }
}

package guessme.ppc2017.unnoba.edu.ar.gametwo;

/**
 * Singleton de la configuracion el juego. Singleton porque solo debe haber una configuracion
 * en el juego, sin posibilidad de mas instanciaciones.
 */
public class Configuration {

    // Creacion de la unica configuracion
    private static Configuration config = new Configuration( );
    // Booleano que indica si solo se aceptan sumas o si se aceptan sumas y restas
    private boolean onlyAddition = true;

    // Constructor privado que es llamado arriba.
    private Configuration(){ }

    // Getter de la unica instancia de esta clase (estatico para no tener que instanciarlo)
    public static Configuration getConfig() {
        return config;
    }

    /**
     * Getter y Setter de la configuracion pertinente al juego
     */

    public boolean isOnlyAddition() {
        return onlyAddition;
    }

    public void setOnlyAddition(boolean onlyAddition) {
        this.onlyAddition = onlyAddition;
    }

}
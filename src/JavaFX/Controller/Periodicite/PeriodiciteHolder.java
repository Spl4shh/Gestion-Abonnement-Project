package JavaFX.Controller.Periodicite;

import JavaFX.Controller.Revue.RevueHolder;
import metier.Periodicite;

public class PeriodiciteHolder {

    private Periodicite periodicite;

    private final static PeriodiciteHolder INSTANCE = new PeriodiciteHolder();

    public static PeriodiciteHolder getInstance()
    {
        return INSTANCE;
    }

    public Periodicite getPeriodicite()
    {
        return this.periodicite;
    }
}

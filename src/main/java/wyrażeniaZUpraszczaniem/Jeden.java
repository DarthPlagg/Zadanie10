package wyrażeniaZUpraszczaniem;

/**
 *
 * @author janusz
 */
public class Jeden extends Stała {

    static private Jeden jeden = new Jeden();  // Jedyny obiekt klasy Jeden

    // Upraszczanie
    @Override
    public Wyrażenie pomnóż(Wyrażenie w) {
        return w;
    }

    @Override
    public Wyrażenie pomnóżOdwr(Wyrażenie w) {
        return w;
    }

    // Tworzenie (wzorzec Singleton)
    static public Jeden twórz() {
        return jeden;
    }

    // Konstruktory
    private Jeden() {
        super(1.0);
    }
}

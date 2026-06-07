package wyrażeniaZUpraszczaniem;

/**
 *
 * @author janusz
 */
public class Zero extends Stała {
    static private Zero zero = new Zero();  // Jedyny obiekt klasy Zero

 // Upraszczanie

    @Override
    public Wyrażenie dodaj(Wyrażenie w)
	{
		return w;
	}
 
    @Override
    public Wyrażenie dodajOdwr(Wyrażenie w)
	{
		return w;
	}

    @Override
    public Wyrażenie pomnóż(Wyrażenie w)
	{
		return Zero.twórz();
	}

    @Override
    public Wyrażenie pomnóżOdwr(Wyrażenie w)
	{
		return Zero.twórz();
	}

// Tworzenie (wzorzec Singleton)
   static public Zero twórz(){
     return zero;
   }

// Konstruktory
    private Zero(){
      super(0.0);
    }

}

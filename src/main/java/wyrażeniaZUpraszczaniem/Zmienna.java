package wyrażeniaZUpraszczaniem;

public class Zmienna extends Wyrażenie {

    static private Zmienna x = new Zmienna();

	@Override
    public Wyrażenie pochodna() {
		return Stała.twórz(1.0);
	}

    @Override
	public String toString() {
		return "x";
	}

	@Override
    public double policz(double x) {
		return x;
	}

    // Tworzenie (wzorzec Singleton)
   static public Zmienna twórz(){
     return x;
   }

   // Konstruktor
   private Zmienna(){} // Zadekalrowany tylko po to, żeby był prywatny
}
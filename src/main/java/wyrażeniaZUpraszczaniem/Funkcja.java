package wyrażeniaZUpraszczaniem;

public abstract class Funkcja extends Wyrażenie {
	protected Wyrażenie arg;

	protected abstract String nazwa();

    @Override
	public String toString() {
		return nazwa()+"("+arg+")";
	}

    // Konstruktor w abstrakcyjnej klasie? Jak najbardziej!
    public Funkcja(Wyrażenie w){
        arg = w;  // Nie tworzę kopii - ważna decyzja projektowa
    }
}
package wyrażeniaZUpraszczaniem;

public abstract class Operator extends Wyrażenie {
	protected Wyrażenie lewe;
	protected Wyrażenie prawe;

	protected abstract String operator();

    @Override
	public String toString() {

        String leweStr;
        if (lewe.priorytet()<priorytet())
            leweStr = "(" + lewe + ")";
        else
            leweStr = lewe.toString();

        String praweStr;
        if (prawe.priorytet()<=priorytet())
            // UWAGA: tu <=, bo przy braku nawiasów przyjmuje się, że najpierw
            // wykonuje się ten operator z lewej (czyli my), a powinien nasz
            // prawy syn.
            praweStr = "(" + prawe + ")";
        else
            praweStr = prawe.toString();


		return leweStr + operator() + praweStr;
	}

    public Operator(Wyrażenie lewe, Wyrażenie prawe){
      // Konstruktor w klasie abstarkcyjnej jest często bardzo użyteczny!
      this.lewe  = lewe;    // Ważna decyzja projektowa - nie kopiuję
      this.prawe = prawe;
    }
}
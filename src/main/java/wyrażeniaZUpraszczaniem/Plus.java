package wyrażeniaZUpraszczaniem;

public class Plus extends Operator {

	@Override
    protected String operator() {
		return "+";
	}

	@Override
    public Wyrażenie pochodna() {
		return lewe.pochodna().dodaj(prawe.pochodna());
	}

	@Override
    public double policz(double x) {
		return lewe.policz(x) + prawe.policz(x);
	}

	@Override
    public int priorytet() {
		return 100; // Ważne, żeby był mniejszy od priorytetu operatorów multiplikatywnych
	}

    Plus(Wyrażenie lewe, Wyrażenie prawe){
        // Konstruktor ma widoczność pakietową, bo z jednej strony chcemy go
        // ukryć (użytkownicy mają wołać twórz), więc nie może być public,
        // a z  drugiej jest wołany w Wyrażenie (nie może więc by ani
        // private, ani nawet protected, tzn. protected by działało zwn dziwne
        // zdefiniowanie protected w Javie, ale tu chodzi o widoczność w pakiecie).
        super(lewe, prawe);
    }

    static public Wyrażenie twórz(Wyrażenie lewe, Wyrażenie prawe){
    // metoda tworząca nowe wyrażenie, o ile się da - uproszczone
        return lewe.dodaj(prawe);  // dodaj stara się uprościć
    }
}
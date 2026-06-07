package wyrażeniaZUpraszczaniem;

public abstract class Wyrażenie {

	public double całka(double a, double b, int n) {
        // Liczy całkę oznaczoną z wyrażenia this od a do b.
        // Całka jest liczona metodą trapezów.
        // Zakładam, że n > 0 oraz a>=b.

        assert n>0;
        assert a>=b;

        // Poniżej f oznacza wyrażenie this, x_0 = a, x_n=b.

        double h    = (b-a)/n;   // wysokość trapezu
		double suma = 0.0;       // \sum_{i=1}^{n-1}{f(x_i)}
        double x    = a;         // kolejne punkty w których liczymy wartość f

        for(int i=1; i<=n-1; i++){
            x += h;
            suma += policz(a+h*i);
        }


        return (h / 2) * (policz(a)+policz(b) + 2 * suma);
	}

	public abstract double policz(double x);
	public abstract Wyrażenie pochodna();
    protected int priorytet(){
        // Wynikiem jest priorytet przy wypisywaniu wskazanego wyrażenia.
        // Im wyższy tym silniej dane wyrażenie wiąże argumenty.
        return Integer.MAX_VALUE;
        // Domyślną wartością jest maksymalna wartość w typi int, bo wiele
        // wyrażeń nie wymaga otaczania nawiasami (stałe, zmienna, funkcja
        // która ma nawiasy dookoła argumentów)
    }

    // Upraszczanie

    public Wyrażenie dodaj(Wyrażenie w)
    // Tworzy nowe - być może uproszczone - wyrażenie dla sumy. Uwaga
    // w wyniku upraszczanie może powstać wyrażenie nie będące sumą.
    // Domyślna implementacja nie potrafi upraszczać, daje szansę
    // uproszczenia drugiemu agrumentowi dodawania.
	{
		return w.dodajOdwr(this);
	}

    protected Wyrażenie dodajOdwr(Wyrażenie w)
    // Tworzy nowe - być może uproszczone - wyrażenie dla sumy. Ta metoda
    // jest wołana, gdy pierwszy argument dodawania (jest nim w) nie potrafił
    // upraszczać.
    // Uwaga: w wyniku upraszczanie może powstać wyrażenie nie będące sumą.
    // Domyślna implementacja nie potrafi upraszczać.
	{
		return new Plus(w, this);
	}

    protected Wyrażenie dodajStałą(Stała s) {
    // Tworzy nowe - być może uproszczone - wyrażenie z sumy, gdzie pierwszy
    // argument dodawania (s) był stałą.
    // Uwaga: w wyniku upraszczanie może powstać wyrażenie nie będące sumą.
    // Domyślna implementacja nie potrafi upraszczać.
		return new Plus(s, this); // return dodajOdwr(s);
	}

    public Wyrażenie pomnóż(Wyrażenie w)
    // Tworzy nowe - być może uproszczone - wyrażenie dla iloczynu. Uwaga
    // w wyniku upraszczanie może powstać wyrażenie nie będące iloczynem.
    // Domyślna implementacja nie potrafi upraszczać, daje szansę
    // uproszczenia drugiemu agrumentowi dodawania.
	{
		return w.pomnóżOdwr(this);
	}

    protected Wyrażenie pomnóżOdwr(Wyrażenie w)
    // Tworzy nowe - być może uproszczone - wyrażenie dla iloczynu. Ta metoda
    // jest wołana, gdy pierwszy argument mnozenia (jest nim w) nie potrafił
    // upraszczać.
    // Uwaga: w wyniku upraszczanie może powstać wyrażenie nie będące iloczynem.
    // Domyślna implementacja nie potrafi upraszczać.
	{
		return new Razy(w, this);
	}

    protected Wyrażenie pomnóżPrzezStałą(Stała s) {
    // Tworzy nowe - być może uproszczone - wyrażenie z iloczynu, gdzie pierwszy
    // argument dodawania (s) był stałą.
    // Uwaga: w wyniku upraszczanie może powstać wyrażenie nie będące iloczynem.
    // Domyślna implementacja nie potrafi upraszczać.
		return new Razy(s, this); // return pomnóżOdwr(s);
	}
}
package wyrażeniaZUpraszczaniem;

public class Stała extends Wyrażenie {

    private double wartość;

    @Override
    public Wyrażenie pochodna() {
        return Stała.twórz(0);
    }

    @Override
    public String toString() {
        return "" + wartość;
    }

    @Override
    public double policz(double x) {
        return wartość;
    }

    // Upraszczanie
    @Override
    public Wyrażenie dodaj(Wyrażenie w) {
        return w.dodajStałą(this);
    }

    // Uwaga: dodajOdwr nie potrzeba przedefiniowywać, skoro pierwszy argument
    // nie był stałą, to nic nie da się zrobić.

    @Override
    protected Wyrażenie dodajStałą(Stała s) {
        // Pierwszy argument dodawania (s) był stałą.
        return Stała.twórz(wartość + s.wartość); // Dla 0.0 i 1.0 daje obiekty klas Zero i Jeden
    }

    @Override
    public Wyrażenie pomnóż(Wyrażenie w) {
        return w.pomnóżPrzezStałą(this);
    }

    // Uwaga: pomnóżOdwr nie potrzeba przedefiniowywać, skoro pierwszy argument
    // nie był stałą, to nic nie da się zrobić.

    @Override
    protected Wyrażenie pomnóżPrzezStałą(Stała s) {
        // Pierwszy argument mnożenia (s) był stałą.
        return Stała.twórz(wartość * s.wartość);
    }

    // Tworzenie

    static public Stała twórz(double x) {
        if (x == 0.0) {
            return Zero.twórz();
        } else if (x == 1.0) {
            return Jeden.twórz();
        } else {
            return new Stała(x);
        }
    }

    // Konstruktory

    protected Stała(double wartość) {
        // Nie może być prywatny, bo wołają go konstruktory w Zero i Jeden.
        // Nie może być publiczny, bo stałe należy tworzyć metodą twórz.
        // Zwn na dziwną definicję protected w Javie lepiej by było zastosować
        // widoczność pakietową, ale protected jest czytelniejsze (lepiej tu
        // oddaje intencje).
        this.wartość = wartość;
    }
}
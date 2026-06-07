package wyrażeniaZUpraszczaniem;

public class Sin extends Funkcja {

    protected String nazwa() {
        return "sin";
    }

    public Wyrażenie pochodna() {
        return (new Cos(arg)).pomnóż(arg.pochodna());
    }

    public double policz(double x) {
        return Math.sin(arg.policz(x));
    }

    public Sin(Wyrażenie w) {
        super(w);
    }
}
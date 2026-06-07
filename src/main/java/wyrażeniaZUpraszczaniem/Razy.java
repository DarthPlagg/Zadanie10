package wyrażeniaZUpraszczaniem;

public class Razy extends Operator {

    @Override
    protected String operator() {
        return "*";
    }

    @Override
    public Wyrażenie pochodna() {
        return (lewe.pomnóż(prawe.pochodna())).dodaj(
                        (lewe.pochodna().pomnóż(prawe)));
    }

    @Override
    public double policz(double x) {
        return lewe.policz(x) * prawe.policz(x);
    }

    @Override
    public int priorytet() {
		return 1000;  // Ważne, żeby był większy od priorytetu operatorów addytywnych
	}

    public Razy(Wyrażenie lewe, Wyrażenie prawe) {
        super(lewe, prawe);
    }
}
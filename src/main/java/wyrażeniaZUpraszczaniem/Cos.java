package wyrażeniaZUpraszczaniem;

public class Cos extends Funkcja {

	protected String nazwa() {
		return "cos";
	}

	public Wyrażenie pochodna() {
		return (new JMinus(new Sin(arg)).pomnóż(arg.pochodna()));
	}

	public double policz(double x) {
		return Math.cos(arg.policz(x));
	}
    
    public Cos(Wyrażenie w){
     super(w);
    }


}
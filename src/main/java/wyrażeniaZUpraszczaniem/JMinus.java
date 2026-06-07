package wyrażeniaZUpraszczaniem;

/**
 * JMinus - Jednoargumentowy minus, potraktowany tu jako funkcja, czyli
 * wymaga zapisu -(wyr).
 * @author janusz
 */
public class JMinus extends Funkcja {

	protected String nazwa() {
		return "-";
	}

	public Wyrażenie pochodna() {
		return new JMinus(arg.pochodna());
	}

	public double policz(double x) {
		return - arg.policz(x);
	}

    public JMinus(Wyrażenie w){
      super(w);
    }

}

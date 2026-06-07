package wyrażeniaZUpraszczaniem;


/**
 *
 * @author janusz
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Wyrażenie jeden, zero, x;
        x = Zmienna.twórz();
        zero = Zero.twórz();
        jeden = Jeden.twórz();
        System.out.println("" + zero.dodaj(x));
        System.out.println("" + x.dodaj(zero));
        System.out.println("" + jeden.dodaj(zero));
        System.out.println("" + zero.pomnóż(x));
        System.out.println("" + x.pomnóż(zero));
        System.out.println("" + jeden.pomnóż(x));
        System.out.println("" + x.pomnóż(jeden));
        System.out.println("" + zero.pomnóż(jeden));
    }
}

package wyrażeniaZUpraszczaniem;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import org.junit.jupiter.api.Test;

public class WyrazenieTest {

    private static final double DELTA = 1e-9; // Margines błędu dla double

    @Test
    public void testPoliczZmiennaIStala() {
        Zmienna x = Zmienna.twórz();
        Stała s = Stała.twórz(5.5);

        assertEquals(10.0, x.policz(10.0), DELTA);
        assertEquals(5.5, s.policz(10.0), DELTA);
    }

    @Test
    public void testPoliczOperatory() {
        Wyrażenie w = new Plus(Stała.twórz(2.0), new Razy(Stała.twórz(3.0), Zmienna.twórz()));
        // f(x) = 2 + 3*x; f(4) = 14
        assertEquals(14.0, w.policz(4.0), DELTA);
    }

    @Test
    public void testPoliczFunkcje() {
        Wyrażenie w1 = new Sin(Zmienna.twórz());
        Wyrażenie w2 = new Cos(Zmienna.twórz());
        Wyrażenie w3 = new JMinus(Zmienna.twórz());
 
        assertEquals(1.0, w1.policz(Math.PI / 2), DELTA);
        assertEquals(-1.0, w2.policz(Math.PI), DELTA);
        assertEquals(-5.0, w3.policz(5.0), DELTA);
    }

    @Test
    public void testPochodna() {
        Zmienna x = Zmienna.twórz();
        
        // Pochodna z x to 1
        assertEquals(1.0, x.pochodna().policz(100.0), DELTA);
        
        // Pochodna ze stałej to 0
        assertEquals(0.0, Stała.twórz(10.0).pochodna().policz(5.0), DELTA);

        // Pochodna z x*x to 1*x + x*1 = 2x
        Wyrażenie xKwadrat = new Razy(x, x);
        assertEquals(6.0, xKwadrat.pochodna().policz(3.0), DELTA); // f'(3) = 2*3 = 6
        
        // Pochodna z sin(x) to cos(x)*1
        Wyrażenie sinX = new Sin(x);
        assertEquals(Math.cos(2.0), sinX.pochodna().policz(2.0), DELTA);
    }

    @Test
    public void testCalka() {
        Zmienna x = Zmienna.twórz();
        // Całka z x na przedziale [0, 2] wynosi 2
        assertEquals(2.0, x.całka(0, 2, 1000), 0.01);
        
        // Całka ze stałej 3 na przedziale [1, 4] wynosi 9
        Stała s = Stała.twórz(3.0);
        assertEquals(9.0, s.całka(1, 4, 100), 0.01);
    }

    @Test
    public void testUpraszczanieDodawanieZera() {
        Wyrażenie x = Zmienna.twórz();
        Wyrażenie zero = Zero.twórz();

        // x + 0 powinno się uprościć do x
        Wyrażenie suma1 = Plus.twórz(x, zero);
        assertSame(x, suma1, "Dodanie zera z prawej strony powinno zwrócić ten sam obiekt");

        // 0 + x powinno się uprościć do x
        Wyrażenie suma2 = Plus.twórz(zero, x);
        assertSame(x, suma2, "Dodanie zera z lewej strony powinno zwrócić ten sam obiekt");
    }

    @Test
    public void testUpraszczanieMnozeniePrzezJedenIZero() {
        Wyrażenie x = Zmienna.twórz();
        Wyrażenie zero = Zero.twórz();
        Wyrażenie jeden = Jeden.twórz();

        // x * 1 -> x
        assertSame(x, x.pomnóż(jeden));
        assertSame(x, jeden.pomnóż(x));

        // x * 0 -> 0
        assertSame(zero, x.pomnóż(zero));
        assertSame(zero, zero.pomnóż(x));
    }

    @Test
    public void testToStringZPriorytetami() {
        Wyrażenie x = Zmienna.twórz();
        Wyrażenie s2 = Stała.twórz(2.0);
        Wyrażenie s3 = Stała.twórz(3.0);

        // (2 + x) * 3 -> plus ma niższy priorytet, więc wymaga nawiasów
        Wyrażenie w1 = new Razy(new Plus(s2, x), s3);
        assertEquals("(2.0+x)*3.0", w1.toString());

        // 2 + (x * 3) -> razy ma wyższy, więc dodawanie nie narzuca nawiasów dla mnożenia
        Wyrażenie w2 = new Plus(s2, new Razy(x, s3));
        assertEquals("2.0+x*3.0", w2.toString());
        
        // -(x)
        Wyrażenie w3 = new JMinus(x);
        assertEquals("-(x)", w3.toString());
    }
}
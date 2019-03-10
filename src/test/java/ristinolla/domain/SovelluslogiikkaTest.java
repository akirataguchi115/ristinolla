package ristinolla.domain;

import java.util.List;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class SovelluslogiikkaTest {

    Sovelluslogiikka logiikka;

    @Before
    public void setUp() {
        logiikka = new Sovelluslogiikka();
    }

    @Test
    public void uusiPeliEiPaaty() {
        this.logiikka.alustaRuudut();
        assertFalse(this.logiikka.onkoPaattynyt());
    }

    @Test
    public void alustusToimii() {
        this.logiikka.alustaRuudut();
        boolean tyhja = true;
        for (List<String> ruudut : this.logiikka.getRuudut()) {
            for (String ruutu : ruudut) {
                if (!ruutu.contains("Tyhjä")) {
                    tyhja = false;
                }
            }
        }
        assertTrue(tyhja);
    }

    @Test
    public void toimiikoSallittuSiirto() {
        this.logiikka.alustaRuudut();
        assertTrue(this.logiikka.onkoSallittuSiirto("1,1"));
    }

    @Test
    public void sallitutSiirrotOikeassaFormaatissa() {
        this.logiikka.alustaRuudut();
        assertFalse(this.logiikka.onkoSallittuSiirto("34sd,4234134"));
    }
}

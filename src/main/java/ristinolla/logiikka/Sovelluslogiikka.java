package ristinolla.logiikka;

import java.util.ArrayList;
import java.util.List;

/**
 * Mainitaan muuttujat ensimmäistä kertaa
 * @author Akira
 */
public class Sovelluslogiikka {

    private List<List<String>> ruudut;
    private String vuoro;
    private String voittaja;

    /**
     *Parametriton konstruktori alustaa muuttujat
     */
    public Sovelluslogiikka() {
        this.ruudut = new ArrayList<>();
        this.vuoro = "Risti";
        this.voittaja = "";
    }

    /**
     *tyhjentää kaikki ruudut pelissä
     */
    public void alustaRuudut() {
        this.ruudut.clear();
        for (int u = 0; u < 3; u++) {
            this.ruudut.add(new ArrayList<String>());
            for (int i = 0; i < 3; i++) {
                this.ruudut.get(u).add("Tyhjä");
            }
        }
    }

    /**
     * Checks horizontal, vertical and cross streaks of 3
     * @return true if someone has won, or there are no space left in the grid
     * @since 2.16
     */
    public boolean onkoPaattynyt() { //testaa onko voittaja horisontaalissa
        int risti = 0;
        int nolla = 0;
        for (int i = 0; i < this.ruudut.size(); i++) {
            for (int u = 0; u < this.ruudut.get(i).size(); u++) {
                if (this.ruudut.get(i).get(u).equals("Risti")) {
                    risti++;
                } else if (this.ruudut.get(i).get(u).equals("Nolla")) {
                    nolla++;
                }
            }
            if (risti == 3) {
                this.voittaja = "Risti";
                return true;
            } else if (nolla == 3) {
                this.voittaja = "Nolla";
                return true;
            }
            risti = 0;
            nolla = 0;
        }

        for (int i = 0; i < this.ruudut.size(); i++) {
            for (int u = 0; u < this.ruudut.get(i).size(); u++) {
                if (this.ruudut.get(u).get(i).equals("Risti")) {
                    risti++;
                } else if (this.ruudut.get(u).get(i).equals("Nolla")) {
                    nolla++;
                }
            }
            if (risti  == 3) {
                this.voittaja = "Risti";
                return true;
            } else if (nolla == 3) {
                this.voittaja = "Nolla";
                return true;
            }
            risti = 0;
            nolla = 0;
        }

        for (int i = 0; i < this.ruudut.size(); i++) {
            if (this.ruudut.get(i).get(i).equals("Risti")) {
                risti++;
            } else if (this.ruudut.get(i).get(i).equals("Nolla")) {
                nolla++;
            }
        }
        if (risti == 3) {
            this.voittaja = "Risti";
            return true;
        } else if (nolla == 3) {
            this.voittaja = "Nolla";
            return true;
        }
        risti = 0;
        nolla = 0;
        
        //cross-check
        for (int i = 2; i >= 0; i--) {
            if (this.ruudut.get(2-i).get(i).equals("Risti")) {
                risti++;
            } else if (this.ruudut.get(2-i).get(i).equals("Nolla")) {
                nolla++;
            }
        }
        if (risti == 3) {
            this.voittaja = "Risti";
            return true;
        } else if (nolla == 3) {
            this.voittaja = "Nolla";
            return true;
        }
        risti = 0;
        nolla = 0;

        for (int i = 0; i < this.ruudut.size(); i++) {
            if (this.ruudut.get(i).contains("Tyhjä")) {
                return false;
            }
        }
        return true;
    }

    /**
     *
     * @param siirto String format: x + "," + y
     * @return boolean whether the grid is empty
     */
    public boolean onkoSallittuSiirto(String siirto) {
        String[] palat = siirto.split(",");
        int x;
        int y;
        try {
            x = Integer.valueOf(palat[0]);
            y = Integer.valueOf(palat[1]);
        } catch (NumberFormatException e) {
            return false;
        }

        if (x >= this.ruudut.size() || x < 0
                || y >= this.ruudut.get(0).size() || y < 0) {
            return false;
        }
        if (this.ruudut.get(x).get(y).equals("Tyhjä")) {
            return true;
        }
        return false;
    }

    /**
     *Usually following the method onkoSallittuSiirto (checks if the place in the grid is empty)
     * @param siirto coordinates of the place in the grid
     */
    public void siirra(String siirto) {
        String[] palat = siirto.split(",");
        int x = Integer.valueOf(palat[0]);
        int y = Integer.valueOf(palat[1]);
        this.ruudut.get(x).set(y, this.vuoro);
    }

    /**
     *Mikäli vuoro on risti, vaihtuu vuoroksi nolla
     * ja vice versa
     */
    public void vuoronVaihto() {
        if (this.vuoro.equals("Risti")) {
            this.vuoro = "Nolla";
        } else {
            this.vuoro = "Risti";
        }
    }

    /**
     *
     * @return
     */
    public List<List<String>> getRuudut() {
        return ruudut;
    }

    /**
     *
     * @return
     */
    public String getVoittaja() {
        return voittaja;
    }

    /**
     *
     * @return
     */
    public String getVuoro() {
        return vuoro;
    }
}

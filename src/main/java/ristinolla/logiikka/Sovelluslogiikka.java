package ristinolla.logiikka;

import java.util.ArrayList;
import java.util.List;

public class Sovelluslogiikka {

    private List<List<String>> ruudut;
    private String vuoro;
    private String voittaja;

    public Sovelluslogiikka() {
        this.ruudut = new ArrayList<>();
        this.vuoro = "Risti";
        this.voittaja = "";
    }

    public void alustaRuudut() {
        this.ruudut.clear();
        for (int u = 0; u < 3; u++) {
            this.ruudut.add(new ArrayList<String>());
            for (int i = 0; i < 3; i++) {
                this.ruudut.get(u).add("Tyhjä");
            }
        }
    }

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

    public void siirra(String siirto) {
        String[] palat = siirto.split(",");
        int x = Integer.valueOf(palat[0]);
        int y = Integer.valueOf(palat[1]);
        this.ruudut.get(x).set(y, this.vuoro);
    }

    public void vuoronVaihto() {
        if (this.vuoro.equals("Risti")) {
            this.vuoro = "Nolla";
        } else {
            this.vuoro = "Risti";
        }
    }

    public List<List<String>> getRuudut() {
        return ruudut;
    }

    public String getVoittaja() {
        return voittaja;
    }

    public String getVuoro() {
        return vuoro;
    }
}

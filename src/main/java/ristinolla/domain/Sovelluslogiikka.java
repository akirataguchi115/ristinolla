package ristinolla.domain;

import java.util.ArrayList;
import java.util.List;

public class Sovelluslogiikka {

    private List<List<String>> ruudut;
    private String vuoro = "Risti";

    public Sovelluslogiikka() {
        this.ruudut = new ArrayList<>();
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

    public List<List<String>> getRuudut() {
        return ruudut;
    }
}

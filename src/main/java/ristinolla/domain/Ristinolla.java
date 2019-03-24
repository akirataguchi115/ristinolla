package ristinolla.domain;

import ristinolla.kayttoliittyma.TekstiKayttoliittyma;
import java.util.ArrayList;
import java.util.List;

public class Ristinolla {

    public static void main(String[] args) {
        System.out.print("Starting the application...");
        TekstiKayttoliittyma kayttis = new TekstiKayttoliittyma();
        kayttis.kaynnista();
    }
}

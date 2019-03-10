package ristinolla.domain;

import java.util.ArrayList;
import java.util.List;

public class Ristinolla {

    public static void main(String[] args) {
        System.out.print("Starting the application...");
        Kayttoliittyma kayttis = new Kayttoliittyma();
        kayttis.kaynnista();
    }
}

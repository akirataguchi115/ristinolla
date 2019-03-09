package ristinolla.domain;

import java.util.List;
import java.util.Scanner;

public class Kayttoliittyma {

    Sovelluslogiikka logiikka;
    Scanner lukija;

    public Kayttoliittyma() {
        this.logiikka = new Sovelluslogiikka();
        this.lukija = new Scanner(System.in);
    }

    public void kaynnista() {
        System.out.println("Tervetuloa ristinollaan!\n"
                + "Kolme putkeen voittaa\n"
                + "Syöte muodossa \"x,y\"");
        logiikka.alustaRuudut();

        boolean jatka = true;
        while (jatka) {
            //tulosta tila
            for (List<String> lista : this.logiikka.getRuudut()) {
                for (String ruutu : lista) {
                    if (ruutu.equals("Tyhjä")) {
                        System.out.print("-");
                    }
                }
                System.out.print("\n");
            }
            while (true) {
                System.out.print(">");
                String siirto = lukija.nextLine();
                if (this.logiikka.sallittuSiirto(siirto)) {
                    break;
                }
                System.out.println("Epäkelpo syöte!");
            }
            if (this.logiikka.paattynyt()) {
                jatka = false;
                continue;
            }
        }
        //julista voittaja
    }
}

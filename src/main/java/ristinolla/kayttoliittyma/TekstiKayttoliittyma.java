package ristinolla.kayttoliittyma;

import ristinolla.logiikka.Sovelluslogiikka;
import java.util.List;
import java.util.Scanner;

public class TekstiKayttoliittyma {

    Sovelluslogiikka logiikka;
    Scanner lukija;

    public TekstiKayttoliittyma() {
        this.logiikka = new Sovelluslogiikka();
        this.lukija = new Scanner(System.in);
    }

    public void kaynnista() {
        System.out.println("Tervetuloa ristinollaan!\n"
                + "Kolme putkeen voittaa\n"
                + "Syöte muodossa \"x,y\"");
        this.logiikka.alustaRuudut();

        boolean jatka = true;
        while (jatka) {
            System.out.print("\nSiirtovuoro: " + this.logiikka.getVuoro() + "\n");
            tulostaTilanne();
            System.out.print("\n");
            while (true) {
                System.out.print(">");
                String siirto = lukija.nextLine();
                if (this.logiikka.onkoSallittuSiirto(siirto)) {
                    this.logiikka.siirra(siirto);
                    break;
                }
                System.out.println("Epäkelpo syöte!");
            }
            if (this.logiikka.onkoPaattynyt()) {
                //chekkaa onko draw
                jatka = false;
            }
            this.logiikka.vuoronVaihto();
        }
        tulostaTilanne();
        if (this.logiikka.getVoittaja().isEmpty()) {
            System.out.print("Game over!\nTasapeli!");
        } else {
            System.out.print("Game over!\nVoittaja: "
                    + this.logiikka.getVoittaja()
            );
        }
    }

    public void tulostaTilanne() {
        for (List<String> lista : this.logiikka.getRuudut()) {
            for (String ruutu : lista) {
                switch (ruutu) {
                    case "Tyhjä":
                        System.out.print("-");
                        break;
                    case "Risti":
                        System.out.print("X");
                        break;
                    case "Nolla":
                        System.out.print("0");
                        break;
                }
            }
            System.out.print("\n");
        }
    }
}

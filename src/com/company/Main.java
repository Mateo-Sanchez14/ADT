package com.company;

import clases.ListaClub;
import clases.Socio;

public class Main {

    public static void main(String[] args) {
        ListaClub listaClub = ListaClub.crearListaClub();

        listaClub.agregarSocio(new Socio(1));
        listaClub.agregarSocio(new Socio(2));
        listaClub.agregarSocio(new Socio(3));
        listaClub.agregarSocio(new Socio(4));
        listaClub.agregarSocio(new Socio(5));

        listaClub.mostrarClub();

        boolean estaSocio5 = listaClub.esta(new Socio(5));
        System.out.println("estaSocio5 = " + estaSocio5);
        boolean estaSocio10 = listaClub.esta(new Socio(10));
        System.out.println("estaSocio10 = " + estaSocio10);

        boolean esClubVacio = listaClub.estaVacio();
        System.out.println("esClubVacio = " + esClubVacio);

        Socio ultimoSocio = listaClub.ultimoSocio();
        System.out.println("ultimoSocio = " + ultimoSocio);

    }
}

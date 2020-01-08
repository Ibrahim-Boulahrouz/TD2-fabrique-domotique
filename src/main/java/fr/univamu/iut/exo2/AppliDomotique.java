package fr.univamu.iut.exo2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class AppliDomotique {
    static ArrayList<Connectable> objets = new ArrayList<Connectable>();

    public static String menu() {
        String choix = "null";
        System.out.println("Taper 0 pour finir, 1 pour connecter une cafetière et 2 pour une radio");
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        try {
            choix = in.readLine();
        } catch (IOException e) {
            System.out.println("Problème de saisie");
        }
        return choix;
    }

    public static void connecter(String type) {
        try {
            Class obj = Class.forName(type);
            Connectable finalObj = (Connectable) obj.newInstance();
            objets.add(finalObj);
            finalObj.equiper("lol");
        }catch(ClassNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String type = menu();
        while (!type.equals("")) {
            connecter(type);
            type = menu();
        }
        System.out.println(objets);
    }
}

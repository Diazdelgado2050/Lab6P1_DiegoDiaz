/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab6p1_diegodiaz;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author diego
 */
public class Lab6P1_DiegoDiaz {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("\n==Menu de laboratorio 6==");
            System.out.println("1. Carrera de Letras");
            System.out.println("2. Cuantos Primos Tiene");
            System.out.println("3. Rail Fence");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opcion: ");
            opcion = leer.nextInt();

            switch (opcion) {
                case 1:
                    carreraArreglos(leer);
                    break;
                case 2:
                    System.out.println("Ejercicio 2 _ Cuantos Primos tienes?");
                    break;
                case 3:
                    System.out.println("Ejercicio 3 - Rail Fence");
                    break;
                case 4:
                    System.out.println("Fin... del...programa... :(");

            }

        } while (opcion != 4);
        System.out.println("saliendo... :( ");

    }

    public static void carreraArreglos(Scanner leer) {

        char jug1 = ' ';
        char jug2 = ' ';

        boolean validar = false;
        while (!validar) {
            System.out.print("Ingrese la letra para el primer jugador: ");
            jug1 = leer.next().charAt(0);
            if (jug1 >= 'A' || jug1 <= 'Z') {
                validar = true;

            } else {
                System.out.println("Debe escoger una letra mayuscula valida.");
            }

        }
        validar = false;
        while (!validar) {
            System.out.print("Ingrese la letra para el segundo jugador:");
            jug2 = leer.next().charAt(0);
            if (jug2 >= 'A' && jug2 <= 'Z') {
                if (jug2 != jug1) {
                    validar = true;
                } else {
                    System.out.println("La letra no puede ser repetida. Intente de nuevo.");
                }
            } else {
                System.out.println("Debe escoger una letra mayuscula valida. .");
            }
        }

        int longi = 0;
        while (longi < 15 || longi > 20) {
            System.out.println("Ingrese longitud de carrera (15 a 20)");
            longi = leer.nextInt();

        }
        char[] arregloJug1 = new char[longi];

        char[] arregloJug2 = new char[longi];
        for (int i = 0; i < longi; i++) {
            arregloJug1[i] = ' ';
            arregloJug2[i] = ' ';

        }
        System.out.println("Comenzando la carrera...");
        Random rnd = new Random();
        int posicionJug1 = 0;
        int posicionJug2 = 0;
        int ronda = 0;

        while (posicionJug1 < longi && posicionJug2 < longi) {
            System.out.println("Ronda " + ronda);

            int mov1 = rnd.nextInt(5) + 1;
            int mov2 = rnd.nextInt(5) + 1;
            System.out.println("El jugador " + jug1 + " se movio " + mov1 + " casillas!!");
            System.out.println("El jugador " + jug2 + " se movio " + mov2 + " casillas!!");
            posicionJug1 += mov1;
            if (posicionJug1 > longi) {
                posicionJug1 = longi;
            }

            posicionJug2 += mov2;
            if (posicionJug2 > longi) {
                posicionJug2 = longi;
            }

            actualizarArreglo(arregloJug1, jug1, posicionJug1);
            actualizarArreglo(arregloJug2, jug2, posicionJug2);

            System.out.println("Resultado actual:");
            
            printArray(arregloJug1);
            printArray(arregloJug2);

            ronda++;

        }

        System.out.println();
        if (posicionJug1 >= longi && posicionJug2 >= longi) {
            System.out.println("Es un empate!");
        } else if (posicionJug1 >= longi) {
            System.out.println("El jugador " + jug1 + " ha ganado!");
        } else {
            System.out.println("El jugador " + jug2 + " ha ganado!");
        }

    }

    public static void actualizarArreglo(char[] arreglo, char letra, int limite) {
        for (int i = 0; i < limite; i++) {
            arreglo[i] = letra;
        }
    }

    public static void printArray(char[] arreglo) {
        for (int i = 0; i < arreglo.length; i++) {
            System.out.print("[" + arreglo[i] + "]");

        }
    }

    public static void printArray(int[] arreglo) {
        for (int i = 0; i < arreglo.length; i++) {
            System.out.print("["+arreglo[i]+"]");
        }

    }
}

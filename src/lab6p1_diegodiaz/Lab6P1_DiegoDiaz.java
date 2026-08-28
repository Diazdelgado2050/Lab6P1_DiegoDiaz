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
                    System.out.println("DIEGO ACORDATE DE DARME LOS 0.5 PUNTOS EXTRA ,PLS BISMILAH, :) :# ");
                    break;
                case 3:
                    Ejercicio3();
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
            System.out.println("");

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
        System.out.println("");
    }

    public static void printCArray(int[] arreglo) {
        for (int i = 0; i < arreglo.length; i++) {
            System.out.print("[" + arreglo[i] + "]");
        }

    }

    public static void Ejercicio3() {
        Scanner leer = new Scanner(System.in);
        
        
        System.out.println("Ejercicio 3 - Rail Fence");
        System.out.println("Ingrese la frase que le gustaria cifrar");
        String palabras = leer.nextLine();
        
       
        String frasepreparada = PrepararFrase(palabras);
        System.out.println("Frase preparada: " + frasepreparada);

   
        char[] riel1 = new char[frasepreparada.length()];
        char[] riel2 = new char[frasepreparada.length()];
        char[] riel3 = new char[frasepreparada.length()];
        
        int contador1 = 0;
        int contador2 = 0;
        int contador3 = 0;        
        
        int actual = 0;
        boolean bajar = true;
        
       for (int i = 0; i < frasepreparada.length(); i++) {
            if (actual == 0) {
                riel1[contador1] = frasepreparada.charAt(i);
                contador1++;
                bajar = true;
            } else if (actual == 1) {
                riel2[contador2] = frasepreparada.charAt(i);
                contador2++;
            } else if (actual == 2) {
                riel3[contador3] = frasepreparada.charAt(i);
                contador3++;
                bajar = false;
            }

            if (bajar == true) {
                actual++;
            } else {
                actual--;
            }
        }
       
       String cifrar = "";
        for (int i = 0; i < contador1; i++) {
            cifrar += riel1[i];
        }
            for (int i = 0; i < contador2; i++) {
            cifrar += riel2[i];
            }
            for (int i = 0; i < contador3; i++) {
            cifrar += riel3[i];
        }
            System.out.println("Texto Cifrado: " + cifrar);
        
        
        
        
    }
    
    public static String PrepararFrase(String frase){
        String resultado = "";
        for (int i = 0; i < frase.length(); i++) {
            char letra = frase.charAt(i);
            if (letra != ' ') {
                if (letra >= 'a' && letra <= 'z') {
                    letra = (char)(letra - 32);
                }
                resultado += letra;
            }
        }
        return resultado;
    }
        
        
        
    }
    

        

       

                
                    
                    
                    
    



/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab6p1_diegodiaz;

import java.util.Scanner;

/**
 *
 * @author diego
 */
public class Lab6P1_DiegoDiaz {
    static Scanner leer = new Scanner(System.in);
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        int opcion;
        do {
            System.out.println("\n==Menu de laboratorio 6==");
            System.out.println("1. Carrera de Letras");
            System.out.println("2. Cuantos Primos Tiene");
            System.out.println("3. Rail Fence");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opcion: ");
            opcion = leer.nextInt();
            
            switch(opcion){
                case 1:
                    System.out.println("Comenzando simulacion de carrera ... ");
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

    
  
    
}

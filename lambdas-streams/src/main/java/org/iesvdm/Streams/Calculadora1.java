package org.iesvdm.Streams;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// Definimos una interfaz funcional para las operaciones
@FunctionalInterface
interface Operacion {
    double oper(double x, double y);
}

public class Calculadora1 {
    
    // Mapa para asociar cadenas (operadores) con operaciones
    private static Map<String, Operacion> mapOperaciones = new HashMap<>();

    public static void main(String[] args) {
        // Definimos las operaciones y las asociamos a símbolos y nombres
        Operacion suma = (x, y) -> x + y;
        mapOperaciones.put("+", suma);
        mapOperaciones.put("add", suma);

        mapOperaciones.put("-", (x, y) -> x - y);
        mapOperaciones.put("sub", (x, y) -> x - y);

        mapOperaciones.put("*", (x, y) -> x * y);
        mapOperaciones.put("mul", (x, y) -> x * y);

        mapOperaciones.put("/", (x, y) -> x / y);
        mapOperaciones.put("div", (x, y) -> x / y);

        String input = "";
        Scanner sc = new Scanner(System.in);
        
        
        // Bucle principal: lee hasta que el usuario escriba "exit" o "salir"
        while (!"exit".equalsIgnoreCase(input)
                && !"salir".equalsIgnoreCase(input)) {
            input = sc.nextLine();
            // Espera entradas tipo: "+ 23 45"

            String[] instruccion = input.trim().split(" ");

            if (instruccion.length != 3) {
                System.out.println("Formato de entrada " + input + " incorrecto");
            } else {
                // ["+","23","45"]
                if (mapOperaciones.containsKey(instruccion[0]) && comprobar(instruccion[1])!=false && comprobar(instruccion[2])!=false) {
                    // Ejecuta la operación y muestra el resultado
                    Operacion op = mapOperaciones.get(instruccion[0]);
                    Double result = op.oper(Double.parseDouble(instruccion[1]), Double.parseDouble(instruccion[2]));
                    System.out.println("Resultado: " + result);
                } else {
                    System.out.println("Operacion " + instruccion[0] + " no contemplada");
                }
            }
        }
        sc.close();
    }

    public static boolean comprobar(String a){
        double oper1 = 0;
         try {
             oper1 = Double.parseDouble(a);
             return true;
        } catch (NumberFormatException nfe) {
                 System.out.println("Formato de 1er parámetro " + a + " incorrecto");
               return false;
        }
        }
}

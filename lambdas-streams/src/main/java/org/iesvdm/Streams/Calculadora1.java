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
            if(longitud(instruccion, input)){
                Operacion op = mapOperaciones.get(instruccion[0]);
                    Double result = op.oper(Double.parseDouble(instruccion[1]), Double.parseDouble(instruccion[2]));
                    System.out.println("Resultado: " + result);
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

        public static boolean longitud(String[] a, String b){
            boolean correcto = false;
              if (a.length != 3) {
                System.out.println("Formato de entrada " + b + " incorrecto");
            } else {
                // ["+","23","45"]
                if (mapOperaciones.containsKey(a[0]) && comprobar(a[1])!=false && comprobar(a[2])!=false) {
                    // Ejecuta la operación y muestra el resultado
                    
                    correcto = true;
                } else {
                    System.out.println("Operacion " + a[0] + " no contemplada");
                }
            }
            return correcto;
        }
}

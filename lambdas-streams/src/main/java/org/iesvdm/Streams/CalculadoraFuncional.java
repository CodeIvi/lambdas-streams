package org.iesvdm.Streams;


import java.util.Map;
import java.util.Scanner;
import java.util.HashMap;


public class CalculadoraFuncional {

    private static Map<String, Operacion> mapOperaciones = new HashMap<>();

    public static void main(String [] args) {

        Operacion suma= ((x, y) -> x + y);

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
        boolean salir = false;

        while(!salir){
            
            input = sc.nextLine();

            salir = "exit".equalsIgnoreCase(input)|| "salir".equalsIgnoreCase(input);

            String[] instruccionArr = input.trim().split(" ");

            if(mapOperaciones.keySet().contains(instruccionArr[0])) {

                Double oper1 = parseo(instruccionArr[1]);
                Double oper2 = parseo(instruccionArr[2]);

                if(oper1 != null && oper2 != null) {

                    Operacion op = mapOperaciones.get(instruccionArr[0]);

                    Double resl = op.oper(oper1, oper2);

                    System.out.println("Resultado " + resl);

                }

            } else {

                System.out.println("Operacion '"+ instruccionArr[0] + "' no contemplada");

            }

            sc.close();

        }
    }

    public static Double parseo(String str) {

        Double n = null;

        try {
            n = Double.parseDouble(str);
        } catch(NumberFormatException nfe) {
            System.out.println("Formato de 1er parámetro '" + str + "' incorrecto");
        }

        return n;

    }
    
} 
    


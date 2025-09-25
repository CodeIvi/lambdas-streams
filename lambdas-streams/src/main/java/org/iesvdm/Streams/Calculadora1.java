package org.iesvdm.Streams;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Calculadora1 {

    private static Map<String, Operacion> mapOperaciones = new HashMap<>();

    private static Map<String, OperacionStr> mapOperacionesStr = new HashMap<>();

    private void inicializar() {

        Operacion suma= ((x, y) -> x + y);
        Operacion resta = ((x, y) -> x - y);
        Operacion mult = ((x, y) -> x * y);
        Operacion div = ((x, y) -> {
            
            if (y == 0) {

                throw new IllegalArgumentException();

            }
            
            return x / y; 
            
        }
        
        );

        mapOperaciones.put("+", suma);
        mapOperaciones.put("add", suma);

        mapOperaciones.put("-", resta);
        mapOperaciones.put("sub", resta);

        mapOperaciones.put("mul", mult);
        mapOperaciones.put("*", mult);

        mapOperaciones.put("/", div);
        mapOperaciones.put("div", div);

        ////////////////////////////////////
        /// OperacionesStr
        /// 
        
        OperacionStr upper = a -> a.toUpperCase();
        mapOperacionesStr.put("upper", upper);

        mapOperacionesStr.put("lower", s -> s.toLowerCase());
        
        
        mapOperacionesStr.put("lower", s -> {
            //Otros pasos
            //...
            return  s.toLowerCase();
        
        });


    }

    
    public static void main(String [] args) {

        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        boolean salir = false;

        String str = "hola mundo";
        

        while(!salir){
            
            //convertimos el input en un Ararray
            String[] instruccionArr = input.trim().split(" ");

            //Valido input y hago la operacion correspondiente.
            if (validarInput.validarStr(instruccionArr, mapOperacionesStr.keySet())) {


            
            } else if(validarInput.validar(instruccionArr, mapOperaciones.keySet())) {

                Operacion.calcular(instruccionArr, mapOperaciones);

            }
            
            //Pido nuevo input
            input = sc.nextLine();

            //Condicion de salida
            salir = input.equalsIgnoreCase("exit") || input.equalsIgnoreCase("salir");

        }

        sc.close();

    }



    

}

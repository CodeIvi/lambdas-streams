package org.iesvdm.Streams;


   import java.util.Map;

public interface Operacion {

    public double oper(double x, double y);

    public static void calcular(String[] instruccionArr, Map<String, Operacion> mapOperaciones) {

        Double oper1 = parseo(instruccionArr[1]);
        Double oper2 = parseo(instruccionArr[2]);

        Operacion op = mapOperaciones.get(instruccionArr[0]);

        Double resl = op.oper(oper1, oper2);

        System.out.println("Resultado " + resl);


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


    

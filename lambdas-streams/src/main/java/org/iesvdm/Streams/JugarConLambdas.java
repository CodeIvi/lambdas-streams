package org.iesvdm.Streams;

public class JugarConLambdas {

    public static void main(String[] args) {
        Operacion oper = ( x,  y)->  x+y;

        System.out.println("Suma: "+oper.oper(1,2));

        oper = (x,y) -> x*y;

        System.out.println("Producto: "+oper.oper(2,3));
    } 
    
}

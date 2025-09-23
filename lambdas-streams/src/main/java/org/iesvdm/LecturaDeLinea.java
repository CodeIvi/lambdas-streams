package org.iesvdm;

import java.io.IO;
import java.io.IOException;

public class LecturaDeLinea {
    public static void main(String[] args) throws IOException{ 
    
    int c = 0;
    int contador = 0;

    while((c=System.in.read()) != '\n'){
        contador++;

        System.out.print((char) c );

    }
    System.out.println("");
    System.out.println("Leídos " + contador +" caracteres");
    }
}

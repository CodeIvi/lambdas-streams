package org.iesvdm;

import java.io.FileReader;

public class LecturaReader {
    public static void main(String[] args) {
        try {
            // Crea un FileReader 
            FileReader reader = new FileReader("/home/ivan/Descargas/lambdas-streams/lambdas-streams/input.txt");

            // Lee el primer carácter
            int i = reader.read();

            while (i != -1) {
                System.out.print((char) i);

                // Lee el siguiente carácter
                i = reader.read();
            }
            reader.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

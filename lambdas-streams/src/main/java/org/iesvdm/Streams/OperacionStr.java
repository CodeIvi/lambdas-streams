package org.iesvdm.Streams;

import java.util.Map;

public interface OperacionStr {

    // 
    //
    // s -> s.toUpperCase()
    
    public String transforma(String str);

    public static String transformar(String[] instruccionesArr, Map<String, OperacionStr> mapOperacionesStr) {

        return mapOperacionesStr
                    .get(instruccionesArr[0])
                    .transforma(instruccionesArr[1]);

    }

}
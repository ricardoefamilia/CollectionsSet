package ColletionsMap;

import java.util.*;

public class ExemploMap {
    public static void main(String[] args) {
        //Exemplo de Map Map<tipodachave, tipodovalor>
        Map<String, Double> carrosPopulares = new HashMap<>() {{
            put("Gol", 14.4);
            put("Uno", 15.6);
            put("Mobi", 16.1);
            put("HB20", 14.5);
            put("Kwid", 16.1);
        }};
        //HasMap
        System.out.println("***\tOrdem Aleatória\t***");
        System.out.println(carrosPopulares.toString());
        System.out.println();

        System.out.println("Substitua o consukmo do Gol por 15,2 km/l: ");
        carrosPopulares.put("Gol",15.2);
        System.out.println(carrosPopulares.toString());
        System.out.println();

        System.out.println("Confira se o modelo Tucson está no dicionário: "+carrosPopulares.containsKey("Tucson"));
        System.out.println();

        System.out.println("Exiba o consumo do uno: "+carrosPopulares.get("Uno"));
        System.out.println();

        System.out.println("Exiba os modelos: ");
        Set<String> modelos = carrosPopulares.keySet();
        System.out.println(modelos);
        System.out.println();

        System.out.println("Exiba os consumos: ");
        Collection<Double> values = carrosPopulares.values();
        System.out.println(values);
        System.out.println();

        System.out.println("Exiba o modelo mais econômico e seu consumo: ");
        Double consumoMaisEficiente = Collections.max(carrosPopulares.values());
        Set<Map.Entry<String, Double>> entries = carrosPopulares.entrySet();
        String modeloMaisEficiente = "";
        for (Map.Entry<String, Double> entry: entries) {
            if(entry.getValue().equals(consumoMaisEficiente)){
                modeloMaisEficiente = entry.getKey();
                System.out.println("Modelo mais eficiente: " + modeloMaisEficiente +
                        " - Consumo: "+consumoMaisEficiente);
            }
        }
        System.out.println();

    }
}

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

        System.out.println("Exiba o modelo menos econômico e seu consumo: ");
        Double consumoMenosEficiente = Collections.min(carrosPopulares.values());
        Set<Map.Entry<String, Double>> entries2 = carrosPopulares.entrySet();
        String modeloMenosEficiente = "";
        for (Map.Entry<String, Double> entry: entries2) {
            if(entry.getValue().equals(consumoMenosEficiente)){
                modeloMenosEficiente = entry.getKey();
                System.out.println("Modelo menos eficiente: " + modeloMenosEficiente +
                        " - Consumo: "+consumoMenosEficiente);
            }
        }

        //soma dos consumos
        Iterator<Double> iterator = carrosPopulares.values().iterator();
        Double soma = 0.0;
        while(iterator.hasNext()){
            soma += iterator.next();
        }
        System.out.println("Exiba a soma dos consumos: " + soma);

        System.out.println("Exiba a média dos consumos: " + (soma/carrosPopulares.size()));

        //Remova os modelos com o consumo igual a 15,6 km/l
        Iterator<Double> iterator2 = carrosPopulares.values().iterator();
        while(iterator2.hasNext()){
            if(iterator2.next().equals(15.6)) iterator2.remove();
        }
        System.out.println("Remova os modelos com o consumo igual a 15,6 km/l: ");
        System.out.println(carrosPopulares);

        System.out.println("Exiba todos os carros na ordem em que foram informados");
        Map<String, Double> carrosPopulares2 = new LinkedHashMap<>() {{
            put("Gol", 14.4);
            put("Uno", 15.6);
            put("Mobi", 16.1);
            put("HB20", 14.5);
            put("Kwid", 16.1);
        }};
        System.out.println(carrosPopulares2);

        System.out.println("Exiba o dicionário ordenado pelo modelo: ");
        Map<String, Double> carrosPopulares3 = new TreeMap<>(carrosPopulares2);
        System.out.println(carrosPopulares3);

        System.out.println("Apague o dicionário de carros: ");
        carrosPopulares.clear();
        System.out.println("Confira se o dicionário de carros está vazio: " + carrosPopulares.isEmpty());

    }
}

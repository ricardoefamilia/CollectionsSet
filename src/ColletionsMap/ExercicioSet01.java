package ColletionsMap;

import jdk.swing.interop.SwingInterOpUtils;

import java.util.*;

public class ExercicioSet01 {
    public static void main(String[] args) {
       //map de estados (nome e população)
        Map<String,Integer> estados = new HashMap<>(){{
            put("PE",9616621);
            put("AL",3351543);
            put("CE",9187103);
            put("RN",3534265);
        }};
        System.out.println("---\tEstados\t---");
        System.out.println(estados);

        //Substituir população de RN po 3534165
        estados.put("RN", 3534165);
        System.out.println("---\tEstados\t---");
        System.out.println(estados);

        if(!estados.containsKey("PB")) estados.put("PB",4039277);
        System.out.println("---\tEstados\t---");
        System.out.println(estados);

        System.out.println("População de PE: "+estados.get("PE"));

        Map<String,Integer> estados1 = new LinkedHashMap<>(){{
            put("PE",9616621);
            put("AL",3351543);
            put("CE",9187103);
            put("RN",3534265);
            put("PB",4039277);
        }};
        System.out.println("--\tordem de inserção\t--");
        System.out.println(estados1);

        //ordem alfabética (pela key)
        Map<String,Integer> estados2 = new TreeMap<>(estados);
        System.out.println("--\tordem alfabética (pela key)\t--");
        System.out.println(estados2);

        //estado com MENOR população
        Integer menorPopulacao = Collections.min(estados.values());
        Set<Map.Entry<String, Integer>> entries1 = estados.entrySet();
        for(Map.Entry<String,Integer> le: entries1){
            if(le.getValue() == menorPopulacao){
                System.out.println("Estado com menor população: "+le.getKey()+" - "+le.getValue());
            }
        }

        //estado com MAIOR população
        Integer maiorPopulacao = Collections.max(estados.values());
        Set<Map.Entry<String, Integer>> entries2 = estados.entrySet();
        for(Map.Entry<String,Integer> le:entries2){
            if(le.getValue() == maiorPopulacao){
                System.out.println("Estado com maior população: "+le.getKey()+" - "+le.getValue());
            }
        }

        //soma da população dos estados inseridos
        Iterator<Integer> iterator = estados.values().iterator();
        Double soma = 0d;
        while (iterator.hasNext()){
            soma += iterator.next();
        }
        System.out.println("Soma da população dos estados inseridos: "+soma);

        //Média da população dos estados inseridos
        Double media = soma/estados.size();
        System.out.println("Média da população dos estados inseridos: "+media);

        //Remover os estados com população menor que 4.000.000
        Iterator<Integer> iterator2 = estados.values().iterator();
        while (iterator2.hasNext()){
            if(iterator2.next() < 4000000) iterator2.remove();
        }
        System.out.println("Remover os estados com população menor que 4.000.000");
        System.out.println(estados);

        //Apagar o dicionário
        estados.clear();

        //Confira se o dicionário está vazio
        System.out.println("Dicionário vazio: " + estados.isEmpty());
    }
}

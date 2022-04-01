package ColletionsMap;

import java.util.*;

/*
Crie uma agenda exibindo id, nome, contato
 */
public class ExercAgenda {
    public static void main(String[] args) {
        System.out.println("***\tOrdem Aleatória\t***");
        Map<Integer, Agenda> minhaAgenda = new HashMap<>(){{
           put(1,new Agenda("Rose", "61 35555-7777"));
            put(4,new Agenda("Moisés", "61 95555-7666"));
            put(3,new Agenda("Carlos", "61 34433-5577"));
            put(5,new Agenda("Ana", "61 98778-7700"));
        }};

        for (Map.Entry<Integer, Agenda> agenda: minhaAgenda.entrySet()) {
            System.out.println(agenda.getKey()+": "+ agenda.getValue().getNome()+" - "+agenda.getValue().getContato());
        }
        System.out.println();

        System.out.println("***\tOrdem de Entrada\t***");
        Map<Integer, Agenda> minhaAgenda1 = new LinkedHashMap<>(){{
            put(1,new Agenda("Rose", "61 35555-7777"));
            put(4,new Agenda("Moisés", "61 95555-7666"));
            put(3,new Agenda("Carlos", "61 34433-5577"));
            put(5,new Agenda("Ana", "61 98778-7700"));
        }};

        for (Map.Entry<Integer, Agenda> agenda: minhaAgenda1.entrySet()) {
            System.out.println(agenda.getKey()+": "+ agenda.getValue().getNome()+" - "+agenda.getValue().getContato());
        }
        System.out.println();

        System.out.println("***\tOrdem por Id\t***");
        Map<Integer, Agenda> minhaAgenda2 = new TreeMap<>(minhaAgenda);

        for(Map.Entry<Integer, Agenda> agenda : minhaAgenda2.entrySet()){
            System.out.println(agenda.getKey()+": "+ agenda.getValue().getNome()+" - "+agenda.getValue().getContato());
        }
        System.out.println();

        System.out.println("***\tOrdem por Nome\t***");
        Set<Map.Entry<Integer, Agenda>> minhaAgenda3 = new TreeSet<>(new ComparatorContatoNome());
        minhaAgenda3.addAll(minhaAgenda.entrySet());

        for(Map.Entry<Integer, Agenda> agenda : minhaAgenda3){
            System.out.println(agenda.getKey()+": "+ agenda.getValue().getNome()+" - "+agenda.getValue().getContato());
        }
    }
}

class Agenda{
    //private int id;
    private String nome;
    private String contato;

    public Agenda(/*int id, */String nome, String contato) {
        //this.id = id;
        this.nome = nome;
        this.contato = contato;
    }
/*
    public int getId() {
        return id;
    }
*/
    public String getNome() {
        return nome;
    }

    public String getContato() {
        return contato;
    }
}

class ComparatorContatoNome implements Comparator<Map.Entry<Integer, Agenda>>{

    @Override
    public int compare(Map.Entry<Integer, Agenda> a1, Map.Entry<Integer, Agenda> a2) {
        return a1.getValue().getNome().compareToIgnoreCase(a2.getValue().getNome());
    }
}
import org.w3c.dom.ls.LSOutput;

import java.util.*;

public class ExercArcoIris {

    public static void main(String[] args) {
        //HashSet
        Set<String> arcoiris = new HashSet<>(){{
            add(new String("Vermelho"));
            add(new String("Laranja"));
            add(new String("Amarelo"));
            add(new String("Verde"));
            add(new String("Azul"));
            add(new String("Anil"));
            add(new String("Violeta"));
        }};


        System.out.println("***\tCores do Arco-íris\t***");
        for (String cor : arcoiris) {
            System.out.println(cor);
        }

        System.out.println("***\tQtde de Cores do Arco-íris\t***");
        System.out.println(arcoiris.stream().count()+" Cores");

        //TreeSet
        System.out.println("***\tCores do Arco-íris em Ordem Alfabética\t***");
        Set<String> arcoIris2 = new TreeSet<>(arcoiris);
        for (String cor : arcoIris2) {
            System.out.println(cor);
        }

        System.out.println("***\tOrdem Inversa\t***");
        ArrayList<String> arcoIrisReverse = new ArrayList<>();
        arcoIrisReverse.addAll(arcoiris);
        Collections.reverse(arcoIrisReverse);
        for (String cor : arcoIrisReverse) {
            System.out.println(cor);
        }

        System.out.println("***\tCores que começam com a letra \"V\"\t***");
        ArrayList<String> firstV = new ArrayList<>(arcoIris2);
        for (String fV: firstV) {
            if (fV.charAt(0) == 'V') System.out.println(fV);
        }

        System.out.println("***\tRemovendo as cores que começam com a letra \"V\"\t***");
        Iterator<String> removeCores = arcoIris2.iterator();
        while (removeCores.hasNext()){
            if(removeCores.next().charAt(0) == 'V') removeCores.remove();
        }
        for (String c : arcoIris2) {
            System.out.println(c);
        }

        arcoiris.clear();
        arcoIris2.clear();
        System.out.println("***\tVerificando se existe algum conteúdo em arcoiris\t***");
        for (String c : arcoiris) {
            System.out.println(c);
        }
        System.out.println("***\tVerificando se existe algum conteúdo em arcoIris2\t***");
        for (String c : arcoIris2) {
            System.out.println(c);
        }
        System.out.println("Confira se o conjunto arcoiris está vazio: " + arcoiris.isEmpty());
        System.out.println("Confira se o conjunto arcoIris2 está vazio: " + arcoIris2.isEmpty());
    }
}

import java.util.*;

public class ExemploSet {
    public static void main(String[] args) {
        //Dada a lista com 7 notas de um aluno [7,8.5,9.3,5,7,0,3.6], faça:

        System.out.println("Crie um conjunto e adicione as notas: ");
        Set<Double> notas = new HashSet<>(Arrays.asList(7d,8.5,9.3,5d,7d,0d,3.6));
        System.out.println(notas.toString());
        /*características:
         1- ordem aleatória,
         2- não repetição de valores.
         3- não faz busca de acordo com a posição (não consegue trabalhar com posição, não possui índice)
         4- não possui os métodos get/set
         */

        System.out.println("Confira se a nota 5.0 está no conjunto: " + notas.contains(5d));
        System.out.println("Exiba a menor nota: " + Collections.min(notas));
        System.out.println("Exiba a soma dos valores: "); //com Iterator
        Iterator<Double> iterator = notas.iterator();
        Double soma = 0.0;
        while (iterator.hasNext()){
            Double next = iterator.next();
            soma += next;
        }
        System.out.println("Exiba a soma dos valores: " + soma);
        System.out.println("Exiba a média dos valores: " + soma/notas.size());
        System.out.println("Remova a nota 0: ");
        notas.remove(0.0);
        System.out.println(notas);
        System.out.println("Remova as notas menores que 7 e exiba a lista: ");
        Iterator<Double> iterator1 = notas.iterator();
        while (iterator1.hasNext()){
            Double next = iterator1.next();
            if(next < 7) iterator1.remove();
        }
        System.out.println(notas);

        //LinkedHashSet<>
        System.out.println("Exiba todas as notas na ordem em que foram informados: ");
        Set<Double> notas2 = new LinkedHashSet<>(Arrays.asList(7d,8.5,9.3,5d,7d,0d,3.6));
        System.out.println(notas2);

        //TreeSet<>
        System.out.println("Exiba todas as notas na ordem crescente: ");
        Set<Double> notas3 = new TreeSet<>(notas2);
        System.out.println(notas3);

        System.out.println("Apague todo o conjunto: ");
        notas.clear();
        System.out.println("Confira se o conjunto está vazio: " + notas.isEmpty());
        notas2.clear();
        System.out.println("Confira se o conjunto 2 está vazio: " + notas2.isEmpty());
        notas3.clear();
        System.out.println("Confira se o conjunto 3 está vazio: " + notas3.isEmpty());
    }
}

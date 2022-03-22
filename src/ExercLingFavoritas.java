import java.util.*;

public class ExercLingFavoritas {
    public static void main(String[] args) {

        //LinkedHashSet
        System.out.println("***\tOrdem de Inserção\t***");
        Set<LinguagemFavorita> minhasLingFavor = new LinkedHashSet<>(){{
            add(new LinguagemFavorita("PHP", 1994, "NetBeans"));
            add(new LinguagemFavorita("Java", 1991, "IntelliJ"));
            add(new LinguagemFavorita("Javascript", 1995, "VS Code"));
        }};
        for (LinguagemFavorita lf: minhasLingFavor) {
            System.out.println(lf.toString());
        }
        System.out.println();

        //TreeSet - LinguagemFavorita implements Comparable - imp. method compareTo
        System.out.println("***\tOrdem Natural (nome/ano/ide)\t***");
        Set<LinguagemFavorita> minhasLingFavor2 = new TreeSet<>(minhasLingFavor);
        for (LinguagemFavorita lf: minhasLingFavor2) {
            System.out.println(lf.toString());
        }
        System.out.println();

        //ComparatoIde - compara por IDE
        System.out.println("***\tOrdem IDE\t***");
        Set<LinguagemFavorita> minhasLingFavor3 = new TreeSet<>(new ComparatoIde());
        minhasLingFavor3.addAll(minhasLingFavor);
        for (LinguagemFavorita lf: minhasLingFavor3) {
            System.out.println(lf.toString());
        }
        System.out.println();

        //ComparatoAnoNome - compara por ano e depois por nome
        System.out.println("***\tOrdem Ano/Nome\t***");
        Set<LinguagemFavorita> minhasLingFavor4 = new TreeSet<>(new ComparatoAnoNome());
        minhasLingFavor4.addAll(minhasLingFavor);
        for (LinguagemFavorita lf : minhasLingFavor4) {
            System.out.println(lf.toString());
        }

    }
}

class ComparatoIde implements Comparator<LinguagemFavorita>{

    @Override
    public int compare(LinguagemFavorita lf1, LinguagemFavorita lf2) {
        return lf1.getIde().compareToIgnoreCase(lf2.getIde());
    }
}

class ComparatoAnoNome implements Comparator<LinguagemFavorita>{

    @Override
    public int compare(LinguagemFavorita lf1, LinguagemFavorita lf2) {
        int ano = Integer.compare(lf1.getAnoDeCriacao(), lf2.getAnoDeCriacao());
        if(ano != 0 ) return ano;
        return lf1.getNome().compareToIgnoreCase(lf2.getNome());
    }
}
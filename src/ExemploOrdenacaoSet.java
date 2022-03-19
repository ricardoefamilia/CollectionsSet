import java.util.*;

public class ExemploOrdenacaoSet {
    public static void main(String[] args) {
        System.out.println("---\tOrdem Aleatória\t---");
        Set<Serie> minhasSeries = new HashSet<>(){{
            add(new Serie("got", "fantasia",60));
            add(new Serie("dark", "drama",60));
            add(new Serie("that '70s show", "comédia",25));
        }};

        for (Serie s:minhasSeries) System.out.println(s.getNome()+" - "+s.getGenero()+
                " - "+s.getTempoEpisodio());

        System.out.println("---\tOrdem Inserção\t---");
        //LinkedHashSet
        Set<Serie> minhasSeries1 = new LinkedHashSet<>(){{
            add(new Serie("got", "fantasia",60));
            add(new Serie("dark", "drama",60));
            add(new Serie("that '70s show", "comédia",25));
        }};
        for (Serie s:minhasSeries1) System.out.println(s.getNome()+" - "+s.getGenero()+
                " - "+s.getTempoEpisodio());

        //TreeSet
        System.out.println("---\tOrdem Natural (TempoEpisodio)\t---");
        Set<Serie> minhasSeries2 = new TreeSet<>(minhasSeries1);
        for (Serie s:minhasSeries2) System.out.println(s.getNome()+" - "+s.getGenero()+
                " - "+s.getTempoEpisodio());

        System.out.println("---\tOrdem Nome/Gênero/TempoEpisodio\t---");
        Set<Serie> minhasSeries3 = new TreeSet<>(new ComparatoNomeGeneroTempoEpisodio());
        minhasSeries3.addAll(minhasSeries);
        for (Serie s:minhasSeries3) System.out.println(s.getNome()+" - "+s.getGenero()+
                " - "+s.getTempoEpisodio());

        System.out.println("---\tOrdem Genero/Nome/TempoEpisodio\t---");
        Set<Serie> minhasSeries4 = new TreeSet<>(new ComparatoGeneroNomeTempoEpisodio());
        minhasSeries4.addAll(minhasSeries);
        for (Serie s:minhasSeries4) System.out.println(s.getNome()+" - "+s.getGenero()+
                " - "+s.getTempoEpisodio());

        System.out.println("---\tOrdem TempoEpisodio/Nome/Genero\t---");
        Set<Serie> minhasSeries5 = new TreeSet<>(new ComparatoTempoEpisodioNomeGenero());
        minhasSeries5.addAll(minhasSeries);
        for (Serie s:minhasSeries5) System.out.println(s.getNome()+" - "+s.getGenero()+
                " - "+s.getTempoEpisodio());

    }
}

class ComparatoNomeGeneroTempoEpisodio implements Comparator<Serie> {

    @Override
    public int compare(Serie s1, Serie s2) {
        int nome = s1.getNome().compareToIgnoreCase(s2.getNome());
        if(nome != 0) return nome;

        int genero = s1.getGenero().compareToIgnoreCase(s2.getGenero());
        if(genero != 0) return genero;

        return Integer.compare(s1.getTempoEpisodio(), s2.getTempoEpisodio());
    }
}

class ComparatoGeneroNomeTempoEpisodio implements Comparator<Serie>{

    @Override
    public int compare(Serie s1, Serie s2) {
        int genero = s1.getGenero().compareToIgnoreCase(s2.getGenero());
        if(genero != 0) return genero;

        int nome = s1.getNome().compareToIgnoreCase(s2.getNome());
        if(nome != 0) return nome;

        return Integer.compare(s1.getTempoEpisodio(), s2.getTempoEpisodio());
    }
}

class ComparatoTempoEpisodioNomeGenero implements Comparator<Serie>{

    @Override
    public int compare(Serie s1, Serie s2) {
        int tempoEpisodio = Integer.compare(s1.getTempoEpisodio(), s2.getTempoEpisodio());
        if(tempoEpisodio != 0) return tempoEpisodio;

        int nome = s1.getNome().compareToIgnoreCase(s2.getNome());
        if(nome != 0) return nome;

        return s1.getGenero().compareToIgnoreCase(s2.getGenero());
    }
}
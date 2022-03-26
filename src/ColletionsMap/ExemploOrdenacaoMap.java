package ColletionsMap;

import java.util.*;

/*
Dados as seguintes informações sobre meus livros favoritos e seus autores,
crie um dicionário e ordene-o exibindo autor e livro
 */
public class ExemploOrdenacaoMap {
    public static void main(String[] args) {
        //ordem aleatória
        System.out.println("Ordenação aleatória");
        Map<String, Livro> meusLivros = new HashMap<>(){{
            put("Hawking, Stephen", new Livro("Uma Breve História do Tempo",256));
            put("Duhigg, Charles", new Livro("O Poder do Hábito",408));
            put("Harari, Yuval Noah", new Livro("21 Lições Para o Século 21",432));
        }};
        for(Map.Entry<String, Livro> livro : meusLivros.entrySet())
            System.out.println(livro.getKey()+" - "+livro.getValue().getNomeLivro());

        System.out.println();
        //ordem por inserção
        System.out.println("---\tOrdenação inserção\t---");
        Map<String, Livro> meusLivros2 = new LinkedHashMap<>(){{
            put("Hawking, Stephen", new Livro("Uma Breve História do Tempo",256));
            put("Duhigg, Charles", new Livro("O Poder do Hábito",408));
            put("Harari, Yuval Noah", new Livro("21 Lições Para o Século 21",432));
        }};
        for(Map.Entry<String, Livro> livro : meusLivros2.entrySet())
            System.out.println(livro.getKey()+" - "+livro.getValue().getNomeLivro());

        System.out.println();
        //ordem alfabética autores
        System.out.println("---\tordem alfabética autores\t---");
        Map<String, Livro> meusLivros3 = new TreeMap<>(meusLivros2);
        for(Map.Entry<String, Livro> livro : meusLivros3.entrySet())
            System.out.println(livro.getKey()+" - "+livro.getValue().getNomeLivro());

        System.out.println();
        //ordem alfabética nomes dos livros
        System.out.println("---\tordem alfabética nomes dos livros\t---");
        Set<Map.Entry<String, Livro>> meusLivros4 = new TreeSet<>(new ComparatorNome());
        meusLivros4.addAll(meusLivros.entrySet());
        for(Map.Entry<String, Livro> livro : meusLivros4)
            System.out.println(livro.getKey()+" - "+livro.getValue().getNomeLivro());

    }
}


class Livro{
    private String nomeLivro;
    private Integer nrPaginas;

    public Livro(String nomeLivro, Integer nrPaginas) {
        this.nomeLivro = nomeLivro;
        this.nrPaginas = nrPaginas;
    }

    @Override
    public String toString() {
        return "Livro{" +
                "nomeLivro='" + nomeLivro + '\'' +
                ", nrPaginas=" + nrPaginas +
                '}';
    }

    public String getNomeLivro() {
        return nomeLivro;
    }

    public Integer getNrPaginas() {
        return nrPaginas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Livro livro = (Livro) o;
        return nomeLivro.equals(livro.nomeLivro) && nrPaginas.equals(livro.nrPaginas);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nomeLivro, nrPaginas);
    }

}


//comparator
class ComparatorNome implements Comparator<Map.Entry<String, Livro>>{


    @Override
    public int compare(Map.Entry<String, Livro> l1, Map.Entry<String, Livro> l2) {
        return l1.getValue().getNomeLivro().compareToIgnoreCase(l2.getValue().getNomeLivro());
    }
}
import java.util.Objects;

public class LinguagemFavorita implements Comparable<LinguagemFavorita>{
    private String nome;
    private int anoDeCriacao;
    private String ide;

    public LinguagemFavorita(String nome, int anoDeCriacao, String ide) {
        this.nome = nome;
        this.anoDeCriacao = anoDeCriacao;
        this.ide = ide;
    }

    @Override
    public String toString() {
        return "LinguagemFavorita{" +
                "nome='" + nome + '\'' +
                ", anoDeCriacao=" + anoDeCriacao +
                ", ide='" + ide + '\'' +
                '}';
    }

    public String getNome() {
        return nome;
    }

    public int getAnoDeCriacao() {
        return anoDeCriacao;
    }

    public String getIde() {
        return ide;
    }

    @Override
    public boolean equals(Object lf) {
        if (this == lf) return true;
        if (lf == null || getClass() != lf.getClass()) return false;
        LinguagemFavorita that = (LinguagemFavorita) lf;
        return anoDeCriacao == that.anoDeCriacao && nome.equals(that.nome) && ide.equals(that.ide);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, anoDeCriacao, ide);
    }


    @Override
    public int compareTo(LinguagemFavorita lf) {
        int nome = this.getNome().compareToIgnoreCase(lf.getNome());
        if(nome != 0) return nome;
        int anoCriacao = Integer.compare(this.anoDeCriacao, lf.anoDeCriacao);
        if(anoCriacao != 0) return anoCriacao;
        return this.getIde().compareToIgnoreCase(lf.getIde());
    }
}

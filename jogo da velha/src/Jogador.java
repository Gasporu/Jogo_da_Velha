public class Jogador {
    private char simbolo;
    private String nome;

    public Jogador(char simbolo, String nome) {
        this.simbolo = simbolo;
        this.nome = nome;
    }

    public char getSimbolo() {
        return simbolo;
    }

    public String getNome() {
        return nome;
    }
}

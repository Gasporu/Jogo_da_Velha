import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Bem-vindo ao Jogo da Velha!");

        // Pedir a dimensão do tabuleiro
        System.out.println("Digite a dimensão do tabuleiro:");
        int dimensao = sc.nextInt();
        JogoDaVelha jogo = new JogoDaVelha(dimensao);

        // Pedir os nomes dos jogadores
        System.out.println("Digite o nome do jogador 1 (apenas uma palavra):");
        String nomeJogador1 = sc.next();
        System.out.println(" ");
        System.out.println("Digite o nome do jogador 2 (apenas uma palavra):");
        String nomeJogador2 = sc.next();
        System.out.println(" ");

        // Criar os objetos Jogador
        Jogador jogador1 = new Jogador('X', nomeJogador1);
        Jogador jogador2 = new Jogador('O',nomeJogador2);

        // Variável para controlar de quem é a vez
        Jogador jogadorAtual = jogador1;

        // Variável para controlar se houve vencedor
        boolean vencedor = false;

        // Variável para contar o número de jogadas
        int numJogadas = 0;

        // Loop principal do jogo
        while (!vencedor && numJogadas < dimensao * dimensao) {
            // Imprimir o tabuleiro
            System.out.println(jogo);

            // Pedir a jogada
            System.out.println(jogadorAtual.getNome() + ", insira a linha:");
            int linha = sc.nextInt() -1;
            System.out.println("Coluna:");
            int coluna = sc.nextInt() -1;

            // Verificar se a jogada é válida
            if (jogo.realizaJogada(linha, coluna, jogadorAtual.getSimbolo())) {
                numJogadas++;

                // Verificar se houve vencedor
                if (jogo.verificaGanhador()) {
                    vencedor = true;
                    System.out.println(jogadorAtual.getNome() + " venceu o jogo!");
                }

                // Trocar de jogador
                if (jogadorAtual == jogador1) {
                    jogadorAtual = jogador2;
                } else {
                    jogadorAtual = jogador1;
                }
            } else {
                System.out.println("Jogada inválida. Tente novamente.");
            }
        }

        // Imprimir o tabuleiro final
        System.out.println(jogo);

        // Verificar se houve empate
        if (!vencedor) {
            System.out.println("O jogo terminou em empate!");
        }

        sc.close();
    }
}

public class JogoDaVelha {
    private char[][] tabuleiro;

    public JogoDaVelha(int dimensao) {
        this.tabuleiro = new char[dimensao][dimensao];
        for (int i = 0; i < dimensao; i++) {
            for (int j = 0; j < dimensao; j++) {
                this.tabuleiro[i][j] = ' ';
            }
        }
    }

    public boolean realizaJogada(int linha, int coluna, char jogador) {
        if (this.tabuleiro[linha][coluna] == ' ') {
            this.tabuleiro[linha][coluna] = jogador;
            return true;
        } else {
            return false;
        }
    }

    public boolean verificaGanhador() {
        int dimensao = this.tabuleiro.length;

        // verifica as linhas
        for (int i = 0; i < dimensao; i++) {
            char primeiro = this.tabuleiro[i][0];
            boolean todasIguais = true;
            for (int j = 1; j < dimensao; j++) {
                if (this.tabuleiro[i][j] != primeiro) {
                    todasIguais = false;
                    break;
                }
            }
            if (todasIguais && primeiro != ' ') {
                return true;
            }
        }

        // verifica as colunas
        for (int j = 0; j < dimensao; j++) {
            char primeiro = this.tabuleiro[0][j];
            boolean todasIguais = true;
            for (int i = 1; i < dimensao; i++) {
                if (this.tabuleiro[i][j] != primeiro) {
                    todasIguais = false;
                    break;
                }
            }
            if (todasIguais && primeiro != ' ') {
                return true;
            }
        }

        // verifica a diagonal principal
        char primeiro = this.tabuleiro[0][0];
        boolean todasIguais = true;
        for (int i = 1; i < dimensao; i++) {
            if (this.tabuleiro[i][i] != primeiro) {
                todasIguais = false;
                break;
            }
        }
        if (todasIguais && primeiro != ' ') {
            return true;
        }

        // verifica a diagonal secundária
        primeiro = this.tabuleiro[0][dimensao - 1];
        todasIguais = true;
        for (int i = 1; i < dimensao; i++) {
            if (this.tabuleiro[i][dimensao - 1 - i] != primeiro) {
                todasIguais = false;
                break;
            }
        }
        if (todasIguais && primeiro != ' ') {
            return true;
        }

        // não há ganhador
        return false;
    }
	public String toString() {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < this.tabuleiro.length; i++) {
        for (int j = 0; j < this.tabuleiro.length; j++) {
            sb.append(" ");
            sb.append(this.tabuleiro[i][j]);
            sb.append(" ");
            if (j < this.tabuleiro.length - 1) {
                sb.append("|");
            }
        }
        sb.append("\n");
        if (i < this.tabuleiro.length - 1) {
            for (int k = 0; k < this.tabuleiro.length * 4 - 1; k++) {
                sb.append("-");
            }
            sb.append("\n");
        }
    }
    return sb.toString();
	}
}	
	
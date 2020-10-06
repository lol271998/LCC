/* -----------------------------------
  Estruturas de Dados 2018/2019
  Jogo da Vida [ED088]  
----------------------------------- */

import java.util.Scanner;

// Classe para representar um jogo
class Game {
    final char DEAD  = '.';  // Constante que indica uma celula morta
    final char ALIVE = 'O';  // Constante que indica uma celula viva
    private int rows, cols;  // Numero de linhas e colunas
    private char m[][];      // Matriz para representar o estado do jogo

    // Construtor: inicializa as variaveis tendo em conta a dimensao dada
    Game(int r, int c) {
	   rows = r;
	   cols = c;
	   m = new char[r][c];
    }

    // Metodo para ler o estado inicial para a matriz m[][]
    public void read(Scanner in) {
        for (int i=0; i<rows; i++){
            m[i] = in.next().toCharArray();
        }
    }
    
    // Metodo para escrever a matriz m[][]
    public void write() {
        int n;
        for(int i = 0; i<rows; i++){
            for(int j = 0; j<cols; j++){
                if(m.data[i][j] == '0') 
                    n = m.countAlive(i,j);
                    m.interate(n);
            }
        }
	   
    }

    // Deve devolver o numero de celulas vivas que sao vizinhas de (y,x)
    private int countAlive(int y, int x) {
        int count = 0;
        int count1 = 0;
        while(count1 < 8){
        for(int i = -1; i<=1; i++)
            for(int j = -1; j<=1; j++){
                if(m[y+i][x+i] == '0'){
                    count1++;
                    count ++;
                }
                else{
                    count1++;
                }
            }
        }
        System.out.println(count);
        return count;
    }

    // Deve fazer uma iteracao: cria nova geracao a partir da actual
    public void iterate(int n) {
        switch(n){
            case n<2:
                for(int i = 0; i<rows; i++){
                    for(int j = 0; j<cols; j++){
                        m.data[i][j] = '.';
                    }
                }
        }
        System.out.println(m.data[i][j]);
    }

}

// Classe principal com o main()
public class ED088 {
    public static void main(String[] args) {
	Scanner in = new Scanner(System.in);

	// Ler linhas, colunas e numero de iteracoes
	int rows = in.nextInt();
	int cols = in.nextInt();
	int n    = in.nextInt();

	// Criar objecto para conter o jogo e ler estado inicial
	Game g = new Game(rows, cols);
	g.read(in);

	g.write();

    }
}
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
	for (int i=0; i<rows; i++) m[i] = in.next().toCharArray();
    }	    

    // Metodo para escrever a matriz m[][]
    public void write() {
	for(int i = 0; i<rows; i++){
	    for(int j = 0; j<cols; j++){
		System.out.print(m[i][j]);
	    }
	    System.out.println("");
	}
    }

    // Deve devolver o numero de celulas vivas que sao vizinhas de (y,x)
    private int countAlive(int x, int y) { //Cordenadas
	int count = 0;
	
	for(int i=-1; i<=1; i++){
	    for(int j=-1; j<=1; j++){
		if((x+i>=0) && (y+j>=0) && (x+i<rows) && (y+j<cols)){
		    if (m[x+i][y+j]==ALIVE && !(x+i == x &&  y+j == y)) count++;
		}
	    }
	}
	return count++;
    }

    // Deve fazer uma iteracao: cria nova geracao a partir da actual
    public void iterate() {
	char m2[][] = new char[rows][cols];
		
	//Copia a matrix para a nova iteração
	for(int i = 0; i<rows; i++){
	    for(int j = 0; j<cols; j++){
		m2[i][j] = m[i][j];
	    }
	}
	
	//System.out.println("Copiou a matrix");
	for(int i = 0; i<rows; i++){
	    for(int j = 0; j<cols; j++){
		//Está viva
		if(m[i][j] == ALIVE){
		    //System.out.println("Está viva i = "+i+" j = "+j);
		    int n = countAlive(i,j);
		    if(n == 2 || n == 3){
			m2[i][j] = ALIVE;
		    }
		    else m2[i][j] = DEAD; 
		}
		//Está morta
		else{
		    //System.out.println("Está morta i = "+i+" j = "+j);
		    int n = countAlive(i,j);
		    if(n == 3) m2[i][j] = ALIVE;
		}
	    }
	}
		
	//Copia a matrix para a nova iteração
	for(int i = 0; i<rows; i++){
	    for(int j = 0; j<cols; j++){
		m[i][j] = m2[i][j];
	    }
	}
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
	//System.out.println("Inicio");
	g.write();
	for(int i = 0; i<n; i++){
	    g.iterate();
	    //System.out.println(i+1 +"ª iteração");
	    g.write();
	}

	//System.out.println("Iteração Final");
	g.write();
    }
}

import java.util.Scanner;

class Game{
    private int n; //Tamanho do tabuleiro
    private char m[][]; // Tabuleiro

    Game(int n){ //Contrutor
	this.n = n;
	m = new char[n][n];
    }
    
    //  Leitura de input para o tabuleiro
    void readgame(Scanner in) {
	for (int i=0; i<n; i++) {
	    String buf = in.next();
	    for (int j=0; j<n; j++)
		m[i][j] = buf.charAt(j);
	}
    }

    void verify(int x, int y, int incx, int incy){
	if(m[x][y] == '.') return;
	for(int i = 0, xx = x, yy = y; i<n; i++,xx+=incx,yy+=incy) //declaração int i = 0, xx = x etc 
	    if(m[x][y] != m[xx][yy]) return;
	message(m[x][y]);
    }

    boolean completo(){
	for(int i = 0; i<n; i++){
	    for(int j = 0; j<n; j++){
		if(m[i][j] == '.') return false;
	    }
	}
	return true;
    }

    void check(){
	for(int i = 0; i<n; i++) verify(i,0,0,1); //linhas
	for(int j = 0; j<n; j++) verify(0,j,0,0); //Colunas
	verify(0,0,1,1); //diagonal 1
	verify(0,n-1,1,-1); //diagonal 2

	if(!completo()) System.out.println("Jogo Incompleto");
	else System.out.println("Empate");
    }
    

    void message(char c){
	System.out.println("Ganhou o "+c);
	System.exit(0);
    }
    
    //Imprime o jogo 
    void printgame(){
	for(int i = 0; i<n; i++){
	    for(int j = 0; j<n; j++){
		System.out.print(m[i][j]);
	    }
	    System.out.println("");
	}
    }
}

public class ED004{
    public static void main(String args[]){
	Scanner in = new Scanner(System.in);
	int n = in.nextInt();
	Game jogo = new Game(n);
	jogo.readgame(in);
	jogo.printgame();
	jogo.check();
    }
}

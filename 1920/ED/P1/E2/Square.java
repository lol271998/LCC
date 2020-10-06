public class Square {
    // Desenha uma linha de n caracteres onde:
    // - o primeiro e o último caracteres são o caracter da variável 'a'
    // - todos os outros caracteres são o caracter da variável 'b'
    public static void line(char a, char b, int n) {
	System.out.print(a);
	for (int i=1; i<=n-2; i++){
	    System.out.print(b);
	}
	System.out.println(a);
    }

    public static void square(int n){
	for(int i = 0; i<n; i++){
	    if(i == 0 || i==n-1) line('+','-',n);
	    else line('|','-',n);
	}
    }

    // O procedimento executado inicialmente é sempre o main
    public static void main(String[] args) {	
	square(12);
    }
}

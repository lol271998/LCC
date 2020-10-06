// -----------------------------------------------------------
// Estruturas de Dados 2018/2019 (CC1007) - DCC/FCUP
// http://www.dcc.fc.up.pt/~pribeiro/aulas/edados1819/
// -----------------------------------------------------------
// Exemplo de utilizacao do TAD Pilha
// Ultima alteracao: 06/04/2018
// -----------------------------------------------------------

public class TestMyStack{
	public static void main(String[] args){
		System.out.println(ED195.balanced("([()])"));
		System.out.println(ED195.balanced("[()()]"));
		System.out.println(ED195.balanced("(()]"));
		System.out.println(ED195.balanced("[()[])"));
		System.out.println(ED195.balanced("[()[]"));
	}
}